package com.tophat.android_interview_kotlin_setup

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.Factory
import com.tophat.android_interview_kotlin_setup.models.Answer
import com.tophat.android_interview_kotlin_setup.network.AnswerAPI
import com.tophat.android_interview_kotlin_setup.network.AnswerAPIImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.UnknownHostException


class QuestionViewModel(
    private val answerAPI: AnswerAPI
) : ViewModel() {

    private val _toastText = MutableLiveData<String?>()
    val toastText: LiveData<String?> = _toastText

    fun onSubmit(text: String) {
        Thread.currentThread().interrupt()//interrupt the sleep thread

        try {
            if (text != "") {
                val newAnswer = Answer(text)
                answerAPI.submitAnswer(newAnswer)
                /*val handler = Handler()               //second option but deprecated to delay simulate the submitAnswer
                handler.postDelayed({
                    _toastText.value = "Answer submitted"
                }, 1000)*/
                viewModelScope.launch { // launch new coroutine in background and continue
                    delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
                    _toastText.value = "Answer submitted" // print after delay
                }
            } else {
                _toastText.value =
                    "Please enter a value"    //this message when empty edittext field
            }
        } catch (e: UnknownHostException) {
            _toastText.value = "Answer not submitted"    //message when no connection
        }
    }

    fun onToastShown() {
        _toastText.value = null
    }
}

@Suppress("UNCHECKED_CAST")
class QuestionViewModelFactory(
    private val appContext: Application
) : Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == QuestionViewModel::class.java) {
            return QuestionViewModel(AnswerAPIImpl(appContext)) as T
        }
        throw IllegalArgumentException("Cannot create view model of class ${modelClass.simpleName}")
    }
}
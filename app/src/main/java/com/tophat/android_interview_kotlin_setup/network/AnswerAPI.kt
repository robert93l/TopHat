package com.tophat.android_interview_kotlin_setup.network

import android.content.Context
import android.util.Log
import com.tophat.android_interview_kotlin_setup.models.Answer
import com.tophat.android_interview_kotlin_setup.network.NetworkConnectionUtils.isConnected
import java.net.UnknownHostException

/**
 * DO NOT MODIFY THIS INTERFACE
 */
interface AnswerAPI {
    @Throws(UnknownHostException::class)
    fun submitAnswer(answer: Answer?)
}

/**
 * DO NOT MODIFY THIS CLASS
 */
class AnswerAPIImpl(private val context: Context) : AnswerAPI {
    /**
     * Submits answers to our backend API. Returns true if successful else it will throw
     */
    @Throws(UnknownHostException::class)
    override fun submitAnswer(answer: Answer?) {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            Log.e(LOG_TAG, e.message ?: "")
        }
        if (!isConnected(context)) {
            throw UnknownHostException("No network connection")
        }
    }

    companion object {
        private const val LOG_TAG = "AnswerAPI"
    }
}
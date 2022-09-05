package com.tophat.android_interview_kotlin_setup

import com.tophat.android_interview_kotlin_setup.network.AnswerAPI
import com.tophat.android_interview_kotlin_setup.testutil.CoroutineDispatcherRule
import com.tophat.android_interview_kotlin_setup.testutil.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

class QuestionViewModelTest {
	
	@JvmField @Rule val instantTaskExecutor = InstantTaskExecutorRule()
	@JvmField @Rule val coroutineDispatcher = CoroutineDispatcherRule()
	
	private val api: AnswerAPI = mock()
	
	private val viewModel = QuestionViewModel(api)
	
	@Test
	fun `when api call succeeds, then show success toast`() {


	}

	@Test
	fun `when api call fails, then show error toast`() {
	viewModel.onSubmit("")
	}
}
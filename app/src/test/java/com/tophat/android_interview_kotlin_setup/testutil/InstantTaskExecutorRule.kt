package com.tophat.android_interview_kotlin_setup.testutil

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class InstantTaskExecutorRule : TestWatcher() {
	override fun starting(description: Description?) {
		super.starting(description)
		ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
			override fun executeOnDiskIO(runnable: Runnable) {
				runnable.run()
			}
			
			override fun postToMainThread(runnable: Runnable) {
				runnable.run()
			}
			
			override fun isMainThread(): Boolean = true
		})
	}
	
	override fun finished(description: Description?) {
		super.finished(description)
		ArchTaskExecutor.getInstance().setDelegate(null)
	}
}
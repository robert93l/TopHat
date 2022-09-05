package com.tophat.android_interview_kotlin_setup.models


/**
 * Question Representation for all question
 */


data class Question(val title: String = newTitle) {

    companion object {
        var newTitle: String = "My new title"

    }
}




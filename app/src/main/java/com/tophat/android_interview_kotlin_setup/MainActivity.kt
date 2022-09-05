package com.tophat.android_interview_kotlin_setup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tophat.android_interview_kotlin_setup.databinding.ActivityMainBinding


/**
 * An activity that shows a full screen [QuestionFragment].
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, QuestionFragment())
            .commit()
    }

}

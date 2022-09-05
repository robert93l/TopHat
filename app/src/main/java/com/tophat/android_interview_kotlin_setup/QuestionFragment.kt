package com.tophat.android_interview_kotlin_setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tophat.android_interview_kotlin_setup.databinding.FragmentQuestionBinding
import com.tophat.android_interview_kotlin_setup.models.Question


/**
 * A [Fragment] that displays a question.
 */
class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            QuestionViewModelFactory(requireActivity().application)
        ).get(QuestionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Question("My New Question").title*/
        binding.tvTitle.text = Question.newTitle

        binding.questionSubmitButton.setOnClickListener {
            viewModel.onSubmit(binding.questionInputEditText.text.toString())
        }

        viewModel.toastText.observe(viewLifecycleOwner) { toastText ->
            if (toastText != null) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
                viewModel.onToastShown()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



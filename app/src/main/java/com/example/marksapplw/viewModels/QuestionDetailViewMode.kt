package com.example.marksapplw.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.marksapplw.Data.model.Question
import com.example.marksapplw.Data.repository.QuestionRepo

class QuestionDetailViewModel : ViewModel() {

    private val _question = mutableStateOf<Question?>(null)
    val question: State<Question?> = _question

    fun loadQuestion(questionId: String) {
        _question.value = QuestionRepo.getQuestionById(questionId)
    }
}

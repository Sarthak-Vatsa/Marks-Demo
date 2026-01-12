package com.example.marksapplw.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.marksapplw.Data.model.Question
import com.example.marksapplw.Data.repository.QuestionRepo

class QuestionsViewModel : ViewModel() {

    private val _questions = mutableStateOf<List<Question>>(emptyList())
    val questions: State<List<Question>> = _questions

    fun loadQuestions(examId: String) {
        _questions.value = QuestionRepo.getQuestionsByExam(examId)
    }
}

package com.example.marksapplw.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.marksapplw.Data.model.Exam
import com.example.marksapplw.Data.repository.QuestionRepo

class HomeViewModel : ViewModel() {

    private val _exams = mutableStateOf<List<Exam>>(emptyList())
    val exams: State<List<Exam>> = _exams

    init {
        loadExams()
    }

    private fun loadExams() {
        _exams.value = QuestionRepo.getExams()
    }
}
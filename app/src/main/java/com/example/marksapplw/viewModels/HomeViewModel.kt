package com.example.marksapplw.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.marksapplw.Data.model.Exam
import com.example.marksapplw.Data.repository.QuestionRepo

class HomeViewModel : ViewModel() {

    private val _exams = mutableStateOf<List<Exam>>(emptyList()) //private state that enables
    // recomposition wherever exams.value changes
    val exams: State<List<Exam>> = _exams // public read only state


    //init
//    Runs once when ViewModel is created
//    Not on recomposition
//    Not on every screen redraw
    init {
        loadExams()
    }

    private fun loadExams() {
        _exams.value = QuestionRepo.getExams()
    }
}
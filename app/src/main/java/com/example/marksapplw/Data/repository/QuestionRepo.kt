package com.example.marksapplw.Data.repository

import com.example.marksapplw.Data.model.Exam
import com.example.marksapplw.Data.model.Question

object QuestionRepo {

    private val exams = listOf(
        Exam("jee", "JEE"),
        Exam("neet", "NEET"),
        Exam("boards", "Boards")
    )

    private val questions = listOf(
        Question("1", "jee", "Physics Question", "What is Newton's First Law?"),
        Question("2", "jee", "Maths Question", "Define derivative."),
        Question("3", "neet", "Biology Question", "What is photosynthesis?")
    )

    fun getExams() = exams

    fun getQuestionsByExam(examId: String) =
        questions.filter { it.examId == examId }

    fun getQuestionById(id: String) =
        questions.first { it.id == id }
}

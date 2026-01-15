package com.example.marksapplw.Data.model

data class Exam(
    val id: String,
    val name: String,
    val subjects: List<String>,
    val totalQuestions: Int
)
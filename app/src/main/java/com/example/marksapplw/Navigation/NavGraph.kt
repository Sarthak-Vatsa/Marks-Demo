package com.example.marksapplw.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marksapplw.UserInterface.home.HomeScreen
import com.example.marksapplw.UserInterface.quesDetail.QuestionDetailScreen
import com.example.marksapplw.UserInterface.questions.QuestionsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }

//        composable("questions/{examId}") {
//            QuestionsScreen(navController)
//        }
//
//        composable("detail/{questionId}") {
//            QuestionDetailScreen()
//        }
    }
}

package com.example.marksapplw.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marksapplw.UserInterface.home.HomeScreen
import com.example.marksapplw.UserInterface.quesDetail.QuestionDetailScreen
import com.example.marksapplw.UserInterface.questions.QuestionsScreen

@Composable //so that it can react to recomposition
fun AppNavGraph(
    navController: NavHostController
) {
    //NavHost: A router + screen container
    //It listens to navigation events
    //It decides which composable to show
    //It manages the back stack
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        // Home → Exams
        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        // Exams → Questions
        composable(
            route = "${Routes.QUESTIONS}/{examId}",
            arguments = listOf(
                navArgument("examId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val examId = backStackEntry.arguments?.getString("examId") ?: return@composable

            //return@composable?
            //Stops composition
            //Avoids rendering invalid UI

            QuestionsScreen(
                navController = navController,
                examId = examId
            )
        }

        // Questions → Question Detail
        composable(
            route = "${Routes.QUESTION_DETAIL}/{questionId}",
            arguments = listOf(
                navArgument("questionId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val questionId =
                backStackEntry.arguments?.getString("questionId") ?: return@composable

            QuestionDetailScreen(
                navController = navController,
                questionId = questionId
            )
        }
    }
}


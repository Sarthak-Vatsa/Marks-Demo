package com.example.marksapplw.UserInterface.quesDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marksapplw.Data.model.Question
import com.example.marksapplw.viewModels.QuestionDetailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.marksapplw.UserInterface.questions.QuestionsScreen
import com.example.marksapplw.ui.theme.MarksAppLWTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionDetailScreen(
    navController: NavController,
    questionId: String,
    viewModel: QuestionDetailViewModel = viewModel()
) {

    LaunchedEffect(questionId) {
        viewModel.loadQuestion(questionId)
    }

    val question = viewModel.question.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Question") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        if (question == null) {
            // Optional loading state
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            QuestionContent(
                question = question,
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun QuestionContent(
    question: Question,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = question.title,
            style = MaterialTheme.typography.titleLarge
        )

        Divider()

        Text(
            text = question.description,
            style = MaterialTheme.typography.bodyLarge,
            lineHeight = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionDetailScreenPreview() {
    MarksAppLWTheme {
        QuestionDetailScreen(navController = rememberNavController() , questionId = "2")
    }
}


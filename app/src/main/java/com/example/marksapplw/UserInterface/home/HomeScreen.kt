package com.example.marksapplw.UserInterface.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.marksapplw.Data.model.Exam
import com.example.marksapplw.ui.theme.MarksAppLWTheme
import com.example.marksapplw.viewModels.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marksapplw.Navigation.Routes
import com.example.marksapplw.ui.theme.Background
import com.example.marksapplw.ui.theme.Primary
import com.example.marksapplw.ui.theme.Accent
import com.example.marksapplw.ui.theme.CardBg

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    val exams by viewModel.exams

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        // Header
        Text(
            text = "Welcome to PrepPro 👋",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = "What do you want to practice today?",
            fontSize = 15.sp,
            color = Color.Gray
        )

        Spacer(Modifier.height(24.dp))

        // Exam cards (horizontal)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(exams) { exam ->
                ExamCard(
                    examName = exam.name,
                    subjects = exam.subjects.joinToString(" • "),
                    totalQuestions = exam.totalQuestions,
                    background = Color(0xFFEEF2FF),
                    onClick = {
                        navController.navigate("${Routes.QUESTIONS}/${exam.id}")
                    }
                )

            }
        }

        Spacer(Modifier.height(32.dp))

        // Continue Practice
        ContinuePracticeCard()
    }
}



@Composable
fun ExamCard(
    examName: String,
    subjects: String,
    totalQuestions: Int,
    background: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = examName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = subjects,
                fontSize = 13.sp,
                color = Color(0xFF374151)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "$totalQuestions Questions",
                fontSize = 12.sp,
                color = Accent
            )
        }
    }
}

@Composable
fun ContinuePracticeCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        border = BorderStroke(1.dp, Color(0xFFE5E7EB)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4F46E5)
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Continue Practice",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Resume your last session",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MarksAppLWTheme {
        HomeScreen(rememberNavController())
    }
}


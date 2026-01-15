package com.example.marksapplw.Data.repository

import com.example.marksapplw.Data.model.Exam
import com.example.marksapplw.Data.model.Question

object QuestionRepo {

    private val exams = listOf(
        Exam(
            id = "jee",
            name = "JEE",
            subjects = listOf("Physics", "Chemistry", "Mathematics"),
            totalQuestions = 6
        ),
        Exam(
            id = "neet",
            name = "NEET",
            subjects = listOf("Biology", "Physics", "Chemistry"),
            totalQuestions = 6
        ),
        Exam(
            id = "boards",
            name = "Boards",
            subjects = listOf("Physics", "Chemistry", "Mathematics", "Biology", "Computers"),
            totalQuestions = 6
        )
    )


    private val questions = listOf(

        // -------- JEE --------
        Question(
            "1",
            "jee",
            "Physics: Laws of Motion",
            "What is Newton's First Law of Motion?"
        ),
        Question(
            "2",
            "jee",
            "Mathematics: Calculus",
            "Define the derivative of a function at a point."
        ),
        Question(
            "3",
            "jee",
            "Chemistry: Atomic Structure",
            "What is the significance of Bohr's postulates?"
        ),
        Question(
            "4",
            "jee",
            "Physics: Work & Energy",
            "State the work–energy theorem."
        ),
        Question(
            "5",
            "jee",
            "Mathematics: Algebra",
            "What is the discriminant of a quadratic equation and what does it signify?"
        ),
        Question(
            "6",
            "jee",
            "Chemistry: Thermodynamics",
            "Define enthalpy and explain its physical significance."
        ),

        // -------- NEET --------
        Question(
            "7",
            "neet",
            "Biology: Photosynthesis",
            "What is photosynthesis? Write its overall chemical equation."
        ),
        Question(
            "8",
            "neet",
            "Biology: Human Physiology",
            "Explain the process of breathing in humans."
        ),
        Question(
            "9",
            "neet",
            "Chemistry: Biomolecules",
            "What are enzymes? Mention any two properties of enzymes."
        ),
        Question(
            "10",
            "neet",
            "Physics: Electrostatics",
            "State Coulomb’s law and write its mathematical form."
        ),
        Question(
            "11",
            "neet",
            "Biology: Cell Biology",
            "What is the function of mitochondria in a cell?"
        ),
        Question(
            "12",
            "neet",
            "Biology: Genetics",
            "State Mendel’s law of segregation."
        ),

        // -------- BOARDS --------
        Question(
            "13",
            "boards",
            "Physics: Motion",
            "Define uniform motion and non-uniform motion with examples."
        ),
        Question(
            "14",
            "boards",
            "Chemistry: Acids and Bases",
            "What is pH? What is the pH value of pure water?"
        ),
        Question(
            "15",
            "boards",
            "Mathematics: Linear Equations",
            "Solve a pair of linear equations using the substitution method."
        ),
        Question(
            "16",
            "boards",
            "Biology: Life Processes",
            "What is respiration? Explain aerobic respiration."
        ),
        Question(
            "17",
            "boards",
            "Physics: Electricity",
            "State Ohm’s law and draw the V–I graph."
        ),
        Question(
            "18",
            "boards",
            "Chemistry: Metals and Non-metals",
            "Write two differences between metals and non-metals."
        )
    )


    fun getExams() = exams

    fun getQuestionsByExam(examId: String) =
        questions.filter { it.examId == examId }

    fun getQuestionById(id: String) =
        questions.first { it.id == id }
}

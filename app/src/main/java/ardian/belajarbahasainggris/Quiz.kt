package ardian.belajarbahasainggris

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quiz.optionsRecyclerView
import kotlinx.android.synthetic.main.activity_quiz.questionTextView

class Quiz : AppCompatActivity() {

    private val questions: List<Question> = listOf(
        Question("Apa Bahasa Inggrisnya warna merah?", listOf("Red", "Green", "Blue", "Dog"), 0),
        Question("Apa Bahasa Inggrisnya Anjing?", listOf("Red", "Green", "Blue", "Dog"), 3),
        Question("Apa Bahasa Inggrisnya Hijau?", listOf("Red", "Green", "Blue", "Dog"), 1),
        Question("Apa Bahasa Inggrisnya Jerapa?", listOf("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 2),
        Question("Apa Bahasa Inggrisnya Elang?", listOf("Elephant", "Eagle", "Giraffe", "Hippopotamus"), 1),
        Question("Apa Bahasa Inggrisnya Apel?", listOf("Tomato", "Onion", "Apple", "Chili"), 2),
        Question("Apa Bahasa Inggrisnya Semangaka?", listOf("Water Melon", "Onion", "Apple", "Chili"), 0),
        Question("Apa Bahasa Inggrisnya Pisang?", listOf("China", "Japan", "Banana", "Vietnam"), 2),
        Question("Apa Bahasa Inggrisnya Biru?", listOf("Atlantic Ocean", "Blue", "Arctic Ocean", "Pacific Ocean"), 1),
        Question("Apa Bahasa Inggrisnya Kucing?", listOf("Dog", "Cat", "Tokyo", "Bangkok"), 1)
        // Add more questions
    ).shuffled()

    private var currentQuestionIndex: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        setupQuestion()

        optionsRecyclerView.layoutManager = LinearLayoutManager(this)
        optionsRecyclerView.adapter = OptionsAdapter(questions[currentQuestionIndex].options) { selectedOption ->
            checkAnswer(selectedOption)
        }
    }

    private fun setupQuestion() {
        val currentQuestion = questions[currentQuestionIndex]
        questionTextView.text = currentQuestion.text
    }

    private fun checkAnswer(selectedOption: Int) {
        val currentQuestion = questions[currentQuestionIndex]
        if (selectedOption == currentQuestion.correctOptionIndex) {
            // Correct answer
            score++
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            // Incorrect answer
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

        currentQuestionIndex++

        if (currentQuestionIndex < questions.size) {
            setupQuestion()
            (optionsRecyclerView.adapter as OptionsAdapter).updateOptions(questions[currentQuestionIndex].options)
        } else {
            // Game over
            Toast.makeText(this, "Game Over. Your score: $score", Toast.LENGTH_LONG).show()
            // You can add logic to restart the game or navigate to another screen
            showTotalScore()
        }
    }

    private fun showTotalScore() {
        val totalScoreIntent = Intent(this, ResultActivity::class.java)
        totalScoreIntent.putExtra("SCORE", score)
        startActivity(totalScoreIntent)
        finish() // Optional: Finish current activity to prevent going back
    }

}

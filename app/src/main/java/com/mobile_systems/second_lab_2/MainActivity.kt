package com.mobile_systems.second_lab_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var epsilonEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        epsilonEditText = findViewById(R.id.epsilonEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val termsString = epsilonEditText.text.toString()
            if (termsString.isNotEmpty()) {
                val terms = termsString.toInt()
                val (result,iterations) = calculateSeriesSum(terms)
                resultTextView.text = "Результат: $result Количество итераций: $iterations"
            } else {
                resultTextView.text = "Пожалуйста, введите количество членов."
            }
        }
    }

    private fun calculateSeriesSum(n: Int): Pair < Double, Int> {
        var sum = 0.0
        for (i in 1..n) {
            sum += 1.0 / (i * i) // Сумма ряда 1/(i^2)
        }
        return Pair(sum,n)
    }
}
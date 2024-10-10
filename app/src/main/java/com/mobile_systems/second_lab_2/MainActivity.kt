package com.mobile_systems.second_lab_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Параметры
        val epsilon = 0.0001 // малое число для остановки
        var sum = 0.0
        var lastTerm = 0.0
        var n = 1
        var iterations = 0

        // Цикл вычисления суммы
        while (true) {
            lastTerm = 1.0 / (n * n)
            sum += lastTerm
            iterations++

            // Проверка условия остановки
            if (Math.abs(lastTerm) < epsilon) {
                break
            }

            n++
        }

        // Вывод результата на экран
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        resultTextView.text = "Сумма: $sum Последнее слагаемое: $lastTerm Количество итераций: $iterations"
    }
}
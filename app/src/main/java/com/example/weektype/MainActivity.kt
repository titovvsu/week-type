package com.example.weektype

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import android.view.View
import java.time.temporal.ChronoUnit


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val endDate = LocalDate.now()
        val startDate = LocalDate.of(endDate.year, Month.SEPTEMBER, 1).with(DayOfWeek.MONDAY)
        val weeksDiff = ChronoUnit.WEEKS.between(startDate, endDate).toInt()
        val weekType: String = if (weeksDiff % 2 == 0) {
            "Числитель"
        } else {
            "Знаменатель"
        }

        setContentView(R.layout.activity_main)
        val weekTypeView = findViewById<View>(R.id.weekType) as TextView
        weekTypeView.text = weekType
    }
}

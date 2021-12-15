package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var rollBtn: Button
    private lateinit var incrementBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)
        rollBtn = findViewById(R.id.btn_roll)
        incrementBtn = findViewById(R.id.btn_increment)

        rollBtn.setOnClickListener { rollDice() }
        incrementBtn.setOnClickListener { tvResult.incrementBy(1) }
    }

    private fun rollDice() {
        tvResult.text = (1..6).random().toString()
    }

    fun TextView.incrementBy(x: Int) {
        var textValue: Int? = this.text.toString().toIntOrNull()
        textValue = when (textValue) {
            null -> 1
            in 1..5 -> textValue + x
            else -> 6
        }
        this.text = textValue.toString()
    }

}

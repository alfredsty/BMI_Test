package com.example.bmi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // ?(물음표)는 Null이 가능하다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val resultButton: Button = findViewById(R.id.resultButton)

        resultButton.setOnClickListener(){
            val intent = Intent(this, ResultActivity::class.java)   // Intent는 액티비티 이동
            intent.putExtra("nameEditText",nameEditText.text.toString())
            intent.putExtra("height",heightEditText.text.toString().toInt())
            intent.putExtra("weight",weightEditText.text.toString().toInt())
            startActivity(intent)
        }
    }
}
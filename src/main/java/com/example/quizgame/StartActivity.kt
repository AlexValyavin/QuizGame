package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        var next = findViewById<Button>(R.id.btStart)
        next.setOnClickListener{
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }

}
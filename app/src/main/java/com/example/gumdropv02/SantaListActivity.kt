package com.example.gumdropv02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SantaListActivity : AppCompatActivity() {

    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_santa_list)
    }

    fun homeButton (view: View){
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }
}

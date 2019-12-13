package com.gumdrop.gumdropv02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gumdrop.gumdropv02.R
import android.view.View
import android.widget.Button

class MyListActivity : AppCompatActivity() {

    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list)
    }

    fun homeButton (view: View){
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }
}

package com.gumdrop.gumdropv02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gumdrop.gumdropv02.R
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var txtTimerDay:TextView
    private lateinit var txtTimerHour:TextView
    private lateinit var txtTimerMinute:TextView
    private lateinit var txtTimerSecond:TextView
    private lateinit var tvEvent: TextView
    private lateinit var santaListButton: Button
    private lateinit var myListButton: Button
    private lateinit var handler: Handler
    private lateinit var runnable:Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTimerDay = findViewById(R.id.txtTimerDay)
        txtTimerHour = findViewById(R.id.txtTimerHour)
        txtTimerMinute = findViewById(R.id.txtTimerMinute)
        txtTimerSecond = findViewById(R.id.txtTimerSecond)
        tvEvent = findViewById(R.id.tvhappyevent)
        countDownStart()
    }

    fun countDownStart() {
        handler = Handler()
        runnable = object:Runnable {
            override fun run() {
                handler.postDelayed(this, 1000)
                try
                {
                    val dateFormat = SimpleDateFormat(
                        "yyyy-MM-dd")
                    // Please here set your event date//YYYY-MM-DD
                    val futureDate = dateFormat.parse("2019-12-25")
                    val currentDate = Date()
                    if (!currentDate.after(futureDate))
                    {
                        var diff = (futureDate.getTime() - currentDate.getTime())
                        val days = diff / (24 * 60 * 60 * 1000)
                        diff -= days * (24 * 60 * 60 * 1000)
                        val hours = diff / (60 * 60 * 1000)
                        diff -= hours * (60 * 60 * 1000)
                        val minutes = diff / (60 * 1000)
                        diff -= minutes * (60 * 1000)
                        val seconds = diff / 1000
                        txtTimerDay.setText("" + String.format("%02d", days))
                        txtTimerHour.setText("" + String.format("%02d", hours))
                        txtTimerMinute.setText(("" + String.format("%02d", minutes)))
                        txtTimerSecond.setText(("" + String.format("%02d", seconds)))
                    }
                    else
                    {
                        tvEvent.setVisibility(View.VISIBLE)
                        tvEvent.setText("The event started!")
                        txtTimerDay.setText("" + String.format("%02d", "00"))
                        txtTimerHour.setText("" + String.format("%02d", "00"))
                        txtTimerMinute.setText(("" + String.format("%02d", "00")))
                        txtTimerSecond.setText(("" + String.format("%02d", "00")))
                    }
                }
                catch (e:Exception) {
                    e.printStackTrace()
                }
            }
        }
        handler.postDelayed(runnable, 1 * 1000)
    }

    fun santaButton (view:View){
        val intent = Intent(this, SantaListActivity::class.java).apply {}
        startActivity(intent)
    }

    fun myListButton (view: View) {
        val intent = Intent(this, MyListActivity::class.java).apply {}
        startActivity(intent)
    }
}

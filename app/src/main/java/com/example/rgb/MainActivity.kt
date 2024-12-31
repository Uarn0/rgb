package com.example.rgb

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCreate = findViewById<Button>(R.id.textButton)
        val yourColor = findViewById<TextView>(R.id.YourColor)

        buttonCreate.setOnClickListener {
            val redChannelEditText = findViewById<TextInputEditText>(R.id.Red_channelEdit)
            val greenChannelEditText = findViewById<TextInputEditText>(R.id.Green_channelEdit)
            val blueChannelEditText = findViewById<TextInputEditText>(R.id.Blue_channelEdit)

            val redChannel = redChannelEditText.text.toString().trim().uppercase()
            val greenChannel = greenChannelEditText.text.toString().trim().uppercase()
            val blueChannel = blueChannelEditText.text.toString().trim().uppercase()

            if (redChannel.isNotEmpty() || greenChannel.isNotEmpty() || blueChannel.isNotEmpty()) {
                yourColor.setBackgroundColor(Color.parseColor("#$redChannel$greenChannel$blueChannel"))
            } else {
                Toast.makeText(this, "Будь ласка, введіть значення RGB", Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}

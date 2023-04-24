package com.example.appdev23s_a03

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editAddressInput: EditText
    private lateinit var activity2Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editAddressInput = findViewById(R.id.editAddressInput)
        activity2Button = findViewById(R.id.activity2Button)

        activity2Button.setOnClickListener {
            val address = editAddressInput.text.toString()
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("ADDRESS", address)
            startActivity(intent)
        }
    }
}
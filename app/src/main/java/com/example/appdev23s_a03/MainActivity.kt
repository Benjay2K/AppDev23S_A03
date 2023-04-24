package com.example.appdev23s_a03

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    override fun onStart() {
        super.onStart()
        Log.d("A4", "onStart Act 1")
    }
    override fun onResume() {
        super.onResume()
        Log.d("A4", "onResume Act 1")
    }

    override fun onPause() {
        super.onPause()
        Log.d("A4", "onPause Act 1")
    }

    override fun onStop() {
        super.onStop()
        Log.d("A4", "onStop Act 1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("A4", "onDestroy Act 1")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("A4", "onRestart Act 1")
    }
}
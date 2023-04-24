package com.example.appdev23s_a03

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondaryActivity : AppCompatActivity() {

    private lateinit var addressTextView: TextView
    private lateinit var returnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        addressTextView = findViewById(R.id.addressTextView)
        returnButton = findViewById(R.id.returnButton)

        val address = intent.getStringExtra("ADDRESS")
        addressTextView.text = address

        val googleMapsButton = findViewById<Button>(R.id.googleMapsButton)

        googleMapsButton.setOnClickListener {
            val address = addressTextView.text.toString()
            val uri = "geo:0,0?q=$address"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        returnButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("ADDRESS", address)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

}
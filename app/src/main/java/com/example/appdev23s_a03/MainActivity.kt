package com.example.appdev23s_a03

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.app.Service
import android.media.MediaPlayer
import android.os.IBinder

class MainActivity : AppCompatActivity() {

    private lateinit var editAddressInput: EditText
    private lateinit var activity2Button: Button
    private lateinit var startMusic: Button
    private lateinit var stopMusic: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editAddressInput = findViewById(R.id.editAddressInput)
        activity2Button = findViewById(R.id.activity2Button)
        startMusic = findViewById(R.id.startMusic)
        stopMusic = findViewById(R.id.stopMusic)

        activity2Button.setOnClickListener {
            val address = editAddressInput.text.toString()
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("ADDRESS", address)
            startActivity(intent)
        }

        startMusic.setOnClickListener{
            Intent(applicationContext, MusicService::class.java).also {
                startService(it)
            }
        }

        stopMusic.setOnClickListener{
            Intent(applicationContext, MusicService::class.java).also {
                stopService(it)
            }
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

class MusicService : Service() {
    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        player = MediaPlayer.create(this, R.raw.music)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

}
package com.example.appdev23s_a03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout
    private lateinit var addFragmentButton: Button
    private lateinit var removeFragmentButton: Button
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        fragmentContainer = findViewById(R.id.fragmentContainer)
        addFragmentButton = findViewById(R.id.addFragmentButton)
        removeFragmentButton = findViewById(R.id.removeFragmentButton)

        addFragmentButton.setOnClickListener {
            if (currentFragment == null) {
                currentFragment = FragmentA()
                val bundle = Bundle()
                bundle.putString("message", "Hello from Activity!")
                currentFragment!!.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, currentFragment!!)
                    .commit()
            }
        }

        removeFragmentButton.setOnClickListener {
            if (currentFragment != null) {
                supportFragmentManager.beginTransaction()
                    .remove(currentFragment!!)
                    .commit()
                currentFragment = null
            }
        }

        // create FragmentA instance and add it to the container
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, FragmentA())
            .commit()
    }
}

override fun onFragmentEvent(message: String) {
    // receive message from FragmentB and handle it
    Toast.makeText(this, "Message received: $message", Toast.LENGTH_SHORT).show()
}

// function to be called in the MainActivity
private fun sendMessageToFragment(message: String) {
    val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as FragmentB
    fragmentB.sendMessage(message)
}
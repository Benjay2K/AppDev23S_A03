package com.example.appdev23s_a03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
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

        val fragmentA = FragmentA("Name")
        val fragmentB = FragmentB("Address")
        fragmentA.arguments = intent.extras //or as a Bundle
        fragmentB.arguments = intent.extras

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.linearLayoutFrag,fragmentA)
        fragmentTransaction.add(R.id.linearLayoutFrag,fragmentB)

        fragmentTransaction.commit()

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

    }

}


package com.example.appdev23s_a03

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.Toast
import kotlin.math.sqrt

class RandomPointActivity : AppCompatActivity() {

    lateinit var surfaceView: MySurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_point)

        val button: Button = findViewById(R.id.pointButton)
        val surfaceView: MySurfaceView = findViewById(R.id.surfaceView)

        button.setOnClickListener {
            surfaceView.drawRandomPoint()
        }
    }

    class MySurfaceView(context: Context, attrs: AttributeSet?) :
        SurfaceView(context, attrs), SurfaceHolder.Callback {
        private var surfaceHolder: SurfaceHolder = holder
        private lateinit var canvas: Canvas
        private var paint: Paint = Paint()
        private var circleX: Float = 0f
        private var circleY: Float = 0f
        private var radius: Float = 50f

        init {
            surfaceHolder.addCallback(this)
            paint.color = Color.RED
        }

        override fun surfaceChanged(
            holder: SurfaceHolder, format: Int, width: Int, height: Int
        ) {
            // nothing to do here
        }

        override fun surfaceCreated(holder: SurfaceHolder) {
            // nothing to do here
        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
            // nothing to do here
        }

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            if (event?.action == MotionEvent.ACTION_DOWN) {
                val x = event.x
                val y = event.y
                val distance = sqrt((x - circleX) * (x - circleX) + (y - circleY) * (y - circleY))
                showDistance(distance)
            }
            return true
        }

        private fun showDistance(distance: Float) {
            // display the distance to the user
            Toast.makeText(context, "Distance: $distance", Toast.LENGTH_SHORT).show()
        }

        fun drawRandomPoint() {
            // get the dimensions of the SurfaceView
            val width = width
            val height = height

            // generate random coordinates for the circle center
            circleX = (0..width).random().toFloat()
            circleY = (0..height).random().toFloat()

            // draw the circle on the canvas
            canvas = surfaceHolder.lockCanvas()
            canvas.drawColor(Color.WHITE)
            canvas.drawCircle(circleX, circleY, radius, paint)
            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }
}
package com.wcp.coordinatesinandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    lateinit var areaLayout: RelativeLayout

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_main)
        areaLayout = findViewById(R.id.layout)

        areaLayout.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val x = event.x.toInt()  // get x-Coordinate
                val y = event.y.toInt()  // get y-Coordinate
                val lp = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                ) // Assuming you use a RelativeLayout
                val iv = ImageView(applicationContext)
                lp.width = 150
                lp.height = 300
                lp.setMargins(x, y, 0, 0) // set margins
                iv.layoutParams = lp
                iv.setImageResource(R.drawable.ic_services_marker) // set the image from drawable
                (view as ViewGroup).addView(iv) // add a View programmatically to the ViewGroup
            }
            true
        }
    }
}
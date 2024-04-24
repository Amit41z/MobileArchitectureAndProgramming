package com.aditya.displaytoastmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Duration of the toast
    // is 10 seconds (10000 milli-seconds)
    private val mToastDuration = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring and initializing
        // the elements from the layout file
        val mTextView = findViewById<TextView>(R.id.text_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        // Creating a toast
        val mToast = Toast.makeText(
            applicationContext,
            "I am MAD Practicals Toast message app",
            Toast.LENGTH_LONG
        )

        // When button is clicked, counter starts
        // and toast is called
        mButton.setOnClickListener {
            mDisplayTimer(mTextView)
            mDisplayToast(mToast)
        }
    }

    // Function to display counter
    private fun mDisplayTimer(view: TextView) {
        Thread {
            val mToastDurationSecs = mToastDuration / 1000
            for (i in 1..mToastDurationSecs) {
                runOnUiThread {
                    view.text = i.toString()
                }
                Thread.sleep(1000)
            }
        }.start()
    }

    // Function to invoke Toast
    private fun mDisplayToast(toast: Toast) {
        Thread {
            for (i in 1..mToastDuration / 5000) {
                toast.show()
                Thread.sleep(5000)
                toast.cancel()
            }
        }.start()

    }
}
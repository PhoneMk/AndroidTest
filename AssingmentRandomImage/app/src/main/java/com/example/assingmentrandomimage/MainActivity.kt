package com.example.assingmentrandomimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val images = intArrayOf(R.drawable.bb1, R.drawable.bb2, R.drawable.bb3, R.drawable.bb4, R.drawable.bb5)
        val r = kotlin.random.Random
        btnGreet.setOnClickListener {
            imageRand.setImageResource(images[r.nextInt(images.size)])
        }

        var msg: String? = null
        rbHowmuchYouRate.setOnRatingBarChangeListener { ratingBar, fl, b ->
            var stars = fl.toInt()

            when (stars) {
                1 -> msg = "Sorry to Hear that!"
                2 -> msg = "Sorry for Inconvenience."
                3 -> msg = "Enjoy your Ride."
                4 -> msg = "Great! Thank You."
                5 -> msg = "Glad,I could Help."
            }
//            Toast.makeText(this,"$msg",Toast.LENGTH_LONG).show()
        }

        btnRate.setOnClickListener {
            Toast.makeText(this,"$msg", Toast.LENGTH_LONG).show()
        }
    }
}


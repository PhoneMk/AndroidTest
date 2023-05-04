package com.example.activitywithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainerFirst, SecondFragment())
//            .add(R.id.fragmentContainerSecond, FirstFragment())
//            .commit()

        supportFragmentManager.commit {
            add<SecondFragment>(R.id.fragmentContainerFirst)
            add<FirstFragment>(R.id.fragmentContainerSecond)
        }
    }
}
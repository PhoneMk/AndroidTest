package com.example.firstapplicatio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_activity.*

class ActivityFirst: AppCompatActivity() {

    companion object{
        val IE_Data_Return = "Data To Return"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        btnClick.setOnClickListener {
//            //Toast.makeText(this,"Welcome from Nihon",Toast.LENGTH_SHORT).show()
//            val intent = Intent(this,ActivitySecond::class.java)
//            startActivity(intent)
//            startActivity(ActivitySecond.newIntent(this))

//            startActivity(ActivitySecond.newIntent(this,"Konbanwa"))
            startActivityForResult(ActivitySecond.newIntent(this,"Konbanwa"),100)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && data != null && resultCode == Activity.RESULT_OK) {
            val dataReturn = data.getStringExtra(IE_Data_Return)
            textReturn.text = dataReturn
        }
    }
}
package com.example.firstapplicatio

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class ActivitySecond: AppCompatActivity() {

    private val IMAGE_REQUEST_CODE = 100

    companion object{

        val IE_Data_To_Show = "Data To Show"
        val IE_Data_Return = "Data To Return"

        fun newIntent(context: Context): Intent {
            return Intent(context,ActivitySecond::class.java)
        }

        fun newIntent(context: Context,dataToShow: String): Intent{
            val intent = Intent(context,ActivitySecond::class.java)
                .putExtra(IE_Data_To_Show,dataToShow)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val dataMessage = intent.getStringExtra(IE_Data_To_Show)
        textView2.text =dataMessage

        btnChooseImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_REQUEST_CODE)
        }

        btnYouTube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            val intent = Intent()
            intent.putExtra(IE_Data_Return,"Oyasumi")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data?.data != null){
            val image = data.data
            SelectedImage.setImageURI(image)
        }
    }
}
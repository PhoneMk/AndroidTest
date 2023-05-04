package com.example.helloviews

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = editName.text.toString()

        btnHello.setOnClickListener {
            val name = editName.text.toString()
            Toast.makeText(this, "Hello, $name", Toast.LENGTH_LONG).show()
        }

        btnCheckFruit.setOnClickListener {
            var selectedFruit = ""
            if (checkBoxApple.isChecked) {
                selectedFruit = getString(R.string.cb_apple_content)
            }
            if (checkBoxOrange.isChecked) {
                selectedFruit += getString(R.string.cb_orange_content)
            }
            if (checkBoxGrape.isChecked) {
                selectedFruit += getString(R.string.cb_grape_content)
            }

            val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle(getString(R.string.fruit_alert_dialog_title))
            alertDialog.setMessage("Your Selected Fruit, $selectedFruit , ")
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",{ dialog, which -> dialog.dismiss() })
            alertDialog.show()
        }

        radioButtonMale.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                Toast.makeText(this,getString(R.string.rb_male),Toast.LENGTH_LONG).show()
            }
        }

        radioButtonFemale.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                Toast.makeText(this,getString(R.string.rb_female),Toast.LENGTH_LONG).show()
            }
        }

        tb_guest_room_light.setOnCheckedChangeListener { compoundButton, b ->
            when {
                b -> {
                    Toast.makeText(this,getString(R.string.light_on), Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this,getString(R.string.light_off), Toast.LENGTH_LONG).show()
                }
            }
        }

        swt_door_lock.setOnCheckedChangeListener { compoundButton, b ->
            when {
                b-> {
                    Toast.makeText(this,"Door Lock", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this,"Door Unlock", Toast.LENGTH_LONG).show()
                }
            }
        }
       sbBrightness.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
           override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {

           }

           override fun onStartTrackingTouch(p0: SeekBar?) {

           }

           override fun onStopTrackingTouch(p0: SeekBar?) {

       }
       })

        rbHowmuchYouLoveRoom.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

        }

        // autoCompeleteTextView
        //need to attach with an adapter
        val additionalDrinksAdapter: ArrayAdapter<Any?> = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.additional_drinks)
        )

        actvAdditonalDrinks.setAdapter(additionalDrinksAdapter)

        //date picker
        btn_select_date.setOnClickListener {
            val calendar = Calendar.getInstance()
            val day = calendar[Calendar.DAY_OF_MONTH]
            val month = calendar[Calendar.MONTH]
            val year = calendar[Calendar.YEAR]

            //date picker dialog
            val picker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                tv_selected_date.text = ("$dayOfMonth/${monthOfYear + 1}/$year")
            },
                1978,
                3,
                21
            )
            picker.show()

            //timepicker
            btn_select_time.setOnClickListener {
                val calendar = Calendar.getInstance()
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                //time picker dialog
                val picker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { tp, sHour, sMinute ->
                    tv_selected_time.text = ("$sHour:$sMinute")
                },
                    hour,
                    minute,
                    true
                )
                picker.show()
            }
        }
    }
}
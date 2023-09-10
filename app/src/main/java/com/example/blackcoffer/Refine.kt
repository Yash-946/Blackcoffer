package com.example.blackcoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Refine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val item = listOf<String>("Available | Hey Let Us Connect","Away | Stay Discreet And Watch","Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP")
        val adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,item)
        spinner.adapter = adapter

        val dropBtn = findViewById<ImageView>(R.id.dropDown)
        val TVPurpose = findViewById<TextView>(R.id.TVpurpose)
        var purpose :String = "Coffee,Business,Friendship"

        val option = arrayOf("Coffee","Business","Hobbies","Friendship","Movies","Dinning","Dating","Matrimony")

        val multiChoiceDialogBox = AlertDialog.Builder(this)
            .setTitle("Choose from the options")
            .setMultiChoiceItems(option, booleanArrayOf(true,true,false,true,false,false,false,false)){_, i , isChecked ->
                if (isChecked){
                    purpose = TVPurpose.text.toString()  + "," + option[i]
                }
                else{
                    Toast.makeText(this,"You Unchecked ${option[i]}", Toast.LENGTH_LONG).show()
                }
            }
            .setPositiveButton("Accept"){_, _ ->
                TVPurpose.text = purpose
            }
            .setNegativeButton("Decline"){_, _ ->
                Toast.makeText(this,"You accepted the multiChoiceDialogBox", Toast.LENGTH_LONG).show()
            }
            .create()

        dropBtn.setOnClickListener {
            multiChoiceDialogBox.show()
        }

        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }

    }
}
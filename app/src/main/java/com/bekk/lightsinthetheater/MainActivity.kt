package com.bekk.lightsinthetheater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var rbFirst: RadioButton
    private lateinit var  rbSecond: RadioButton
    private lateinit var etRed: EditText
    private lateinit var etGreen: EditText
    private lateinit var etBlue: EditText
    private lateinit var btnEnter: Button

    private var rbChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        rbFirst = findViewById(R.id.rbFirst)
        rbSecond = findViewById(R.id.rbSecond)
        etRed = findViewById(R.id.etRed)
        etGreen = findViewById(R.id.etGreen)
        etBlue = findViewById(R.id.etBlue)
        btnEnter = findViewById(R.id.btnEnter)

        rbFirst.setOnClickListener {
            rbSecond.isChecked = false
            rbChecked = true
        }

        rbSecond.setOnClickListener {
            rbFirst.isChecked = false
            rbChecked = true
        }

        btnEnter.setOnClickListener {
            //possible errors
            if (etRed.text.isNullOrBlank() || etGreen.text.isNullOrBlank() || etBlue.text.isNullOrBlank()){
                Toast.makeText(this, "Don't leave anything empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!rbChecked){
                Toast.makeText(this, "Don't leave anything empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val red = etRed.text.toString()
            val green = etGreen.text.toString()
            val blue = etBlue.text.toString()
            val firstSequence = rbFirst.isChecked

            rbFirst.isChecked = false
            rbSecond.isChecked = false
            etRed.text = null
            etGreen.text = null
            etBlue.text = null
            rbChecked = false
            etRed.requestFocus()

            val i = Intent(this, LightingActivity::class.java)
            i.putExtra("red", red)
            i.putExtra("green", green)
            i.putExtra("blue", blue)
            i.putExtra("firstSequence", firstSequence)
            startActivity(i)

        }
    }
}
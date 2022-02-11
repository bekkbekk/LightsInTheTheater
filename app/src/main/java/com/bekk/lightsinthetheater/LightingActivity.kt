package com.bekk.lightsinthetheater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LightingActivity : AppCompatActivity() {

    private lateinit var rvLights: RecyclerView
    private lateinit var tvLabel: TextView

    private lateinit var colorList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lighting)

        supportActionBar?.hide()

        colorList = ArrayList()
        rvLights = findViewById(R.id.rvLights)
        tvLabel = findViewById(R.id.tvLabel)
        val red = intent.getStringExtra("red")?.toInt()
        val green = intent.getStringExtra("green")?.toInt()
        val blue = intent.getStringExtra("blue")?.toInt()
        val firstSequence = intent.getBooleanExtra("firstSequence", true)

        tvLabel.text = "R: $red  G: $green  B: $blue"

        if (firstSequence){
            performFirst(red, green, blue)
        } else {
            performSecond(red, green, blue)
        }

        val myAdapater = ColorAdapter(colorList)
        rvLights.layoutManager = LinearLayoutManager(this)
        rvLights.adapter = myAdapater



    }

    private fun performFirst(red: Int?, green: Int?, blue: Int?) {

            if (red != null && green != null && blue != null){
                if (red >= green && red >= blue){
                    for (i in 1..10){
                        colorList.add("Red")
                    }
                } else if (blue > red && blue > green){
                    for (i in 1..10){
                        if (i == 1 || i == 4 || i == 7 || i == 10){
                            colorList.add("Blue")
                        } else {
                            colorList.add("White")
                        }
                    }
                } else {
                    for (i in 1..10) {
                        if (i == 1 || i == 10){
                            colorList.add("Green")
                        } else {
                            if (red > blue) {
                                colorList.add("Red")
                            } else if (blue > red) {
                                colorList.add("Blue")
                            } else {
                                if (i == 2 || i == 3 || i == 4 || i == 5){
                                    colorList.add("Red")
                                } else {
                                    colorList.add("Blue")
                                }
                            }
                        }
                    }
                }
            }

    }

    private fun performSecond(red: Int?, green: Int?, blue: Int?) {

        if (red == 0 && blue == 0){
            for (i in 1..10){
                colorList.add("off")
            }
            return
        }

        if (red != null && green != null && blue != null){
            if(red % 2 == 0 && green % 2 == 1){
                for (i in 1..10){
                    if (i % 2 == 1){
                        colorList.add("on")
                    } else {
                        colorList.add("off")
                    }
                }
            } else if (red % 2 == 0 && green % 2 == 0){
                for (i in 1..10){
                    if (i % 2 == 0){
                        colorList.add("on")
                    } else {
                        colorList.add("off")
                    }
                }
            } else if (red % 2 == 1 && green % 2 == 1){
                for (i in 1..5){
                    colorList.add("on")
                }
                for (i in 1..5){
                    colorList.add("off")
                }
            }

            if (blue % 10 == 0){
                if (colorList.isEmpty()){
                    colorList.add("on")
                } else {
                    colorList[0] = "on"
                }
            }
        }
    }
}
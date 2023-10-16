package com.simon.aplicacionespmdm.IMCA

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import com.simon.aplicacionespmdm.R
import java.text.DecimalFormat

class IMC_calculator : AppCompatActivity() {

    private var currentWeight: Int = 60
    private var currentEdad: Int=30
    private var currentHeight: Int = 120
    private var isMAleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractWeight: CardView
    private lateinit var btnAddWeight: CardView
    private lateinit var tvEdad: TextView
    private lateinit var btnSubstractEdad: CardView
    private lateinit var btnAddEdad: CardView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        setWeight()
        setEdad()

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.numPeso)
        btnAddWeight = findViewById(R.id.plusPeso)
        btnSubtractWeight = findViewById(R.id.substracPeso)
        tvEdad = findViewById(R.id.numEdad)
        btnAddEdad = findViewById(R.id.plusEdad)
        btnSubstractEdad = findViewById(R.id.substracEdad)
        btnCalculate=findViewById(R.id.calculator)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorMale() }
        viewFemale.setOnClickListener { setComponentColorFemale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubstractEdad.setOnClickListener {
            currentEdad --
            setEdad()
        }
        btnAddEdad.setOnClickListener {
            currentEdad ++
            setEdad()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigatetoResult()
        }


    }

    private fun navigatetoResult() {
        var intent = Intent(this, Result_Activity::class.java)
        startActivity(intent)
    }

    private fun calculateIMC():Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight / Math.pow(currentHeight.toDouble()/100, 2.0)

        return df.format(imc).toDouble()
    }

    private fun setEdad() {
        tvEdad.text = currentEdad.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setComponentColorFemale() {
        if (!isFemaleSelected){
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            isMAleSelected = false
            isFemaleSelected = true
        }

    }

    private fun setComponentColorMale() {
        if (!isMAleSelected){
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMAleSelected = true
            isFemaleSelected = false
        }
    }
}
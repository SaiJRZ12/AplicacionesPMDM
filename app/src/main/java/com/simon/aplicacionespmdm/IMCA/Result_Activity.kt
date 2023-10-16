package com.simon.aplicacionespmdm.IMCA

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.simon.aplicacionespmdm.R


class Result_Activity : AppCompatActivity() {

    private lateinit var btnRecalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnRecalcular = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners() {
        btnRecalcular.setOnClickListener {
            navigateToIMAC()
        }
    }

    private fun navigateToIMAC() {
        var intent = Intent(this, IMC_calculator::class.java)
        startActivity(intent)
    }
}
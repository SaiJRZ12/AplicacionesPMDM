package com.simon.aplicacionespmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.simon.aplicacionespmdm.HelloApp.MainActivity
import com.simon.aplicacionespmdm.IMCA.IMC_calculator
import com.simon.aplicacionespmdm.Message.Mensajeria

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHello)
        btnHelloApp.setOnClickListener{navigateToHelloApp()}

        var btnMessage = findViewById<Button>(R.id.btnMessage)
        btnMessage.setOnClickListener{navigateToMessageApp()}

        var btnIMAC = findViewById<Button>(R.id.btnIMAC)
        btnIMAC.setOnClickListener{navigateToIMAC()}
    }

    private fun navigateToIMAC() {
        var intent = Intent(this, IMC_calculator::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp() {
        var intent = Intent(this, Mensajeria::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
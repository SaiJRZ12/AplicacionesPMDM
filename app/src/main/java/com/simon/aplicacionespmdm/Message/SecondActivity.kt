package com.simon.aplicacionespmdm.Message

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.simon.aplicacionespmdm.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var texto=findViewById<TextView>(R.id.texto)

        var mensaje: String = intent.extras?.getString("extra_name").orEmpty()
        texto.text="$mensaje"

        var btnSend = findViewById<Button>(R.id.btn2)
        var userText = findViewById<EditText>(R.id.editText)

        btnSend.setOnClickListener{
            var name = userText.text.toString()
            if (name.isNotEmpty()){
                var textIntent = Intent(this, Mensajeria::class.java)
                textIntent.putExtra("extra_reply", name)
                startActivity(textIntent)
            }
        }
    }
}
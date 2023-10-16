package com.simon.aplicacionespmdm.Message

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.simon.aplicacionespmdm.R

class Mensajeria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensajeria)

        var btnSend = findViewById<Button>(R.id.btn1)
        var userText = findViewById<EditText>(R.id.editText)

        btnSend.setOnClickListener{
            var name = userText.text.toString()
            if (name.isNotEmpty()){
                var textIntent = Intent(this, SecondActivity::class.java)
                textIntent.putExtra("extra_name", name)
                startActivity(textIntent)
            }
        }

        var texto=findViewById<TextView>(R.id.texto)

        var mensaje: String = intent.extras?.getString("extra_name").orEmpty()
        texto.text="$mensaje"
    }
}
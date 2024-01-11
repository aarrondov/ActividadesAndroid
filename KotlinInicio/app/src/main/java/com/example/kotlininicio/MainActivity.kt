package com.example.kotlininicio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cuadroEntrada : EditText = findViewById(R.id.editTextText)
        val miBoton : Button = findViewById(R.id.button4)
        val cuadroSalida : TextView = findViewById(R.id.textView2)

        miBoton.setOnClickListener {
            val textoIntro = cuadroEntrada.text
            cuadroSalida.text = textoIntro
        }

    }
}

class Persona(var nombre:String, private var edad:Int){
    fun cumpleanyos(){
        this.edad++
    }
}
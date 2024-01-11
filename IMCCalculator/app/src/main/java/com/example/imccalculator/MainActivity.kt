package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var editTextResultado: EditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa las referencias a las vistas
        editTextPeso = findViewById(R.id.editTextPeso)
        editTextAltura = findViewById(R.id.editTextAltura)
        editTextResultado = findViewById(R.id.editTextResultado)
        btnCalcular = findViewById(R.id.btnCalcular)

        // Agrega un OnClickListener al botón
        btnCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        // Obtiene los valores de los EditText y los convierte a Float
        val pesoString = editTextPeso.text.toString()
        val alturaString = editTextAltura.text.toString()

        try {
            val peso = pesoString.toFloat()
            val altura = alturaString.toFloat()

            val imc = (peso / altura.pow(2))
            val imcText: String = when (imc) {
                in Float.MIN_VALUE..18.5F -> "Usted sufre delgadez, debería comer más."
                in 18.5..24.9 -> "Su estado de forma es bueno."
                in 25.0..29.9 -> "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista."
                in 30.0..Float.MAX_VALUE.toDouble() -> "Usted sufre obesidad, debería llamar a un médico urgentemente."
                else -> "Valor de IMC no válido." // Esto debería ser manejado como caso de error.
            }
            // Muestra el resultado en el EditText
            editTextResultado.setText(imcText)

        } catch (e: NumberFormatException) {
            // Maneja la excepción si no se pueden convertir a Float
            editTextResultado.setText("")

            // Puedes mostrar un mensaje Toast también
             Toast.makeText(this, "Los campos no son números válidos", Toast.LENGTH_SHORT).show()
        }
    }


}
package com.example.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nota1Edit = findViewById<EditText>(R.id.nota1)
        val nota2Edit = findViewById<EditText>(R.id.nota2)
        val faltasEdit = findViewById<EditText>(R.id.faltas)
        val calcularButton = findViewById<Button>(R.id.calcular)
        val resultadoText = findViewById<TextView>(R.id.resultado)

        calcularButton.setOnClickListener{
            var resultado = ""
            val nota1 = nota1Edit.text.toString().toDouble()
            val nota2 = nota2Edit.text.toString().toDouble()
            val faltas = faltasEdit.text.toString().toInt()
            resultado = calcaulte(nota1, nota2, faltas)
            resultadoText.text = resultado
            if (resultado.contains("Aprovado"))
                resultadoText.setTextColor(Color.GREEN)
            else
                resultadoText.setTextColor(Color.RED)
        }
    }

    private fun calcaulte(nota1: Double, nota2: Double, faltas:Int): String{
        val media = (nota1 + nota2) / 2
        return if (media >= 6 && faltas <= 10)
            "Aprovado!\nNota final: $media\nFaltas: $faltas"
        else
            "Reprovado...\nNota final: $media\nFaltas: $faltas"
    }
}
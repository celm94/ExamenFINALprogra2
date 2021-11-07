package com.example.appud.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.appud.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {



    private var StringNumero = StringBuilder()
    private lateinit var Display: TextView
    private lateinit var Botones: Array<Button>
    private lateinit var Operadores: List<Button>
    private var operator: Operador = Operador.NINGUNA
    private var operadorClick: Boolean = false

    private var N1: Double = 0.0

    private lateinit var punto: Button
    private lateinit var cero: Button
    private lateinit var uno: Button
    private lateinit var dos: Button
    private lateinit var tres: Button
    private lateinit var cuatro: Button
    private lateinit var cinco: Button
    private lateinit var seis: Button
    private lateinit var siete: Button
    private lateinit var ocho: Button
    private lateinit var nueve: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InicializarComponentes()

        butINFO.setOnClickListener{
            val intent = Intent(this, INFO::class.java)
            startActivity(intent)
        }






    }

    private fun InicializarComponentes(){
        Display = findViewById(R.id.textoV)

        cero = findViewById(R.id.but0)
        uno = findViewById(R.id.but1)
        dos = findViewById(R.id.but2)
        tres = findViewById(R.id.but3)
        cuatro = findViewById(R.id.but4)
        cinco = findViewById(R.id.but5)
        seis = findViewById(R.id.but6)
        siete = findViewById(R.id.but7)
        ocho = findViewById(R.id.but8)
        nueve = findViewById(R.id.but9)
        punto = findViewById(R.id.butPUNTO)

        Botones = arrayOf(cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto)
        Operadores = listOf(butDIV, butMULTI, butMENOS, butSUMA)
        butIGUAL.setOnClickListener { ClickIgual() }
        butC.setOnClickListener { ClickCLEAR() }

        for( i in Botones){
            i.setOnClickListener { ClickBoton(i) }
        }

        for(i in Operadores){
            i.setOnClickListener { ClilckOperador(i) }
        }



    }

    private fun ClickBoton(boton: Button){
        if(operadorClick){
            N1 = StringNumero.toString().toDouble()
            StringNumero.clear()
            operadorClick = false
        }
        StringNumero.append(boton.text)
        Display.text = StringNumero

    }

    private fun ClilckOperador(boton: Button){
        if(boton.text == "+" ) operator = Operador.SUM
        else if(boton.text == "-" ) operator = Operador.RES
        else if(boton.text == "*" ) operator = Operador.MUL
        else if(boton.text == "/" ) operator = Operador.DIV
        else if(boton.text == "C") operator = Operador.CLEAR1


        else operator = Operador.NINGUNA
        operadorClick = true

    }

    private fun ClickCLEAR(){
        Display.text = StringNumero.clear()

    }

    private fun ClickIgual(){
        val N2 = StringNumero.toString().toDouble()
        val resultado = when(operator){

            Operador.SUM ->  N1 + N2
            Operador.RES ->  N1 - N2
            Operador.MUL ->  N1 * N2
            Operador.DIV ->  N1 / N2


            else ->  0.0
        }

        StringNumero.clear()
        StringNumero.append(resultado.toString())
        Display.text = StringNumero
        operadorClick = true
    }








}



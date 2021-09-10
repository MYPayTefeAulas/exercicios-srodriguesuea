package com.example.mypatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypatas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btTrocarTexto.setOnClickListener {
           trocaTexto()
            binding.txtHello.text= trocaTexto3()
            binding.txtHello.text = calculaDobro()
                   }


        val view = binding.root
        setContentView(view)
    }

    fun calculaDobro(): String {
        val textoEntrada = binding.txtInput.text.toString()
        val numero = textoEntrada.toInt()
        val dobro = numero* 2
        return dobro.toString()
    }

    fun trocaTexto() {
        binding.txtHello.text = "Olá\nSou Sabrina"
    }
    fun trocaTexto2():String {
        return "Olá\nSou Sabrina"
    }
    fun trocaTexto3 (): String{
        return binding.txtInput.text.toString()
    }

}
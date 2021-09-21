package com.example.mypatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypatas.databinding.ActivityListasBinding
import com.example.mypatas.databinding.ActivityListasBinding.*
import com.example.mypatas.databinding.ActivityMainBinding

class ListasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListasBinding
    private val listaFrutas = listOf ("laranja", "abacaxi", "abacate")
    private val listaVegetais = listOf ("pepino", "alface", "pimentão")

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

                binding = ActivityListasBinding.inflate(layoutInflater)

                binding.btAnalisar.setOnClickListener{
                binding.txtSaida.text = analisar (binding.txtEntrada.text.toString())
                }

        setContentView(binding.root)
    }

    fun analisar (entrada: String): String {
        var saida = ""

        for (fruta in listaFrutas) {
            if (fruta == entrada) {
                saida = "É fruta"
                break
            }
        }
        for (vegetal in listaVegetais) {
            if (vegetal == entrada) {
                saida = "É um vegetal"
                break
            }
        }
        if (saida==""){
            saida= "Não sei o que é isso"
        }
        return saida
    }
}
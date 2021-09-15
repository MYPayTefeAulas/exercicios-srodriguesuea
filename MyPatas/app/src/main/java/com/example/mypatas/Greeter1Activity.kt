package com.example.mypatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypatas.databinding.ActivityGreeter1Binding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    private val listaNomes = mutableListOf<String>()
    private var indiceAtual = 0
    private var greeterAtual = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreeter1Binding.inflate(layoutInflater)

        val greeter1 = GreeterTipo1("Olá")
        val greeter2 = GreeterTipo1("Seja bem vindo")
        listaNomes.add("Sabrina")
        listaNomes.add ("Anna")
        listaNomes.add("Lobinho")


        binding.btImprimir.setOnClickListener {
            val nomeAtual = listaNomes[indiceAtual]

            when(greeterAtual){
                1 -> binding.txtSaida.text = greeter1.greet (nomeAtual)
                2 -> binding.txtSaida.text = greeter2.greet (nomeAtual)
            }

            if(indiceAtual == listaNomes.size - 1){
                indiceAtual = 0
            } else {
                indiceAtual++
            }

        }
        binding.btTrocar.setOnClickListener {
            if(greeterAtual == 1){
                greeterAtual = 2
                binding.txtNumGreeter.text = "2"
            } else {
                greeterAtual = 1
                binding.txtNumGreeter.text = "1"
            }
        }

        setContentView(binding.root)
    }
}
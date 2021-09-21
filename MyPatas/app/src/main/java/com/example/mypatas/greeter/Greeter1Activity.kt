package com.example.mypatas.greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypatas.databinding.ActivityGreeter1Binding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    private val listaNomes = mutableListOf<String>()
    private var indiceAtual = 0
    private lateinit var greeterAtual: GreeterTipo1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreeter1Binding.inflate(layoutInflater)

        val greeter1 = GreeterTipo1("Olá")
        val greeter2 = GreeterTipo1("Seja bem vindo")
        greeterAtual = greeter1
        listaNomes.add("Sabrina")
        listaNomes.add ("Anna")
        listaNomes.add("Lobinho")


        binding.btImprimir.setOnClickListener {
            val nomeAtual = listaNomes[indiceAtual]

            binding.txtSaida.text = greeterAtual.greet(nomeAtual)

            if(indiceAtual == listaNomes.size - 1){
                indiceAtual = 0
            } else {
                indiceAtual++
            }

        }
        binding.btTrocar.setOnClickListener {
            if(greeterAtual == greeter1){
                greeterAtual = greeter2
                binding.txtNumGreeter.text = "2"
            } else {
                greeterAtual = greeter1
                binding.txtNumGreeter.text = "1"
            }
        }

        setContentView(binding.root)
    }
}
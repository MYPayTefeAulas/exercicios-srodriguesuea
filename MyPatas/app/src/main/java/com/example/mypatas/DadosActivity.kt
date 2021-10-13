package com.example.mypatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypatas.databinding.ActivityDadosBinding

class DadosActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityDadosBinding
    private val dado1 = Dados(4)
    private val dado2 = Dados(6)
    private val dado3 = Dados(8)
    private val dado4 = Dados(10)
    private val listaDados = mutableListOf<Dados>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosBinding.inflate(layoutInflater)

        binding.btSortear.setOnClickListener {
            binding.txtQuantLados1.text = "${dado1.numeroLados}"
            binding.txtNumDados1.text = dado1.lancar()
            binding.txtQuantLados2.text = "${dado2.numeroLados}"
            binding.txtNumDados2.text = dado2.lancar()
            binding.txtQuantLados3.text = "${dado3.numeroLados}"
            binding.txtNumDados3.text = dado3.lancar()
        }

        setContentView(binding.root)
    }
}
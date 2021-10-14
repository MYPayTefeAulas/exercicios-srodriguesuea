package com.example.mypatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mypatas.databinding.ActivityDadosBinding

class DadosActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityDadosBinding
    private val dado1 = Dados(4)
    private val dado2 = Dados(6)
    private val dado3 = Dados(8)
    private val dado4 = Dados(10)
    private var indice1 = 0
    private var indice2 = 0
    private var indice3 = 0
    private val listaDados = mutableListOf<Dados>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosBinding.inflate(layoutInflater)
        listaDados.add(dado1)
        listaDados.add(dado2)
        listaDados.add(dado3)
        listaDados.add(dado4)

        setTitle("Sorteio de Dados")


        binding.btSortear.setOnClickListener {
            binding.txtQuantLados1.text = "${listaDados[indice1].numeroLados}"
            binding.txtNumDados1.text = listaDados[indice1].lancar()
            binding.txtQuantLados2.text = "${listaDados[indice2].numeroLados}"
            binding.txtNumDados2.text = listaDados[indice2].lancar()
            binding.txtQuantLados3.text = "${listaDados[indice3].numeroLados}"
            binding.txtNumDados3.text = listaDados[indice3].lancar()
        }
        Toast.makeText(this, "Sorteio Relatizado",Toast.LENGTH_SHORT).show()

        binding.btTrocar1.setOnClickListener {
            indice1++
            if (indice1 == listaDados.size){
                indice1 = 0
            }
            binding.txtQuantLados1.text = "${listaDados[indice1].numeroLados}"
        }
        binding.btTrocar2.setOnClickListener {
            indice2++
            if (indice2 == listaDados.size){
                indice2 = 0
            }
            binding.txtQuantLados2.text = "${listaDados[indice2].numeroLados}"
        }
        binding.btTrocar3.setOnClickListener {
            indice3++
            if (indice3 == listaDados.size){
                indice3 = 0
            }
            binding.txtQuantLados3.text = "${listaDados[indice3].numeroLados}"
        }
        // variavel listaDados = [0,1,2,3]
        // [dado1,dado2,dado3,dado4]
        setContentView(binding.root)
    }
}
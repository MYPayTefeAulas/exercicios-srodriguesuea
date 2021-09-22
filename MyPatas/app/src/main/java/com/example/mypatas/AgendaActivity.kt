package com.example.mypatas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypatas.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    private val agenda = Agenda()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)

        binding.btSalvarAgenda.setOnClickListener {
            val nome = binding.txtEntradaNomeAgenda.text.toString()
            val telefone = binding.txtEntradaTelefoneAgenda.text.toString()
            val novoContato = Pessoa(nome,idade = 0, telefone)
            agenda.salvarContato(novoContato)
        }

        binding.btImprimirAgenda.setOnClickListener {


            binding.txtEntradaNomeAgenda.setText(agenda.imprimirNomeContatos())
            binding.txtEntradaTelefoneAgenda.setText(agenda.imprimirTelefoneContatos())
        }

        binding.btDeletarAgenda.setOnClickListener {
            if (agenda.retornarNumeroContato() == 0){
                binding.txtStatusAgenda.setTextColor(Color.rgb(200,10,10))
                binding.txtStatusAgenda.text= "Não existe contato para deletar"
            } else {
                agenda.deletarContato()
                binding.txtStatusAgenda.setTextColor(Color.rgb(10,200,30))
                binding.txtStatusAgenda.text= "Contato Deletado com Sucesso"
            }
        }

        setContentView(binding.root)
    }
}
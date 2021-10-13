package com.example.mypatas

import android.content.res.ColorStateList
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
            if (novoContato.verificaNomeVazio()&&novoContato.verificaTelefoneVazio()){
                binding.txtStatusAgenda.setTextColor(corVermelha)
                binding.txtStatusAgenda.text = "Por favor digite um nome e telefone"
            } else if (novoContato.verificaNomeVazio()){
                binding.txtStatusAgenda.setTextColor(corVermelha)
                binding.txtStatusAgenda.text = "Por favor digite um nome"
            } else if (novoContato.verificaTelefoneVazio()){
                binding.txtStatusAgenda.setTextColor(corVermelha)
                binding.txtStatusAgenda.text = "Por favor digite um telefone"
            } else if(agenda.checarContatoRepetido(novoContato)){
                binding.txtStatusAgenda.setTextColor(corVermelha)
                binding.txtStatusAgenda.text = "Este contato já existe"
            }else{
                agenda.salvarContato(novoContato)
                binding.txtStatusAgenda.setTextColor(corVerde)
                binding.txtStatusAgenda.text = "Contato salvo com sucesso"
                binding.txtEntradaNomeAgenda.setText("")
                binding.txtEntradaTelefoneAgenda.setText("")
            }
        }
        binding.btBuscarContato.setOnClickListener {
            val contatoExistente = binding.txtPesquisar.text.toString()
            val pessoaPesquisar = Pessoa(contatoExistente,0,"")

            if (agenda.checarVazio()){
                binding.txtStatusAgenda.text = "Não existem contatos em sua agenda!"
            }else if (!agenda.pesquisarContato(pessoaPesquisar)){
                binding.txtStatusAgenda.text = "Contato não encontrado"
            } else {
                binding.txtEntradaNomeAgenda.setText(agenda.imprimirNomePesquisa(pessoaPesquisar))
                binding.txtEntradaTelefoneAgenda.setText(agenda.imprimirTelefonePesquisa(pessoaPesquisar))
            }

//            val contatoExistente = binding.txtPesquisar.text.toString()
//          if (agenda.existeContato(contatoExistente)){
//               binding.txtStatusPesquisa.text
//           } else{
//               binding.txtStatusPesquisa.setTextColor(Color.rgb(200,10,20))
//               binding.txtStatusPesquisa.text= "Contato Inexistente"
//           }
        }

        binding.btImprimirAgenda.setOnClickListener {
            if (agenda.checarVazio()){
                binding.txtStatusAgenda.setTextColor(Color.rgb(200,10,10))
                binding.txtStatusAgenda.text = "Não existe contato para imprimir"
            }else{
                binding.txtEntradaNomeAgenda.setText(agenda.imprimirNomeContatos())
                binding.txtEntradaTelefoneAgenda.setText(agenda.imprimirTelefoneContatos())
            }
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

    companion object{
        val corVermelha: Int = Color.rgb(200,10,10)
        val corVerde: Int = Color.rgb(10,200,10)
    }
}
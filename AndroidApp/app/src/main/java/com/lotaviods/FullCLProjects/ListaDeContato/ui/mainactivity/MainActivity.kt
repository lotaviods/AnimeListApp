package com.lotaviods.FullCLProjects.ListaDeContato.ui.mainactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.teste.ui.mainactivity.adapter.ContatoAdapter
import com.example.teste.ui.mainactivity.viewModel.ContatoViewModel
import com.lotaviods.FullCLProjects.ListaDeContato.R
import com.lotaviods.FullCLProjects.ListaDeContato.model.Contato
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {
    private val viewModel: ContatoViewModel = ContatoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        configuraObserver()

        viewModel.procuraAluno()

        swipeContainer.setOnRefreshListener {
            viewModel.procuraAluno()
        }

    }

    private fun configuraObserver() {

        viewModel.contato.observe(this, { data ->
            swipeContainer.isRefreshing = false
            Log.i("API", "Dados recebidos")
            contato_recyclerview.apply {
                layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                adapter = ContatoAdapter(this.context, data.conteudoResposta)
            }
        })
    }

}
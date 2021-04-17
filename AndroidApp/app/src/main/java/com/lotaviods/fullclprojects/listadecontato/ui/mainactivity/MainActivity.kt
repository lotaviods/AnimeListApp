package com.lotaviods.fullclprojects.listadecontato.ui.mainactivity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teste.ui.mainactivity.adapter.ContatoAdapter
import com.lotaviods.fullclprojects.listadecontato.R
import com.lotaviods.fullclprojects.listadecontato.ui.mainactivity.viewModel.ContatoViewModel
import kotlinx.android.synthetic.main.activity_main.*


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
                layoutManager =
                    LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                adapter = ContatoAdapter(this.context, data.conteudoResposta)
            }
        })

        viewModel.erro.observe(this, {
            swipeContainer.isRefreshing = false
            contato_recyclerview.adapter = null
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
        })
    }


}
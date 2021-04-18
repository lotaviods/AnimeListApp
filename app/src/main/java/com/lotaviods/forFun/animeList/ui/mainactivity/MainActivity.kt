package com.lotaviods.forFun.animeList.ui.mainactivity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lotaviods.forFun.animeList.ui.mainactivity.adapter.AnimeAdapter
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.ui.mainactivity.viewModel.AnimeViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val viewModel: AnimeViewModel = AnimeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        configuraObserver()

        swipeContainer.setOnRefreshListener {
            viewModel.searchAnimes()
        }

    }

    override fun onResume() {
        swipeContainer.isRefreshing = true
        viewModel.searchAnimes()
        super.onResume()
    }
    private fun configuraObserver() {

        viewModel.anime.observe(this, { data ->
            swipeContainer.isRefreshing = false
            Log.i("API", "Data recived")
            contato_recyclerview.apply {
                layoutManager =
                    LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                adapter = AnimeAdapter(this.context, data.AnimeList)
            }
        })

        viewModel.erro.observe(this, {
            swipeContainer.isRefreshing = false
            contato_recyclerview.adapter = null
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
        })
    }


}
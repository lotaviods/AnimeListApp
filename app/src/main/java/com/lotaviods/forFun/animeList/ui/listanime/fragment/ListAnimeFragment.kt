package com.lotaviods.forFun.animeList.ui.listanime.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.ui.listanime.adapter.AnimeAdapter
import com.lotaviods.forFun.animeList.ui.listanime.viewModel.AnimeViewModel
import kotlinx.android.synthetic.main.fragment_anime_list.*

class ListAnimeFragment : Fragment() {

    private val viewModel: AnimeViewModel = AnimeViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeObserver()
        configButtons()
        viewModel.searchAnimes()
    }

    private fun configButtons() {
        fab_new_anime.setOnClickListener {
            findNavController().navigate(R.id.listAnime_to_CrateAnime)
        }
    }

    private fun initializeObserver() {
        viewModel.anime.observe(viewLifecycleOwner, { data ->
            swipeContainer.isRefreshing = false
            Log.i("API", "Data recived")
            contato_recyclerview.apply {
                layoutManager =
                    LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                adapter = AnimeAdapter(this.context, data.AnimeList)
            }
        })

        viewModel.erro.observe(viewLifecycleOwner, {
            swipeContainer.isRefreshing = false
            contato_recyclerview.adapter = null
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }
}
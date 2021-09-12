package com.lotaviods.forFun.animeList.ui.listanime.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.ui.listanime.adapter.AnimeAdapter
import com.lotaviods.forFun.animeList.ui.listanime.viewModel.AnimeViewModel
import kotlinx.android.synthetic.main.fragment_anime_list.*

class ListAnimeFragment : Fragment() {

    private val viewModel: AnimeViewModel = AnimeViewModel()
    private lateinit var meuAdapter: AnimeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraAdapter()
        configuraSwipe()
        initializeObserver()
        configButtons()
        viewModel.searchAnimes()
    }

    private fun configuraAdapter() {
        meuAdapter = AnimeAdapter(requireContext())
        ItemTouchHelper(ItemHelper()).attachToRecyclerView(anime_recyclerview)
        anime_recyclerview.apply {
            layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = meuAdapter
        }
    }

    private fun configuraSwipe() {
        swipeContainer.setOnRefreshListener {
            viewModel.searchAnimes()
        }
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
            meuAdapter.loadAnimes(data.AnimeList)

        })

        viewModel.erro.observe(viewLifecycleOwner, {
            swipeContainer.isRefreshing = false
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

    }

    inner class ItemHelper : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val anime = viewModel.anime.value?.AnimeList?.get(viewHolder.absoluteAdapterPosition)
            meuAdapter.animes.removeAt(viewHolder.absoluteAdapterPosition)
            meuAdapter.notifyItemRemoved(viewHolder.absoluteAdapterPosition)

            viewModel.removeAnime(anime?.name)
                .observe(viewLifecycleOwner, { sucesso ->
                    if (sucesso) {
                        Toast.makeText(
                            requireContext(),
                            "Anime removido com sucesso",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }


    }
}

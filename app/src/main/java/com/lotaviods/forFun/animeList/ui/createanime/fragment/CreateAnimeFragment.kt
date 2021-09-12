package com.lotaviods.forFun.animeList.ui.createanime.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.ui.createanime.viewmodel.CreateAnimeViewModel
import kotlinx.android.synthetic.main.fragment_create_anime.*

class CreateAnimeFragment : Fragment(R.layout.fragment_create_anime) {
    private val viewModel: CreateAnimeViewModel = CreateAnimeViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_buttom.setOnClickListener {
            val nome = anime_name_textField.text.toString()
            viewModel.createAnime(nome)
        }

        viewModel.animeCriado.observe(viewLifecycleOwner, {
            if (it) {
                Toast.makeText(requireContext(), "Anime Criado com sucesso", Toast.LENGTH_SHORT)
                    .show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Não foi possivel criar o anime", Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }
}



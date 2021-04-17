package com.example.teste.ui.mainactivity.adapter

import ContatoViewHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lotaviods.fullclprojects.listadecontato.R
import com.lotaviods.fullclprojects.listadecontato.model.Contato

class ContatoAdapter(private val context: Context?, private val contatos : List<Contato>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_contato,parent, false)
        return ContatoViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ContatoViewHolder
        val contato = contatos.elementAt(position)
        holder.bindView(contato)

    }
    override fun getItemCount(): Int {
        return contatos.size
    }
}
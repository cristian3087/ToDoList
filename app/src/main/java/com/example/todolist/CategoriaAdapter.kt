package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriaAdapter(private val categorias: List<CategoriaTareas>) :
    RecyclerView.Adapter<CategoriaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria,parent, false)
        return CategoriaViewHolder(view)
    }

    override fun getItemCount()=categorias.size


    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.render(categorias[position])
    }
}

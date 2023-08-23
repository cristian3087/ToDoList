package com.example.todolist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriaViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val tvCategoria:TextView = view.findViewById(R.id.tvCategoria)
    private val hr:View = view.findViewById(R.id.hr)
    fun render(categoriaTarea:CategoriaTareas){
        tvCategoria.text = "Ejemplo"
    }

}
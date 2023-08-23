package com.example.todolist

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriaViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val tvCategoria:TextView = view.findViewById(R.id.tvCategoria)
    private val hr:View = view.findViewById(R.id.hr)
    fun render(categoriaTarea:CategoriaTareas){
        when(categoriaTarea){
            CategoriaTareas.Negocios->{
                tvCategoria.text = "Negocios"
                tvCategoria.setTextColor(Color.rgb(0, 128, 0))
                hr.setBackgroundColor(Color.parseColor("#008000"))
            }
            CategoriaTareas.Personal->{
                tvCategoria.text = "Personal"
                hr.setBackgroundColor(Color.parseColor("#0000FF"))
            }
            CategoriaTareas.Otro->{
                tvCategoria.text = "Otro"
                hr.setBackgroundColor(ContextCompat.getColor(hr.context, R.color.my_color))
            }
        }
    }

}
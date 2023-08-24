package com.example.todolist

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TareaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvTarea:TextView=view.findViewById(R.id.tvTarea)
    private val cbTarea:TextView=view.findViewById(R.id.cbTarea)
    fun render(tarea:Tarea){
        Toast.makeText(cbTarea.context, "Seleccionado: ${tarea.name}  ${tarea.isSelected} ",Toast.LENGTH_SHORT).show()
        if(tarea.isSelected){
            tvTarea.paintFlags=tvTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTarea.paintFlags=tvTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        tvTarea.text=tarea.name


    }
}
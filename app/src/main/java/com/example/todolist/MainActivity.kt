package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val categorias = listOf(
        CategoriaTareas.Negocios,
        CategoriaTareas.Personal,
        CategoriaTareas.Otro,
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var rvTareas: RecyclerView
    private lateinit var categoriasAdapter:CategoriaAdapter
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponnet()
        initUI()

    }

    private fun initComponnet() {
        rvCategorias = binding.rvCategorias
        rvTareas = binding.rvTareas
    }
    private fun initUI(){
        categoriasAdapter= CategoriaAdapter(categorias)
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter=categoriasAdapter
    }
}
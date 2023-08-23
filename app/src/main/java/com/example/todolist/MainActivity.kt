package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var rvcategorias: RecyclerView
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponnet()
        initUI()

    }

    private fun initComponnet() {
        rvcategorias = binding.rvCategorias
    }
    private fun initUI(){

    }
}
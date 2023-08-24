package com.example.todolist

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val categorias = listOf(
        CategoriaTareas.Negocios,
        CategoriaTareas.Personal,
        CategoriaTareas.Otro,
    )

    private val tareas = mutableListOf(
        Tarea("Tarea1", CategoriaTareas.Negocios,true),
        Tarea("Tarea2", CategoriaTareas.Negocios),
        Tarea("Tarea1", CategoriaTareas.Personal),
        Tarea("Tarea1", CategoriaTareas.Otro),

    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var rvTareas: RecyclerView
    private lateinit var categoriasAdapter:CategoriaAdapter
    private lateinit var binding:ActivityMainBinding
    private lateinit var tareaAdapter: TareaAdapter
    private lateinit var btnAdd:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponnet()
        initUI()
        initListener()
    }

    private fun initListener() {
        btnAdd.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog(){
        val dialogo = Dialog(this)
        dialogo.setContentView(R.layout.dialogo_tareas)
        val btnAddTarea = dialogo.findViewById<Button>(R.id.btnAgregar)
        val etTarea = dialogo.findViewById<EditText>(R.id.etTarea)
        val rGroup = dialogo.findViewById<RadioGroup>(R.id.rTareas)
        btnAddTarea.setOnClickListener {
            val seleccionadoID = rGroup.checkedRadioButtonId
            val rbSeleccionado = rGroup.findViewById<RadioButton>(seleccionadoID)
            val texto= etTarea.text.toString()
            if (texto.isNotEmpty()){
                val categoriaActual:CategoriaTareas = when(rbSeleccionado.text){
                    "Negocios" -> CategoriaTareas.Negocios
                    "Personal" -> CategoriaTareas.Personal
                    else    -> CategoriaTareas.Otro
                }
                tareas.add(Tarea(etTarea.text.toString(),categoriaActual))
                updateTareas()
                dialogo.hide()
            }else{
                Toast.makeText(this,"No tiene tareas", Toast.LENGTH_SHORT).show()
            }

        }
        dialogo.show()

    }

    private fun updateTareas() {
        tareaAdapter.notifyDataSetChanged()
    }

    private fun initComponnet() {
        rvCategorias = binding.rvCategorias
        rvTareas = binding.rvTareas
        btnAdd = binding.fbtnAdd
    }

    private fun onItemSeleccionado(index:Int){
        tareas[index].isSelected = !tareas[index].isSelected
        updateTareas()
    }
    private fun initUI(){
        categoriasAdapter= CategoriaAdapter(categorias)
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter=categoriasAdapter

        rvTareas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        tareaAdapter= TareaAdapter(tareas){index->onItemSeleccionado(index)}
        rvTareas.adapter = tareaAdapter
    }
}
package com.example.todolist

sealed class CategoriaTareas {
    object Personal : CategoriaTareas()
    object Negocios: CategoriaTareas()
    object Otro :CategoriaTareas()
}
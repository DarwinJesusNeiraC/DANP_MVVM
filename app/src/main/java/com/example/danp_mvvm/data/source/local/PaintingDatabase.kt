package com.example.danp_mvvm.data.source.local

import com.example.danp_mvvm.data.model.Painting

// Clase singleton para manejar los datos en memoria
object PaintingDatabase {
    private val paintingList = mutableListOf<Painting>()

    // Obtener todas las pinturas
    fun getAllPaintings(): List<Painting> {
        return paintingList
    }

    // Agregar una nueva pintura
    fun addPainting(painting: Painting) {
        paintingList.add(painting)
    }

    // Obtener una pintura por ID
    fun getPaintingById(id: Int): Painting? {
        return paintingList.find { it.id == id }
    }

    // Actualizar una pintura existente
    fun updatePainting(updatedPainting: Painting) {
        val index = paintingList.indexOfFirst { it.id == updatedPainting.id }
        if (index != -1) {
            paintingList[index] = updatedPainting
        }
    }

    // Eliminar una pintura por ID
    fun deletePaintingById(id: Int) {
        paintingList.removeAll { it.id == id }
    }
}

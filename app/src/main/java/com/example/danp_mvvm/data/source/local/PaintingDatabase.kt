package com.example.danp_mvvm.data.source.local

import com.example.danp_mvvm.data.model.Painting

// Clase singleton para manejar los datos en memoria
object PaintingDatabase {
    private val paintingList = mutableListOf<Painting>()

    // Inicializar con datos de prueba
    init {
        addTestData()
    }

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

    // Función para agregar datos de prueba
    private fun addTestData() {
        paintingList.addAll(
            listOf(
                Painting(
                    id = 1,
                    title = "Starry Night",
                    artist = "Vincent van Gogh",
                    imageUrl = "https://example.com/starry_night.jpg"
                ),
                Painting(
                    id = 2,
                    title = "Mona Lisa",
                    artist = "Leonardo da Vinci",
                    imageUrl = "https://example.com/mona_lisa.jpg"
                ),
                Painting(
                    id = 3,
                    title = "The Persistence of Memory",
                    artist = "Salvador Dalí",
                    imageUrl = "https://example.com/persistence_of_memory.jpg"
                ),
                Painting(
                    id = 4,
                    title = "The Scream",
                    artist = "Edvard Munch",
                    imageUrl = "https://example.com/the_scream.jpg"
                ),
                Painting(
                    id = 5,
                    title = "Girl with a Pearl Earring",
                    artist = "Johannes Vermeer",
                    imageUrl = "https://example.com/girl_with_pearl_earring.jpg"
                )
            )
        )
    }
}

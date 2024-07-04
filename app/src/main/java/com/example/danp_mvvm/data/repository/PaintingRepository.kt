package com.example.danp_mvvm.data.repository

import com.example.danp_mvvm.data.model.Painting

interface PaintingRepository {
    suspend fun getPaintings(): List<Painting>
}

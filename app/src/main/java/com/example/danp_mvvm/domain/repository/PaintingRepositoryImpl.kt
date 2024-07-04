package com.example.danp_mvvm.domain.repository

import PaintingDao
import com.example.danp_mvvm.data.model.Painting
import com.example.danp_mvvm.data.repository.PaintingRepository

class PaintingRepositoryImpl(private val paintingDao: PaintingDao) : PaintingRepository {
    override suspend fun getPaintings(): List<Painting> {
        return paintingDao.getAllPaintings()
    }
}

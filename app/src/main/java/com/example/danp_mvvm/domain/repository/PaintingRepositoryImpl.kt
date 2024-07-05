package com.example.danp_mvvm.domain.repository

import com.example.danp_mvvm.data.model.Painting
import com.example.danp_mvvm.data.repository.PaintingRepository
import com.example.danp_mvvm.data.source.local.PaintingDatabase

class PaintingRepositoryImpl() : PaintingRepository {
    override fun getPaintings(): List<Painting> {
        return PaintingDatabase.getAllPaintings()
    }

}


package com.example.danp_mvvm.domain.usecase

import com.example.danp_mvvm.data.repository.PaintingRepository
import com.example.danp_mvvm.domain.model.PaintingDomainModel

class GetPaintingsUseCase(private val repository: PaintingRepository) {
    suspend fun execute(): List<PaintingDomainModel> {
        return repository.getPaintings().map { painting ->
            PaintingDomainModel(
                id = painting.id,
                title = painting.title,
                artist = painting.artist,
                imageUrl = painting.imageUrl
            )
        }
    }
}

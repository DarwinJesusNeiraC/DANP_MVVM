package com.example.danp_mvvm.ui.viewmodel

import androidx.lifecycle.*
import com.example.danp_mvvm.domain.model.PaintingDomainModel
import com.example.danp_mvvm.domain.usecase.GetPaintingsUseCase
import kotlinx.coroutines.launch

class PaintingViewModel(private val getPaintingsUseCase: GetPaintingsUseCase) : ViewModel() {
    private val _paintings = MutableLiveData<List<PaintingDomainModel>>()
    val paintings: LiveData<List<PaintingDomainModel>> get() = _paintings

    init {
        viewModelScope.launch {
            _paintings.value = getPaintingsUseCase.execute()
        }
    }

    // Método para manejar el evento de agregar pintura
    fun addPainting(painting: PaintingDomainModel) {
        val updatedList = _paintings.value.orEmpty().toMutableList().apply {
            add(painting)
        }
        _paintings.value = updatedList
    }
}

class PaintingViewModelFactory(private val getPaintingsUseCase: GetPaintingsUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PaintingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PaintingViewModel(getPaintingsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

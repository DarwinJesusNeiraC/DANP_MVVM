package com.example.danp_mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.danp_mvvm.data.model.Painting
import com.example.danp_mvvm.data.repository.PaintingRepository
import com.example.danp_mvvm.domain.model.PaintingDomainModel
import com.example.danp_mvvm.domain.repository.PaintingRepositoryImpl
import com.example.danp_mvvm.domain.usecase.GetPaintingsUseCase
import kotlinx.coroutines.launch

//class PaintingViewModel(private val getPaintingsUseCase: GetPaintingsUseCase) : ViewModel() {
//    private val _paintings = MutableLiveData<List<PaintingDomainModel>>()
//    val paintings: LiveData<List<PaintingDomainModel>> = _paintings
//
//    init {
//        viewModelScope.launch {
//            _paintings.value = getPaintingsUseCase.execute()
//        }
//    }
//}

//@HiltViewModel
class PaintingViewModel(private val getPaintingsUseCase: GetPaintingsUseCase) : ViewModel() {
    private val _paintings = MutableLiveData<List<PaintingDomainModel>>()
    val paintings: LiveData<List<PaintingDomainModel>> get() = _paintings

    init {
        viewModelScope.launch {
            _paintings.value = getPaintingsUseCase.execute()
        }
    }
}
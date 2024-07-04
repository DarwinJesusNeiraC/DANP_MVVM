package com.example.danp_mvvm.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.danp_mvvm.data.model.Painting
import com.example.danp_mvvm.data.repository.PaintingRepository
import com.example.danp_mvvm.ui.components.PaintingItem
import com.example.danp_mvvm.ui.viewmodel.PaintingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaintingViewModel @Inject constructor(
    private val repository: PaintingRepository // Suponiendo que tienes un repositorio
) : ViewModel() {
    val paintings: LiveData<List<Painting>> = repository.getPaintings()
}

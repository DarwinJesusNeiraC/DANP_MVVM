package com.example.danp_mvvm.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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


@Composable
fun PaintingList(viewModel: PaintingViewModel) {
    val paintings = viewModel.paintings.observeAsState(emptyList())

    LazyColumn {
        items(paintings.value) { painting ->
            PaintingItem(painting = painting)
        }
    }
}

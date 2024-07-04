package com.example.danp_mvvm.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.danp_mvvm.ui.components.PaintingItem
import com.example.danp_mvvm.ui.viewmodel.PaintingViewModel

@Composable
fun PaintingListScreen(viewModel: PaintingViewModel = hiltViewModel()) {
    val paintings by viewModel.paintings.observeAsState(emptyList())

    LazyColumn {
        items(paintings) { painting ->
            PaintingItem(painting)
        }
    }
}


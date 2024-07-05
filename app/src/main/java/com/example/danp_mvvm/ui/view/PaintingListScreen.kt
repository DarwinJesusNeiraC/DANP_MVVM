package com.example.danp_mvvm.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.danp_mvvm.domain.model.PaintingDomainModel
import com.example.danp_mvvm.ui.components.PaintingItem
import com.example.danp_mvvm.ui.viewmodel.PaintingViewModel

@Composable
fun PaintingList(viewModel: PaintingViewModel) {
    val paintings = viewModel.paintings.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            viewModel.addPainting(
                PaintingDomainModel(
                    id = paintings.value.size + 1,
                    title = "New Painting",
                    artist = "New Artist",
                    imageUrl = "https://example.com/new_painting.jpg"
                )
            )
        }) {
            Text("Add Painting")
        }

        Text(text = if (paintings.value.isEmpty()) "No paintings available" else "Paintings available")

        LazyColumn {
            items(paintings.value) { painting ->
                PaintingItem(painting = painting, onDeleteClick = { viewModel.removePainting(painting) })
            }
        }
    }
}

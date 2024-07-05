package com.example.danp_mvvm.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.danp_mvvm.domain.model.PaintingDomainModel

@Composable
fun PaintingItem(painting: PaintingDomainModel, onDeleteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = painting.title)
            Text(text = painting.artist)
            Text(text = painting.imageUrl)  // Muestra la URL como texto

        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onDeleteClick) {
            Text("Delete")
        }
            }
    }
}

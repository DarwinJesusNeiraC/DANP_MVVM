package com.example.danp_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.danp_mvvm.data.repository.PaintingRepository
import com.example.danp_mvvm.domain.repository.PaintingRepositoryImpl
import com.example.danp_mvvm.domain.usecase.GetPaintingsUseCase
import com.example.danp_mvvm.ui.theme.DANP_MVVMTheme
import com.example.danp_mvvm.ui.view.PaintingList
import com.example.danp_mvvm.ui.viewmodel.PaintingViewModel
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DANP_MVVMTheme {
                PaintingList(PaintingViewModel(GetPaintingsUseCase(PaintingRepositoryImpl())))
            }
        }
    }
}

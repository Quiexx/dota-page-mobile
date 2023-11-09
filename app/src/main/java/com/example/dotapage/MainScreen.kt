package com.example.dotapage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.dotapage.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun MainScreen() {
    ApplySystemBarColors()

    Surface(
        color = AppTheme.BgColors.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        DotaScreen()
    }
}

@Composable
fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}
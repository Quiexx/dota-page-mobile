package com.example.dotapage

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.dotapage.ui.theme.AppTheme


@Composable
fun DotaDescription(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.dota_description),
            color = AppTheme.TextColors.secondary,
            style = AppTheme.TextStyle.Regular_12
        )
    }
}
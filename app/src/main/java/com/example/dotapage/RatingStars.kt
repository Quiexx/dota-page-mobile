package com.example.dotapage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dotapage.ui.theme.AppTheme

@Composable
fun RatingStars(rating: Double, starSize: Dp) {
    val fullStars = rating.toInt()
    val remaining = rating - fullStars

    Row {
        repeat(fullStars) {
            StarIcon(starSize = starSize, tint = AppTheme.RatingColors.active)
        }

        if (remaining > 0) {
            StarIcon(starSize = starSize, tint = AppTheme.RatingColors.active, progress = remaining)
        }

        repeat(5 - (fullStars + if (remaining > 0) 1 else 0)) {
            StarIcon(starSize = starSize, tint = AppTheme.RatingColors.inactive)
        }
    }
}

@Composable
fun StarIcon(starSize: Dp, tint: Color, progress: Double = 1.0) {
    Icon(
        imageVector = Icons.Filled.Star,
        tint = tint,
        contentDescription = null,
        modifier = Modifier
            .size(starSize)
            .padding(end = 2.dp)
    )
}

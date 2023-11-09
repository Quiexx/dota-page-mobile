package com.example.dotapage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableVideoRow(
    resources: List<Int>,
    modifier: Modifier,
    previewModifier: Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier
    ) {
        items(resources) { res ->
            VideoPreview(res, previewModifier)
        }
    }
}

@Preview
@Composable
fun ScrollableVideoRowPreview() {
    val videos = listOf(
        R.drawable.video_preview_1,
        R.drawable.video_preview_2,
        R.drawable.video_preview_3,
    )
    ScrollableVideoRow(videos, Modifier, Modifier.height(150.dp))
}

@Composable
fun VideoPreview(resourceId: Int, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(resourceId),
            contentDescription = null,
            modifier = modifier
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        Surface(
            color = Color(255, 255, 255, 61),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        ) {}

        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

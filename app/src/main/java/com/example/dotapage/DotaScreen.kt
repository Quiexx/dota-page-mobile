package com.example.dotapage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DotaScreen() {
    val modifier = Modifier.padding(horizontal = 25.dp)

    val commentList = List(3) {
        CommentContent(
            image = R.drawable.avatar_1,
            author = stringResource(id = R.string.comment_author),
            date = stringResource(id = R.string.comment_date),
            text = stringResource(id = R.string.comment_text)
        )
    }

    val previewsList = listOf(
        R.drawable.video_preview_1,
        R.drawable.video_preview_2,
        R.drawable.video_preview_3,
    )

    val rating = 4.9

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        item {
            DotaScreenHeader(modifier = modifier, rating = rating)
        }
        item {
            DotaDescription(modifier = modifier)
        }

        item {
            ScrollableVideoRow(
                resources = previewsList,
                modifier = modifier,
                previewModifier = Modifier.height(140.dp)
            )
        }

        item {
            ReviewAndRatings(
                modifier = modifier,
                comments = commentList,
                rating = rating
            )
        }

        item {
            InstallButton(
                onClick = {},
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)
            )
        }

    }
}

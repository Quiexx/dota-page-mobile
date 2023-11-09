package com.example.dotapage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotapage.ui.theme.AppTheme

data class CommentContent(val image: Int, val author: String, val date: String, val text: String)

@Composable
fun ReviewAndRatings(modifier: Modifier, comments: List<CommentContent>, rating: Double) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.review_ratings_title),
            color = AppTheme.TextColors.primary,
            style = AppTheme.TextStyle.Bold_16,
        )

        RatingAndReviewsCount(rating = rating)

        CommentList(comments = comments)
    }
}

@Composable
fun RatingAndReviewsCount(modifier: Modifier = Modifier, rating: Double) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$rating",
            color = AppTheme.TextColors.primary,
            style = AppTheme.TextStyle.Bold_48
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            RatingStars(rating = rating, starSize = 15.dp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.reviews_count),
                color = AppTheme.TextColors.tertiary,
                style = AppTheme.TextStyle.Regular_12
            )

        }
    }
}

@Composable
fun CommentList(modifier: Modifier = Modifier, comments: List<CommentContent>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        comments.forEachIndexed { index, comment ->
            Column {
                CommentBlock(comment, modifier)
                if (index < comments.size - 1) {
                    Spacer(Modifier.height(20.dp))
                    Divider(
                        color = AppTheme.TextColors.tertiary,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CommentBlock(commentContent: CommentContent, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(commentContent.image),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = commentContent.author,
                    color = AppTheme.TextColors.primary,
                    style = AppTheme.TextStyle.Bold_16
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = commentContent.date,
                    color = AppTheme.TextColors.tertiary,
                    style = AppTheme.TextStyle.Regular_14
                )
            }
        }
        Spacer(Modifier.height(15.dp))
        Text(
            text = commentContent.text,
            color = AppTheme.TextColors.secondary,
            style = AppTheme.TextStyle.Regular_14
        )
    }

}

@Preview
@Composable
fun ReviewAndRatingsPreview() {
    val comments = List(3) {
        CommentContent(
            image = R.drawable.avatar_1,
            author = stringResource(id = R.string.comment_author),
            date = stringResource(id = R.string.comment_date),
            text = stringResource(id = R.string.comment_text)
        )
    }
    ReviewAndRatings(Modifier, comments, 3.5)
}
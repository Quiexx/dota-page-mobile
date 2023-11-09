package com.example.dotapage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotapage.ui.theme.AppTheme

@Composable
fun DotaScreenHeader(modifier: Modifier = Modifier, rating: Double) {
    HeaderBackground(
        painter = painterResource(R.drawable.dota_background),
        modifier = Modifier
    ) {
        HeaderContent(modifier = modifier, rating = rating)
    }
}

@Composable
fun HeaderBackground(
    painter: Painter,
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .height(360.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        content()
    }
}

@Composable
fun HeaderContent(modifier: Modifier, rating: Double) {
    Box(
        modifier = modifier
    ) {
        Column {
            Spacer(modifier = Modifier.height(330.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DotaLogo()

                Column(
                    modifier = Modifier.padding(top = 25.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.dota_name),
                        color = AppTheme.TextColors.primary,
                        style = AppTheme.TextStyle.Bold_18
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        RatingStars(rating = rating, starSize = 15.dp)
                        Text(
                            text = stringResource(id = R.string.header_reviews),
                            color = AppTheme.TextColors.tertiary,
                            style = AppTheme.TextStyle.Regular_10
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            ScrollableChips(listOf("MOBA", "MULTIPLAYER", "STRATEGY"))
        }
    }

}

@Composable
fun ScrollableChips(chips: List<String>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(chips) { chip ->
            Chip(name = chip)
        }
    }
}

@Composable
fun Chip(name: String) {
    Surface(
        color = AppTheme.BgColors.chip,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
    ) {
        Text(
            text = name,
            color = AppTheme.TextColors.chip,
            style = AppTheme.TextStyle.Regular_10,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
        )
    }
}

@Preview
@Composable
fun DotaLogo() {
    Surface(
        color = AppTheme.BgColors.logo,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                2.dp,
                AppTheme.BgColors.logoBorder,
                RoundedCornerShape(20.dp)
            )
    ) {
        Image(
            painter = painterResource(R.drawable.dota_logo),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .padding(18.dp)
        )
    }
}

@Preview
@Composable
fun DotaScreenHeaderPreview() {
    Surface(
        color = AppTheme.BgColors.primary
    ) {
        DotaScreenHeader(rating = 4.9)
    }
}
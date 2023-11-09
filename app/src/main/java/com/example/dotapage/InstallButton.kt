package com.example.dotapage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotapage.ui.theme.AppTheme

@Composable
fun InstallButton(onClick: () -> Unit, modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(AppTheme.ButtonColors.background)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = stringResource(id = R.string.button_text),
            color = AppTheme.ButtonColors.text,
            style = AppTheme.TextStyle.Bold_24,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Preview
@Composable
fun InstallButtonPreview() {
    InstallButton(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    )
}
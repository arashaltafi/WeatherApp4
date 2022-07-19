package com.arash.altafi.weatherapp4.main_view_background_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.arash.altafi.weatherapp4.theme.getMainViewBottomBackgroundColor
import com.arash.altafi.weatherapp4.theme.getMainViewTopBackgroundColor

@Composable
fun MainViewBackgroundView(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colors.getMainViewTopBackgroundColor(),
                    MaterialTheme.colors.getMainViewBottomBackgroundColor()
                )
            )
        )
    ) {
        content()
    }
}

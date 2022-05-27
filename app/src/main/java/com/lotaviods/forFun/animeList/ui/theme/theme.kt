package com.lotaviods.forFun.animeList.ui.theme

import android.content.res.Resources
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors: Colors = if (darkTheme) {
        lightColors()
        //TODO: add DarkMode = darkColors()
    } else {
        lightColors()
    }

    MaterialTheme(
        content = content,
        colors = colors
    )
}
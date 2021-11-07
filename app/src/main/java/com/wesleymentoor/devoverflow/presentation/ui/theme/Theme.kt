package com.wesleymentoor.devoverflow.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Color.Yellow.copy(alpha = 0.87f)

    primary = onPrimary,
    primaryVariant = onPrimary.copy(0.87f),
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = onBackground,
    surface = onSurface.copy(0.87f),
    error = error,
    onPrimary = primary,
    onSecondary = onSecondary.copy(0.87f),
    onBackground = background.copy(0.87f),
    onSurface = surface.copy(0.87f),
    onError = onError.copy(0.87f)
)

private val LightColorPalette = lightColors(
//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Color.Yellow.copy(alpha = 0.87f)

    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    error = error,
    onPrimary = onPrimary.copy(0.60f),
    onSecondary = onSecondary.copy(0.38f),
    onBackground = onBackground.copy(0.87f),
    onSurface = onSurface.copy(0.60f),
    onError = onError.copy(0.60f)
)

@Composable
fun DevOverflowTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
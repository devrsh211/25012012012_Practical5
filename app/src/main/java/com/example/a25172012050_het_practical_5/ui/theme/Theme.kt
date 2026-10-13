package com.example.a25172012050_het_practical_5.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class GuniColors(
    val background: Color,
    val cardBackground: Color,
    val cardBorder: Color,
    val inputBorder: Color,
    val inputText: Color,
    val inputPlaceholder: Color,
    val labelText: Color,
    val buttonBackground: Color,
    val buttonText: Color,
    val textSecondary: Color,
    val accentPink: Color = GuniPink,
    val isDark: Boolean
)

val DarkGuniColors = GuniColors(
    background = DarkBackground,
    cardBackground = DarkCardBackground,
    cardBorder = DarkCardBorder,
    inputBorder = DarkInputBorder,
    inputText = DarkInputText,
    inputPlaceholder = DarkInputPlaceholder,
    labelText = DarkLabelText,
    buttonBackground = DarkButtonBackground,
    buttonText = DarkButtonText,
    textSecondary = DarkTextSecondary,
    accentPink = GuniPink,
    isDark = true
)

val LightGuniColors = GuniColors(
    background = LightBackground,
    cardBackground = LightCardBackground,
    cardBorder = LightCardBorder,
    inputBorder = LightInputBorder,
    inputText = LightInputText,
    inputPlaceholder = LightInputPlaceholder,
    labelText = LightLabelText,
    buttonBackground = LightButtonBackground,
    buttonText = LightButtonText,
    textSecondary = LightTextSecondary,
    accentPink = GuniPink,
    isDark = false
)

val LocalGuniColors = staticCompositionLocalOf { LightGuniColors }

object GuniTheme {
    val colors: GuniColors
        @Composable
        get() = LocalGuniColors.current
}

private val DarkMaterialColorScheme = darkColorScheme(
    primary = GuniPink,
    onPrimary = Color.White,
    secondary = DarkButtonBackground,
    onSecondary = DarkButtonText,
    background = DarkBackground,
    onBackground = DarkInputText,
    surface = DarkCardBackground,
    onSurface = DarkInputText
)

private val LightMaterialColorScheme = lightColorScheme(
    primary = GuniPink,
    onPrimary = Color.White,
    secondary = LightButtonBackground,
    onSecondary = LightButtonText,
    background = LightBackground,
    onBackground = LightInputText,
    surface = LightCardBackground,
    onSurface = LightInputText
)

@Composable
fun _25172012050_Het_Practical_5Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val guniColors = if (darkTheme) DarkGuniColors else LightGuniColors
    val materialColorScheme = if (darkTheme) DarkMaterialColorScheme else LightMaterialColorScheme

    CompositionLocalProvider(LocalGuniColors provides guniColors) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography,
            content = content
        )
    }
}
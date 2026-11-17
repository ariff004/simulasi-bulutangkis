package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = HistoricGoldPrimary,
    onPrimary = HistoricDarkBg,
    primaryContainer = HistoricGoldDark,
    onPrimaryContainer = ParchmentText,
    secondary = HistoricBronze,
    onSecondary = ParchmentText,
    background = HistoricDarkBg,
    onBackground = ParchmentText,
    surface = HistoricDarkSurface,
    onSurface = ParchmentText,
    surfaceVariant = HistoricDarkSurfaceVariant,
    onSurfaceVariant = ParchmentTextMuted
)

private val LightColorScheme = lightColorScheme(
    primary = HistoricBronzeDark,
    onPrimary = ParchmentText,
    primaryContainer = HistoricLightSurfaceVariant,
    onPrimaryContainer = CharcoalText,
    secondary = HistoricBronze,
    onSecondary = ParchmentText,
    background = HistoricLightBg,
    onBackground = CharcoalText,
    surface = HistoricLightSurface,
    onSurface = CharcoalText,
    surfaceVariant = HistoricLightSurfaceVariant,
    onSurfaceVariant = CharcoalTextMuted
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep historic theme consistent
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

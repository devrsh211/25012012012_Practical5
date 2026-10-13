package com.example.a25172012050_het_practical_5.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a25172012050_het_practical_5.ui.theme.GuniPink
import com.example.a25172012050_het_practical_5.ui.theme.GuniTheme

/**
 * GUNI Brand Header displaying the vibrant logo and optional theme toggle.
 */
@Composable
fun GuniHeader(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean? = null,
    onToggleTheme: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        // Centered GUNI logo
        Text(
            text = "GUNI",
            color = GuniPink,
            fontSize = 42.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 2.sp
        )

        // Optional theme toggle in the top-right corner
        if (onToggleTheme != null && isDarkTheme != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape)
                    .background(GuniTheme.colors.cardBackground)
                    .clickable { onToggleTheme() }
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isDarkTheme) "☀️" else "🌙",
                    fontSize = 18.sp
                )
            }
        }
    }
}

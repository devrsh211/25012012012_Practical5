package com.example.a25172012050_het_practical_5.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a25172012050_het_practical_5.ui.theme.GuniPink
import com.example.a25172012050_het_practical_5.ui.theme.GuniTheme

/**
 * Footer prompt at the bottom of the screen to switch between Login and Register.
 */
@Composable
fun BottomNavigationPrompt(
    prefixText: String,
    actionText: String,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$prefixText ",
            color = GuniTheme.colors.textSecondary,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = actionText,
            color = GuniPink,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onActionClick() }
        )
    }
}

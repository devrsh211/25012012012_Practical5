package com.example.a25172012050_het_practical_5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormField(
    label: String,
    textState: String,
    onTextChange: (String) -> Unit,
    isPassword: Boolean = false,
    isNumber: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )

        OutlinedTextField(
            value = textState,
            onValueChange = {
                // If isNumber, allow only digits
                if (isNumber) {
                    if (it.all { char -> char.isDigit() }) {
                        onTextChange(it)
                    }
                } else {
                    onTextChange(it)
                }
            },
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(2f),
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = if (isNumber) KeyboardOptions(keyboardType = KeyboardType.Number) else KeyboardOptions.Default,
            label = { Text("Enter $label") },
            singleLine = true
        )
    }
}
@Composable
@Preview
fun FormFieldPreview() {
    FormField(
        label = "Name",
        textState = "John Doe",
        onTextChange = {},
        isPassword = false,
        isNumber = false
    )
}

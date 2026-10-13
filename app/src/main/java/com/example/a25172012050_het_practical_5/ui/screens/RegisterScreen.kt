package com.example.a25172012050_het_practical_5.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.a25172012050_het_practical_5.ui.components.BottomNavigationPrompt
import com.example.a25172012050_het_practical_5.ui.components.FormRowField
import com.example.a25172012050_het_practical_5.ui.components.GuniButton
import com.example.a25172012050_het_practical_5.ui.components.GuniHeader
import com.example.a25172012050_het_practical_5.ui.theme.GuniTheme

/**
 * Registration Screen featuring the GUNI logo, elevated form card,
 * 6 input fields (Name, Phone Number, City, Email, Password, Confirm Password),
 * Register button, and "LOGIN" footer prompt.
 */
@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean? = null,
    onToggleTheme: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var name by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var city by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(GuniTheme.colors.background)
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Header with GUNI branding and theme switch
            GuniHeader(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Card container enclosing all 6 registration fields and Register button
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = GuniTheme.colors.cardBorder,
                        shape = RoundedCornerShape(16.dp)
                    ),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = GuniTheme.colors.cardBackground
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = if (GuniTheme.colors.isDark) 0.dp else 4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 20.dp)
                ) {
                    // 1. Name
                    FormRowField(
                        label = "Name",
                        value = name,
                        onValueChange = { name = it },
                        placeholder = "Enter Name",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 2. Phone Number
                    FormRowField(
                        label = "Phone Number",
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        placeholder = "Enter Phone Number",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 3. City
                    FormRowField(
                        label = "City",
                        value = city,
                        onValueChange = { city = it },
                        placeholder = "Enter City",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 4. Email
                    FormRowField(
                        label = "Email",
                        value = email,
                        onValueChange = { email = it },
                        placeholder = "Enter Email",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 5. Password
                    FormRowField(
                        label = "Password",
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "Enter Password",
                        isPassword = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 6. Confirm Password
                    FormRowField(
                        label = "Confirm\nPassword",
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        placeholder = "Enter Confirm Password",
                        isPassword = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        )
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    // Register Action Button
                    GuniButton(
                        text = "Register",
                        onClick = {
                            focusManager.clearFocus()
                            when {
                                name.isBlank() -> {
                                    Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
                                }
                                phoneNumber.isBlank() -> {
                                    Toast.makeText(context, "Please enter your phone number", Toast.LENGTH_SHORT).show()
                                }
                                city.isBlank() -> {
                                    Toast.makeText(context, "Please enter your city", Toast.LENGTH_SHORT).show()
                                }
                                email.isBlank() -> {
                                    Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
                                }
                                password.isBlank() -> {
                                    Toast.makeText(context, "Please enter a password", Toast.LENGTH_SHORT).show()
                                }
                                password != confirmPassword -> {
                                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    Toast.makeText(context, "Registration Successful! Please login", Toast.LENGTH_SHORT).show()
                                    onNavigateToLogin()
                                }
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Footer prompt to navigate back to Login
            BottomNavigationPrompt(
                prefixText = "Do you have an account?",
                actionText = "LOGIN",
                onActionClick = onNavigateToLogin
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

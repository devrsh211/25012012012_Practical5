package com.example.a25172012050_het_practical_5.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a25172012050_het_practical_5.ui.components.BottomNavigationPrompt
import com.example.a25172012050_het_practical_5.ui.components.FormRowField
import com.example.a25172012050_het_practical_5.ui.components.GuniButton
import com.example.a25172012050_het_practical_5.ui.components.GuniHeader
import com.example.a25172012050_het_practical_5.ui.theme.GuniTheme

/**
 * Login Screen featuring the GUNI logo, elevated form card,
 * email & password inputs, "Forgot Password?" link, and "SIGN UP" footer.
 */
@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean? = null,
    onToggleTheme: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

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
            Spacer(modifier = Modifier.height(24.dp))

            // Header with GUNI branding and theme switch
            GuniHeader(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Card container enclosing form rows and Login button
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
                        .padding(horizontal = 18.dp, vertical = 22.dp)
                ) {
                    // Email row
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

                    Spacer(modifier = Modifier.height(16.dp))

                    // Password row
                    FormRowField(
                        label = "Password",
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "Enter Password",
                        isPassword = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // "Forgot Password?" right aligned
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = "Forgot Password?",
                            color = GuniTheme.colors.textSecondary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Password reset link sent to your email",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                .padding(vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    // Login Action Button
                    GuniButton(
                        text = "Login",
                        onClick = {
                            focusManager.clearFocus()
                            when {
                                email.isBlank() -> {
                                    Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
                                }
                                password.isBlank() -> {
                                    Toast.makeText(context, "Please enter your password", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    Toast.makeText(context, "Login Successful! Welcome, $email", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Footer prompt to navigate to Register
            BottomNavigationPrompt(
                prefixText = "Don't have an account?",
                actionText = "SIGN UP",
                onActionClick = onNavigateToRegister
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

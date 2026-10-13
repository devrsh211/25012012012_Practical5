package com.example.a25172012050_het_practical_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a25172012050_het_practical_5.ui.screens.LoginScreen
import com.example.a25172012050_het_practical_5.ui.screens.RegisterScreen
import com.example.a25172012050_het_practical_5.ui.theme.GuniTheme
import com.example.a25172012050_het_practical_5.ui.theme._25172012050_Het_Practical_5Theme

enum class AuthScreen {
    LOGIN,
    REGISTER
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemInDark = isSystemInDarkTheme()
            var isDarkTheme by rememberSaveable { mutableStateOf(systemInDark) }

            _25172012050_Het_Practical_5Theme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GuniTheme.colors.background
                ) {
                    AuthAppNavHost(
                        isDarkTheme = isDarkTheme,
                        onToggleTheme = { isDarkTheme = !isDarkTheme }
                    )
                }
            }
        }
    }
}

/**
 * Handles navigation between Login and Registration screens with BackHandler
 * and animated transitions.
 */
@Composable
fun AuthAppNavHost(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    initialScreen: AuthScreen = AuthScreen.LOGIN
) {
    var currentScreen by rememberSaveable { mutableStateOf(initialScreen) }

    // Intercept hardware/gesture back press on Registration to navigate back to Login
    BackHandler(enabled = currentScreen == AuthScreen.REGISTER) {
        currentScreen = AuthScreen.LOGIN
    }

    Crossfade(
        targetState = currentScreen,
        animationSpec = tween(durationMillis = 300),
        label = "AuthScreenCrossfade"
    ) { screen ->
        when (screen) {
            AuthScreen.LOGIN -> {
                LoginScreen(
                    onNavigateToRegister = { currentScreen = AuthScreen.REGISTER },
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = onToggleTheme
                )
            }
            AuthScreen.REGISTER -> {
                RegisterScreen(
                    onNavigateToLogin = { currentScreen = AuthScreen.LOGIN },
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = onToggleTheme
                )
            }
        }
    }
}

/* ==========================================================================
   Jetpack Compose Previews matching the 4 screens in the Practical assignment
   ========================================================================== */

@Preview(name = "1. Dark Mode - Login Screen", showBackground = true, widthDp = 380, heightDp = 800)
@Composable
fun LoginScreenDarkPreview() {
    _25172012050_Het_Practical_5Theme(darkTheme = true) {
        LoginScreen(
            onNavigateToRegister = {},
            isDarkTheme = true,
            onToggleTheme = {}
        )
    }
}

@Preview(name = "2. Dark Mode - Registration Screen", showBackground = true, widthDp = 380, heightDp = 800)
@Composable
fun RegisterScreenDarkPreview() {
    _25172012050_Het_Practical_5Theme(darkTheme = true) {
        RegisterScreen(
            onNavigateToLogin = {},
            isDarkTheme = true,
            onToggleTheme = {}
        )
    }
}

@Preview(name = "3. Light Mode - Registration Screen", showBackground = true, widthDp = 380, heightDp = 800)
@Composable
fun RegisterScreenLightPreview() {
    _25172012050_Het_Practical_5Theme(darkTheme = false) {
        RegisterScreen(
            onNavigateToLogin = {},
            isDarkTheme = false,
            onToggleTheme = {}
        )
    }
}

@Preview(name = "4. Light Mode - Login Screen", showBackground = true, widthDp = 380, heightDp = 800)
@Composable
fun LoginScreenLightPreview() {
    _25172012050_Het_Practical_5Theme(darkTheme = false) {
        LoginScreen(
            onNavigateToRegister = {},
            isDarkTheme = false,
            onToggleTheme = {}
        )
    }
}
package com.rahatshah.mediaplayerdemo


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rahatshah.mediaplayerdemo.ui.screens.MusicListScreen

@Composable
fun Navigation() {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MusicListScreen.route) {

        composable(Screen.MusicListScreen.route) {

            MusicListScreen()
        }



        // rest of screens

    }


}

private sealed class Screen(val route: String) {
    object MusicListScreen : Screen("MusicListScreen")
    object PlayerScreen : Screen("PlayerScreen")
}
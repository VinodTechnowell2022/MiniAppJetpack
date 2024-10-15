package com.tw.miniappjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.tw.miniappjetpack.routes.Routes
import com.tw.miniappjetpack.ui.screens.HomeScreen
import com.tw.miniappjetpack.ui.screens.ProfileScreen
import com.tw.miniappjetpack.ui.screens.SettingScreen
import com.tw.miniappjetpack.ui.screens.Signup
import com.tw.miniappjetpack.ui.screens.SignupScreen
import com.tw.miniappjetpack.ui.screens.SimpleLoginScreen
import com.tw.miniappjetpack.ui.screens.Splash
import com.tw.miniappjetpack.ui.theme.SabziMandiJetpackTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SabziMandiJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.e(this.javaClass.name, "onCreate: $innerPadding" )
                    ScreenMain()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenMain() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Splash.route) {

        composable(Routes.Splash.route) {
            Splash(navController = navController)
        }

        composable(Routes.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(Routes.SimpleLoginScreen.route) {
            SimpleLoginScreen(navController)
        }

        composable(Routes.SignupScreen.route) {
            SignupScreen(navController)
        }

        composable(Routes.Signup.route) {
            Signup(navController)
        }


        composable(Routes.Home.route) {
            HomeScreen()
        }

        //Settings Route, Notice the "/{id}" in last, its the argument passed down from homeScreen
        composable(Routes.SettingScreen.route + "/{id}") { navBackStack ->

            //Extracting the argument
            val data = navBackStack.arguments?.getString("id")

            //Setting screen, Pass the extracted Counter
            SettingScreen(data = data)
        }
    }
}
package com.tw.miniappjetpack.routes

sealed class Routes(val route: String) {

    object Splash : Routes("splash")

    object SimpleLoginScreen : Routes("simpleLoginScreen")

    object SignupScreen : Routes("signupScreen")

    object Signup : Routes("signup")

    object Home : Routes("home")

    object ProfileScreen : Routes("profile")

    object SettingScreen : Routes("setting")
}
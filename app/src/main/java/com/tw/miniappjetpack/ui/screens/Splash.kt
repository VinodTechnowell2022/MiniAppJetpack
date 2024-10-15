package com.tw.miniappjetpack.ui.screens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavHostController
import com.tw.miniappjetpack.R
import com.tw.miniappjetpack.routes.Routes
import com.tw.miniappjetpack.ui.theme.MainColor

@Composable
fun Splash(navController: NavHostController) {
    val view = LocalView.current
    SideEffect {
        requestFullScreen(view)
    }

    Column (
    Modifier.background( color= MainColor ).fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    ){
        // ... other content
        Image(
            painter = painterResource(R.drawable.sabji_mandi_logo),
            contentDescription = "Gmail",
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
        )

//        LocalView.current.context.getActivity()?.resources?.let {
//            Text(text = it.getString(R.string.app_name),
//                color = Color.White,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold)
//        }

    }



    Log.e("TAG", "gotoNextScreen: Home " )
    Handler(Looper.getMainLooper()).postDelayed({
        navController.navigate(Routes.Signup.route)
//        navController.popBackStack()
    }, 3000)


}

fun requestFullScreen(view: View) {
    // !! should be safe here since the view is part of an Activity
    val window = view.context.getActivity()!!.window
    WindowCompat.getInsetsController(window, view).hide(
        WindowInsetsCompat.Type.statusBars() or
                WindowInsetsCompat.Type.navigationBars()
    )
}

fun Context.getActivity(): Activity? = when (this) {
    is Activity -> this
    // this recursion should be okay since we call getActivity on a view context
    // that should have an Activity as its baseContext at some point
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
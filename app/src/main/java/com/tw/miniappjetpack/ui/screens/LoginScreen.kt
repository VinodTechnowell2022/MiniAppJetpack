package com.tw.miniappjetpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tw.miniappjetpack.R
import com.tw.miniappjetpack.routes.Routes
import com.tw.miniappjetpack.ui.theme.MainColor


@Composable
fun SimpleLoginScreen(navController: NavHostController) {

    val (focusRequester) = FocusRequester.createRefs()
    val keyboardController = LocalSoftwareKeyboardController.current

    var email by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    var sum by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .verticalScroll( rememberScrollState() )
            .fillMaxSize() //it works like match_parent on height and width as well
            .background(
                color = colorResource(R.color.white).copy(alpha = 0.65f)
            ),
         verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

       // Spacer(modifier = Modifier.height(25.dp))

            Image(
                painter = painterResource(R.drawable.sabji_mandi_logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
               // colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Green),
                modifier = Modifier
//                    .padding(16.dp)
                    .width(250.dp)
                    //.height(280.dp)
                    //.background(color = colorResource(R.color.grey).copy(alpha = 0.35f))
            )

       // Spacer(modifier = Modifier.height(2.dp))

        Text(text = "Please enter credentials", fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily =  androidx.compose.ui.text.font.FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.height(26.dp))
        OutlinedTextField(
            value = email,
            singleLine = true,
            leadingIcon = { Icon(painter = painterResource(R.drawable.baseline_email_24),
                contentDescription = "Mobile", tint = Color.Gray) },
            onValueChange = {
                email = it
            }, label = {
                Text(text = "Mobile Number")
            },
            keyboardActions = KeyboardActions(
                onNext = {},),
            maxLines = 1, )

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
           // horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(text = " 8 ")
            Text(text = " + ")
            Text(text = " 7 ")
            Text(text = " = ")

            OutlinedTextField(
                value = sum,
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_email_24),
                        contentDescription = "Sum", tint = Color.Gray
                    )
                },
                onValueChange = {
                    sum = it
                },
                label = {
                    Text(text = "Sum?")
                },
                keyboardActions = KeyboardActions(
                    onNext = {},
                ),
                maxLines = 1,
            )
        }


        Spacer(modifier = Modifier.height(26.dp))
        OutlinedButton(onClick = {

            navController.navigate(Routes.Signup.route)

        } , colors = ButtonColors(containerColor = MainColor, contentColor = Color.White, disabledContainerColor = Color.Gray, disabledContentColor = Color.Gray)) {
            Text("Login", Modifier.padding(horizontal = 100.dp, vertical = 5.dp))
        }

        Spacer(modifier = Modifier.height(26.dp))

        Row {
            Spacer(modifier = Modifier.width(26.dp))
            Text(text = "Not signed in yet?", modifier = Modifier.clickable {  })

            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "Click Signup", modifier = Modifier.clickable {
                navController.navigate(Routes.Signup.route)
            },color = MainColor)


//            (text = "Click Signup", modifier = Modifier.clickable {
//
//            }, color = MainColor)
        }



    }
}




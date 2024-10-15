package com.tw.miniappjetpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tw.miniappjetpack.R
import com.tw.miniappjetpack.routes.Routes
import com.tw.miniappjetpack.ui.theme.MainColor


@Composable
fun Signup(navController: NavHostController) {

    val (focusRequester) = FocusRequester.createRefs()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    var email by remember{
        mutableStateOf("")
    }

    var name by remember{
        mutableStateOf("")
    }

    var phone by remember{
        mutableStateOf("")
    }

    var location by remember{
        mutableStateOf("")
    }



    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
//            .weight(weight = 1f, fill = false)
            .fillMaxSize() //it works like match_parent on height and width as well
            .background(color = colorResource(R.color.white).copy(alpha = 0.65f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(5.dp))

        Image(
            painter = painterResource(id = R.drawable.sabji_mandi_logo),
            contentDescription = stringResource(id = R.string.app_logo),
            modifier = Modifier.size(125.dp)
        )

        Spacer(modifier = Modifier.height(1.dp))

        Text(text = "Signup", fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily =  androidx.compose.ui.text.font.FontFamily.Default
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = name,
            singleLine = true,
           // leadingIcon = { Icon(painter = painterResource(R.drawable.baseline_email_24), contentDescription = "Name", tint = Color.Gray) },
            onValueChange = {
                name = it
            }, label = {
                Text(text = "Name")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            maxLines = 1, )


        Spacer(modifier = Modifier.height(26.dp))

        OutlinedTextField(
            value = phone,
            singleLine = true,
            //leadingIcon = { Icon(painter = painterResource(R.drawable.baseline_email_24), contentDescription = "Phone", tint = Color.Gray) },
            onValueChange = {
                phone = it
            }, label = {
                Text(text = "Phone")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            maxLines = 1, )

        Spacer(modifier = Modifier.height(26.dp))
        OutlinedTextField(
            value = email,
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            onValueChange = {
                email = it
            }, label = {
                Text(text = "Email (optional)")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            maxLines = 1,
            )
        Spacer(modifier = Modifier.height(26.dp))

        OutlinedTextField(
            value = location,
            singleLine = true,
            leadingIcon = { Icon(painter = painterResource(R.drawable.location_pin_24), contentDescription = "Location", tint = Color.Red) },
            onValueChange = {
                location = it
            }, label = {
                Text(text = "Location")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            maxLines = 1, )

        Spacer(modifier = Modifier.height(26.dp))

        OutlinedButton(onClick = {

            navController.navigate(Routes.SimpleLoginScreen.route)
//            navController.popBackStack()

        } , colors = ButtonColors(containerColor = MainColor, contentColor = Color.White, disabledContainerColor = Color.Gray, disabledContentColor = Color.Gray)) {
            Text("Signup", Modifier.padding(horizontal = 100.dp, vertical = 5.dp))
        }

        Spacer(modifier = Modifier.height(26.dp))
        Text(text = "Forgot Password?", modifier = Modifier.clickable {  })

    }
}


package com.example.awantrixprojects.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.awantrixprojects.R
import com.example.awantrixprojects.ui.theme.AwantrixProjectsTheme
import com.example.awantrixprojects.utils.HandelEvents
import com.example.awantrixprojects.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Home() {

    val homeViewModel: HomeViewModel = viewModel()
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {}

    LoginComposable(homeViewModel)
    Observer(homeViewModel, scaffoldState)

}

@Composable
fun Observer(homeViewModel: HomeViewModel, scaffoldState: ScaffoldState) {

    LaunchedEffect(key1 = true) {
        homeViewModel.eventFlow.collectLatest {
            when (it) {
                is HandelEvents.ShowErrorMessages -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = it.messages.toString(),
                        actionLabel = "Okay"
                    )
                }
                is HandelEvents.ShowSuccessMessages -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = it.messages.toString(),
                        actionLabel = "Okay"
                    )
                }
            }
        }
    }
}

@Composable
fun LoginComposable(homeViewModel: HomeViewModel) {
    val emailValue = remember {
        mutableStateOf("")
    }
    val passwordValue = remember {
        mutableStateOf("")
    }

    val passwordVisiblity = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(8.68f)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .padding(10.dp)
    ) {
        Text(
            text = "Sign In", style = TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = TextUnit.Unspecified,
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //this is for email
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = {
                    emailValue.value = it
                },
                label = {
                    Text(text = "Email Address")
                },
                placeholder = {
                    Text(text = "Enter Your Email")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(1f),
                leadingIcon = {
                    IconButton(onClick = { })
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_email_24),
                            contentDescription = "",
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                value = passwordValue.value,

                onValueChange = {
                    passwordValue.value = it
                },

                label = {
                    Text(text = "Password ")
                },
                placeholder = {
                    Text(text = "Enter Your Password")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(1f),
                trailingIcon = {
                    IconButton(onClick = { passwordVisiblity.value = !passwordVisiblity.value }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "",
                            tint = if (passwordVisiblity.value) Color.Black else Color.Gray
                        )
                    }
                },
                visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.padding(20.dp))
            //login button
            Button(
                onClick = {
                    homeViewModel.sendData(
                        emailValue.value.toString(),
                        passwordValue.value.toString()
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(45.dp)
            ) {
                Text(text = "Sign In", fontSize = 15.sp)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewee() {
    AwantrixProjectsTheme {
        // LoginComposable(homeViewModel = hom)
    }
}


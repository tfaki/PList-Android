package com.loftymr.plist.screen.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.loftymr.plist.domain.request.SignupRequest
import com.loftymr.plist.res.component.PListButton
import com.loftymr.plist.res.component.PListLoading
import com.loftymr.plist.res.component.PListOutlinedTextField
import com.loftymr.plist.ui.theme.PListColor

/**
 * Created by talhafaki on 29.09.2022.
 */

@Composable
fun SignupScreen(
    viewModel: SignupViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    SignupContent(
        clickToButton = {
            viewModel.signup(it)
        }
    )

    when (viewModel.screenState) {
        is SignupState.Loading -> {
            PListLoading()
        }
        is SignupState.Error -> {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }
        is SignupState.Content -> {
            Toast.makeText(context, "Done", Toast.LENGTH_LONG).show()
        }
        is SignupState.Idle -> Unit
    }
}



@Composable
fun SignupContent(clickToButton: (SignupRequest) -> Unit) {
    val signUpRequest = SignupRequest()
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = PListColor.SolidBlue)) {
        PListOutlinedTextField(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            label = "Email",
            callbackText = {
                emailText = it
            }
        )

        PListOutlinedTextField(
            label = "Password",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            callbackText = {
                passwordText = it
            }
        )

        PListButton(buttonText = "Kayit Ol") {
            signUpRequest.email = emailText
            signUpRequest.password = passwordText
            signUpRequest.name = "emirhan"
            signUpRequest.lastname = "emmez"
            signUpRequest.number = "myNumber"
            clickToButton.invoke(signUpRequest)
        }
    }
}
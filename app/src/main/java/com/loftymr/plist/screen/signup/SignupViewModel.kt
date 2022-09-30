package com.loftymr.plist.screen.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loftymr.plist.data.remote.repository.PListRepository
import com.loftymr.plist.domain.request.SignupRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by talhafaki on 29.09.2022.
 */

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val pListRepository: PListRepository
) : ViewModel() {

    var screenState: SignupState by mutableStateOf(SignupState.Idle)

    fun signup(signupRequest: SignupRequest) = viewModelScope.launch {
        screenState = SignupState.Loading
        pListRepository.signUp(signupRequest)
            .onSuccess {
                screenState = SignupState.Content
            }.onFailure {
                screenState = SignupState.Error
            }
    }
}

sealed class SignupState {
    object Loading: SignupState()
    object Idle: SignupState()
    object Error: SignupState()
    object Content: SignupState()
}
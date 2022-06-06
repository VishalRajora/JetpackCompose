package com.example.awantrixprojects.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awantrixprojects.utils.HandelEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel : ViewModel() {


    private var checkAuth = Channel<HandelEvents>()
    val check = checkAuth.receiveAsFlow()

    private val _eventFlow = MutableSharedFlow<HandelEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun sendData(email: String, password: String) = viewModelScope.launch {
        Dispatchers.IO
        Timber.i("Called")
        when {
            email.isBlank() or email.isEmpty()
            -> {
                _eventFlow.emit(HandelEvents.ShowErrorMessages("Email Can't be empty"))
                Timber.i("Called i")
            }
            password.isEmpty() or password.isEmpty() -> {
                _eventFlow.emit(HandelEvents.ShowErrorMessages("Password Can't be empty"))
                Timber.i("Called iii")
            }
            else -> {
                _eventFlow.emit(HandelEvents.ShowSuccessMessages("Success"))
            }
        }
    }

}
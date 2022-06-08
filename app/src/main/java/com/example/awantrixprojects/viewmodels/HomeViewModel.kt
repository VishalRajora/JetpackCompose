package com.example.awantrixprojects.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awantrixprojects.repository.HomeRepo
import com.example.awantrixprojects.utils.HandelEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(val repo: HomeRepo) : ViewModel() {

    private var checkAuth = Channel<HandelEvents>()
    val check = checkAuth.receiveAsFlow()

    private val _eventFlow = MutableSharedFlow<HandelEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun sendData(email: String, password: String) = viewModelScope.launch() {
        when {
            email.isBlank() or email.isEmpty()
            -> {
                _eventFlow.emit(HandelEvents.ShowErrorMessages("Email Can't be empty"))
            }
            password.isEmpty() or password.isEmpty() -> {
                _eventFlow.emit(HandelEvents.ShowErrorMessages("Password Can't be empty"))
            }
            else -> {
                _eventFlow.emit(HandelEvents.ShowSuccessMessages("Success"))
                repo.saveData(email, password)
            }
        }
    }
}
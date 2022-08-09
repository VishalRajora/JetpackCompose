package com.example.awantrixprojects.mvi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awantrixprojects.repository.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MVIHomeViewModel @Inject constructor(private val remoteSource: HomeRepo) :
    ViewModel() {

    var state by mutableStateOf(
        HomeContract.State(
            status = "",
            isLoading = true
        )
    )
        private set

    var effects = Channel<HomeContract.Effect>(Channel.UNLIMITED)
        private set


    fun setData(email: String, password: String) = viewModelScope.launch {
        val result = remoteSource.saveData(email, password)
        Timber.i("InsideResult $result")
        if (result.toInt() > -1) {
            Timber.i("Inside")
            viewModelScope.launch {
                state = state.copy(status = "Success", isLoading = false)
                effects.send(HomeContract.Effect.DataWasLoaded)
            }
        } else {
            Timber.i("Inside failed")
            viewModelScope.launch {
                state = state.copy(status = "Failed", isLoading = false)
                effects.send(HomeContract.Effect.DataWasFailed)
            }
        }
    }
}
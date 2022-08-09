package com.thegoodguys.pos.core.compose.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.channels.Channel

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

// Tutorial found: https://codingtroops.com/android/compose-architecture-part-1-mvvm-or-mvi-architecture-with-flow/#comments

 abstract class MVIViewModel<
        Event : ViewEvent,
        UiStateForHome : ViewState,
        EffectForHome : ViewSideEffect,
        > : ViewModel() {

    private val initialState: UiStateForHome by lazy { setInitialState() }
    abstract fun setInitialState(): UiStateForHome


    private val _viewState: MutableState<UiStateForHome> = mutableStateOf(initialState)
    val viewState: State<UiStateForHome> = _viewState

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    private val _effect: Channel<EffectForHome> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    fun setEvent(event: Event) {
        viewModelScope.launch { _event.emit(event) }
    }

    protected fun setState(reducer: UiStateForHome.() -> UiStateForHome) {
        val newState = viewState.value.reducer()
        _viewState.value = newState
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            _event.collect {
                handleEvents(it)
            }
        }
    }

    abstract fun handleEvents(event: Event)

    protected fun setEffect(builder: () -> EffectForHome) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

}
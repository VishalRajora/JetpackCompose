package com.example.awantrixprojects.mvi


class HomeContract {

    data class State(
        val status: String = "",
        val isLoading: Boolean = false
    )

    sealed class Effect {
        object DataWasLoaded : Effect()
        object DataWasFailed : Effect()
    }
}
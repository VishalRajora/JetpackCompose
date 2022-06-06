package com.example.awantrixprojects.utils

sealed class HandelEvents {
    data class ShowSuccessMessages(val messages: String) : HandelEvents()
    data class ShowErrorMessages(val messages: String) : HandelEvents()
}

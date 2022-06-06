package com.example.awantrixprojects.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.awantrixprojects.ui.theme.AwantrixProjectsTheme

@Composable
fun Unlocked() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "UnlockedFF",
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPrevieweeee() {
    AwantrixProjectsTheme {
        Unlocked()
    }
}
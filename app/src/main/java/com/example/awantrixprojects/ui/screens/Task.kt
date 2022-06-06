package com.example.awantrixprojects.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.awantrixprojects.R
import com.example.awantrixprojects.ui.theme.AwantrixProjectsTheme

@Composable
fun Task() {
    ToolBars()
}


@Composable
fun UserList() {
    LazyColumn {
        item {
            UserCard()
            UserCard()
            UserCard()
            UserCard()
            UserCard()
            UserCard()
            UserCard()
            UserCard()
            UserCard()
        }
    }
}

@Composable
fun ToolBars() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(backgroundColor = Color.White,
                    title = {
                        Text(
                            text = "Task",
                        )
                    }, navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }, actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Settings, contentDescription = "")
                        }
                    })
            }, floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                    }
                }
            }
        ) {
            UserList()
        }
    }
}

@Composable
fun UserCard() {
    Card(
        elevation = 4.dp, modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = "BREVILLE THE Barista Espresso Coffie",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(text = "Model :")
                    Text(text = "5000555888")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(text = "SOH :")
                    Text(text = "4")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(text = "S.order :")
                    Text(text = "CH114455")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(text = "CutOff :")
                    Text(text = "5%")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPrevieweeeee() {
    AwantrixProjectsTheme {
        ToolBars()
    }
}
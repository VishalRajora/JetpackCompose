package com.example.awantrixprojects.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.awantrixprojects.R
import com.example.awantrixprojects.ui.theme.AwantrixProjectsTheme

@Composable
fun Orders() {
    ToolBarForOrder()
}

@Composable
fun ToolBarForOrder() {
    androidx.compose.material.Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.White, title = {
                Text(text = "Orders")
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Search, contentDescription = null)
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
                        contentDescription = ""
                    )
                }
            })
        }) {
            OrderList()
        }
    }
}

@Composable
fun OrderList() {
    LazyColumn {
        item {
            OrderUI()
            OrderUI()
            OrderUI()
            OrderUI()
            OrderUI()
            OrderUI()
            OrderUI()
            OrderUI()
            OrderUI()
        }
    }
}

@Composable
fun OrderUI() {
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
                .padding(5.dp)
        ) {
            Checkbox(
                checked = false, onCheckedChange = {
                }, modifier = Modifier
                    .wrapContentSize()
                    .align(alignment = Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = "S1005599888",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(start = 0.dp, top = 0.dp, end = 2.dp, bottom = 0.dp),
                        text = "BB",
                        color = Color.Red,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "1005599888",
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "2 Items",
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPrevieweee() {
    AwantrixProjectsTheme {
        ToolBarForOrder()
    }
}
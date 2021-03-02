/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PetBean
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "宠物之家") }
                        )
                    },
                    content = {
                        PetList { item ->
                            startActivity(
                                Intent(
                                    this,
                                    PetDetailActivity::class.java
                                ).apply {
                                    putExtra("item", item)
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun PetList(onClick: (item: PetBean) -> Unit) {
    val dataSet = PetBean.defaultValues()
    LazyColumn {
        items(dataSet.size) { index ->
            PetItem(dataSet[index], onClick)
        }
    }
}

@Composable
fun PetItem(item: PetBean, onClick: (item: PetBean) -> Unit) {
    Card(
        elevation = 3.dp,
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .clickable { onClick(item) }
    ) {
        Row {
            Image(
                painter = painterResource(item.rid),
                contentDescription = item.title,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                contentScale = ContentScale.Crop,
            )
            Column {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        top = 5.dp,
                        end = 10.dp,
                    )
                )
                Text(
                    text = item.desc,
                    style = MaterialTheme.typography.caption,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        top = 5.dp,
                        end = 10.dp,
                        bottom = 5.dp
                    )
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        PetList {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PetList {}
    }
}

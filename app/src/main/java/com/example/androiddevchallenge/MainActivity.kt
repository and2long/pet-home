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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PetBean
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "宠物之家") }
            )
        },
        content = {

            val data = mutableListOf(
                PetBean(0, "可爱小狗"),
                PetBean(0, "可爱小狗"),
                PetBean(0, "可爱小狗"),
                PetBean(0, "可爱小狗"),
                PetBean(0, "可爱小狗"),
                PetBean(0, "可爱小狗"),
                PetBean(0, "可爱小狗"),
            )
            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
            ) {
                items(data.size) { index ->
                    Card(
                        elevation = 3.dp,
                        modifier = Modifier.padding(
                            start = 5.dp,
                            top = 5.dp,
                            end = 5.dp,
                            bottom = 10.dp
                        )
                    ) {
                        Column {
                            Image(
                                painter = painterResource(R.mipmap.dog1),
                                contentDescription = "",
                                 modifier = Modifier.fillMaxWidth()
                            )
                            Text(
                                text = data[index].title,
                                Modifier.padding(
                                    start = 10.dp,
                                    top = 5.dp,
                                    end = 5.dp,
                                    bottom = 10.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    )
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

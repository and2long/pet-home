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
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "宠物之家") }
            )
        },
        content = {
            val dataSet = mutableListOf(
                PetBean(R.mipmap.dog1, "哈士奇", "很凶的样子有没有"),
                PetBean(R.mipmap.dog2, "可爱小狗", "在草地上快乐地奔跑"),
                PetBean(R.mipmap.dog3, "柴犬", "柴犬的搞事能力总是不会让人失望。"),
                PetBean(R.mipmap.dog4, "金毛寻回犬", "善于游泳"),
                PetBean(
                    R.mipmap.dog5,
                    "两只小金毛",
                    "两只可爱的小金毛"
                ),
                PetBean(R.mipmap.dog6, "西施犬", "又长又飘逸的毛发扎个蝴蝶结真可爱"),
                PetBean(R.mipmap.dog7, "可爱小狗", "很凶的样子有没有"),
            )
            LazyColumn(
            ) {
                items(dataSet.size) { index ->
                    Card(
                        elevation = 3.dp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                            .fillMaxWidth()
                            .clickable {  }
                    ) {
                        Row {
                            Image(
                                painter = painterResource(dataSet[index].rid),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp),
                                contentScale = ContentScale.Crop,
                            )
                            Column {
                                Text(
                                    text = dataSet[index].title,
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
                                    text = dataSet[index].desc,
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

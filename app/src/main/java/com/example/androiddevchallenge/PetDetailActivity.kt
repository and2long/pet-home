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
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PetBean
import com.example.androiddevchallenge.ui.theme.MyTheme

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getSerializableExtra("item") as PetBean
        setContent {
            MyTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = item.name) },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = ""
                                    )
                                }
                            }
                        )
                    },
                    content = { PetDetail(item) },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                Toast.makeText(this, "喜欢！", Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "",
                                tint = Color(0xffffffff)
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun PetDetail(item: PetBean) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = item.rid),
            contentDescription = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        )
        Box(modifier = Modifier.padding(top = 20.dp)) {
            PetTags(item = item)
        }
        Text(
            text = item.desc,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(15.dp)
        )
    }
}

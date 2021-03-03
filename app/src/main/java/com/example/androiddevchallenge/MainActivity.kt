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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

val colors =
    mutableListOf(
        Color(0xff99cccc),
        Color(0xffffcc99),
        Color(0xffcc9999),
        Color(0xffcccc99),
        Color(0xffff9966),
        Color(0xff99cc66),
        Color(0xffcc99ff),
        Color(0xffffcc99),
        Color(0xffff99cc),
        Color(0xff99ccff),
        Color(0xffff6666),
        Color(0xff6666ff),
        Color(0xffffcc00),
        Color(0xff336666),
    )

@Composable
fun PetItem(item: PetBean, onClick: (item: PetBean) -> Unit) {

    Row(
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .clickable { onClick(item) }
    ) {
        Image(
            painter = painterResource(item.rid),
            contentDescription = item.name,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .clip(shape = RoundedCornerShape(6)),
            contentScale = ContentScale.Crop,
        )
        Column {
            Text(
                text = item.name,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
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
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp, vertical = 5.dp
                    )
                    .height(35.dp)
            )
            PetTags(item = item)
        }
    }
}

@Composable
fun PetTags(item: PetBean) {
    Row(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PetAge(item)
        Spacer(modifier = Modifier.width(10.dp))
        PetBreed(item)
    }
}

@Composable
fun PetBreed(item: PetBean) {
    Surface(
        color = colors[(0 until colors.size).random()],
        modifier = Modifier
            .clip(shape = RoundedCornerShape(50))
    ) {
        Text(
            text = item.breed,
            style = MaterialTheme.typography.caption.copy(color = Color.White),
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun PetAge(item: PetBean) {
    Surface(
        color = colors[(0 until colors.size).random()],
        modifier = Modifier
            .clip(shape = RoundedCornerShape(50))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_age),
                contentDescription = "age",
                modifier = Modifier
                    .height(12.dp)
                    .width(12.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Text(
                text = "${item.age}个月",
                style = MaterialTheme.typography.caption.copy(color = Color.White),
                modifier = Modifier.absolutePadding(left = 5.dp)
            )
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

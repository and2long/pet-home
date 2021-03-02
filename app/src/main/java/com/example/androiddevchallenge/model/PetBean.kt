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
package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R
import java.io.Serializable

data class PetBean(val rid: Int, val title: String, val desc: String) : Serializable {

    companion object {

        /**
         * 模拟数据
         */
        fun defaultValues(): List<PetBean> {
            return mutableListOf(
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
        }
    }
}

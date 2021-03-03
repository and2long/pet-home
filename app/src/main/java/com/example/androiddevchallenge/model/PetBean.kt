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

data class PetBean(
    val rid: Int,
    val name: String,
    val desc: String,
    val age: Int,
    val breed: String
) : Serializable {

    companion object {

        /**
         * 模拟数据
         */
        fun defaultValues(): List<PetBean> {
            return mutableListOf(
                PetBean(
                    R.mipmap.dog1,
                    "豆子",
                    "豆子是非常温顺的，当它见到主人的客人时，尾巴不停的摇尾巴和你打招呼，也会用身子蹭你的腿，或是跳上沙发来任你抚摸它，十分惹人爱。",
                    3,
                    "哈士奇"
                ),
                PetBean(
                    R.mipmap.dog2,
                    "球球",
                    "球球的性格非常温和.如果你对它好，它就会用头顶你的腿，好像是在向你撒娇；可是如果是陌生人来到它的家里，它仍会“汪汪”地叫个不停。",
                    5,
                    "金毛"
                ),
                PetBean(
                    R.mipmap.dog3,
                    "洛奇",
                    "洛奇最爱吃骨头了，每次吃饭的时候，我就把吃剩的肉骨头放进一个专门喂狗的饭碗里，它就会迫不及待地跑到饭碗里，低下头拼命的吃，还吃的津津有味。",
                    7,
                    "柴犬"
                ),
                PetBean(R.mipmap.dog4, "皮特", "皮特是可爱的金毛狗，眼睛大大的，身上的毛长长的，走起路来一扭一扭的，可爱极了。", 4, "金毛"),
                PetBean(
                    R.mipmap.dog5,
                    "当当/妞妞",
                    "它虎头虎脑，脑袋圆圆，耳朵毛茸茸，耳尖是黒色的，耷拉着。眼睛大大的，圆圆的，像个铜铃。鼻头是深棕色的，像块巧克力。鼻孔大大的，热的时候呼哧呼哧直喘粗气。",
                    6,
                    "金毛"
                ),
                PetBean(
                    R.mipmap.dog6,
                    "雪花",
                    "它全身雪白雪白的，两个像大黑宝石似的眼睛在太阳的照射下闪闪发亮，小鼻子黑黑的，两个耳朵一轻轻一动就能听到周围的动静，厉害吧！有客人来时，它总是跑到客人跟前摇着尾巴汪汪的叫，好像在说：\"欢迎欢迎。”",
                    5,
                    "西施犬"
                ),
                PetBean(
                    R.mipmap.dog7,
                    "萝莉",
                    "萝莉长得非常可爱，一双水灵灵的大眼睛，总是一眨一眨的。脖子上围着一条“白围脖”，身上的毛摸着滑滑的，软软的，舒服极了！他还时常吐着舌头，好像很热市的。",
                    2,
                    "泰迪"
                ),
            )
        }
    }
}

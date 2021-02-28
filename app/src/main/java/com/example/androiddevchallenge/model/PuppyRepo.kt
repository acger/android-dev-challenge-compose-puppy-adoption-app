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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object PuppyRepo {
    private val puppies = listOf(
        Puppy(
            2,
            "Buddie",
            Puppy.Sex.MALE,
            "Hi! My name is Buddie! My first days in my life I spent in a family. They had little kids and I wasn't get a long with them. I was adopted shortly after but thought the cats were fun to chase and not be nice to. Unfortunately I have found myself back yet again. I know I can be a little bit of a stinker in the home, but I try real hard to be good. I really do need a home that is low key with no children or other animals. Someone that will take me for walks and spend all their time with me and me only. Could that be you?!",
            R.drawable.austin_kirk_qzenflkkwt0_unsplash
        ),
        Puppy(
            3,
            "Mike",
            Puppy.Sex.MALE,
            "Hi! My name is Mike! My first days in my life I spent in a family. They had little kids and I wasn't get a long with them. They moved away and now I need a new family. I like other dogs and even cats.",
            R.drawable.hannah_grace_fk4timldff0_unsplash
        ),
        Puppy(4, "Trisha", Puppy.Sex.FEMALE, "", R.drawable.matthew_foulds_bn6uvogy5vm_unsplash),
        Puppy(
            1,
            "Miranda",
            Puppy.Sex.FEMALE,
            "Miranda came to us after being severely neglected with another dog. They both were underweight and needed a lot of tlc to get back to the normal dogs they once were. Despite the difficult life she had, Miranda is still looking to trust humans once again and find his forever home with NO OTHER PETS OR CHILDREN! Miranda is a very special girl who is easily excited by: play, food, and toys, so she will need someone who knows how to keep her cool when she gets over the top with her excitement.",
            R.drawable.bill_stephan_9lkqymzflre_unsplash
        ),
        Puppy(5, "Tiny", Puppy.Sex.FEMALE, "", R.drawable.patrick_kool_06efqvjkib8_unsplash),
    )

    fun findPuppies(): Flow<List<Puppy>> {
        return flow { emit(puppies) }
    }

    fun findById(puppyId: Int): Puppy {
        return puppies.first { it.id == puppyId }
    }
}

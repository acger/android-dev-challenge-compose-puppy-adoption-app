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

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.overview.PuppyCard
import com.example.androiddevchallenge.ui.overview.PuppyViewModel

@Composable
fun AllPuppies(
    puppyViewModel: PuppyViewModel,
    selectPuppy: (Int) -> Unit
) {
    val lazyListState = rememberLazyListState()

    val typography = MaterialTheme.typography
    val allPuppiesList: List<Puppy> by puppyViewModel.allPuppies.observeAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Overview")
                },
            )
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(16.dp), state = lazyListState
            ) {
                item {
                    Text(text = "Find a best buddy", style = typography.h5)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                itemsIndexed(
                    items = allPuppiesList,
                    itemContent = { index, item ->
                        PuppyCard(item, selectPuppy)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                )
            }
        }
    )
}

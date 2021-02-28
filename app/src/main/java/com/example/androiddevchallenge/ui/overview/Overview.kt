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
                itemsIndexed(items = allPuppiesList, itemContent = { index, item ->
                    PuppyCard(item, selectPuppy)
                    Spacer(modifier = Modifier.height(8.dp))
                })
            }

        }
    )
}
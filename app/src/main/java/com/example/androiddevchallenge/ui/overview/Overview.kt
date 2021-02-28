package com.example.androiddevchallenge


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.overview.PuppyCard
import com.example.androiddevchallenge.viewmodel.OverviewViewModel

@Composable
fun AllPuppies(navController: NavHostController, overviewViewModel: OverviewViewModel) {
    val allPuppiesList: List<Puppy> by overviewViewModel.allPuppies.observeAsState(initial = emptyList<Puppy>())
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(allPuppiesList) { puppy ->
            PuppyCard(puppy)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}
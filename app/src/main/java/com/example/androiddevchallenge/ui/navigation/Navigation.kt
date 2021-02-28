package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.PuppyRepo
import com.example.androiddevchallenge.viewmodel.OverviewViewModel

@Composable
fun NavGraph() {
    val overviewViewModel = OverviewViewModel(PuppyRepo.findPuppies())
    val navController = rememberNavController()

    NavHost(navController, startDestination = "overview") {
        composable("overview") { AllPuppies(navController, overviewViewModel) }
    }

}
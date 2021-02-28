package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.PuppyRepo
import com.example.androiddevchallenge.ui.details.DetailsViewModel
import com.example.androiddevchallenge.ui.details.PuppyDetails
import com.example.androiddevchallenge.ui.overview.PuppyViewModel

@Composable
fun NavGraph() {
    val repo = PuppyRepo
    val overviewViewModel = PuppyViewModel(repo)
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController, startDestination = "overview") {
        composable("overview") { AllPuppies(overviewViewModel, actions.selectPuppy) }
        composable("details/{id}") {
            PuppyDetails(
                DetailsViewModel(
                    repo, requireNotNull(it.arguments?.getString("id")?.toInt())
                ),
                actions.upPress
            )
        }
    }
}


class MainActions(navController: NavHostController) {
    val selectPuppy: (Int) -> Unit = { id: Int ->
        navController.navigate("details/$id")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
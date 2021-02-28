package com.example.androiddevchallenge.ui.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.androiddevchallenge.model.PuppyRepo

class PuppyViewModel(input: PuppyRepo) : ViewModel() {
    val allPuppies = input.findPuppies().asLiveData()

}

class OverviewViewModelFactory(private val repo: PuppyRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PuppyRepo::class.java).newInstance(repo)
    }

}
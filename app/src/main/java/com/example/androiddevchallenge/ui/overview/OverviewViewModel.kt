package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.PuppyRepo
import kotlinx.coroutines.flow.Flow

class OverviewViewModel(input: Flow<List<Puppy>>) : ViewModel() {
    val allPuppies = input.asLiveData()

}

class OverviewViewModelFactory(private val repo: PuppyRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PuppyRepo::class.java).newInstance(repo)
    }

}
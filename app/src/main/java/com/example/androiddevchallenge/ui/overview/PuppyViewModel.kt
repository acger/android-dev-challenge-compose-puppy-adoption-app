package com.example.androiddevchallenge.ui.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.androiddevchallenge.model.PuppyRepo

class PuppyViewModel(input: PuppyRepo) : ViewModel() {
    val allPuppies = input.findPuppies().asLiveData()
}

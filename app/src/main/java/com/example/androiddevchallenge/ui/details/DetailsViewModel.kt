package com.example.androiddevchallenge.ui.details

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.PuppyRepo

class DetailsViewModel(repo: PuppyRepo, puppyId: Int) : ViewModel() {
    val puppy = repo.findById(puppyId)
}
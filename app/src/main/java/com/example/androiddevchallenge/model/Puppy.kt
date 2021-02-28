package com.example.androiddevchallenge.model

data class Puppy(
    val id: Long,
    val name: String,
    val sex: Sex,
    val description: String,
    val image: Int
) {
    enum class Sex {
        MALE,
        FEMALE
    }
}

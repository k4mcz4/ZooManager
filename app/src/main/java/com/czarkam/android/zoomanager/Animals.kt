package com.czarkam.android.zoomanager

data class Animal(
    var age: Int,
    var weight: Int,
    val gender: Boolean,
    val species: Species
){
    fun aging() = age.plus(1)
    fun feed() = weight.plus(species.weightGain)
}


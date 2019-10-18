package com.czarkam.android.zoomanager

import java.util.concurrent.ThreadLocalRandom

class Animal(
    private val speciesAttributes: AnimalSpecies,
    private var isDeceased: Boolean = false,
    val isFemale: Boolean = ThreadLocalRandom.current().nextBoolean(),
    private val isNewBorn: Boolean = false
) {

    var age: Int = if (isNewBorn) {
        1
    } else {
        ThreadLocalRandom.current().nextInt(1, speciesAttributes.maxAge / 2)
    }
    var weight: Int = ThreadLocalRandom.current().nextInt(1, speciesAttributes.maxWeight)

    fun getMaxAge(): Int {
        return speciesAttributes.maxAge
    }

    fun getMaxWeight(): Int {
        return speciesAttributes.maxWeight
    }

    fun getName(): String{
        return speciesAttributes.name
    }

    fun aging(): Int {
        if (age > speciesAttributes.maxAge || weight > speciesAttributes.maxWeight || weight <= 0) {
            terminate()
        } else {
            age += 1
        }
        return age
    }

    fun feed(): Int {
        if (!isDeceased) {
            weight += speciesAttributes.weightGain
            aging()
        }
        return weight
    }

    fun makeSound(): Int {
        if (!isDeceased) {
            weight -= speciesAttributes.weightGain / 2
            aging()
            println(speciesAttributes.sound)
        }
        return weight
    }

    private fun terminate() {
        isDeceased = true
    }

    fun isDeceased(): Boolean {
        return isDeceased
    }

}

data class AnimalSpecies(
    val weightGain: Int,
    val maxWeight: Int,
    val maxAge: Int,
    val sound: String,
    val birthDuration: Int,
    val name: String
)
data class AnimalList(var animalList: List<Animal>)
data class Zoo(var animals: List<AnimalList>)
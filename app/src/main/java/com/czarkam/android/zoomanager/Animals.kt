package com.czarkam.android.zoomanager

import java.util.concurrent.ThreadLocalRandom

class Animal(
    private val speciesAttributes: AnimalTypes
) {

    var isDeceased: Boolean = false; private set
    var isFemale: Boolean = ThreadLocalRandom.current().nextBoolean()
    var isNewBorn: Boolean = false; private set

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

    fun getName(): String {
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
        }
        return weight
    }

    fun starve(): Int {
        if (!isDeceased) {
            weight -= speciesAttributes.weightGain / 2
        }
        return weight
    }

    fun makeSound() {
        if (!isDeceased) {
            println(speciesAttributes.sound)
        }
    }

    private fun terminate() {
        isDeceased = true
    }


}

data class AnimalList(var animalList: List<Animal>) {

    fun balanceGender() {
        var femaleCounter = 0
        for (animal in animalList) {
            if (animal.isFemale) {
                femaleCounter++
            }
        }
        when (femaleCounter) {
            animalList.size -> animalList.first().isFemale = false
            0 -> animalList.first().isFemale = true
        }
    }

}

data class Zoo(var animals: List<AnimalList>)
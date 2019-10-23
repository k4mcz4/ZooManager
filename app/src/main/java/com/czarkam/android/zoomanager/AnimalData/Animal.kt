package com.czarkam.android.zoomanager.AnimalData

import com.czarkam.android.zoomanager.System.RenderSpaces
import java.util.concurrent.ThreadLocalRandom

class Animal(
    private val speciesAttributes: AnimalTypes
) {

    //TODO Clean it up

    var isDeceased: Boolean = false; private set
    var isFemale: Boolean = ThreadLocalRandom.current().nextBoolean()
    var isNewBorn: Boolean = false; private set

    var age: Int = if (isNewBorn) {
        1
    } else {
        ThreadLocalRandom.current().nextInt(1, speciesAttributes.maxAge / 2)
    }

    private fun getAgeLength(): Int {
        return age.toString().length
    }

    var weight: Int = ThreadLocalRandom.current().nextInt(1, speciesAttributes.maxWeight)

    private fun getWeightLength(): Int {
        return weight.toString().length
    }

    fun getMaxAge(): Int {
        return speciesAttributes.maxAge
    }

    private fun getMaxAgeLength(): Int {
        return getMaxAge().toString().length
    }

    fun getMaxWeight(): Int {
        return speciesAttributes.maxWeight
    }

    private fun getMaxWeightLength(): Int {
        return getMaxWeight().toString().length
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

    fun getMaxLeftSpacing(): Int {

        return when (getAgeLength() > getWeightLength()) {
            true -> getAgeLength()
            false -> getWeightLength()
        }
    }

    fun getMaxRightSpacing(): Int {

        return when (getMaxAgeLength() > getMaxWeightLength()) {
            true -> getMaxAgeLength()
            false -> getMaxWeightLength()
        }
    }

    private fun returnDisplayAge(): String {
        return "$age/${getMaxAge()}"
    }

    private fun returnDisplayWeight(): String {
        return "$weight/${getMaxWeight()}"
    }

    fun returnAgeWithSpaces(spacer: RenderSpaces): String {
        return "${spaceGenerator(spacer.leftSpacing - getAgeLength())}${returnDisplayAge()}${spaceGenerator(
            spacer.rightSpacing - getMaxAgeLength()
        )}"
    }

    fun returnWeightWithSpaces(spacer: RenderSpaces): String {
        return "${spaceGenerator(spacer.leftSpacing - getWeightLength())}${returnDisplayWeight()}${spaceGenerator(
            spacer.rightSpacing - getMaxWeightLength()
        )}"
    }

    private fun spaceGenerator(spaceAmount: Int): String {
        var spaces = ""
        for (i in 1..spaceAmount) {
            spaces += " "
        }
        return spaces
    }

}



package com.czarkam.android.zoomanager

import java.util.concurrent.ThreadLocalRandom

class AnimalGenerator {

    fun generateHerd(): Zoo {

        var animalTypes = AnimalTypes.values()
        var animalHerd = Zoo(mutableListOf())

        for (animalType in animalTypes.iterator()) {
            animalHerd.animals += generateAnimals(animalType)
        }
        return animalHerd
    }

    private fun generateAnimals(animalType: AnimalTypes): AnimalList {

        var animals = AnimalList(mutableListOf())
        val loops = ThreadLocalRandom.current().nextInt(2,7)

        for (x in 1..loops) {
            animals.animalList += Animal(animalType)
        }

        return animals
    }


}
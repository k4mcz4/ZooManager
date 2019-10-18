package com.czarkam.android.zoomanager

class AnimalGenerator {

    fun generateHerd(): Zoo {

        var animalTypes = AnimalTypes.getAnimalList()
        var animalHerd = Zoo(mutableListOf())

        for (animalType in animalTypes.iterator()) {
            animalHerd.animals =  animalHerd.animals + generateAnimals(animalType)
        }
        return animalHerd
    }

    private fun generateAnimals(animalType: AnimalSpecies): AnimalList {

        var animals = AnimalList(mutableListOf())

        for (x in 2..5) {
            animals.animalList = animals.animalList + Animal(animalType)
        }

        return animals
    }


}
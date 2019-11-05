package com.czarkam.android.zoomanager.System

import com.czarkam.android.zoomanager.AnimalData.Animal
import com.czarkam.android.zoomanager.AnimalData.AnimalList
import com.czarkam.android.zoomanager.AnimalData.AnimalTypes
import com.czarkam.android.zoomanager.AnimalData.Zoo

class ScreenRender {
    //TODO Tidy everything here. I should be ashamed

    fun displayAnimals(animalsArray: Zoo) {
        val spacers = animalsArray.getMaxLeftRightSpacers()

        for (animalList in animalsArray.animals.iterator()) {

            val clearListForPrint = transmuteAnimalAttributesToCorrectOrder(animalList, spacers)

            println()
            println(animalList.animalList.first().getName())
            println()

            for ((index, item) in clearListForPrint.iterator().withIndex()) {
                when (index == 0) {
                    true -> print("Age:    | ")
                    false -> print("Weight: | ")
                }
                for (i in item.iterator()) {
                    print("$i || ")
                }
                println()
            }
            //TODO Get rid of that and introduce dynamic scaling
            print("-------------------------------------------------")

        }

    }


    private fun transmuteAnimalAttributesToCorrectOrder(
        list: AnimalList,
        spacers: RenderSpaces
    ): MutableList<MutableList<String>> {

        val clearArray = mutableListOf(mutableListOf<String>(), mutableListOf())

        for (animal in list.animalList.iterator()) {
            clearArray[0].add(animal.returnAgeWithSpaces(spacers))
            clearArray[1].add(animal.returnWeightWithSpaces(spacers))
        }

        return clearArray
    }

    fun displayAnimalOptions(){
        println()
        println("Pick animals: ")
        for((index,animal) in AnimalTypes.values().iterator().withIndex()){
            println("${index+1} - ${animal.name}")
        }
    }

    fun displayActionOptions(animal: Animal){
        println()
        println("You picked: ${animal.getName()}")
        println("Pick action:")
        println("1 - Feed")
        println("2 - Walk the animals")
        println("3 - Train")
    }


}

data class RenderSpaces(var leftSpacing: Int = 0, var rightSpacing: Int = 0)




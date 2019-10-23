package com.czarkam.android.zoomanager.System

import com.czarkam.android.zoomanager.AnimalData.AnimalList
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


}

data class RenderSpaces(var leftSpacing: Int = 0, var rightSpacing: Int = 0)




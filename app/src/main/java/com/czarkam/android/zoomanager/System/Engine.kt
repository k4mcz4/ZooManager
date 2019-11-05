package com.czarkam.android.zoomanager.System

import com.czarkam.android.zoomanager.AnimalData.AnimalGenerator
import com.czarkam.android.zoomanager.AnimalData.Zoo

class Game {
    //TODO Add game logic
    fun startGame() {
        var animals = AnimalGenerator().generateHerd()
        var exit = false
        var errorLoop = false
        var round = 1

        loop@ while (!exit) {
            if (!errorLoop) {
                println("Round $round")
                ScreenRender().displayAnimals(animals)
                ScreenRender().displayAnimalOptions()
            }


            var animalOption = readLine()

            //TODO: This looks and feels bad. Clean it up
            try {
                if (animalOption?.toInt() in 1..5) {

                    ScreenRender().displayActionOptions(
                        animals.animals[animalOption?.toInt()!!.minus(
                            1
                        )].animalList.first()
                    )

                    var animalAction = readLine()!!.toInt()

                    performAction(animals, animalOption.toInt(), animalAction)

                    errorLoop = false

                } else {
                    println("Choose a correct number")
                    errorLoop = true
                    continue@loop
                }
            } catch (e: NumberFormatException) {
                println("Choose a correct number")
                errorLoop = true
                continue@loop
            }


            round++

        }
    }


    //TODO Take a DEEP dive into this. Looks and feels dirty and crashes.
    private fun performAction(zoo: Zoo, animalIndex: Int, actionType: Int) {
        for (animals in zoo.animals) {
            for (animal in animals.animalList) {
                if (zoo.animals.indexOf(animals) == animalIndex - 1) {
                    when (actionType) {
                        1 -> animal.feed()
                        2 -> animal.training()
                    }
                } else {
                    animal.starve()
                }
                if (animal.isDeceased) {
                    animals.animalList.removeIf{ it == animal}
                } else {
                    animal.aging()
                }
            }
        }
    }


}
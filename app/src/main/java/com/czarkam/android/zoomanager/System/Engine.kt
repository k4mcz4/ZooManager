package com.czarkam.android.zoomanager.System

import com.czarkam.android.zoomanager.AnimalData.AnimalGenerator
import com.czarkam.android.zoomanager.AnimalData.Zoo

class Game {
    //TODO Add game logic
    fun startGame() {
        var animals = AnimalGenerator().generateHerd()
        var exit = false
        var round = 1

        while (!exit) {
            println("Round $round")
            ScreenRender().displayAnimals(animals)
            ScreenRender().displayOptions()

            var animalOption = if(readLine()!!.toInt() in 1..5) readLine() else

            round++
            exit = true
        }
    }

    private fun performAction(zoo: Zoo, animalIndex: Int, actionType: Int) {
        for (animals in zoo.animals) {
            for (animal in animals.animalList) {
                if (zoo.animals.indexOf(animals) == animalIndex) {
                    when (actionType) {
                        1 -> animal.feed()
                        2 -> animal.training()
                    }
                }
                if (animal.isDeceased) {
                    animals.animalList.remove(animal)
                } else {
                    animal.aging()
                }
            }
        }
    }


}
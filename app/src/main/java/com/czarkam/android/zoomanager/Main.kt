package com.czarkam.android.zoomanager


fun main() {
    var animals = AnimalGenerator().generateHerd()
    var exit = false
    var round = 1

    while (!exit) {

        println("Round $round")

        for (animalList in animals.animals.iterator()) {
            println("Animal: ${animalList.animalList.first().getName()}")
            print("Age: ")
            for (animal in animalList.animalList.iterator()) {
                print(" ${animal.age}/${animal.getMaxAge()} || ")
            }
            println("")
            println("")
        }

        exit = true


    }


}


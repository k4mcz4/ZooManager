package com.czarkam.android.zoomanager

import com.czarkam.android.zoomanager.AnimalData.AnimalGenerator
import com.czarkam.android.zoomanager.System.ScreenRender


fun main() {
    var animals = AnimalGenerator().generateHerd()
    var exit = false
    var round = 1

    //TODO Export everything to separate class

    while (!exit) {

        println("Round $round")

        ScreenRender().displayAnimals(animals)

        exit = true


    }


}


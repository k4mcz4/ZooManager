package com.czarkam.android.zoomanager


fun main() {
    var animals = AnimalGenerator().generateHerd()
    var exit = false
    var round = 1

    while (!exit) {

        println("Round $round")

        ScreenRender().displayAnimals(animals)

        exit = true


    }


}


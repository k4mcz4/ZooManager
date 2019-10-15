package com.czarkam.android.zoomanager


fun main() {
    var wolf = Animal(AnimalTypes.WOLVES)
    var exit = false
    var round = 1

    while(!exit) {

        println("Round $round")

        if(wolf.isDeceased()){
            println("I died :<")
        } else {
            println("Age: ${wolf.age} / ${wolf.getMaxAge()}")
            println("Weight: ${wolf.weight} / ${wolf.getMaxWeight()}")
        }

        val input = readLine()

        when(input){
            "1" -> wolf.feed()
            "2" -> wolf.makeSound()
            "exit" -> exit = true
            "restart" -> wolf = Animal(AnimalTypes.WOLVES)
            else -> println("Enter again")
        }

        println("\n")
        round += 1

    }

}


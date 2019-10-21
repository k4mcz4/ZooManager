package com.czarkam.android.zoomanager

class ScreenRender {
    fun displayAnimals(animalsArray: Zoo) {
        //TODO Introduce and reverse additional array to display stats in correct order
        val frameWidth = displayAnimalsSpacing(animalsArray)

        for (animalList in animalsArray.animals.iterator()) {
            println(animalList.animalList.first().getName())
            for (animal in animalList.animalList.iterator()) {
                printAnimalWithSpacing(animal, frameWidth)
            }
            println()
        }

    }

    private fun displayAnimalsSpacing(animalsArray: Zoo): Int {
        //Calculates Array content looking for the longest entry to render console table

        var frameWidth = 0

        for (animalList in animalsArray.animals.iterator()) {
            for (animal in animalList.animalList.iterator()) {
                frameWidth = maxAttributeLength(animal, frameWidth)
            }
        }
        return frameWidth
    }

    private fun maxAttributeLength(animal: Animal, frame: Int): Int {

        var frameWidth = frame

        var ageString = "${animal.age}/${animal.getMaxAge()}".length
        var weightString = "${animal.weight}/${animal.getMaxWeight()}".length

        if (frameWidth < ageString) {
            frameWidth = ageString
        }

        if (frameWidth < weightString) {
            frameWidth = weightString
        }

        return frameWidth
    }

    private fun calculateSpacing(attributeString: String, maxFrameSpace: Int): Int {
        return maxFrameSpace - attributeString.length / 2
    }


    private fun printAnimalWithSpacing(animal: Animal, maxFrameSpace: Int) {
        var ageString = "${animal.age}/${animal.getMaxAge()}"
        var weightString = "${animal.weight}/${animal.getMaxWeight()}"
        var ageSpaces = generateSpaces(calculateSpacing(ageString, maxFrameSpace))
        var weightSpaces = generateSpaces(calculateSpacing(weightString, maxFrameSpace))
        print (ageSpaces + ageString + ageSpaces)
        print (weightSpaces + weightString + weightSpaces)
    }

    private fun generateSpaces(spacing: Int): String {
        var spaces = ""
        for (i in 1..spacing) {
            spaces += " "
        }

        return spaces

    }

}
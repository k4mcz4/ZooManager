package com.czarkam.android.zoomanager.AnimalData

import com.czarkam.android.zoomanager.System.RenderSpaces

data class AnimalList(var animalList: List<Animal>) {

    fun balanceGender() {
        var femaleCounter = 0
        for (animal in animalList) {
            if (animal.isFemale) {
                femaleCounter++
            }
        }
        when (femaleCounter) {
            animalList.size -> animalList.first().isFemale = false
            0 -> animalList.first().isFemale = true
        }
    }

    fun getMaxLeftRightSpacingInList(): RenderSpaces {
        val spaces = RenderSpaces()
        for (animal in animalList.iterator()) {
            when (animal.getMaxLeftSpacing() > spaces.leftSpacing) {
                true -> spaces.leftSpacing = animal.getMaxLeftSpacing()
            }
            when (animal.getMaxRightSpacing() > spaces.rightSpacing) {
                true -> spaces.rightSpacing = animal.getMaxRightSpacing()
            }
        }
        return spaces
    }

}
package com.czarkam.android.zoomanager.AnimalData

import com.czarkam.android.zoomanager.System.RenderSpaces

data class Zoo(var animals: List<AnimalList>) {
    fun getMaxLeftRightSpacers(): RenderSpaces {
        val finalSpaces = RenderSpaces()
        for (animals in animals.iterator()) {
            val spaces = animals.getMaxLeftRightSpacingInList()
            when (spaces.leftSpacing > finalSpaces.leftSpacing) {
                true -> finalSpaces.leftSpacing = spaces.leftSpacing
            }
            when (spaces.rightSpacing > finalSpaces.rightSpacing) {
                true -> finalSpaces.rightSpacing = spaces.rightSpacing
            }
        }
        return finalSpaces
    }
}
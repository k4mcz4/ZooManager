package com.czarkam.android.zoomanager

class AnimalTypes{
    companion object {
        val WOLVES = AnimalSpecies(
            weightGain = 5,
            maxAge = 10,
            sound = "Auuuu",
            birthDuration = 4,
            maxWeight = 40
        )

        val PARROTS = AnimalSpecies(
            weightGain = 1,
            maxAge = 7,
            sound = "Kraaa?",
            birthDuration = 2,
            maxWeight = 10
        )

        val SEALS = AnimalSpecies(
            weightGain = 3,
            maxAge = 14,
            sound = "Onk Onk",
            birthDuration = 3,
            maxWeight = 55
        )

        val WHALE = AnimalSpecies(
            weightGain = 10,
            maxAge = 200,
            sound = "Thwops in 20Hz",
            birthDuration = 20,
            maxWeight = 300
        )

        val ELEPHANT = AnimalSpecies(
            weightGain = 20,
            maxAge = 210,
            sound = "Pawooo!",
            birthDuration = 20,
            maxWeight = 300
        )
    }
}
package com.czarkam.android.zoomanager

enum class AnimalTypes(
    val weightGain: Int,
    val maxWeight: Int,
    val maxAge: Int,
    val sound: String,
    val birthDuration: Int
) {

    WOLVES(
        weightGain = 1,
        maxAge = 7,
        sound = "Kraaa?",
        birthDuration = 2,
        maxWeight = 10
    ),

    PARROTS(
        weightGain = 1,
        maxAge = 7,
        sound = "Kraaa?",
        birthDuration = 2,
        maxWeight = 10
    ),

    SEALS(
        weightGain = 3,
        maxAge = 14,
        sound = "Onk Onk",
        birthDuration = 3,
        maxWeight = 55
    ),

    WHALE(
        weightGain = 10,
        maxAge = 200,
        sound = "Thwops in 20Hz",
        birthDuration = 20,
        maxWeight = 300
    ),

    ELEPHANT(
        weightGain = 20,
        maxAge = 210,
        sound = "Pawooo!",
        birthDuration = 20,
        maxWeight = 300
    )
}
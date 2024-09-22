package ru.sug4chy.homework2109.model

object RockPaperScissors {

    enum class Variant {
        ROCK,
        PAPER,
        SCISSORS
    }

    enum class Result {
        PLAYER_WIN,
        COMPUTER_WIN,
        DRAW
    }

    fun getResult(playerVariant: Variant, computerVariant: Variant) =
        when (playerVariant) {
            Variant.ROCK -> when(computerVariant) {
                Variant.ROCK -> Result.DRAW
                Variant.PAPER -> Result.COMPUTER_WIN
                Variant.SCISSORS -> Result.PLAYER_WIN
            }
            Variant.PAPER -> when(computerVariant) {
                Variant.ROCK -> Result.PLAYER_WIN
                Variant.PAPER -> Result.DRAW
                Variant.SCISSORS -> Result.COMPUTER_WIN
            }
            Variant.SCISSORS -> when(computerVariant) {
                Variant.ROCK -> Result.COMPUTER_WIN
                Variant.PAPER -> Result.PLAYER_WIN
                Variant.SCISSORS -> Result.DRAW
            }
        }
}
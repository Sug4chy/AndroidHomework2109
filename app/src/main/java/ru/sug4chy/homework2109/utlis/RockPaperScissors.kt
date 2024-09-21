package ru.sug4chy.homework2109.utlis

import ru.sug4chy.homework2109.model.ChosenVariant
import ru.sug4chy.homework2109.model.RockPaperScissorsResult

object RockPaperScissors {

    fun getResult(playerVariant: ChosenVariant, computerVariant: ChosenVariant) =
        when (playerVariant) {
            ChosenVariant.ROCK -> when(computerVariant) {
                ChosenVariant.ROCK -> RockPaperScissorsResult.DRAW
                ChosenVariant.PAPER -> RockPaperScissorsResult.COMPUTER_WIN
                ChosenVariant.SCISSORS -> RockPaperScissorsResult.PLAYER_WIN
            }
            ChosenVariant.PAPER -> when(computerVariant) {
                ChosenVariant.ROCK -> RockPaperScissorsResult.PLAYER_WIN
                ChosenVariant.PAPER -> RockPaperScissorsResult.DRAW
                ChosenVariant.SCISSORS -> RockPaperScissorsResult.COMPUTER_WIN
            }
            ChosenVariant.SCISSORS -> when(computerVariant) {
                ChosenVariant.ROCK -> RockPaperScissorsResult.COMPUTER_WIN
                ChosenVariant.PAPER -> RockPaperScissorsResult.PLAYER_WIN
                ChosenVariant.SCISSORS -> RockPaperScissorsResult.DRAW
            }
        }
}
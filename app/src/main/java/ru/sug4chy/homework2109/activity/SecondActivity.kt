package ru.sug4chy.homework2109.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.sug4chy.homework2109.R
import ru.sug4chy.homework2109.extensions.findButtonById
import ru.sug4chy.homework2109.extensions.findTextViewById
import ru.sug4chy.homework2109.model.RockPaperScissors

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val playerVariant = RockPaperScissors.Variant.valueOf(
            value = intent.extras?.getString(MainActivity.PLAYER_CHOSEN_VARIANT_KEY) ?: return
        ).also {
            findTextViewById(R.id.txv_your_variant).apply {
                text = getString(mapVariantToId(it))
            }
        }

        val computerVariant = RockPaperScissors.Variant.valueOf(
            value = intent.extras?.getString(MainActivity.COMPUTER_CHOSEN_VARIANT_KEY) ?: return
        ).also {
            findTextViewById(R.id.txv_computer_variant).apply {
                text = getString(mapVariantToId(it))
            }
        }

        RockPaperScissors.getResult(
            playerVariant = playerVariant,
            computerVariant = computerVariant
        ).also {
            findTextViewById(R.id.txv_result).apply {
                text = getString(mapResultToId(it))
            }
        }

        findButtonById(R.id.btn_back).setOnClickListener {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun mapVariantToId(variant: RockPaperScissors.Variant) = when (variant) {
        RockPaperScissors.Variant.ROCK -> R.string.rock
        RockPaperScissors.Variant.PAPER -> R.string.paper
        RockPaperScissors.Variant.SCISSORS -> R.string.scissors
    }

    private fun mapResultToId(result: RockPaperScissors.Result) = when (result) {
        RockPaperScissors.Result.PLAYER_WIN -> R.string.you_win
        RockPaperScissors.Result.COMPUTER_WIN -> R.string.computer_win
        RockPaperScissors.Result.DRAW -> R.string.draw
    }
}
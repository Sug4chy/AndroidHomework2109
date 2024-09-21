package ru.sug4chy.homework2109.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.sug4chy.homework2109.R
import ru.sug4chy.homework2109.model.ChosenVariant
import ru.sug4chy.homework2109.model.RockPaperScissorsResult
import ru.sug4chy.homework2109.utlis.RockPaperScissors

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val playerVariant = ChosenVariant.valueOf(
            value = intent.extras?.getString(MainActivity.PLAYER_CHOSEN_VARIANT_KEY) ?: return
        )
        findTextViewById(R.id.txv_your_variant).apply {
            text = getString(mapVariantToId(playerVariant))
        }

        val computerVariant = ChosenVariant.valueOf(
            value = intent.extras?.getString(MainActivity.COMPUTER_CHOSEN_VARIANT_KEY) ?: return
        )
        findTextViewById(R.id.txv_computer_variant).apply {
            text = getString(mapVariantToId(computerVariant))
        }

        val result = RockPaperScissors.getResult(
            playerVariant = playerVariant,
            computerVariant = computerVariant
        )
        findTextViewById(R.id.txv_result).apply {
            text = getString(mapResultToId(result))
        }

        val backBtn = findButtonById(R.id.btn_back)
        backBtn.setOnClickListener {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun mapVariantToId(variant: ChosenVariant) = when (variant) {
        ChosenVariant.ROCK -> R.string.rock
        ChosenVariant.PAPER -> R.string.paper
        ChosenVariant.SCISSORS -> R.string.scissors
    }

    private fun mapResultToId(result: RockPaperScissorsResult) = when (result) {
        RockPaperScissorsResult.PLAYER_WIN -> R.string.you_win
        RockPaperScissorsResult.COMPUTER_WIN -> R.string.computer_win
        RockPaperScissorsResult.DRAW -> R.string.draw
    }
}

fun AppCompatActivity.findTextViewById(id: Int): TextView = findViewById(id)
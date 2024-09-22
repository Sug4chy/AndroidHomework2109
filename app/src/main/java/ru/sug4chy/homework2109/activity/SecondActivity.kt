package ru.sug4chy.homework2109.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.sug4chy.homework2109.R
import ru.sug4chy.homework2109.extensions.findButtonById
import ru.sug4chy.homework2109.extensions.findTextViewById
import ru.sug4chy.homework2109.model.Shape
import ru.sug4chy.homework2109.utils.RockPaperScissors

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        create()

        val playerVariant = Shape.valueOf(
            value = intent.extras?.getString(PLAYER_CHOSEN_VARIANT_KEY) ?: return
        ).also {
            findTextViewById(R.id.txv_your_variant).text = getString(it.stringResourceId)
        }

        val computerVariant = Shape.valueOf(
            value = intent.extras?.getString(COMPUTER_CHOSEN_VARIANT_KEY) ?: return
        ).also {
            findTextViewById(R.id.txv_computer_variant).text = getString(it.stringResourceId)
        }

        RockPaperScissors.getResult(
            playerVariant = playerVariant,
            computerVariant = computerVariant
        ).also {
            findTextViewById(R.id.txv_result).text = getString(it.resourceStringId)
        }

        findButtonById(R.id.btn_back).setOnClickListener {
            this.finish()
        }
    }

    private fun create() {
        setContentView(R.layout.activity_second)
    }

    companion object {
        const val PLAYER_CHOSEN_VARIANT_KEY = "PLAYER_CHOSEN_VARIANT"
        const val COMPUTER_CHOSEN_VARIANT_KEY = "COMPUTER_CHOSEN_VARIANT"
    }
}
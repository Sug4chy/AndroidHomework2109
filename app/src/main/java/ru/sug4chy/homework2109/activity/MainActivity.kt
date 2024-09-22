package ru.sug4chy.homework2109.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.sug4chy.homework2109.R
import ru.sug4chy.homework2109.extensions.findButtonById
import ru.sug4chy.homework2109.model.RockPaperScissors

class MainActivity : AppCompatActivity() {
    private val rockPaperScissorsVariantsTypedArray =
        RockPaperScissors.Variant.entries.toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        findButtonById(R.id.btn_rock).setOnClickListener {
            goToSecondActivity(RockPaperScissors.Variant.ROCK)
        }

        findButtonById(R.id.btn_paper).setOnClickListener {
            goToSecondActivity(RockPaperScissors.Variant.PAPER)
        }

        findButtonById(R.id.btn_scissors).setOnClickListener {
            goToSecondActivity(RockPaperScissors.Variant.SCISSORS)
        }
    }

    private fun goToSecondActivity(variant: RockPaperScissors.Variant) =
        Intent(this, SecondActivity::class.java).apply {
            Bundle().also {
                it.putString(PLAYER_CHOSEN_VARIANT_KEY, variant.name)
                it.putString(
                    COMPUTER_CHOSEN_VARIANT_KEY,
                    rockPaperScissorsVariantsTypedArray.random().name
                )
            }.apply {
                putExtras(this)
            }
        }.run {
            startActivity(this)
        }

    companion object {
        const val PLAYER_CHOSEN_VARIANT_KEY = "PLAYER_CHOSEN_VARIANT"
        const val COMPUTER_CHOSEN_VARIANT_KEY = "COMPUTER_CHOSEN_VARIANT"
    }
}
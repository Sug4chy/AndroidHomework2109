package ru.sug4chy.homework2109.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.sug4chy.homework2109.R
import ru.sug4chy.homework2109.model.ChosenVariant

class MainActivity : AppCompatActivity() {
    private val computerChosenVariant = ChosenVariant.entries.toTypedArray().random()

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
        val rockBtn = findButtonById(R.id.btn_rock)
        rockBtn.setOnClickListener {
            goToSecondActivity(ChosenVariant.ROCK)
        }

        val paperBtn = findButtonById(R.id.brn_paper)
        paperBtn.setOnClickListener {
            goToSecondActivity(ChosenVariant.PAPER)
        }

        val scissorsBtn = findButtonById(R.id.btn_scissors)
        scissorsBtn.setOnClickListener {
            goToSecondActivity(ChosenVariant.SCISSORS)
        }
    }

    private fun goToSecondActivity(variant: ChosenVariant) = startActivity(
        Intent(this, SecondActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putString(PLAYER_CHOSEN_VARIANT_KEY, variant.toString())
            bundle.putString(COMPUTER_CHOSEN_VARIANT_KEY, computerChosenVariant.toString())

            putExtras(bundle)
        }
    )

    companion object {
        const val PLAYER_CHOSEN_VARIANT_KEY = "PLAYER_CHOSEN_VARIANT"
        const val COMPUTER_CHOSEN_VARIANT_KEY = "COMPUTER_CHOSEN_VARIANT"
    }
}

fun AppCompatActivity.findButtonById(id: Int): Button = findViewById(id)
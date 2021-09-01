package com.example.d100

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// this activity allows the user to roll a dice and view the result
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice() //the function is called when button is clicked
        }
    }

    //roll dice and update screen with the result
    private fun rollDice() {

        //lists of strings as res variables
        val weapon_fail = resources.getStringArray(R.array.weapon_fail).toList()
        val weapon_fail_sub = resources.getStringArray(R.array.weapon_fail_sub).toList()

        //dice variables
        val dice = Dice(100) // create new Dice object with 100 sides and roll it
        val diceRoll = dice.roll()

        //update the screen with the result
        var resultTextView: TextView = findViewById(R.id.textView)
        var detailTextView: TextView = findViewById(R.id.details)
        var result: TextView = findViewById(R.id.result)

        //diceRoll logic
        when (diceRoll) {
            1 -> resultTextView.text = weapon_fail.get(0)
            in 2..5 -> resultTextView.text = weapon_fail.get(1)
            in 6..9 -> resultTextView.text = weapon_fail.get(2)
            in 10..14 -> resultTextView.text = weapon_fail.get(3)
            in 15..19 -> resultTextView.text = weapon_fail.get(4)
            in 20..29 -> resultTextView.text = weapon_fail.get(5)
            in 30..39 -> resultTextView.text = weapon_fail.get(6)
            in 40..49 -> resultTextView.text = weapon_fail.get(7)
            in 50..59 -> resultTextView.text = weapon_fail.get(8)
            in 60..69 -> resultTextView.text = weapon_fail.get(9)
            in 70..74 -> resultTextView.text = weapon_fail.get(10)
            in 75..79 -> resultTextView.text = weapon_fail.get(11)
            in 80..89 -> resultTextView.text = weapon_fail.get(12)
            in 90..99 -> resultTextView.text = weapon_fail.get(13)
            else -> {
                resultTextView.text = weapon_fail.get(14)
            }
        }
        when (diceRoll) {
            1 -> detailTextView.text = weapon_fail_sub.get(0)
            in 2..5 -> detailTextView.text = weapon_fail_sub.get(1)
            in 6..9 -> detailTextView.text = weapon_fail_sub.get(2)
            in 10..14 -> detailTextView.text = weapon_fail_sub.get(3)
            in 15..19 -> detailTextView.text = weapon_fail_sub.get(4)
            in 20..29 -> detailTextView.text = weapon_fail_sub.get(5)
            in 30..39 -> detailTextView.text = weapon_fail_sub.get(6)
            in 40..49 -> detailTextView.text = weapon_fail_sub.get(7)
            in 50..59 -> detailTextView.text = weapon_fail_sub.get(8)
            in 60..69 -> detailTextView.text = weapon_fail_sub.get(9)
            in 70..74 -> detailTextView.text = weapon_fail_sub.get(10)
            in 75..79 -> detailTextView.text = weapon_fail_sub.get(11)
            in 80..89 -> detailTextView.text = weapon_fail_sub.get(12)
            in 90..99 -> detailTextView.text = weapon_fail_sub.get(13)
            else -> {
                detailTextView.text = weapon_fail_sub.get(14)
            }
        }
        result.setText("$diceRoll")
    }

    /*
    ********OLD DICEROLL LOGIC********
    View logic, dependent on results
    when (diceRoll) {
    1 -> resultTextView.text = getString(R.string.one_fail_weapon)
    in 2..5 -> resultTextView.text = getString(R.string.two_five_fail_weapon)
    in 6..9 -> resultTextView.text = getString(R.string.six_nine_weapon)
    in 10..14 -> resultTextView.text = getString(R.string.ten_fourteen_weapon)
    in 15..19 -> resultTextView.text = getString(R.string.fifteen_nineteen_weapon)
    in 20..29 -> resultTextView.text = getString(R.string.twenties_weapon)
    in 30..39 -> resultTextView.text = getString(R.string.thirties_weapon)
    in 40..49 -> resultTextView.text = getString(R.string.fourties_weapon)
    in 50..59 -> resultTextView.text = getString(R.string.fifties_weapon)
    in 60..69 -> resultTextView.text = getString(R.string.sixties_weapon)
    in 70..74 -> resultTextView.text = getString(R.string.seventy_seventyfour_weapon)
    in 75..79 -> resultTextView.text = getString(R.string.seventyfive_seventynine_weapon)
    in 80..89 -> resultTextView.text = getString(R.string.eighties_weapon)
    in 90..99 -> resultTextView.text = getString(R.string.nineties_weapon)
    else -> {
    resultTextView.text = getString(R.string.onehundred_weapon)
    }
    }
    when (diceRoll) {
    1 -> detailTextView.text = getString(R.string.one_fail_weapon_sub)
    in 2..5 -> detailTextView.text = getString(R.string.two_five_fail_weapon_sub)
    in 6..9 -> detailTextView.text = getString(R.string.six_nine_weapon_sub)
    in 10..14 -> detailTextView.text = getString(R.string.ten_fourteen_weapon_sub)
    in 15..19 -> detailTextView.text = getString(R.string.fifteen_nineteen_weapon_sub)
    in 20..29 -> detailTextView.text = getString(R.string.twenties_weapon_sub)
    in 30..39 -> detailTextView.text = getString(R.string.thirties_weapon_sub)
    in 40..49 -> detailTextView.text = getString(R.string.fourties_weapon_sub)
    in 50..59 -> detailTextView.text = getString(R.string.fifties_weapon_sub)
    in 60..69 -> detailTextView.text = getString(R.string.sixties_weapon_sub)
    in 70..74 -> detailTextView.text = getString(R.string.seventy_seventyfour_weapon_sub)
    in 75..79 -> detailTextView.text = getString(R.string.seventyfive_seventynine_weapon_sub)
    in 80..89 -> detailTextView.text = getString(R.string.eighties_weapon_sub)
    in 90..99 -> detailTextView.text = getString(R.string.nineties_weapon_sub)
    else -> {
    detailTextView.text = getString(R.string.onehundred_weapon_sub)
    }
    }
    result.setText("$diceRoll")
    }
    */

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}
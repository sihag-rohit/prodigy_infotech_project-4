package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tictactoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var flag = 0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            resetGame()
        }
    }

    fun check(view: View) {
        val btncurrent = view as Button
        if (btncurrent.text == "") {
            count++
            if (flag == 0) {
                btncurrent.text = "x"
                btncurrent.setTextColor(ContextCompat.getColor(this, R.color.colorX))
                flag = 1
            } else {
                btncurrent.text = "o"
                btncurrent.setTextColor(ContextCompat.getColor(this, R.color.colorO))
                flag = 0
            }
            val b1 = binding.btn1.text.toString()
            val b2 = binding.btn2.text.toString()
            val b3 = binding.btn3.text.toString()
            val b4 = binding.btn4.text.toString()
            val b5 = binding.btn5.text.toString()
            val b6 = binding.btn6.text.toString()
            val b7 = binding.btn7.text.toString()
            val b8 = binding.btn8.text.toString()
            val b9 = binding.btn9.text.toString()
            when {
                b1 == b2 && b2 == b3 && b3 != "" -> showWinner(b1)
                b4 == b5 && b5 == b6 && b6 != "" -> showWinner(b4)
                b7 == b8 && b8 == b9 && b9 != "" -> showWinner(b7)
                b1 == b4 && b4 == b7 && b7 != "" -> showWinner(b7)
                b2 == b5 && b5 == b8 && b8 != "" -> showWinner(b5)
                b3 == b6 && b6 == b9 && b9 != "" -> showWinner(b9)
                b1 == b5 && b5 == b9 && b9 != "" -> showWinner(b9)
                b3 == b5 && b5 == b7 && b7 != "" -> showWinner(b7)
                count == 9 -> {
                    Toast.makeText(this@MainActivity, "Match is Drawn", Toast.LENGTH_LONG).show()
                    resetGame()
                }
            }
        }
    }

    private fun showWinner(winner: String) {
        Toast.makeText(this@MainActivity, "Winner is: $winner", Toast.LENGTH_LONG).show()
        resetGame()
    }

    fun resetGame(view: View? = null) {
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        flag = 0
        count = 0
    }
}

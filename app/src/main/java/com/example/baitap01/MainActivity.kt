package com.example.baitap01

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //In số chẵn lẻ
        val btnArray = findViewById<Button>(R.id.button)
        val numbers = generateRandomNumbers(10) // Tạo 10 số ngẫu nhiên

        // Gán sự kiện OnClickListener cho button
        btnArray.setOnClickListener {
            printEvenAndOddNumbers(numbers)
        }
        //Đảo ngược chuỗi
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonReverse = findViewById<Button>(R.id.buttonReverse)
        val textViewOutput = findViewById<TextView>(R.id.textViewOutput)
        buttonReverse.setOnClickListener {
            val inputString = editTextInput.text.toString()

            if (inputString.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập chuỗi ký tự!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val reversedString = reverseString(inputString).uppercase()
            textViewOutput.text = reversedString
            Toast.makeText(this, reversedString, Toast.LENGTH_SHORT).show()
        }
    }

    private fun reverseString(input: String): String {
        val words = input.split(" ")
        val reversedWords = words.reversed()
        return reversedWords.joinToString(" ")
    }

    private fun generateRandomNumbers(count: Int): ArrayList<Int> {
        val random = Random()
        val numbers = arrayListOf<Int>()

        for (i in 1..count) {
            numbers.add(random.nextInt(100)) // Số ngẫu nhiên từ 0 đến 99
        }

        return numbers
    }

    private fun printEvenAndOddNumbers(numbers: ArrayList<Int>) {
        val evenNumbers = numbers.filter { it % 2 == 0 } // Lọc số chẵn
        val oddNumbers = numbers.filter { it % 2 != 0 }  // Lọc số lẻ
        // In ra số chẵn
        Log.d("MainActivity", "Các số chẵn:")
        for (number in evenNumbers) {
            Log.d("MainActivity", number.toString())
        }
        // In ra số lẻ
        Log.d("MainActivity", "Các số lẻ:")
        for (number in oddNumbers) {
            Log.d("MainActivity", number.toString())
        }
    }
}
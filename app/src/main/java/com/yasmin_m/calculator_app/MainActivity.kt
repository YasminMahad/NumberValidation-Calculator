package com.yasmin_m.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tilFirstNum:TextInputLayout
    lateinit var tilSecondNum:TextInputLayout
    lateinit var etFirstNum:TextInputEditText
    lateinit var etSecondNum:TextInputEditText
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnModulus: Button
    lateinit var btnDivision: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CastView()
        calculation()

    }

    fun CastView(){
        tilFirstNum = findViewById(R.id.tilFirstNum)
        tilSecondNum = findViewById(R.id.tilSecondNum)
        etFirstNum = findViewById(R.id.etFirstNum)
        etSecondNum = findViewById(R.id.etSecondNum)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnModulus = findViewById(R.id.btnModulus)
        btnDivision = findViewById(R.id.btnDivision)
        tvResult = findViewById(R.id.tvResult)

    }
    fun calculation(){
        btnAdd.setOnClickListener {
            validation()
            var firstNumber = etFirstNum.text.toString().toInt()
            var secondNumber = etSecondNum.text.toString().toInt()
            calculateAddition(firstNumber,secondNumber)

        }
        btnSubtract.setOnClickListener {
            var firstNumber = etFirstNum.text.toString().toInt()
            var secondNumber = etSecondNum.text.toString().toInt()
            calculateSubtraction(firstNumber,secondNumber)
            validation()
        }
        btnModulus.setOnClickListener {
            var firstNumber = etFirstNum.text.toString().toInt()
            var secondNumber = etSecondNum.text.toString().toInt()
            calculateModulus(firstNumber, secondNumber)
            validation()
        }
        btnDivision.setOnClickListener {
            var firstNumber = etFirstNum.text.toString().toInt()
            var secondNumber = etSecondNum.text.toString().toInt()
            calculateDivision(firstNumber, secondNumber)
            validation()

        }
    }

    fun calculateAddition(firstNumber:Int, secondNumber:Int){
        var add = firstNumber + secondNumber
        tvResult.text = add.toString()
    }
    fun calculateSubtraction(firstNumber: Int,secondNumber: Int){
        var subtract = firstNumber - secondNumber
        tvResult.text = subtract.toString()
    }
    fun calculateModulus(firstNumber: Int, secondNumber: Int){
        var modulus = firstNumber % secondNumber
        tvResult.text = modulus.toString()
    }
    fun calculateDivision(firstNumber: Int, secondNumber: Int){
        var division = firstNumber / secondNumber
        tvResult.text = division.toString()
    }
    fun validation(){
        var error = false

        tilFirstNum.error = null
        tilSecondNum.error = null

        var firstNumber = etFirstNum.text.toString()
        if (firstNumber.isBlank()) {
            tilFirstNum.error = "First number is required"
            error = true
        }
        var secondNumber = etSecondNum.text.toString()
        if (secondNumber.isBlank()) {
            tilSecondNum.error = "Second number is required"
            error = true
        }
        if (!error){}

    }

}
package com.example.calculatortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    //lateinit var num1 = findViewById<EditText>(R.id.etNum)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declared in task 1
        val head = findViewById<TextView>(R.id.tvHeader) //this is the 'Calculator' header
        val num1 = findViewById<EditText>(R.id.etNum)
        val num2 = findViewById<EditText>(R.id.etNum2)
        val add = findViewById<Button>(R.id.btAdd)
        val sub = findViewById<Button>(R.id.btSub)
        val multi = findViewById<Button>(R.id.btMul)
        val div = findViewById<Button>(R.id.btDiv)
        val output = findViewById<TextView>(R.id.tvOut)
        val thanks = findViewById<Button>(R.id.btThankYou)
        val square = findViewById<Button>(R.id.btSqrt) //added declarations
        val power = findViewById<Button>(R.id.btPower)
        val errtext = findViewById<TextView>(R.id.errtext)
        val sum = 0






        //this section sets the input, operator ,and output

        //addition section
        add.setOnClickListener {
            val input1 = num1.text.toString().toInt()   //converts first input to integer and stores in input1
            val input2 = num2.text.toString().toInt()   //converts second input to integer and stores in input2
            val add = input1 + input2                   //applies operation and stores value in variable
            output.text = ("$input1 + $input2 = $add")  //outputs the equation and answer in the output text view
                //added error section
                errtext.visibility = View.VISIBLE
                errtext.text = "No errors."
            Timer().schedule(2000) {
                errtext.visibility = View.INVISIBLE
            }
        }
        //subtraction section
        sub.setOnClickListener {
            val input1 = num1.text.toString().toInt()
            val input2 = num2.text.toString().toInt()
            val sub = input1 - input2
            output.text = ("$input1 - $input2 = $sub")
                //added error section
                errtext.visibility = View.VISIBLE
                errtext.text = "No errors."
                Timer().schedule(2000) {
                errtext.visibility = View.INVISIBLE
            }
        }
        //multiplication section
        multi.setOnClickListener {
            val input1 = num1.text.toString().toInt()
            val input2 = num2.text.toString().toInt()
            val multi = input1 * input2
            output.text = ("$input1 * $input2 = $multi")
                //added error section
                errtext.visibility = View.VISIBLE
                errtext.text = "No errors."
                Timer().schedule(2000) {
                errtext.visibility = View.INVISIBLE
            }
        }
        //division section
        div.setOnClickListener {
            val input1 = num1.text.toString().toInt()
            val input2 = num2.text.toString().toInt()

            //if statement for error checking
            if (input2 == 0){
                Toast.makeText(this, "ERROR You cannot divide by 0", Toast.LENGTH_SHORT).show()
                    num1.text.clear()
                    num2.text.clear()
                    output.text = ""
            }
            if (input2 > 0){
                val div = input1 / input2
                output.text = ("$input1 / $input2 = $div")
                    errtext.visibility = View.VISIBLE
                    errtext.text = "No errors."
                    Timer().schedule(2000) {
                    errtext.visibility = View.INVISIBLE }
            }
        }

        //Task 2 calculations
            //Square root
        square.setOnClickListener {
            val input1 = num1.text.toString()
            val negative = 1
            val newno = input1.toInt()

            //if to check positive input
            if (newno >= 1){
                val sum = Math.sqrt(newno.toDouble())
                output.text = "sqrt(" + input1.toString() + ") = " + sum.roundToInt()
                    errtext.visibility = View.VISIBLE
                    errtext.text = "No errors."
                    Timer().schedule(2000) {
                        errtext.visibility = View.INVISIBLE }
            }
            //if to check negative input
            if (newno <= -1){
                val newno = input1.drop(negative).toInt()
                val sum = Math.sqrt(newno.toDouble())
                output.text = "sqrt(" + input1.toString() + ") = " + sum.roundToInt() + "i"
                    errtext.visibility = View.VISIBLE
                    errtext.text = "No errors."
                    Timer().schedule(2000) {
                        errtext.visibility = View.INVISIBLE }
            }
            //if to check zero as an input
            if (newno == 0){
                Toast.makeText(this, "ERROR You cannot square 0", Toast.LENGTH_SHORT).show()
                num1.text.clear()
                num2.text.clear()
                output.text = ""
            }
        }

            //power calculation
        power.setOnClickListener {
            val input1 = num1.text.toString().toInt()
            var input2 = num2.text.toString().toInt()
            var sum: Long = 1
            while (input2 != 0) {
                sum *= input1.toLong()
                --input2
            }
            output.text = input1.toString() + " ^ " + num2.text.toString() + " = " + sum.toString()
            errtext.visibility = View.VISIBLE
            errtext.text = "No errors."
            Timer().schedule(2000) {
                errtext.visibility = View.INVISIBLE }
        }


        //A toast to say thank you.
        thanks.setOnClickListener {

            Toast.makeText(this, "Thanks for watching!", Toast.LENGTH_SHORT).show()
        }
    }
}
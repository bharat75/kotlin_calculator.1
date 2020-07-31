package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOne.setOnClickListener()
        {
            appendExpression("1", clear = true)
        }

        btnZero.setOnClickListener()
        {
            appendExpression("0", clear = true)
        }

        btnTwo.setOnClickListener()
        {
            appendExpression("2", clear = true)
        }

        btnThree.setOnClickListener()
        {
            appendExpression("3", clear = true)
        }

        btnFour.setOnClickListener()
        {
            appendExpression("4", clear = true)
        }

        btnFive.setOnClickListener()
        {
            appendExpression("5", clear = true)
        }

        btnSix.setOnClickListener()
        {
            appendExpression("6", clear = true)
        }

        btnSeven.setOnClickListener()
        {
            appendExpression("7", clear = true)
        }

        btnEight.setOnClickListener()
        {
            appendExpression("8", clear = true)
        }

        btnNine.setOnClickListener()
        {
            appendExpression("9", clear = true)
        }

        btnDot.setOnClickListener()
        {
            appendExpression(".", clear = true)
        }

        btnPlus.setOnClickListener()
        {
            appendExpression("+", clear = false)
        }

        btnMinus.setOnClickListener()
        {
            appendExpression("-", clear = false)
        }

        btnMultiply.setOnClickListener()
        {
            appendExpression("*", clear = false)
        }

        btnDivide.setOnClickListener()
        {
            appendExpression("/", clear = false)
        }

        btnDel.setOnClickListener()
        {
            tvExpression.text = ""
            tvResult.text = ""
        }

        btnBack.setOnClickListener()
        {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty())
            {
                tvExpression.text = string.substring(0, string.length-1)
            }
            tvResult.text = ""
        }

        btnEquals.setOnClickListener()
        {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                {
                    tvResult.text = longResult.toString()
                }
                else {
                    tvResult.text = result.toString()
                }
            }
            catch (e: Exception)
            {
                Log.d("Exception","message :" + e.message)
            }
        }
    }

     fun appendExpression(s: String, clear: Boolean) {

    if(tvResult.text.isNotEmpty())
    {
        tvExpression.text = ""
    }

         if(clear)
         {
             tvResult.text = ""
             tvExpression.append(s)
         }

         else
         {
             tvExpression.append(tvResult.text)
             tvExpression.append(s)
             tvResult.text = ""
         }

    }

}
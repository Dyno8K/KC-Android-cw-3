package com.example.lesson3;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String output, secondNumStr, symbol ;
    TextView screen;
    double firstNum, secondNum;
    boolean firstNumVal, symbolVal = false;
    double ans, history;
    double ansunrounded;


    //function to reset all variables and validation booleans
    public void Reset(){
        output = null;
        ans = 0;
        symbolVal= false;
        firstNumVal = false;
        secondNumStr = null;
        firstNum = 0;
        secondNum = 0;
    }

    //function to check that the variable containing the output of the screen does not display 'null'
    public void NullCheck(String num)
    {
        if(output == null){
            output = num;

        }
        else{
            output+= num;
        }

    }
    //function to record the second number
    public void SecondNumListener(String num){
        if(symbolVal){
            if(secondNumStr == null){
                secondNumStr = num;

            }
            else{
                secondNumStr+= num;
            }

        }
    }

    //function of every buttons operation
    public void No1(View view) {
        //link Text view from xml to java
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("1");
        NullCheck("1");
        screen.setText(output);
    }

    public void No2(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("2");
        NullCheck("2");
        screen.setText(output);
    }
    public void No3(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("3");
        NullCheck("3");
        screen.setText(output);
    }
    public void No4(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("4");
        NullCheck("4");
        screen.setText(output);
    }
    public void No5(View view) {
        SecondNumListener("5");
        screen = (TextView) findViewById(R.id.Screen);
        NullCheck("5");
        screen.setText(output);
    }
    public void No6(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("6");
        NullCheck("6");
        screen.setText(output);
    }
    public void No7(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("7");
        NullCheck("7");
        screen.setText(output);
    }
    public void No8(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("8");
        NullCheck("8");
        screen.setText(output);
    }
    public void No9(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("9");
        NullCheck("9");
        screen.setText(output);
    }
    public void No0(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        SecondNumListener("0");
        NullCheck("0");
        screen.setText(output);
    }
    //buttons for symbols
    public void NoMultiply(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        //statement to record firstnum
        if (!firstNumVal & output != null){
            firstNum = Integer.parseInt(output);
            firstNumVal = true;
        }

        //if symbol is pressed right after equals previous answer = firstnum
        if(!symbolVal){
            if (output == null & history != 0){
                firstNum = history;
                output = String.valueOf(history);
            }
            NullCheck("×");
            screen.setText(output);
            symbolVal = true;
            symbol = "*";

        }

    }
    public void NoPlus(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        if (!firstNumVal & output != null){
            firstNum = Integer.parseInt(output);
            firstNumVal = true;
        }
        if(!symbolVal){
            if (output == null & history != 0){
                firstNum = history;
                output = String.valueOf(history);
            }
            NullCheck("+");
            screen.setText(output);
            symbolVal = true;
            symbol = "+";

        }
    }
    public void NoMinus(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        if (!firstNumVal & output != null){
            firstNum = Integer.parseInt(output);
            firstNumVal = true;
        }
        if(!symbolVal){
            if (output == null & history != 0){
                firstNum = history;
                output = String.valueOf(history);
            }
            NullCheck("−");
            screen.setText(output);
            symbolVal = true;
            symbol = "-";

        }

    }
    public void NoDivide(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        if (!firstNumVal & output != null) {
            firstNum = Integer.parseInt(output);
            firstNumVal = true;
        }
        if(!symbolVal){
            if (output == null & history != 0){
                firstNum = history;
                output = String.valueOf(history);
            }
            NullCheck("÷");
            screen.setText(output);
            symbolVal = true;
            symbol = "/";

        }

    }
    public void NoEquals(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        NullCheck("=");
        output = null;
        secondNum = Integer.parseInt(secondNumStr);

        //case statement to check the symbol entered and respond accordingly
        switch (symbol){
            case "+":
                ans = firstNum + secondNum;
                //break to not continue through case as there is only one answer
                break;
            case "-":
                ans = firstNum - secondNum;
                break;
            case "*":
                ans = firstNum * secondNum;
                break;
            case "/":

                //division is the only possible symbol to cause decimals
                ansunrounded = firstNum / secondNum;
                //so i rounded up decimals to 3 decimal places
                ans = Math.round(ansunrounded * 1000.0) / 1000.0;

                break;
        }
        //setting answer to history
        history = ans;
        screen.setText(String.valueOf(ans));
        Reset();
    }
    public void NoClear(View view) {
        screen = (TextView) findViewById(R.id.Screen);
        screen.setText("0");
        Reset();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
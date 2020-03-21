package com.example.calculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView inputNumber;

    private Button buttonNumber1;
    private Button buttonNumber2;
    private Button buttonNumber3;
    private Button buttonNumber4;
    private Button buttonNumber5;
    private Button buttonNumber6;
    private Button buttonNumber7;
    private Button buttonNumber8;
    private Button buttonNumber9;
    private Button buttonNumber0;
    private Button buttonPoint;

    private Button buttonPlus;
    private Button buttonEqual;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonSqr;
    private Button buttonSqrt;
    private Button buttonMinus;
    private Button buttonPercent;
    private Button buttonAC;
    private Button buttonClearOneChar;
    private Button buttonSin;
    private Button buttonCos;
    private Button buttonTg;
    private Button buttonCtg;
    private Button buttonSqrNM;
    private Button buttonLog;
    private Button buttonLn;
    private Button buttonFac;

    private String lastoperation = null;
    private double number1;
    private double number2;
    private double result;

    enum Sign {
        PLUS, MINUS, MUL, DIV, SQR, SQRT, PER, SIN, COS, TG, CTG, SQR1, LN, LOG, FAC
    }

    private Sign sign;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("temp", inputNumber.getText().toString());
        outState.putDouble("number1", number1);
        outState.putDouble("number2", number2);
        outState.putSerializable("sign", sign);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.text);

        buttonNumber1 = findViewById(R.id.bt_1);
        buttonNumber2 = findViewById(R.id.bt_2);
        buttonNumber3 = findViewById(R.id.bt_3);
        buttonNumber4 = findViewById(R.id.bt_4);
        buttonNumber5 = findViewById(R.id.bt_5);
        buttonNumber6 = findViewById(R.id.bt_6);
        buttonNumber7 = findViewById(R.id.bt_7);
        buttonNumber8 = findViewById(R.id.bt_8);
        buttonNumber9 = findViewById(R.id.bt_9);
        buttonNumber0 = findViewById(R.id.bt_0);

        buttonPlus = findViewById(R.id.bt_plus);
        buttonEqual = findViewById(R.id.bt_eq);
        buttonSqr = findViewById((R.id.bt_sqr));
        buttonDivide = findViewById(R.id.bt_div);
        buttonSqrt = findViewById(R.id.bt_sqrt);
        buttonMultiply = findViewById(R.id.bt_mult);
        buttonMinus = findViewById(R.id.bt_minus);
        buttonPercent = findViewById(R.id.percent);
        buttonClearOneChar = findViewById(R.id.bt_cancel);
        buttonAC = findViewById(R.id.bt_AC);
        buttonSin = findViewById(R.id.bt_sin);
        buttonCos = findViewById(R.id.bt_cos);
        buttonTg = findViewById(R.id.bt_tg);
        buttonCtg = findViewById(R.id.bt_ctg);
        buttonSqrNM = findViewById(R.id.bt_squareNM);
        buttonFac = findViewById(R.id.bt_fac);
        buttonLn = findViewById(R.id.bt_ln);
        buttonLog = findViewById(R.id.bt_log);
        buttonPoint = findViewById(R.id.bt_point);

        buttonNumber1.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);
        buttonNumber0.setOnClickListener(this);

        buttonPlus.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonSqr.setOnClickListener(this);
        buttonClearOneChar.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTg.setOnClickListener(this);
        buttonCtg.setOnClickListener(this);
        buttonSqrNM.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonLn.setOnClickListener(this);
        buttonFac.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);

        if (savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState);
            number1 = savedInstanceState.getDouble("number1");
            number2 = savedInstanceState.getDouble("number2");
            sign = (Sign) savedInstanceState.getSerializable("sign");
            inputNumber.setText(savedInstanceState.getString("temp"));
        }
    }



    private double calculateFactorial(double n){
        int num = 1;
        for (int i = 1; i <= n; i ++){
            num = num*i;
        }
        return num;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_1:{
                inputNumber.append("1");
                break;
            }
            case R.id.bt_2:{
                inputNumber.append("2");
                break;
            }
            case R.id.bt_3:{
                inputNumber.append("3");
                break;
            }
            case R.id.bt_4:{
                inputNumber.append("4");
                break;
            }
            case R.id.bt_5:{
                inputNumber.append("5");
                break;
            }
            case R.id.bt_6:{
                inputNumber.append("6");
                break;
            }
            case R.id.bt_7:{
                inputNumber.append("7");
                break;
            }
            case R.id.bt_8:{
                inputNumber.append("8");
                break;
            }
            case R.id.bt_9:{
                inputNumber.append("9");
                break;
            }
            case R.id.bt_0:{
                inputNumber.append("0");
                break;
            }
            case R.id.bt_plus:{
                sign = Sign.PLUS;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "+";

                    break;
                }
                else
                    break;
            }
            case R.id.bt_minus: {

                if (inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");

                    if (lastoperation != null) {
                        inputNumber.setText("-");
                    }

                    else if (inputNumber.getText().length() >= 2) {
                        sign = Sign.MINUS;
                        lastoperation = "";
                        break;
                    }
                    else if (inputNumber.getText().length() == 1)
                        break;
                }

                else
                    inputNumber.setText("-");
                break;

            }
            case R.id.bt_div:{

                sign = Sign.DIV;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");

                    lastoperation = "/";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_mult:{
                sign = Sign.MUL;
                if(inputNumber.getText().length() != 0){
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "*";
                    break;
                }
                else{
                    break;
                }
            }
            case R.id.bt_sqr:{
                sign = Sign.SQR;
                if(inputNumber.getText().length() != 0){
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "sqrt";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_sqrt:{
                sign = Sign.SQRT;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "sqrt";
                    break;
                }
                else
                    break;
            }
            case R.id.percent:{
                sign = Sign.PER;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation  = "percent";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_AC:{
                inputNumber.setText("");
                lastoperation = null;
                break;
            }
            case R.id.bt_cancel:{

                if (inputNumber.getText().length() > 10){
                    inputNumber.setText("");
                    break;
                }

                else if (inputNumber.length() != 0) {
                    String number;
                    number = inputNumber.getText().toString();
                    number = number.substring(0, (number.length() - 1));
                    inputNumber.setText(number);
                    break;
                }
                else{
                    break;
                }
            }
            case R.id.bt_sin:{
                sign = Sign.SIN;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "sin";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_cos:{
                sign = Sign.COS;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "cos";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_tg:{
                sign = Sign.TG;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "tg";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_ctg:{
                sign = Sign.CTG;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "ctg";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_squareNM:{
                sign = Sign.SQR1;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "sqaureNM";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_fac:{
                sign = Sign.FAC;
                if(inputNumber.getText().length() != 0) {
                    number1 = Integer.parseInt(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "fac";
                    break;
                }
                else
                    inputNumber.setText("-");
                    lastoperation = "fac";
                    break;
            }
            case R.id.bt_ln:{
                sign = Sign.LN;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "ln";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_log:{
                sign = Sign.LOG;
                if(inputNumber.getText().length() != 0) {
                    number1 = Float.parseFloat(inputNumber.getText().toString());
                    inputNumber.setText("");
                    lastoperation = "log";
                    break;
                }
                else
                    break;
            }
            case R.id.bt_point:{
                if (inputNumber.getText().length() == 0) {

                } else {
                    String number = inputNumber.getText().toString();
                    boolean point = number.contains(".");
                    if (!point)
                        inputNumber.setText(number + ".");
                }
                break;
            }
            case R.id.bt_eq: {
                if (sign == Sign.PLUS) {
                    number2 = Float.parseFloat(inputNumber.getText().toString());
                    result = number1 + number2;

                }
                else if(sign == Sign.MINUS){
                    number2 = Float.parseFloat(inputNumber.getText().toString());
                    result = number1 - number2;
                }
                else if(sign == Sign.MUL){
                    number2 = Float.parseFloat(inputNumber.getText().toString());
                    result = number1 * number2;

                }
                else if(sign == Sign.DIV){
                    number2 = Float.parseFloat(inputNumber.getText().toString());
                    result = number1 / number2;

                }
                else if(sign == Sign.SQR){
                    result = Math.pow(number1,2);
                }
                else if(sign == Sign.SQRT){
                    result = Math.sqrt(number1);
                }
                else if(sign == Sign.PER){
                    result = number1 / 100;
                }
                else if(sign == Sign.SIN){
                    result = Math.sin(number1);
                }
                else if(sign == Sign.COS){
                    result = Math.cos(number1);
                }
                else if(sign == Sign.TG){
                    result = Math.tan(number1);
                }
                else if(sign == Sign.CTG){
                    result = Math.cos(number1) / Math.sin(number1);
                }
                else if(sign == Sign.LN){
                    result = Math.log10(number1);
                }
                else if(sign == Sign.LOG){
                    result = Math.log(number1);
                }
                else if(sign == Sign.FAC){
                    double a;
                    a = calculateFactorial(number1);
                    result = a;
                }
                else if(sign == Sign.SQR1){
                    number2 = Float.parseFloat(inputNumber.getText().toString());
                    result = Math.pow(number1, number2);
                }
                inputNumber.setText(String.valueOf(result));
                lastoperation = null;
                break;
            }
        }
    }
}

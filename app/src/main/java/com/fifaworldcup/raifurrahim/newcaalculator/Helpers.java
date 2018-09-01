package com.fifaworldcup.raifurrahim.newcaalculator;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Helpers {

    public static String division ="/";
    public static String inverseSin = "sin<sup>-1</sup>";
    public static String inverseCos = "cos<sup>-1</sup>";
    public static String inverseTan ="tan<sup>-1</sup>";
    public static String exponential = "e<sup>x</sup>";
    public static String tenPowerX = "10<sup>x</sup>";
    public static String CubeSquare = "3&radic;";
    public static String CubeRoot = "x<sup>3</sup>";
    public static String YPowerX = "Y<sup>x</sup>";
    public static String SquareRoot = "&radic;";
    public static String xSquare = "x<sup>2</sup>";
    public static String pi = "&pi";


    public static void disPlayErrorMassage(Context context){
        Toast.makeText(context,"Input field must not be Zero.",Toast.LENGTH_SHORT).show();
    }

    public static boolean isZero(EditText input){
        if (Double.parseDouble(input.getText().toString()) == 0){
            return true;
        }
        return false;
    }


    public static int getTopicId(Bundle bundle,String InputValue){
        int id = 0;
        if (bundle!=null){
            id = bundle.getInt(InputValue);
        }

        return id;
    }
 }

package com.fifaworldcup.raifurrahim.newcaalculator;


import android.arch.core.util.Function;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Parameters;

import java.util.ArrayList;
import java.util.Iterator;


//add third party library for square root,factorial,cube root,combination,permutation;
public class Calculator {

    //the function has one argument that's name is sqrt.

     final com.fathzer.soft.javaluator.Function sqrt = new com.fathzer.soft.javaluator.Function("sqrt",1);
     final com.fathzer.soft.javaluator.Function factorial = new com.fathzer.soft.javaluator.Function("!",1);
     final com.fathzer.soft.javaluator.Function cuberoot = new com.fathzer.soft.javaluator.Function("crt",1);
     final com.fathzer.soft.javaluator.Function combination = new com.fathzer.soft.javaluator.Function("comb",1);
     final com.fathzer.soft.javaluator.Function permutation = new com.fathzer.soft.javaluator.Function("permu",1);

     Parameters parameters;
     DoubleEvaluator doubleEvaluator;

     private double previousSum = 0;
     private double currentSum = 0;

     private String currentDisplay = "";
     private boolean isRadians =false;


     public Calculator(){
         addFunction();

         //Adds the function to the evaluator

         doubleEvaluator = new DoubleEvaluator(parameters){
             @Override
             protected Double evaluate(com.fathzer.soft.javaluator.Function function, Iterator<Double> arguments, Object evaluationContext) {
                 if (function == sqrt){
                     return Math.sqrt((Double)arguments.next());
                 }
                 else if (function == cuberoot){
                     return Math.cbrt((Double)arguments.next());
                 }else if (function == combination){
                     double numberInput = 0;
                     ArrayList<Double>saveValue = new ArrayList<Double>();
                     while (arguments.hasNext()){
                         numberInput = (Double)arguments.next();
                         saveValue.add(numberInput);
                     }

                     double firstArgument = saveValue.get(0);
                     double secondArgument = saveValue.get(1);
                     double denominator = getFactorial((int)firstArgument);
                     double nominator = getFactorial((int)secondArgument)*(getFactorial((int)(firstArgument-secondArgument)));
                     return denominator/nominator;
                 }
                 else if (function == permutation){
                     double numberInputs = 0;

                     ArrayList<Double>saveValue = new ArrayList<Double>();

                     while (arguments.hasNext()){
                         numberInputs = (Double)arguments.next();
                         saveValue.add(numberInputs);
                     }

                     double firstArgument = saveValue.get(0);
                     double secondArgument = saveValue.get(1);
                     double denominator = getFactorial((int)firstArgument);
                     double nominator = (getFactorial((int)(firstArgument-secondArgument)));
                     return denominator/nominator;
                 }

                 else if (function==factorial){
                     double result = 1;
                     double num = (Double)arguments.next();

                     for (int i=2; i<=num;i++){
                         result = result*1;
                     }
                     return result;
                 }else {
                     return super.evaluate(function,arguments,evaluationContext);
                 }
             }
         };

     }

    private int getFactorial(int n) {
         int result;
         if (n==0|| n==1)
                     return 1;

         result = getFactorial(n-1)*n;
         return result;
    }

    private void addFunction() {
    parameters = DoubleEvaluator.getDefaultParameters();
    parameters.add(sqrt);
    parameters.add(factorial);
    parameters.add(cuberoot);
    parameters.add(combination);
    parameters.add(permutation);

     }



    public String getResult(String currentDisplayed, String ExpressionUsedParsing) {
         //try to parse the information as it entered ,if the parse can't handle it,the word error is shown on the screen.
        try{
            System.out.println("DisplayOut"+ExpressionUsedParsing);
            currentSum = doubleEvaluator.evaluate(fixExpression(ExpressionUsedParsing));
            currentSum = convertToRadians(currentSum);
            currentDisplayed = String.valueOf(currentSum);
        }catch (Exception e){
            currentDisplayed = "Error";
        }
        return currentDisplayed;
    }


    private double convertToRadians(double Sum) {
         double newSum = Sum;
         if (isRadians == true){
             newSum = Math.toRadians(Sum);

         }
        return newSum;
    }


    //used to show display to users
    public String getCurrentDisplay(){
         return currentDisplay;
    }

    //Handle fixing the expression before parsing.Adding parens,making sure parens can multiply with each other.
    private String fixExpression(String exp) {

         int OpenParens = 0;
         int closeParens = 0;
         char openP = '(';
         char closeP = ')';

         String expr = exp;

         for (int i=0;i<exp.length();i++){
             if (exp.charAt(i)==openP){
                 OpenParens++;
             }else if (exp.charAt(i)==closeP)
                 closeParens++;
         }
         while (OpenParens>0){
             expr += closeP;
             OpenParens--;
         }
         while (closeParens>0){
             expr = openP+expr;
             closeParens--;
         }
         expr = multiplicationForParens(expr);
         return expr;
    }

    //used to fix multiplication between parentheses

    private String multiplicationForParens(String s) {

         String fixed = "";

         for (int position = 0;position<s.length();position++){
             fixed +=s.charAt(position);
             if (position == s.length()-1)continue;
             if (s.charAt(position)==')' && s.charAt(position+1)=='(')fixed+='*';

             if (s.charAt(position)== '(' && s.charAt(position+1)==')')fixed+='1';
         }
         return fixed;

    }
}

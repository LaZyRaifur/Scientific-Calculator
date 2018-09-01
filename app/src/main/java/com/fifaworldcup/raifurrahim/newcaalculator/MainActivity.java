package com.fifaworldcup.raifurrahim.newcaalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static junit.runner.BaseTestRunner.getPreference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//Declaring Value

    private TextView outPutResult;
    private TextView shiftDisplay;
    private TextView degreeRed;

    private boolean isDegree = false;
    private boolean isInverse = false;

    private String lastResultObtain = "";
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private Calculator mCalculator;

    private static String Press_Name = "memory";

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnDivided,btnMultiplication,btnAddition,btnSubtract,btnPercent,btnEqual,btnDecimal, btnOpenParenthesis,btnSingleDelete,btnExpo,btnEndParenthesis,btnAnswer, btnSquareRoot,btnXSquare;

    private TextView FactorialTv,CombinationTv,PermutationTv,PiTv,ETv,CommaTv,CubeRootTv,CubeTv,InverseCosTv,InverseSinTv,InverseTanTv,ExponentialTv,TenPowerXTv,RCLTv,STOTv,MMinusTv,FloatTv,DegTv;

    private Button btnSin,btnCos,btnTan,btnLn,btnLog;
    private Button btnYPowerX;
    private Button btnRnd;
    private Button btnShift;
    private Button btnRad;
    private Button btnMPluse;
    private Button btnMs;
    private Button btnMr;
    private Button btnAbs;
    private TextView labelFactorial;
    private TextView InverseXTv;
    private TextView TanPowerXTv;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mCalculator = new Calculator();
        outPutResult =  (TextView)findViewById(R.id.display);
        outPutResult.setText("");

        shiftDisplay = (TextView)findViewById(R.id.shift_display);

        degreeRed = (TextView)findViewById(R.id.degree);

        btn0 = (Button)findViewById(R.id.zeroBt);
        btn1 = (Button)findViewById(R.id.oneBt);
        btn2 = (Button)findViewById(R.id.twoBt);
        btn3 = (Button)findViewById(R.id.threeBt);
        btn4 = (Button)findViewById(R.id.fourBt);
        btn5 = (Button)findViewById(R.id.fiveBt);
        btn6 =(Button)findViewById(R.id.sixBt);
        btn7 = (Button)findViewById(R.id.sevenBt);
        btn8 = (Button)findViewById(R.id.eightBt);
        btn9 = (Button)findViewById(R.id.nineBt);
        btnDivided = (Button)findViewById(R.id.divisionBt);
        btnMultiplication = (Button)findViewById(R.id.multiplicationBt);
        btnAddition = (Button)findViewById(R.id.additionBt);
        btnSubtract = (Button)findViewById(R.id.subtractBt);
        btnPercent = (Button)findViewById(R.id.percent);
        btnDecimal = (Button)findViewById(R.id.dotBt);
        btnOpenParenthesis = (Button)findViewById(R.id.open_bracket);
        btnEndParenthesis = (Button)findViewById(R.id.close_bracket);
        btnExpo =(Button)findViewById(R.id.expBt);
        btnSquareRoot = (Button) findViewById(R.id.square_root);
        btnXSquare = (Button)findViewById(R.id.x_square);
        btnYPowerX = (Button) findViewById(R.id.x_power_y);
        btnSin =(Button)findViewById(R.id.sin_sign);
        btnCos = (Button)findViewById(R.id.cos_sign);
        btnTan = (Button)findViewById(R.id.tan_sign);
        btnLn = (Button)findViewById(R.id.natural_log);
        btnLog = (Button)findViewById(R.id.log);
        btnRnd = (Button)findViewById(R.id.hys);


        //using another class is used for

        btnDivided.setText(Html.fromHtml(Helpers.division));
        btnSquareRoot.setText(Html.fromHtml(Helpers.SquareRoot));
        btnXSquare.setText(Html.fromHtml(Helpers.xSquare));
        btnYPowerX.setText(Html.fromHtml(Helpers.YPowerX));

        btnShift = (Button)findViewById(R.id.shift);
        btnRad = (Button)findViewById(R.id.rad);
        btnAbs = (Button)findViewById(R.id.abs);
        btnMr = (Button)findViewById(R.id.mr);
        btnMs = (Button)findViewById(R.id.ms);
        btnMPluse = (Button)findViewById(R.id.m_plus);
        btnClear = (Button)findViewById(R.id.clear);
        btnSingleDelete = (Button)findViewById(R.id.single_delete);
        btnEqual = (Button)findViewById(R.id.equalSignBt);
        btnAnswer = (Button)findViewById(R.id.ansBt);

        FactorialTv =(TextView)findViewById(R.id.factorial);
        CombinationTv = (TextView)findViewById(R.id.combination);
        PermutationTv = (TextView)findViewById(R.id.permutation);
        PiTv = (TextView)findViewById(R.id.pi);
        ETv = (TextView)findViewById(R.id.e);
        CommaTv = (TextView)findViewById(R.id.comma);
        CubeRootTv = (TextView)findViewById(R.id.cube_root);
        CubeTv = (TextView)findViewById(R.id.cube);
        InverseXTv = (TextView)findViewById(R.id.one_over_x);
        InverseSinTv = (TextView)findViewById(R.id.inverse_sin);
        InverseCosTv = (TextView)findViewById(R.id.inverse_cos);
        InverseTanTv = (TextView)findViewById(R.id.inverse_tan);
        ExponentialTv = (TextView)findViewById(R.id.expo);
        TanPowerXTv = (TextView)findViewById(R.id.ten_power);
        RCLTv = (TextView)findViewById(R.id.rcl);
        STOTv = (TextView)findViewById(R.id.sto);
        MMinusTv = (TextView)findViewById(R.id.m_minus);
        FloatTv = (TextView)findViewById(R.id.float_number);
        DegTv = (TextView)findViewById(R.id.degree);
        InverseSinTv.setText(Html.fromHtml(Helpers.inverseSin));
        InverseCosTv.setText(Html.fromHtml(Helpers.inverseCos));
        InverseTanTv.setText(Html.fromHtml(Helpers.inverseTan));
        ExponentialTv.setText(Html.fromHtml(Helpers.exponential));
        TanPowerXTv.setText(Html.fromHtml(Helpers.tenPowerX));
        CubeRootTv.setText(Html.fromHtml(Helpers.CubeSquare));
        CubeTv.setText(Html.fromHtml(Helpers.CubeRoot));
        PiTv.setText(Html.fromHtml(Helpers.pi));

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDivided.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnAddition.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnOpenParenthesis.setOnClickListener(this);
        btnEndParenthesis.setOnClickListener(this);
        btnSingleDelete.setOnClickListener(this);
        btnExpo.setOnClickListener(this);
        btnSquareRoot.setOnClickListener(this);
        btnXSquare.setOnClickListener(this);
        btnYPowerX.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnRnd.setOnClickListener(this);
        btnShift.setOnClickListener(this);
        btnRad.setOnClickListener(this);
        btnAbs.setOnClickListener(this);
        btnMr.setOnClickListener(this);
        btnMs.setOnClickListener(this);
        btnMPluse.setOnClickListener(this);





    }

    //using switch case for calculation

    private void obtainInputValues(String input){
        switch (input){
            case "0":
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;

            case "1":
                if (isInverse){
                    currentDisplayedInput +="PI";
                    inputToBeParsed +="pi";
                }else {
                    currentDisplayedInput +="1";
                    inputToBeParsed +="1";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "2":
                if (isInverse){
                    currentDisplayedInput +="e";
                    inputToBeParsed +="e";
                }else {
                    currentDisplayedInput +="2";
                    inputToBeParsed +="2";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "3":
                if (isInverse){
                    currentDisplayedInput +=",";
                    inputToBeParsed +=",";
                }else {
                    currentDisplayedInput +="3";
                    inputToBeParsed +="3";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "4":
                if (isInverse){
                    currentDisplayedInput +="!(";
                    inputToBeParsed +="!(";
                }else {
                    currentDisplayedInput +="4";
                    inputToBeParsed +="4";
                }toggleInverse();
                toggleShiftButton();
                break;

            case "5":
                if (isInverse){
                    currentDisplayedInput +="comb(";
                    inputToBeParsed +="comb(";
                }else{
                    currentDisplayedInput +="5";
                    inputToBeParsed +="5";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "6":
                if (isInverse){
                    currentDisplayedInput +="permu(";
                    inputToBeParsed +="permu(";
                }else {
                    currentDisplayedInput +="6";
                    inputToBeParsed +="6";

                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "7":
                currentDisplayedInput +="7";
                inputToBeParsed +="7";
                break;

            case "8":
                currentDisplayedInput +="8";
                inputToBeParsed +="8";
                break;

            case "9":
                currentDisplayedInput +="9";
                inputToBeParsed +="9";
                break;

            case ".":
                currentDisplayedInput +=".";
                inputToBeParsed +=".";
                break;

            case "+":
                currentDisplayedInput +="+";
                inputToBeParsed +="+";
                break;
            case "-":
                currentDisplayedInput +="-";
                inputToBeParsed +="-";
                break;
            case "*":
                currentDisplayedInput +="*";
                inputToBeParsed +="*";
                break;
            case "/":
                currentDisplayedInput +="/";
                inputToBeParsed +="/";
                break;

            case "(":
                currentDisplayedInput +="(";
                inputToBeParsed +="(";
                break;

            case ")":
                currentDisplayedInput +=")";
                inputToBeParsed +=")";
                break;

            case "%":
                if (isInverse){
                    currentDisplayedInput +="1/";
                    inputToBeParsed +="1/";
                }else {
                    currentDisplayedInput +="%";
                    inputToBeParsed +="%";

                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "ln":
                if (isInverse){
                    currentDisplayedInput +="e^";
                    inputToBeParsed +="e^";
                }else {
                    currentDisplayedInput +="ln(";
                    inputToBeParsed +="ln(";

                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "log":
                if (isInverse){
                    currentDisplayedInput +="10^";
                    inputToBeParsed +="10^";
                }else {
                    currentDisplayedInput +="log(";
                    inputToBeParsed +="log(";

                }
                toggleInverse();
                toggleShiftButton();
                break;


            case "√":
                if(isInverse){
                    currentDisplayedInput +="3√(";
                    inputToBeParsed +="crt(";
                }else{
                    currentDisplayedInput +="√(";
                    inputToBeParsed +="sqrt(";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "Yx":
                currentDisplayedInput +="^";
                inputToBeParsed +="^";
                break;

            case "sin":
                if (isInverse){
                    currentDisplayedInput +="asin(";
                    inputToBeParsed +="asin(";

                }else {
                    currentDisplayedInput +="sin(";
                    inputToBeParsed +="sin(";

                }toggleInverse();
                toggleShiftButton();
                break;

            case "cos":
                    if (isInverse){
                        currentDisplayedInput +="acos(";
                       inputToBeParsed +="acos(";
                    }else{
                        currentDisplayedInput +="cos(";
                        inputToBeParsed +="cos(";

                }toggleInverse();
                    toggleShiftButton();
                    break;

            case "tan":
                if (isInverse){
                    currentDisplayedInput +="atan(";
                    inputToBeParsed +="atan(";
                }else {
                    currentDisplayedInput += "tan";
                    inputToBeParsed +="tan";
                }toggleInverse();
                toggleShiftButton();
                break;

            case "exp":
                currentDisplayedInput +="E";
                inputToBeParsed +="EO";
                break;

            case "x2":
                if (isInverse){
                    currentDisplayedInput +="^3";
                    inputToBeParsed +="^3";
                }else
                {
                    currentDisplayedInput +="^2";
                    inputToBeParsed +="^2";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case "rnd":
                double ran = Math.random();
                currentDisplayedInput +=String.valueOf(ran);
                inputToBeParsed +=String.valueOf(ran);
                break;

            case "ABS":
                currentDisplayedInput +="abs(";
                inputToBeParsed +="abs(";
                break;

            case "MR":
                String mValue = getStoredPreferenceValue(MainActivity.this);
                String result = removeTrailingZero(mValue);

                if (!result.equals("0")){
                    currentDisplayedInput +=result;
                    inputToBeParsed +=result;
                }

                break;

            case "MS":
                clearMemoryStorage(MainActivity.this);
                break;

            case "M+":
                if (isInverse){
                    double inputValueMinus = isANumber(outPutResult.getText().toString());
                    if (!Double.isNaN(inputValueMinus)){
                        subtractMemoryStorage(MainActivity.this,inputValueMinus);
                    }

                }else {
                    double inputValue = isANumber(outPutResult.getText().toString());
                    if (!Double.isNaN(inputValue)){
                        addToMemoryStorage(MainActivity.this,inputValue);
                    }
                }
                toggleInverse();
                toggleShiftButton();
                break;


        }
        outPutResult.setText(currentDisplayedInput);
    }

    //method use for memory storage

    private void addToMemoryStorage(Context context, double inputToStore) {

        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue +(float)inputToStore;
        setPreference(context,newValue);

    }

    static public boolean setPreference(Context context, float newValue) {
        SharedPreferences settings  = context.getSharedPreferences(Press_Name,0);
        settings = context.getSharedPreferences(Press_Name,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("key",newValue);
        return editor.commit();
    }

    private void subtractMemoryStorage(Context context,double inputToStore) {

        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue - (float)inputToStore;
        setPreference(context,newValue);
    }

    private double isANumber(String numberInput) {

        double result = Double.NaN;
        try{
            result = Double.parseDouble(numberInput);
        }catch (NumberFormatException nfe){

        }
        return result;
    }

    private void clearMemoryStorage(Context context) {
        setPreference(context,0);
    }

    private String removeTrailingZero(String formattingInput) {

        if (!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue  = formattingInput.substring(dotPosition,formattingInput.length());

        if (newValue.equals(".0")){
            return formattingInput.substring(0,dotPosition);
        }
        return formattingInput;

    }

    private String getStoredPreferenceValue(Context context) {
        float returnedValue = getPreference(context);
        return String.valueOf(returnedValue);
    }

    static public float getPreference(Context c) {

        SharedPreferences settings = c.getSharedPreferences(Press_Name,0);
        settings = c.getSharedPreferences(Press_Name,0);
        float Value = settings.getFloat("key",0);
        return Value;
    }


    private void toggleShiftButton() {

        if (isInverse){
            shiftDisplay.setText("SHIFT");

        }else {
            shiftDisplay.setText("");
        }
    }

    private void toggleInverse() {

        if (isInverse){
            isInverse =false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public void onClick(View v) {

        Button button = (Button) v;
        String data = button.getText().toString();
        Toast.makeText(this,"Click"+data,Toast.LENGTH_SHORT).show();

        if (data.equals("AC")){
            outPutResult.setText("");
            currentDisplayedInput = "";
            inputToBeParsed ="";
        }

        if (data.equals("del")){
            String enterInput = outPutResult.getText().toString();

            if (enterInput.length()>0){
                enterInput = enterInput.substring(0,enterInput.length()-1);
                currentDisplayedInput = enterInput;
                inputToBeParsed = enterInput;
                outPutResult.setText(currentDisplayedInput);
            }
        }else if (data.equals("=")){
            String enterInput = outPutResult.getText().toString();

            //call function that will return the result of the calculation.

            String resultObject = mCalculator.getResult(currentDisplayedInput,inputToBeParsed);
            outPutResult.setText(removeTrailingZero(resultObject));


        }else if (data.equals("Ans")){
            String enterInput = outPutResult.getText().toString();
            enterInput += lastResultObtain;
            outPutResult.setText(enterInput);

        }else if (data.equals("SHIFT")){
            if (!isInverse){
                isInverse =true;
            }else {isInverse = false;}toggleShiftButton();
        }else if(data.equals("RAD")){
            btnRad.setText("DEG");
            degreeRed.setText("RAD");
        }
        else if (data.equals("DEG")){
            btnRad.setText("RAD");
            degreeRed.setText("DEG");
        }else {
            obtainInputValues(data);
        }


    }





}

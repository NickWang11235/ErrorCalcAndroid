package com.example.nickw.errorcalculatorandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.ArrayList;

import calculator.NumWithError;
import calculator.Operations;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private TableLayout tableLayout;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDecimal, btn0, btnPlusMinus,
            btnAdd, btnSubtract, btnMultiply, btnDivide, btnCOSINE, btnSINE, btnTANGENT, btnLOG10,
            btnPower, btnANS, btnClear, btnBackspace;
    private Switch switchRad;
    private String currentNum;
    private boolean decimalPresent, plusMinusPresent;
    private ArrayList<NumWithError> numWithErrors = new ArrayList<>();
    private NumWithError ans, tempAns;
    private Method op = null;
    private boolean radians = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNum = "";
        decimalPresent = false;
        plusMinusPresent = false;

        tableLayout = findViewById(R.id.tableLayout);
        txtView = findViewById(R.id.txtView);
        switchRad = findViewById(R.id.switchRad);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDecimal = findViewById(R.id.btnDecimal);
        btn0 = findViewById(R.id.btn0);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnCOSINE = findViewById(R.id.btnCOSINE);
        btnSINE = findViewById(R.id.btnSINE);
        btnTANGENT = findViewById(R.id.btnTANGENT);
        btnClear = findViewById(R.id.btnClear);
        btnANS = findViewById(R.id.btnANS);
        btnBackspace = findViewById(R.id.btnBackspace);
        btnLOG10 = findViewById(R.id.btnLOG10);

        switchRad.setChecked(true);
        switchRad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                radians = switchRad.getShowText();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn1.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn2.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn3.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn4.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn5.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn6.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn7.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn8.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn9.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!decimalPresent) {
                    currentNum += btnDecimal.getText().toString();
                    txtView.setText(currentNum);
                    tempAns = null;
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum += btn0.getText().toString();
                txtView.setText(currentNum);
                tempAns = null;
            }
        });

        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!plusMinusPresent) {
                    currentNum += btnPlusMinus.getText().toString();
                    txtView.setText(currentNum);
                    tempAns = null;
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalcTwoParam();
                op = Operations.ADD;
                currentNum = "";
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalcTwoParam();
                op = Operations.SUBTRACT;
                currentNum = "";
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalcTwoParam();
                op = Operations.MULTIPLY;
                currentNum = "";
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalcTwoParam();
                op = Operations.DIVIDE;
                currentNum = "";
            }
        });

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalcTwoParam();
                op = Operations.POWER;
                currentNum = "";
            }
        });

        btnSINE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radians)
                    currentNum = degToRad(currentNum);
                handleCalcOneParam(Operations.SINE);
            }
        });

        btnCOSINE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radians)
                    currentNum = degToRad(currentNum);
                handleCalcOneParam(Operations.COSINE);
            }
        });

        btnTANGENT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radians)
                    currentNum = degToRad(currentNum);
                handleCalcOneParam(Operations.TANGENT);
            }
        });

        btnLOG10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalcOneParam(Operations.LOG10);
            }
        });

        btnANS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans == null){
                    txtView.setText("ERROR:NULL");
                }else{
                    txtView.setText(ans.toString());
                    currentNum = ans.toString();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numWithErrors.clear();
                currentNum = "";
                op = null;
                txtView.setText("0");
                tempAns = null;
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentNum.length() >= 1){
                    String temp = currentNum.substring(0,currentNum.length()-1);
                    currentNum = temp;
                    txtView.setText(currentNum);
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle b){
        super.onSaveInstanceState(b);

    }

    private void handleCalcOneParam(Method m){
        if(currentNum.length() != 0){
            try{
                NumWithError result = NumWithError.calculate(m, new NumWithError(currentNum));
                txtView.setText(result.toString());
                tempAns = result;
                ans = result;
                currentNum = "";
            }catch(IllegalArgumentException e){
                txtView.setText("ERROR:ARGUMENT");
            }catch(NullPointerException e){
                txtView.setText("ERROR:NULL");
            }catch(Exception e){
                txtView.setText("ERROR");
            }
        }else if(tempAns != null){
            try{
                NumWithError result = NumWithError.calculate(m, tempAns);
                txtView.setText(result.toString());
                tempAns = result;
                ans = result;
                currentNum = "";
            }catch(IllegalArgumentException e){
                txtView.setText("ERROR:ARGUMENT");
            }catch(NullPointerException e){
                txtView.setText("ERROR:NULL");
            }catch(Exception e){
                txtView.setText("ERROR");
            }
        }
    }

    private void handleCalcTwoParam(){
        if(currentNum.length() != 0){
            numWithErrors.add(new NumWithError(currentNum));
        }else if(tempAns != null){
            System.out.println(tempAns);
            numWithErrors.add(tempAns);
        }
        txtView.setText("0");

        if(numWithErrors.size() >= 2){
            NumWithError result;
            NumWithError[] params = numWithErrors.toArray(new NumWithError[0]);
            try{
                result = NumWithError.calculate(op, params);
                txtView.setText(result.toString());
                numWithErrors.set(0,result);
                numWithErrors.remove(1);
                ans =result;
                tempAns = result;
            }catch(IllegalArgumentException e){
                txtView.setText("ERROR:ARGUMENT");
            }catch(NullPointerException e){
                txtView.setText("ERROR:NULL");
            }catch(Exception e){
                txtView.setText("ERROR");
            }
        }
        currentNum = "";
    }

    private static String degToRad(String str){

        String[] temps = str.split("±");
        String result;
        result = String.valueOf(Math.toRadians(Double.valueOf(temps[0])));
        result += "±";
        if(temps.length >= 2){
            result += String.valueOf(Math.toRadians(Double.valueOf(temps[1])));
        }else
            result += "0";
        return result;
    }

    private static NumWithError radToDeg(NumWithError num){
        return new NumWithError(Math.toDegrees(num.getNum()), Math.toDegrees(num.getError()));
    }
}

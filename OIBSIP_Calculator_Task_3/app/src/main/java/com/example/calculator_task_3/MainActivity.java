package com.example.calculator_task_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.tools.jsc.Main;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    TextView zero,one,two,three,four,five,six,seven,eight,nine,rightbracket,mul,div,perc,dot,equal,clear,plus,minus,leftbracket,input,show,cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=findViewById(R.id.input);
        show=findViewById(R.id.display);

        assignId(clear,R.id.clear);
        assignId(leftbracket,R.id.leftbracket);
        assignId(rightbracket,R.id.rightbrac);
        assignId(div,R.id.divide);
        assignId(mul,R.id.multiply);
        assignId(minus,R.id.minus);
        assignId(plus,R.id.plus);
        assignId(equal,R.id.equal);
        assignId(perc,R.id.percentage);
        assignId(dot,R.id.dot);


        assignId(one,R.id.one);
        assignId(two,R.id.two);
        assignId(three,R.id.three);
        assignId(four,R.id.four);
        assignId(five,R.id.five);
        assignId(six,R.id.six);
        assignId(seven,R.id.seven);
        assignId(eight,R.id.eight);
        assignId(nine,R.id.nine);
        assignId(zero,R.id.zero);
        assignId(cross,R.id.removeall);



    }

    void assignId(TextView txt, int id)
    {
        txt=findViewById(id);
        txt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        TextView textView= (TextView) view;
        String buttontext= textView.getText().toString();
        String dataToCalculate= input.getText().toString();


        if (buttontext.equals("C")){
            input.setText("");
            show.setText("0");
            return;
        }
        if (buttontext.equals("=")){
            input.setText(show.getText());
            return;
        }
        if (buttontext.equals("X")){
                if (dataToCalculate.length() == 1  ){
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                }else{
                    dataToCalculate= dataToCalculate.substring(0, dataToCalculate.length()-1);
                }
        }
        else{
            dataToCalculate= dataToCalculate+buttontext;
        }
        input.setText(dataToCalculate);

        String finalResult= getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            show.setText(finalResult);
        }
    }

    String getResult(String data){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable= context.initStandardObjects();
            String finalResult=context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (finalResult.endsWith(".0")){
                finalResult= finalResult.replace(".0","");
            }
            return  finalResult;
        }catch (Exception e){
            return "Err";
        }

    }
}
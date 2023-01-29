package com.example.unit_converter_application_tasl_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    Spinner spinner1;

    TextView result;
    EditText value;
    String enter;
    String enterr;

    String firstunit;
    String secondunit;
    String firstparameter;


    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

         spinner= findViewById(R.id.spinner);
         spinner1= findViewById(R.id.parameters);
         spinner2= findViewById(R.id.spinner2);

         value=findViewById(R.id.value);
         result=findViewById(R.id.result);

         convert=findViewById(R.id.convert);

        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this, R.array.parameters, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                firstparameter= spinner1.getSelectedItem().toString();


                if (Objects.equals(firstparameter, "Length") ) {

                    ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(MainActivity.this, R.array.length, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinner.setAdapter(adapter);
                    spinner2.setAdapter(adapter);

                }else{

                    ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(MainActivity.this, R.array.Weight, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinner.setAdapter(adapter2);
                    spinner2.setAdapter(adapter2);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enter= value.getText().toString().trim();
                if(enter.isEmpty()){
                    value.setError("Value is required");
                    value.requestFocus();
                }
                else {
                            firstunit = spinner.getSelectedItem().toString().trim();
                            secondunit = spinner2.getSelectedItem().toString().trim();
                            enterr= enter;


                            //converting cm to all other units
                            if(Objects.equals(firstunit, "CentiMeter") && Objects.equals(secondunit, "CentiMeter")){
                                result.setText(enterr);
                            }
                            if(Objects.equals(firstunit, "CentiMeter") && Objects.equals(secondunit, "MilliMeter")){
                                Double mm= Double.parseDouble(enterr )*10;
                               String millimeter= String.valueOf(mm);
                                result.setText(millimeter);
                            }
                            if(Objects.equals(firstunit, "CentiMeter") && Objects.equals(secondunit, "Meter")){
                                Double m= Double.parseDouble(enterr )/100;
                                String meter= String.valueOf(m);
                                result.setText(meter);
                            }
                            if(Objects.equals(firstunit, "CentiMeter") && Objects.equals(secondunit, "KiloMeter")){
                                Double km= Double.parseDouble(enterr )/100000;
                                String kilometer= String.valueOf(km);
                                result.setText(kilometer);
                            }


                            //converting millimeter to all other units
                            if(Objects.equals(firstunit, "MilliMeter") && Objects.equals(secondunit, "MilliMeter")){
                                result.setText(enterr);
                            }
                            if(Objects.equals(firstunit, "MilliMeter") && Objects.equals(secondunit, "Meter")){
                                Double m= Double.parseDouble(enterr)/1000;
                                String meter= String.valueOf(m);
                                result.setText(meter);
                            }
                            if(Objects.equals(firstunit, "MilliMeter") && Objects.equals(secondunit, "KiloMeter")){

                                Double km=Double.parseDouble(enterr)/1000000;
                                String kilometer= String.valueOf(km);
                                result.setText(kilometer);
                            }
                            if(Objects.equals(firstunit, "MilliMeter") && Objects.equals(secondunit, "CentiMeter")){

                                Double cm= Double.parseDouble(enterr)/10;
                                String centimeter= String.valueOf(cm);
                                result.setText(centimeter);
                            }



                            //converting meter to all other units
                            if(Objects.equals(firstunit, "Meter") && Objects.equals(secondunit, "Meter")){
                                result.setText(enterr);
                            }
                            if(Objects.equals(firstunit, "Meter") && Objects.equals(secondunit, "KiloMeter")){
                                Double km=Double.parseDouble(enterr)/1000;
                                String kilometer= String.valueOf(km);
                                result.setText(kilometer);
                            }
                            if(Objects.equals(firstunit, "Meter") && Objects.equals(secondunit, "CentiMeter")){
                                Double cm=Double.parseDouble(enterr)*100;
                                String centimeter= String.valueOf(cm);
                                result.setText(centimeter);
                            }
                            if(Objects.equals(firstunit, "Meter") && Objects.equals(secondunit, "MilliMeter")){
                                Double mm= Double.parseDouble(enterr) *1000;
                                String millimeter= String.valueOf(mm);
                                result.setText(millimeter);
                            }



                            //converting kilometer to all other units
                            if(Objects.equals(firstunit, "KiloMeter") && Objects.equals(secondunit, "KiloMeter")){
                                result.setText(enterr);
                            }
                            if(Objects.equals(firstunit, "KiloMeter") && Objects.equals(secondunit, "Meter")){
                                Double m= Double.parseDouble(enterr)*1000;
                                String meter= String.valueOf(m);
                                result.setText(meter);
                            }
                            if(Objects.equals(firstunit, "KiloMeter") && Objects.equals(secondunit, "CentiMeter")){
                                Double cm= Double.parseDouble(enterr)*100000;
                                String centimeter= String.valueOf(cm);
                                result.setText(centimeter);
                            }
                            if(Objects.equals(firstunit, "KiloMeter") && Objects.equals(secondunit, "MilliMeter")){
                                Double mm= Double.parseDouble(enterr)*1000000;
                                String kilometer= String.valueOf(mm);
                                result.setText(kilometer);
                            }


                            //converting kilogram to all other units
                            if(Objects.equals(firstunit, "KiloGram") && Objects.equals(secondunit, "KiloGram")){
                                result.setText(enterr);
                            }
                            if(Objects.equals(firstunit, "KiloGram") && Objects.equals(secondunit, "Gram")){
                                Double g= Double.parseDouble(enterr)*1000;
                                String gram = String.valueOf(g);
                                result.setText(gram);
                            }



                            //converting gram to all other units
                            if(Objects.equals(firstunit, "Gram") && Objects.equals(secondunit, "Gram")){
                                result.setText(enterr);
                            }
                            if(Objects.equals(firstunit, "Gram") && Objects.equals(secondunit, "KiloGram")){
                                Double kg= Double.parseDouble(enterr)/1000;
                                String kilogram= String.valueOf(kg);
                                result.setText(kilogram);
                            }
                }
                }
            });
    }
}
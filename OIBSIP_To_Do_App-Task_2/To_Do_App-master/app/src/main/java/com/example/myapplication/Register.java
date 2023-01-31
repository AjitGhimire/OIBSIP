package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button register;
    EditText username,password,rconfirmpassword;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.fname);
        password=findViewById(R.id.fpassword);
        rconfirmpassword=findViewById(R.id.fcpassword);
        register=findViewById(R.id.fregister);
        dbHelper=new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String uname=username.getText().toString();
                final String upassword=password.getText().toString();
                final String ucpassword=rconfirmpassword.getText().toString();

                if(uname.isEmpty()){
                    Toast.makeText(Register.this, "User name is required", Toast.LENGTH_SHORT).show();
                }
                else if (upassword.isEmpty()){
                    Toast.makeText(Register.this, "Password is required", Toast.LENGTH_SHORT).show();
                }
                else if(ucpassword.isEmpty()){
                    Toast.makeText(Register.this, "Confirm Password is required", Toast.LENGTH_SHORT).show();
                }
                else if(upassword.equals(ucpassword)){
                    Boolean checkuser= dbHelper.checkusername(uname);
                    if(!checkuser){
                        Boolean insert= dbHelper.insertData(uname, upassword);
                        if (insert){
                            Toast.makeText(Register.this, "register successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, Login.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Register.this, "User Already Exists, Please Login", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Password does not matched", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
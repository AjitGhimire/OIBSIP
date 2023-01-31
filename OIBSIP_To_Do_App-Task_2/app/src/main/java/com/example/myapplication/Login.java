package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView register;
    Button login;
    EditText username, password;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register= findViewById(R.id.register);
        login=findViewById(R.id.login);
        username=findViewById(R.id.name);
        password=findViewById(R.id.password);
        dbHelper=new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String namee=username.getText().toString();
                final String passwordd= password.getText().toString();

                if(namee.isEmpty()){
                    Toast.makeText(Login.this, "User name is required", Toast.LENGTH_SHORT).show();
                }
                else if(passwordd.isEmpty()){
                    Toast.makeText(Login.this, "Password is required", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass= dbHelper.checkusernamepassword(namee, passwordd);
                    if(checkuserpass){
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, MainActivity.class));
                    }else{
                        Toast.makeText(Login.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
//
//        delete.setOnClickListener(new View.OnClickListener() {
//            final String nameee=username.getText().toString();
//            @Override
//            public void onClick(View view) {
//                dbHelper.delete(nameee);
//                Toast.makeText(Login.this, "deleted", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Login.this,Login.class));
//            }
//        });

    }
}
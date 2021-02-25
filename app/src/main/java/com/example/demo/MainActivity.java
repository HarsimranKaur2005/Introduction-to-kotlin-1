package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText username , pwd;
    String uname = " ";
    String password = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btn_submit);
        username = findViewById(R.id.et_username);
        pwd = findViewById(R.id.et_password);

        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                uname=username.getText().toString();
                password = pwd.getText().toString();

               if (uname.equals("tothenew") && password.equals("12345678"))
               {
                   Intent intent = new Intent(MainActivity.this, homePage.class);
                   Toast.makeText(getApplicationContext(),"login successful!!",Toast.LENGTH_SHORT).show();
                   startActivity(intent);
               }

               else
               {
                   Toast.makeText(getApplicationContext(), "Username or password is incorrect",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}
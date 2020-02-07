package com.example.myappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,password;
    Button btnlogin;
    TextView tvregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUIView();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    startActivity(new Intent(MainActivity.this,homepage.class));
                    Toast.makeText(MainActivity.this, "Login succesfully", Toast.LENGTH_SHORT).show();
                }
                else 
                {
                    Toast.makeText(MainActivity.this, "username and password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,register.class));
            }
        });

    }

    private void setUpUIView()
    {
         user = (EditText)findViewById(R.id.etusername);
         password = (EditText) findViewById(R.id.etpassword);
         btnlogin =  (Button)findViewById(R.id.tvlogin);
         tvregister = (TextView)findViewById(R.id.tvregister);
    }
    private Boolean validate()
    {
        Boolean result = false;
        String name = user.getText().toString();
        String pass = password.getText().toString();
        if(name.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(this, "Please fill all detailes", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;
        }
        return  result;
    }
}


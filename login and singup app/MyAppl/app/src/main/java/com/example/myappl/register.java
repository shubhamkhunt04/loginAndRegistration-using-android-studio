package com.example.myappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText user,email,password,cnfpassword;
    Button btnregister;
    TextView tvlogin;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUpUIView();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    startActivity(new Intent(register.this,homepage.class));
                    Toast.makeText(register.this, "Login succesfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(register.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,MainActivity.class));
            }
        });

    }

    private void setUpUIView()
    {
        user = (EditText)findViewById(R.id.etusername);
        email = (EditText)findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);
        cnfpassword = (EditText) findViewById(R.id.etcnfpassword);
        btnregister =  (Button)findViewById(R.id.btnregister);
        tvlogin = (TextView)findViewById(R.id.tvlogin);
    }
    private Boolean validate()
    {
        Boolean result = false;
        String name = user.getText().toString();
        String emails = email.getText().toString();
        String pass = password.getText().toString();
        String cnfpass = cnfpassword.getText().toString();
        if(name.isEmpty() || pass.isEmpty() || emails.isEmpty())
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

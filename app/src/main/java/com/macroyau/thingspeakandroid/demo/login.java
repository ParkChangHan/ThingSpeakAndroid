package com.macroyau.thingspeakandroid.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by pch on 2018-02-25.
 */

public class login extends AppCompatActivity {

    EditText ID;
    EditText PASSWORD;
    Button SIGN_IN;
    public static int sign = 0;
    public static Activity log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log_in = this;
        if(sign == 1){
            Intent intent = new Intent(getApplicationContext(), Main.class);
            startActivity(intent);
        }

        ID = (EditText) findViewById(R.id.editText2);
        PASSWORD = (EditText) findViewById(R.id.editText1);
        SIGN_IN = (Button) findViewById(R.id.button);

        SIGN_IN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String id = ID.getText().toString();
                String password = PASSWORD.getText().toString();


                if(id.equals("admin") && password.equals("admin")){
                    sign = 1;
                    Intent intent = new Intent(getApplicationContext(), Main.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(login.this, "Invalid ID or PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

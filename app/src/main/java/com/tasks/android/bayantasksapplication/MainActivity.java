package com.tasks.android.bayantasksapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button goToSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        goToSignup = (Button) findViewById(R.id.go_to_sign_up_page);




        goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegistrationAndLoginActivity();
            }
        });


    }

    private void goToRegistrationAndLoginActivity() {
        Intent intent = new Intent(this, RegistratonAndLoginActivity.class);
        startActivity(intent);


    }
}

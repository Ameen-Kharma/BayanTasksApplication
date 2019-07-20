package com.tasks.android.bayantasksapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RegistratonAndLoginActivity extends AppCompatActivity {
    TextView goToLogin;
    TextView goToRegister;

    EditText email;
    EditText password;
    EditText confirmPassword;
    Button regester;
    Button login;

    LinearLayout loginLayout;
    LinearLayout registrationLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraton_and_login);

        email = (EditText) findViewById(R.id.user_email_register_edit_text);
        password = (EditText) findViewById(R.id.password_register_edit_text);
        confirmPassword = (EditText) findViewById(R.id.password_confirm_register_edit_text);
        regester = (Button) findViewById(R.id.regestration_button);
        login = (Button) findViewById(R.id.do_login);
        goToLogin = (TextView) findViewById(R.id.go_to_login_text_view);
        goToRegister = (TextView) findViewById(R.id.go_to_register_text_view);

        loginLayout = (LinearLayout) findViewById(R.id.login_layout);
        registrationLayout = (LinearLayout) findViewById(R.id.regestration_layout);


        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationLayout.setVisibility(View.INVISIBLE);
                loginLayout.setVisibility(View.VISIBLE);


            }
        });
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationLayout.setVisibility(View.VISIBLE);
                loginLayout.setVisibility(View.INVISIBLE);


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = (EditText) findViewById(R.id.login_email_edit_text);
                password = (EditText) findViewById(R.id.login_password_edit_text);
                String userEmail = email.getText().toString();
                String userPasswrd = password.getText().toString();
                doLogin(userEmail, userPasswrd);
            }
        });

        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userNameEditText = (EditText) findViewById(R.id.user_name_register_edit_text);
                email = (EditText) findViewById(R.id.user_email_register_edit_text);
                password = (EditText) findViewById(R.id.password_register_edit_text);
                confirmPassword = (EditText) findViewById(R.id.password_confirm_register_edit_text);

                String userName = userNameEditText.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                if (password.equals(""))
                {
                    Toast.makeText(RegistratonAndLoginActivity.this,"password field can not be Empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userPassword.equals(confirmPassword.getText().toString()))
                  {
                    doRegistration(userName, userEmail, userPassword);
                  }
                else {
                    Toast.makeText(RegistratonAndLoginActivity.this,"password not matched!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void doRegistration(String userName, String userEmail, String userPassword) {
        Toast.makeText(this,"doing registration", Toast.LENGTH_SHORT).show();
    }

    private void doLogin(String email, String password) {
        Toast.makeText(this,"doing login", Toast.LENGTH_SHORT).show();

    }
}

package com.tasks.android.bayantasksapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import Controller.RegistrationCall;
import Controller.LoginCall;

public class RegistratonAndLoginActivity extends AppCompatActivity implements RegistrationCall.RegistrationCallBackListner, LoginCall.LoginCallBackListner {
    // View variables
    TextView goToLogin;
    TextView goToRegister;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button regester;
    Button login;
    LinearLayout loginLayout;
    LinearLayout registrationLayout;
    private ProgressDialog dialog;


    //Model and private variables
    private UserInfo userInfo;
    private String sessionid;


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

        //set the view to login
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationLayout.setVisibility(View.INVISIBLE);
                loginLayout.setVisibility(View.VISIBLE);


            }
        });

        //set the view to registration
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
                if (userPassword.equals(""))
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
        dialog = ProgressDialog.show(this, "registering...", "Please wait...", true);
        Drawable drawable = new ProgressBar(this).getIndeterminateDrawable().mutate();
        drawable.setColorFilter(Color.BLUE,
                PorterDuff.Mode.SRC_IN);
        dialog.setIndeterminateDrawable(drawable);

        RegistrationCall registrationCall = new RegistrationCall(userEmail, userName, userPassword, this);
        registrationCall.doRegistration();


//        Toast.makeText(this,"doing registration", Toast.LENGTH_SHORT).show();
    }

    private void doLogin(String email, String password) {
        dialog = ProgressDialog.show(this, "registering...", "Please wait...", true);
        Drawable drawable = new ProgressBar(this).getIndeterminateDrawable().mutate();
        drawable.setColorFilter(Color.BLUE,
                PorterDuff.Mode.SRC_IN);
        dialog.setIndeterminateDrawable(drawable);
        LoginCall loginCall = new LoginCall(email,password,this);
        userInfo  = loginCall.doLogin();
        Toast.makeText(this,"doing login", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFetchComplete(UserInfo user, String sessionKey) {
            userInfo = user;
            if (userInfo.getStatusCode() == 200) {
                dialog.dismiss();
                sessionid = sessionKey;
                // todo should navigate to the profile or to tasks screen ( go to tasks threads)
                Intent intent = new Intent(this, MyTaskTeamTasksActivity.class);
                startActivity(intent);
            } else {
                //Dialog error
                Log.d("something wrong", "wrong email or password");


            }
        Toast.makeText(this,"done registration", Toast.LENGTH_SHORT).show();


    }
}

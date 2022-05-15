package com.example.mytodo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    Button btnlogin, btnCancel;
    AlertDialog.Builder mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername= findViewById(R.id.splash_txt_username);
        txtPassword= findViewById(R.id.splash_txt_password);
        btnCancel= findViewById(R.id.splash_btn_cancel);
        btnlogin= findViewById(R.id.splash_btn_submit);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= txtUsername.getText().toString();
                String password= txtPassword.getText().toString();

                if (username.equals(""))
                {
                    txtUsername.setError(getString(R.string.login_username_required));
                    txtUsername.requestFocus();
                }
                else if(password.equals(""))
                {
                    txtPassword.setError(getString(R.string.login_password_required));
                    txtPassword.requestFocus();
                }
                else
                {
                    if(username.equals("admin") && password.equals("here"))
                    {
                        SharedPreferences preferences= getApplicationContext().getSharedPreferences( "MyToDo_pref", 0);
                        SharedPreferences.Editor editor=preferences.edit();
                        editor.putBoolean("authentication", true);
                        editor.commit();
                        Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        txtUsername.setError(getString(R.string.login_invalid_details));
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog= new AlertDialog.Builder(LoginActivity.this);
                mAlertDialog.setMessage(getString(R.string.quit_app))
                        .setCancelable(false)
                        .setTitle(getString(R.string.app_name))
                        .setIcon(R.mipmap.ic_launcher);
                mAlertDialog.setPositiveButton((R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                mAlertDialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                mAlertDialog.show();
            }
        });



    }
}


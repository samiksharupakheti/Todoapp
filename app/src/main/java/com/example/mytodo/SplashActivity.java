package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler= new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                SharedPreferences preferences= getApplicationContext().getSharedPreferences("MyToDo_pref", 0);
                Boolean authentication= preferences.getBoolean("authentication",  false);
                if(authentication)
                {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();




            }
        }, 4000); //delayMillis: 4000);
    }






}

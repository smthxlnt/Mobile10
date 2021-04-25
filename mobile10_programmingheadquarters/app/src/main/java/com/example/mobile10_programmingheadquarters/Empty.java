package com.example.mobile10_programmingheadquarters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Empty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        try {
            SharedPreferences runCheck = getSharedPreferences("hasRunBefore", 0); //load the preferences
            Boolean hasRun = runCheck.getBoolean("hasRun", false); //see if it run before, default no
            if (!hasRun) {
                SharedPreferences settings = getSharedPreferences("hasRunBefore", 0);
                SharedPreferences.Editor edit = settings.edit();
                edit.putBoolean("hasRun", true); //set to has run
                edit.commit(); //apply
                //code for if this is the first time the app has run
                Intent intent1=new Intent(this, MainActivity.class);
                startActivity(intent1);
                SharedPreferences settingsForPin = getSharedPreferences("hasRunBefore", 0);
                SharedPreferences.Editor editForPin = settingsForPin.edit();
                editForPin.putBoolean("checkIn", false); //смена пароля
                editForPin.commit(); //apply
            }
            else {
                //code if the app HAS run before
                Intent intent2=new Intent(this, PinCodeInput.class);
                startActivity(intent2);
                SharedPreferences settingsForPin = getSharedPreferences("hasRunBefore", 0);
                SharedPreferences.Editor editForPin = settingsForPin.edit();
                editForPin.putBoolean("checkIn", true); //вход
                editForPin.commit(); //apply
            }
        }
        catch (Exception error) {
        }
    }
}
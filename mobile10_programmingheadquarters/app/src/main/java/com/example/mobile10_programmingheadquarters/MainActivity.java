package com.example.mobile10_programmingheadquarters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PinInput(View view) {
        SharedPreferences settingsForPin = getSharedPreferences("hasRunBefore", 0);
        SharedPreferences.Editor editForPin = settingsForPin.edit();
        editForPin.putBoolean("checkIn", false); //выполняется смена пароля, а не вход
        editForPin.commit(); //apply
        Intent intent=new Intent(this, PinCodeInput.class);
        startActivity(intent);
    }
}
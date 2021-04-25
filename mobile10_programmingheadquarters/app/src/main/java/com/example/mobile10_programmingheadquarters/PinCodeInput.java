package com.example.mobile10_programmingheadquarters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PinCodeInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_code_input);
    }

    public void PinInput(View view) {
        EditText pinCode=(EditText) findViewById(R.id.pin1);
        SharedPreferences runCheckIn = getSharedPreferences("hasRunBefore", 0); //load the preferences
        Boolean checkIn = runCheckIn.getBoolean("checkIn", true);
        if (!checkIn){
            SharedPreferences settingsForPin = getSharedPreferences("hasRunBefore", 0);
            SharedPreferences.Editor editForPin = settingsForPin.edit();
            editForPin.putString("pin", String.valueOf(pinCode.getText())); //смена пароля
            editForPin.commit(); //apply
            Intent intent2=new Intent(this, Confirmation.class);
            startActivity(intent2);
        }
        else {
            SharedPreferences runCheckPin = getSharedPreferences("hasRunBefore", 0);
            String pin = runCheckPin.getString("pin", null); //авторизация
            String pinForShow=String.valueOf(pinCode.getText());
            if (pinForShow.equals(pin)){
                Intent intent3=new Intent(this, MainActivity.class);
                startActivity(intent3);
                Toast.makeText(getApplicationContext(),"Успешная авторизация.",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Введен неверный пароль!",Toast.LENGTH_LONG).show();
            }
        }
    }
}
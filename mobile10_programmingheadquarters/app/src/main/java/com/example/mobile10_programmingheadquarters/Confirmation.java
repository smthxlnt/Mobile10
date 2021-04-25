package com.example.mobile10_programmingheadquarters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
    }

    public void Confirm(View view) {
        EditText pinCode=(EditText) findViewById(R.id.pin2);
        SharedPreferences runCheckPin = getSharedPreferences("hasRunBefore", 0);
        String pin = runCheckPin.getString("pin", null); //получения пароля с предыдущей activity
        String confirmPin=String.valueOf(pinCode.getText());
        if (confirmPin.equals(pin)){
            Intent intent3=new Intent(this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(getApplicationContext(),"Пароль успешно изменен.",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Пароли не совпадают!",Toast.LENGTH_LONG).show();
        }
    }
}
package com.diyroomdecorideas.demo_sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.check1);
        btn = findViewById(R.id.btn);
        share();
        btnclick();


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences preferences = getSharedPreferences("PREFRENCE", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("FirstInstall", "yes");
                editor.apply();
            }
        });


    }

    private void share() {
        SharedPreferences preferences = getSharedPreferences("PREFRENCE", MODE_PRIVATE);

        String firsttime = preferences.getString("FirstInstall", "");

        if (firsttime.equals("yes")) {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();

        } else
        {
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putString("FirstInstall", "yes");
//            editor.apply();
        }
    }

    private void btnclick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(MainActivity.this, "Please Accept Terms and Conditions,Its Compulsory Required", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }


}
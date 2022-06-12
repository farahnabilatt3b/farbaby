package com.example.baby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlarmBayi = findViewById(R.id.btn_alarm_bayi);
        Button btnListLaguTidur = findViewById(R.id.btn_list_lagu_tidur);
        Button btnHistoryAlarm = findViewById(R.id.btn_history_alarm);

        btnAlarmBayi.setOnClickListener(this);
        btnListLaguTidur.setOnClickListener(this);
        btnHistoryAlarm.setOnClickListener(this);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.btn_alarm_bayi) {
            Intent moveIntent = new Intent(MainActivity.this, AlarmBayi.class);
            startActivity(moveIntent);
        }
        if (v.getId() == R.id.btn_list_lagu_tidur) {
            Intent moveIntent = new Intent(MainActivity.this, ListLaguTidur.class);
            startActivity(moveIntent);
        }
        if (v.getId() == R.id.btn_history_alarm) {
            Intent moveIntent = new Intent(MainActivity.this, HistoryAlarm.class);
            startActivity(moveIntent);
        }
    }
}






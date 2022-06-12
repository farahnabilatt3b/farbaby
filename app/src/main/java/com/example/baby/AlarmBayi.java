package com.example.baby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.google.firebase.messaging.FirebaseMessaging;

import java.net.HttpCookie;

public class AlarmBayi extends AppCompatActivity {
    TextView nilaiSound;
    Button laguOn, laguOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_bayi);
        nilaiSound = findViewById(R.id.nilaiSound);
        laguOn = findViewById(R.id.laguOn);
        laguOff = findViewById(R.id.laguOff);


        //Membaca Nilai Kondisi Bayi
        DatabaseReference statuskondisibayi = FirebaseDatabase.getInstance().getReference();
        statuskondisibayi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String suara =dataSnapshot.child("Nilai").getValue().toString();
                if (Integer.parseInt(suara) >= 70) {
                    nilaiSound.setText("BAYI SEDANG MENANGIS");
                } else {
                    nilaiSound.setText("BAYI TENANG");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Menyalakan Lagu
        laguOn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference LAGU = database.getReference("LAGU");
                LAGU.setValue("1"); }
        });

        //Mematikan Lagu
        laguOff.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference LAGU = database.getReference("LAGU");
                LAGU.setValue("0"); }
        });

    }
}


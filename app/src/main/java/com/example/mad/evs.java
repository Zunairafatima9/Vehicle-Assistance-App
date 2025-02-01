package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class evs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evs2);

        LinearLayout cs = findViewById(R.id.lv1);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs.this, chargingstation.class);
                startActivity(intent);
            }
        });

        LinearLayout bs = findViewById(R.id.lv2);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs.this, batteryswap.class);
                startActivity(intent);
            }
        });

        LinearLayout ss = findViewById(R.id.lv3);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs.this, servicestation.class);
                startActivity(intent);
            }
        });

        LinearLayout tt = findViewById(R.id.lv4);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs.this, towtruck.class);
                startActivity(intent);
            }
        });

        Button b1=findViewById(R.id.bu1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button b2=findViewById(R.id.bu2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs.this, emergency.class);
                startActivity(intent);
            }
        });

    }
}

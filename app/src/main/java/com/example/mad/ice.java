package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ice2);

        LinearLayout pp = findViewById(R.id.lv1);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ice.this, petrolpump.class);
                startActivity(intent);
            }
        });

        LinearLayout mp = findViewById(R.id.lv2);
        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ice.this, mobilepp.class);
                startActivity(intent);
            }
        });

        LinearLayout ss = findViewById(R.id.lv3);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ice.this, garage.class);
                startActivity(intent);
            }
        });

        LinearLayout tt = findViewById(R.id.lv4);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ice.this, tt.class);
                startActivity(intent);
            }
        });

        Button b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ice.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button b2=findViewById(R.id.button9);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ice.this, emergency.class);
                startActivity(intent);
            }
        });
    }
}

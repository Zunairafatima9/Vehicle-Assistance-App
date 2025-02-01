package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    Button exitButton,bu1,bu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ev = findViewById(R.id.lv1);
        ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, evs.class);
                startActivity(intent);
            }
        });

        LinearLayout ic = findViewById(R.id.lv2);
        ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ice.class);
                startActivity(intent);
            }
        });

        LinearLayout au = findViewById(R.id.lv3);
        au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
            }
        });

        LinearLayout cu = findViewById(R.id.lv4);
        cu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, contact.class);
                startActivity(intent);
            }
        });

        Button bu2=findViewById(R.id.button6);
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, emergency.class);
                startActivity(intent);
            }
        });

        Button bu1=findViewById(R.id.button3);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, sos.class);
                startActivity(intent);
            }
        });

    }


    public void homelayoutButton(View view){setContentView(R.layout.evs2);}
    public void homelayoutButton1(View view){
        setContentView(R.layout.ice2);
    }
    public void homelayoutButton2(View view){
        setContentView(R.layout.aboutus);
    }


    public void evlayoutButton(View view){setContentView(R.layout.activity_main);}
    public void iclayoutButton(View view){setContentView(R.layout.activity_main);}



    public void evCSButton(View view){
        setContentView(R.layout.chargingstation);
    }
    public void ev2(View view){
        setContentView(R.layout.batteryswap);
    }
    public void ev3(View view){
        setContentView(R.layout.servicestation);
    }
    public void ev4(View view){
        setContentView(R.layout.towtruck);
    }



    public void icPPButton(View view){
        setContentView(R.layout.petrolpump);
    }
    public void ic2(View view){
        setContentView(R.layout.garage);
    }
    public void ic3(View view){
        setContentView(R.layout.mobilepp);
    }
    public void ic4(View view){
        setContentView(R.layout.tt);
    }


    public void cslayoutButton(View view){
        setContentView(R.layout.evs2);
    }
    public void pplayoutButton(View view){
        setContentView(R.layout.ice2);
    }


}
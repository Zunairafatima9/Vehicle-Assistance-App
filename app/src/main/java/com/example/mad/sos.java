package com.example.mad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.Manifest;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class sos extends AppCompatActivity implements LocationListener{
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private LocationManager locationManager;
        private EditText contactEditText;
        private TextView locationEditText;
        private Button sosButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sos);

            contactEditText = findViewById(R.id.context1);
            locationEditText = findViewById(R.id.loctext);
            sosButton = findViewById(R.id.sosButton);

            sosButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendSOS();
                }
            });

            locationEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getLocation();
                }
            });

            Button b3=findViewById(R.id.bu3);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(sos.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

        private void getLocation() {
            locationEditText.setText("Loading...Please wait.");
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (locationManager != null) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                            0, 0, this);
                }
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION_PERMISSION);
            }
        }

        private void sendSOS() {
            String contactNumber = contactEditText.getText().toString();
            String currentLocation = locationEditText.getText().toString();
            String message = "SOS! I'm stuck at " + currentLocation + ". Please help!";

            if (!contactNumber.isEmpty() && !currentLocation.isEmpty()) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(contactNumber, null, message, null, null);
                    Toast.makeText(this, "SOS sent successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "SMS permission denied.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter a contact number and fetch the location first.",
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            String mapsLink = "https://www.google.com/maps?q=" + latitude + "," + longitude;
//            String coordinates = latitude + ", " + longitude;
            locationEditText.setText(mapsLink);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // Location provider status changed
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Location provider enabled
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(this, "GPS is disabled. Please enable GPS.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                               @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == REQUEST_LOCATION_PERMISSION) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    Toast.makeText(this, "Location permission denied.", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (locationManager != null) {
                locationManager.removeUpdates(this);
            }
        }

    }

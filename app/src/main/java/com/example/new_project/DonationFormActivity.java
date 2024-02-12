package com.example.new_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DonationFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_donation_form);

        Button donateWithGPayButton = findViewById(R.id.payButton);
        donateWithGPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiateGooglePayPayment();

            }
        });
        }

    private void initiateGooglePayPayment() {
    }


}

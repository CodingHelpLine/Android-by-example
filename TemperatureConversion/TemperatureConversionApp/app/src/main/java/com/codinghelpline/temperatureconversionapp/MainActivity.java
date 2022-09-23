package com.codinghelpline.temperatureconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Edit text input
    private EditText txtTemperature;
    private TextView lblOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // map the component
        this.txtTemperature = findViewById(R.id.txtTemperature);
        this.lblOutput = findViewById(R.id.lblOutput);
    }

    // six function

    /**
     * Convert Celsius to Fahrenheit
     *
     * @param view
     */
    public void convertCToF(View view) {
        try {
            double temperature = Double.parseDouble(txtTemperature.getText().toString());

            // convert
            double result = (temperature * 9.0 / 5.0) + 32;

            // output
            this.lblOutput.setText(String.format("%.2f", result));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Convert Fahrenheit To Celsius
     *
     * @param view
     */
    public void convertFToC(View view) {
        try {
            double temperature = Double.parseDouble(txtTemperature.getText().toString());

            // convert
            double result = (temperature - 32) *  5.0 / 9.0;

            // output
            this.lblOutput.setText(String.format("%.2f", result));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Convert Celsius to Kelvin
     *
     * @param view
     */
    public void convertCToK(View view) {
        try {
            double temperature = Double.parseDouble(txtTemperature.getText().toString());

            // convert
            double result = temperature + 273.15;

            // output
            this.lblOutput.setText(String.format("%.2f", result));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Convert Kelvin to Celsius
     *
     * @param view
     */
    public void convertKToC(View view) {
        try {
            double temperature = Double.parseDouble(txtTemperature.getText().toString());

            // convert
            double result = (temperature - 273.15);

            // output
            this.lblOutput.setText(String.format("%.2f", result));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Convert Fahrenheit To Kelvin
     *
     * @param view
     */
    public void convertFToK(View view) {
        try {
            double temperature = Double.parseDouble(txtTemperature.getText().toString());

            // convert
            double result = (temperature - 32) *  5.0 / 9.0;  // F to C
            result = result + 273.15; // C to Kelvin

            // output
            this.lblOutput.setText(String.format("%.2f", result));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Convert Kelvin to Fahrenheit
     *
     * @param view
     */
    public void convertKToF(View view) {
        try {
            double temperature = Double.parseDouble(txtTemperature.getText().toString());

            // convert
            double result = (temperature - 273.15);  // K to C
            result = (result * 9.0 / 5.0) + 32; // C to F

            // output
            this.lblOutput.setText(String.format("%.2f", result));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
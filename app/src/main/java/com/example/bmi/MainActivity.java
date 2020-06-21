package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }

        private String BMI(float bmi) {

            if (bmi < 16) {
                return "Severely underweight";
            } else if (bmi< 18.5) {

                return "Underweight";
            } else if (bmi < 25) {

                return "Normal";
            } else if (bmi < 30) {

                return "Overweight";
            } else {
                return "Obese";
            }
        }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        bmiLabel = bmi + "\n\n" + bmiLabel+BMI(bmi);
        result.setText(bmiLabel);
    }

}



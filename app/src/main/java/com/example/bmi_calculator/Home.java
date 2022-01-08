package com.example.bmi_calculator;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Home extends AppCompatActivity {

    RadioGroup RBG;
    EditText weightET, heightET;
    TextView resultTV;
    Button calculate;

    double height, weight, bmi;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RBG = findViewById(R.id.rbg);
        weightET = findViewById(R.id.weight);
        heightET = findViewById(R.id.height);
        resultTV = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);

        RBG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb1) {
                    weightET.setHint(getResources().getString(R.string.pounds));
                    heightET.setHint(getResources().getString(R.string.inches));
                } else {
                    weightET.setHint(getResources().getString(R.string.kilograms));
                    heightET.setHint(getResources().getString(R.string.meter));
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                height = Double.parseDouble(heightET.getText().toString());
                weight = Double.parseDouble(weightET.getText().toString());

                if (RBG.getCheckedRadioButtonId() == R.id.rb1) {
                    bmi = ((weight) / (height * height)) * 703;
                } else {
                    bmi = (weight) / (height * height);
                }
                result = "Your BMI is : " + String.format(Locale.getDefault(), "%.2f", bmi);
                result += "<br><br>According to World Health Organization :<br>";
                if (bmi < 16) {
                    result += "<br>You are Severely Underweight";
                    result += "<br><br>Suggestions: ";
                    result += "<br>A BMI of under 18.5 indicates that a person has insufficient weight, so they may need to put on some weight. Having insufficient weight can increase the risk of malnutrition, osteoporosis, anemia, and a range of problems that can result from various nutrient deficiencies. It can also be a symptom of a hormonal, digestive, or other problem.They should ask a doctor or dietitian for advice.";
                    result += "<br>So You Must increase Your weight According to your doctor advices. ";
                } else if (bmi >= 16 && bmi <= 18.4) {
                    result += "<br>You are  Underweight";
                    result += "<br><br>Suggestions: ";
                    result += "<br>A BMI of under 18.5 indicates that a person has insufficient weight, so they may need to put on some weight. Having insufficient weight can increase the risk of malnutrition, osteoporosis, anemia, and a range of problems that can result from various nutrient deficiencies. It can also be a symptom of a hormonal, digestive, or other problem.They should ask a doctor or dietitian for advice.";
                    result += "<br>So You Must increase Your weight According to your doctor advices. ";

                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    result += "<br><font color=\"#008000\">You are Normal</font>";
                    result += "<br><br>Suggestion: ";
                    result += "<br>A BMI of 18.5–24.9 indicates that a person has a healthy weight for their height. By maintaining a healthy weight, they can lower their risk of developing serious health problems.";
                    result += "<br>Congratulations.You have a perfect BMI but you have to strictly maintain your BMI.";
                } else if (bmi >= 25 && bmi <= 29.9) {
                    result += "<br>You are Overweight";
                    result += "<br><br>Suggestion: ";
                    result += "<br>A BMI of 25–29.9 indicates that a person is slightly overweight. A doctor may advise them to lose some weight for health reasons. They should talk with a doctor or dietitian for advice.";
                    result += "<br>So You Must decrease Your weight According to your doctor advices. ";

                } else if (bmi >= 30 && bmi <= 34.9) {
                    result += "<br>You are Moderately Obese";
                    result += "<br><br>Suggestion: ";
                    result += "<br> A BMI of over 30 indicates that a person has obesity. Their health may be at risk if they do not lose weight. They should talk with a doctor or dietitian for advice.";
                    result += "<br>So You Must decrease Your weight According to your doctor advices. ";

                } else if (bmi >= 35 && bmi <= 39.9) {
                    result += "<br>You are Severely Obese";
                    result += "<br><br>Suggestion: ";
                    result += "<br>The value of your BMI indicates that you are Severely Obese.It's very bad indicate for your health.People who are overweight may have a higher riskTrusted Source than others of conditions such as heart disease, type 2 diabetes, sleep apnea, and colorectal cancer. Some of these can be life threatening.So You must need to decrease your weight.";
                    result += "<br>So You Must decrease Your weight According to your doctor advices. ";


                } else if (bmi >= 40) {
                    result += "<br>You are Morbidly Obese";
                    result += "<br><br>Suggestion: ";
                    result += "<br>The value of your BMI indicates that you are Severely Obese.It's very bad indicate for your health.People who are overweight may have a higher riskTrusted Source than others of conditions such as heart disease, type 2 diabetes, sleep apnea, and colorectal cancer. Some of these can be life threatening.So You must need to decrease your weight.";
                    result += "<br>So You Must decrease Your weight According to your doctor advices. ";

                }

                resultTV.setText(Html.fromHtml(result));
            }
        });


    }
}
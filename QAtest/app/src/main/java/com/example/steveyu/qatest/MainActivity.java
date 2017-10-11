package com.example.steveyu.qatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup answerGroup1;
    RadioButton answer1A;
    RadioButton answer1B;
    RadioButton answer1C;
    RadioButton answer1D;
    RadioGroup answerGroup2;
    RadioButton answer2A;
    RadioButton answer2B;
    RadioButton answer2C;
    RadioButton answer2D;
    CheckBox answer3A;
    CheckBox answer3B;
    CheckBox answer3C;
    CheckBox answer3D;
    EditText answer4input;
    TextView answer4output;
    int score1;
    int score2;
    int score3;
    int score4;
    int testforgit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerGroup1 = (RadioGroup) findViewById(R.id.answerGroup1);
        answer1A = (RadioButton) findViewById(R.id.answer1A);
        answer1B = (RadioButton) findViewById(R.id.answer1B);
        answer1C = (RadioButton) findViewById(R.id.answer1C);
        answer1D = (RadioButton) findViewById(R.id.answer1D);
        answerGroup2 = (RadioGroup) findViewById(R.id.answerGroup2);
        answer2A = (RadioButton) findViewById(R.id.answer2A);
        answer2B = (RadioButton) findViewById(R.id.answer2B);
        answer2C = (RadioButton) findViewById(R.id.answer2C);
        answer2D = (RadioButton) findViewById(R.id.answer2D);
        answer3A = (CheckBox) findViewById(R.id.answer3A);
        answer3B = (CheckBox) findViewById(R.id.answer3B);
        answer3C = (CheckBox) findViewById(R.id.answer3C);
        answer3D = (CheckBox) findViewById(R.id.answer3D);
        answer4input = (EditText) findViewById(R.id.answer4input);
        answer4output = (TextView) findViewById(R.id.answer4output);
    }

    public void submit(View v) {
        boolean answer3ACheck = answer3A.isChecked();
        boolean answer3CCheck = answer3C.isChecked();
        boolean answer3DCheck = answer3D.isChecked();
        int score = score1() + score2() + score3(answer3ACheck, answer3CCheck, answer3DCheck) + inputScore();
        displayMessage(testSummary(score));
    }

    public void clear(View v) {
        answerGroup1.clearCheck();
        answerGroup2.clearCheck();
        answer3A.setChecked(false);
        answer3B.setChecked(false);
        answer3C.setChecked(false);
        answer3D.setChecked(false);
        answer4input.setText(null);
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        displayMessage(testSummary(0));
    }

    private int score3(boolean answer3a, boolean answer3c, boolean answer3d) {
        if (answer3a && answer3c && answer3d) {
            score3 = 1;
        }
        return score3;
    }

    private int score2() {
        answerGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == answer2D.getId()) {
                    score2 = 1;
                }
            }
        });
        return score2;
    }

    private int score1() {
        answerGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == answer1A.getId()) {
                    score1 = 1;
                }
            }
        });
        return score1;
    }

    private int inputScore() {
        String textAnswer = "日月潭";
        String answer4 = answer4input.getText().toString();
        if (answer4.equals(textAnswer)) {
            score4 = 1;
        }
        return score4;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.answer4output);
        orderSummaryTextView.setText(message);
    }

    private String testSummary(int score) {
        String summaryMessage;
        summaryMessage = "總答對題數: " + score + " !";
        summaryMessage += "\n歡迎再次挑戰!";
        return summaryMessage;
    }
}

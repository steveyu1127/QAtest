package com.example.steveyu.qatest;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        boolean answer1ACheck = answer1A.isChecked();
        boolean answer2DCheck = answer2D.isChecked();
        boolean answer3ACheck = answer3A.isChecked();
        boolean answer3BCheck = answer3B.isChecked();
        boolean answer3CCheck = answer3C.isChecked();
        boolean answer3DCheck = answer3D.isChecked();
        int score = score1(answer1ACheck) + score2(answer2DCheck) + score3(answer3ACheck, answer3BCheck, answer3CCheck, answer3DCheck) + inputScore();
        displayToast(testSummary(score));
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
        displayToast(testSummary(0));
    }

    private int score3(boolean answer3a, boolean answer3b, boolean answer3c, boolean answer3d) {
        if (answer3b) {
            score3 = 0;
        } else if (answer3a && answer3c && answer3d) {
            score3 = 1;
        }
        return score3;
    }

    private int score1(boolean answer1a) {
        if (answer1a) {
            score1 = 1;
        } else {
            score1 = 0;
        }
        return score1;
    }

    private int score2(boolean answer2d) {
        if (answer2d) {
            score1 = 1;
        } else {
            score2 = 0;
        }
        return score1;
    }

    private int inputScore() {
        String textAnswer = getString(R.string.answer4_sunmoonlake);
        String answer4 = answer4input.getText().toString();
        if (answer4.equals(textAnswer)) {
            score4 = 1;
        }
        return score4;
    }

    private String testSummary(int score) {
        Resources res = getResources();
        String finalMessage = res.getString(R.string.final_score, score);
        String summaryMessage;
        summaryMessage = finalMessage;
        summaryMessage += getString(R.string.welcone_challenge);
        return summaryMessage;
    }

    public void displayToast(String string) {
        Toast mtoast = Toast.makeText(this, string, Toast.LENGTH_LONG);
        mtoast.show();
    }
}

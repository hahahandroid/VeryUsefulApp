package com.hahahandroid.kaomoji.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seeTheResult(View View) {

        int TOTAL = 8;
        int score = 0;
        boolean err = false;

        // Radio button answers

        RadioGroup question1 = findViewById(R.id.question1);
        int answer1 = question1.getCheckedRadioButtonId();
        RadioGroup question2 = findViewById(R.id.question2);
        int answer2 = question2.getCheckedRadioButtonId();
        RadioGroup question3 = findViewById(R.id.question3);
        int answer3 = question3.getCheckedRadioButtonId();
        RadioGroup question4 = findViewById(R.id.question4);
        int answer4 = question4.getCheckedRadioButtonId();
        RadioGroup question5 = findViewById(R.id.question5);
        int answer5 = question5.getCheckedRadioButtonId();
        RadioGroup question6 = findViewById(R.id.question6);
        int answer6 = question6.getCheckedRadioButtonId();

        if (answer1 == -1) err = true;
        if (answer1 == R.id.answer1_2) score++;

        if (answer2 == -1) err = true;
        if (answer2 == R.id.answer2_1) score++;

        if (answer3 == -1) err = true;
        if (answer3 == R.id.answer3_3) score++;

        if (answer4 == -1) err = true;
        if (answer4 == R.id.answer4_2) score++;

        if (answer5 == -1) err = true;
        if (answer5 == R.id.answer5_1) score++;

        if (answer6 == -1) err = true;
        if (answer6 == R.id.answer6_4) score++;

        // Answer with checkboxes

        CheckBox answerCheckBox1 = findViewById(R.id.questionCheckBox1);
        boolean qcb1 = answerCheckBox1.isChecked();

        CheckBox answerCheckBox2 = findViewById(R.id.questionCheckBox2);
        boolean qcb2 = answerCheckBox2.isChecked();

        CheckBox answerCheckBox3 = findViewById(R.id.questionCheckBox3);
        boolean qcb3 = answerCheckBox3.isChecked();

        CheckBox answerCheckBox4 = findViewById(R.id.questionCheckBox4);
        boolean qcb4 = answerCheckBox4.isChecked();

        CheckBox answerCheckBox5 = findViewById(R.id.questionCheckBox5);
        boolean qcb5 = answerCheckBox5.isChecked();

        CheckBox answerCheckBox6 = findViewById(R.id.questionCheckBox6);
        boolean qcb6 = answerCheckBox6.isChecked();

        if (qcb1 && qcb2 && qcb5 && qcb6 && !qcb3 && !qcb4) score++;

        // Text answer

        EditText feelingInput = findViewById(R.id.answerEdit);
        String feeling = feelingInput.getText().toString().toLowerCase();

        if (feeling.isEmpty()) err = true;
        if (feeling.equals("love")) score++;

        // Display result

        String result;
        if (err) {
            result = getString(R.string.allQuestionsHint);
        } else {
            result = getString(R.string.resultMessage, score, TOTAL);
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

    }

}





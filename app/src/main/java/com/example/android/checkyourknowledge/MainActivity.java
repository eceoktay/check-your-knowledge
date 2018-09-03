package com.example.android.checkyourknowledge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResults(View view) {
        int correctAnswers = 0;

        if (checkResultEditText(R.id.q1_answer)) {
            correctAnswers++;
        }

        if (checkResultRadioButton(R.id.q2_answer2)) {
            correctAnswers++;
        }

        if (checkResultRadioButton(R.id.q3_answer3)) {
            correctAnswers++;
        }

        if (checkResultRadioButton(R.id.q4_answer1)) {
            correctAnswers++;
        }

        if (checkResultQ5()) {
            correctAnswers++;
        }

        if (checkResultRadioButton(R.id.q6_answer3)) {
            correctAnswers++;
        }

        showResults(correctAnswers);
    }

    private boolean checkResultEditText(int id) {
        String correctAnswer = getString(R.string.scuba_standing);

        EditText question = (EditText) findViewById(id);
        String givenAnswer = question.getText().toString();

        return correctAnswer.equalsIgnoreCase(givenAnswer);
    }

    private boolean checkResultRadioButton(int id) {
        RadioButton correctOption = (RadioButton) findViewById(id);

        return correctOption.isChecked();
    }

    private boolean checkResultQ5() {
        CheckBox answerOption1 = (CheckBox) findViewById(R.id.q5_answer1);
        CheckBox answerOption2 = (CheckBox) findViewById(R.id.q5_answer2);
        CheckBox answerOption3 = (CheckBox) findViewById(R.id.q5_answer3);
        CheckBox answerOption4 = (CheckBox) findViewById(R.id.q5_answer4);
        CheckBox answerOption5 = (CheckBox) findViewById(R.id.q5_answer5);

        return answerOption1.isChecked() && answerOption2.isChecked()
                && !answerOption3.isChecked()
                && answerOption4.isChecked() && answerOption5.isChecked();
    }

    private void showResults(int result) {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.quiz_result, result);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

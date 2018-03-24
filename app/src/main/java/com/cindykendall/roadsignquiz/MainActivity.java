package com.cindykendall.roadsignquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // set quiz score to 0
    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // submit the quiz for scoring
    public void submitQuiz(View view) {

        // get user's name
        EditText nameField;
        nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();


        //identify correct answers
        RadioButton questionOneButton;
        questionOneButton = findViewById(R.id.stop_radio_button);
        boolean stop_radio_buttonisChecked = questionOneButton.isChecked();

        RadioButton questionTwoButton;
        questionTwoButton = findViewById(R.id.bump_radio_button);
        boolean bump_radio_buttonisChecked = questionTwoButton.isChecked();

        RadioButton questionThreeButton = findViewById(R.id.pass_radio_button);
        boolean pass_radio_buttonisChecked;
        pass_radio_buttonisChecked = questionThreeButton.isChecked();

        RadioButton questionFourButton;
        questionFourButton = findViewById(R.id.lowBeam_radio_button);
        boolean lowBeam_radio_buttonisChecked = questionFourButton.isChecked();

        RadioButton questionFiveButton;
        questionFiveButton = findViewById(R.id.rocks_radio_button);
        boolean rocks_radio_buttonisChecked = questionFiveButton.isChecked();

        RadioButton questionSixButton;
        questionSixButton = findViewById(R.id.railroad_radio_button);
        boolean railroad_radio_buttonisChecked = questionSixButton.isChecked();

        CheckBox sign1_checkbox = findViewById(R.id.sign1_checkbox);
        boolean sign1_checkboxisChecked = sign1_checkbox.isChecked();

        CheckBox sign2_checkbox =  findViewById(R.id.sign2_checkbox);
        boolean sign2_checkboxisChecked = sign2_checkbox.isChecked();

        CheckBox sign3_checkbox = findViewById(R.id.sign3_checkbox);
        boolean sign3_checkboxisChecked = sign3_checkbox.isChecked();

        double totalScore = calculateScore(
                stop_radio_buttonisChecked,
                bump_radio_buttonisChecked,
                pass_radio_buttonisChecked,
                lowBeam_radio_buttonisChecked,
                rocks_radio_buttonisChecked,
                railroad_radio_buttonisChecked,
                sign1_checkboxisChecked,
                sign2_checkboxisChecked,
                sign3_checkboxisChecked
        );

        // Display the score on the screen
        String scoreMessage = createScoreMessage(name, totalScore);
        displayMessage(scoreMessage);

    }
    // create the score message on screen and one of two toast messages based on score result
    private String createScoreMessage(String name, double totalScore) {
        String scoreMessage = name;
        scoreMessage = scoreMessage + getString(R.string.result_part1) + totalScore + getString(R.string.result_part2);
        if (totalScore>7) {
            Toast.makeText(this, R.string.positive_message, Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, R.string.study_message, Toast.LENGTH_LONG).show();
        return scoreMessage;
    }

    private void displayMessage(String message) {
        TextView scoreSummaryTextView = findViewById(R.id.total_score_text_view);
        scoreSummaryTextView.setText(message);
    }
    // This message displays when the user clicks the take quiz again (reset) button
    private String resetMessage() {
        String scoreMessage = "Total Score: " + totalScore;
        return scoreMessage;
    }

    // Calculate the score
    private double calculateScore(
            boolean stop_radio_buttonisChecked,
            boolean bump_radio_buttonisChecked,
            boolean pass_radio_buttonisChecked,
            boolean lowBeam_radio_buttonisChecked,
            boolean rocks_radio_buttonisChecked,
            boolean railroad_radio_buttonisChecked,
            boolean sign1_checkboxisChecked,
            boolean sign2_checkboxisChecked,
            boolean sign3_checkboxisChecked)

    {

        if (stop_radio_buttonisChecked) {
            totalScore=totalScore+1;
        }
        if (bump_radio_buttonisChecked) {
            totalScore=totalScore+1;
        }
        if (pass_radio_buttonisChecked) {
            totalScore=totalScore+1;
        }
        if (lowBeam_radio_buttonisChecked) {
            totalScore=totalScore+1;
        }
        if (rocks_radio_buttonisChecked) {
            totalScore=totalScore+1;
        }
        if (railroad_radio_buttonisChecked) {
            totalScore=totalScore+1;
        }
        if (sign1_checkboxisChecked) {
            totalScore=totalScore+1;
        }
        if (sign2_checkboxisChecked) {
            totalScore=totalScore+1;
        }
        if (sign3_checkboxisChecked) {
            totalScore=totalScore+1;
        }
        return totalScore;
    }


    // Reset all quiz answer buttons
    public void resetButton(View view) {

        totalScore=0;

        EditText questionFormBox = findViewById(R.id.name);
        questionFormBox.setText("");

        RadioGroup radioGroupOne = findViewById(R.id.question_one_radio_group);
        radioGroupOne.clearCheck();

        RadioGroup radioGroupTwo = findViewById(R.id.question_two_radio_group);
        radioGroupTwo.clearCheck();

        RadioGroup radioGroupThree = findViewById(R.id.question_three_radio_group);
        radioGroupThree.clearCheck();

        RadioGroup radioGroupFour = findViewById(R.id.question_four_radio_group);
        radioGroupFour.clearCheck();

        RadioGroup radioGroupFive = findViewById(R.id.question_five_radio_group);
        radioGroupFive.clearCheck();

        RadioGroup radioGroupSix = findViewById(R.id.question_six_radio_group);
        radioGroupSix.clearCheck();

        CheckBox sign1_checkbox =  findViewById(R.id.sign1_checkbox);
        sign1_checkbox.setChecked(false);

        CheckBox sign2_checkbox =  findViewById(R.id.sign2_checkbox);
        sign2_checkbox.setChecked(false);

        CheckBox sign3_checkbox =  findViewById(R.id.sign3_checkbox);
        sign3_checkbox.setChecked(false);

        CheckBox sign4_checkbox =  findViewById(R.id.sign4_checkbox);
        sign4_checkbox.setChecked(false);

        String resetMessage = resetMessage();
        displayMessage(resetMessage);

    }

}

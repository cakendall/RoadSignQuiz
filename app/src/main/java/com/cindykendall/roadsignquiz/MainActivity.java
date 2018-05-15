package com.cindykendall.roadsignquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // set quiz score to 0 and declare variables
    int totalScore = 0;
    RadioButton questionOneButton;
    RadioButton questionTwoButton;
    RadioButton questionThreeButton;
    RadioButton questionFourButton;
    RadioButton questionFiveButton;
    RadioButton questionSixButton;
    CheckBox sign1_checkbox;
    CheckBox sign2_checkbox;
    CheckBox sign3_checkbox;
    CheckBox sign4_checkbox;
    TextView scoreSummaryTextView;
    EditText questionFormBox;
    RadioGroup radioGroupOne;
    RadioGroup radioGroupTwo;
    RadioGroup radioGroupThree;
    RadioGroup radioGroupFour;
    RadioGroup radioGroupFive;
    RadioGroup radioGroupSix;
    EditText question8_answer;
    String resetMessage;
    Button viewAnswers;
    TextView sign1_answer;
    TextView sign2_answer;
    TextView sign3_answer;
    TextView sign4_answer;
    TextView sign5_answer;
    TextView sign6_answer;
    TextView sign7_answer;
    TextView sign8_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize variables
        questionOneButton = findViewById(R.id.stop_radio_button);
        questionTwoButton  = findViewById(R.id.bump_radio_button);
        questionThreeButton = findViewById(R.id.pass_radio_button);
        questionFourButton = findViewById(R.id.lowBeam_radio_button);
        questionFiveButton = findViewById(R.id.rocks_radio_button);
        questionSixButton = findViewById(R.id.railroad_radio_button);
        sign1_checkbox = findViewById(R.id.sign1_checkbox);
        sign2_checkbox = findViewById(R.id.sign2_checkbox);
        sign3_checkbox = findViewById(R.id.sign3_checkbox);
        sign4_checkbox =  findViewById(R.id.sign4_checkbox);
        scoreSummaryTextView = findViewById(R.id.total_score_text_view);
        questionFormBox = findViewById(R.id.name);
        radioGroupOne = findViewById(R.id.question_one_radio_group);
        radioGroupTwo = findViewById(R.id.question_two_radio_group);
        radioGroupThree = findViewById(R.id.question_three_radio_group);
        radioGroupFour = findViewById(R.id.question_four_radio_group);
        radioGroupFive = findViewById(R.id.question_five_radio_group);
        radioGroupSix = findViewById(R.id.question_six_radio_group);
        resetMessage = resetMessage();
        question8_answer = findViewById(R.id.question8_answer);
        viewAnswers = findViewById(R.id.view_answers);
        sign1_answer = findViewById(R.id.sign1_answer_display);
        sign2_answer = findViewById(R.id.sign2_answer_display);
        sign3_answer = findViewById(R.id.sign3_answer_display);
        sign4_answer = findViewById(R.id.sign4_answer_display);
        sign5_answer = findViewById(R.id.sign5_answer_display);
        sign6_answer = findViewById(R.id.sign6_answer_display);
        sign7_answer = findViewById(R.id.sign7_answer_display);
        sign8_answer = findViewById(R.id.sign8_answer_display);
        }


    // submit the quiz for scoring
    public void submitQuiz(View view) {

        // get user's name
        EditText nameField;
        nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();

        //identify correct answers
        boolean stop_radio_buttonisChecked = questionOneButton.isChecked();
        boolean bump_radio_buttonisChecked = questionTwoButton.isChecked();
        boolean pass_radio_buttonisChecked = questionThreeButton.isChecked();
        boolean lowBeam_radio_buttonisChecked = questionFourButton.isChecked();
        boolean rocks_radio_buttonisChecked = questionFiveButton.isChecked();
        boolean railroad_radio_buttonisChecked = questionSixButton.isChecked();
        boolean sign1_checkboxisChecked = sign1_checkbox.isChecked();
        boolean sign2_checkboxisChecked = sign2_checkbox.isChecked();
        boolean sign3_checkboxisChecked = sign3_checkbox.isChecked();
        boolean sign4_checkboxisChecked = sign4_checkbox.isChecked();

        double totalScore = calculateScore(
                stop_radio_buttonisChecked,
                bump_radio_buttonisChecked,
                pass_radio_buttonisChecked,
                lowBeam_radio_buttonisChecked,
                rocks_radio_buttonisChecked,
                railroad_radio_buttonisChecked,
                sign1_checkboxisChecked,
                sign2_checkboxisChecked,
                sign3_checkboxisChecked,
                sign4_checkboxisChecked
        );

            EditText editText = question8_answer;
            String question8_answer = editText.getText().toString().toUpperCase();
            if (question8_answer.equals("LLAMA"))
                totalScore = totalScore+1;

        // Display the score on the screen
        String scoreMessage = createScoreMessage(name, totalScore);
        displayMessage(scoreMessage);

        //Show the View Answers Button
        viewAnswers.setVisibility(View.VISIBLE);


    }
    // create the score message on screen and one of two toast messages based on score result
    private String createScoreMessage(String name, double totalScore) {
        String scoreMessage = name;
        scoreMessage = scoreMessage + getString(R.string.result_part1) + totalScore + getString(R.string.result_part2);
        String scoreMessagePos = scoreMessage + getString(R.string.positive_message);
        String scoreMessageStudy = scoreMessage + getString(R.string.study_message);
        if (totalScore>7) {
            Toast.makeText(this, scoreMessagePos, Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, scoreMessageStudy, Toast.LENGTH_LONG).show();
        return scoreMessage;
    }

    private void displayMessage(String message) {
        TextView scoreSummaryTextView = findViewById(R.id.total_score_text_view);
        scoreSummaryTextView.setText(message);
    }
    // This message displays when the user clicks the take quiz again (reset) button
    private String resetMessage() {
        return "Total Score: " + totalScore;
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
            boolean sign3_checkboxisChecked,
            boolean sign4_checkboxisChecked)
    {
        totalScore = 0;

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
        if (sign1_checkboxisChecked &&
                sign2_checkboxisChecked &&
                sign3_checkboxisChecked &&
                !sign4_checkboxisChecked) {
            totalScore=totalScore+3;
        }
        return totalScore;
    }


    // Reset all quiz answer buttons
    public void resetButton(View view) {

        totalScore=0;
        questionFormBox.setText("");
        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();
        radioGroupFive.clearCheck();
        radioGroupSix.clearCheck();
        sign1_checkbox.setChecked(false);
        sign2_checkbox.setChecked(false);
        sign3_checkbox.setChecked(false);
        sign4_checkbox.setChecked(false);
        question8_answer.setText("");
        String resetMessage = resetMessage();
        displayMessage(resetMessage);

        //Make answers invisible and make submit visible
         viewAnswers.setVisibility(View.INVISIBLE);

         //To hide all the answers made visible
          sign1_answer.setVisibility(View.INVISIBLE);
          sign2_answer.setVisibility(View.INVISIBLE);
          sign3_answer.setVisibility(View.INVISIBLE);
          sign4_answer.setVisibility(View.INVISIBLE);
          sign5_answer.setVisibility(View.INVISIBLE);
          sign6_answer.setVisibility(View.INVISIBLE);
          sign7_answer.setVisibility(View.INVISIBLE);
          sign8_answer.setVisibility(View.INVISIBLE);
        }

        //Show answer text boxes
        public void viewAnswers(View view) {
        sign1_answer.setVisibility(View.VISIBLE);
        sign2_answer.setVisibility(View.VISIBLE);
        sign3_answer.setVisibility(View.VISIBLE);
        sign4_answer.setVisibility(View.VISIBLE);
        sign5_answer.setVisibility(View.VISIBLE);
        sign6_answer.setVisibility(View.VISIBLE);
        sign7_answer.setVisibility(View.VISIBLE);
        sign8_answer.setVisibility(View.VISIBLE);
    }
}

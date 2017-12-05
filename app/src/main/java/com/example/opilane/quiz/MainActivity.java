package com.example.opilane.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Questions MyQuestions = new Questions();

    private Button choice1; //multiple choice1 from Questions'
    private Button choice2; //multiple choice2 from Questions
    private Button choice3; //multiple choice3 from Questions
    private Button choice4; //multiple choice4 from Questions
    private TextView score; //view for current total score
    private TextView question; //current question to answer
    private String MyAnswer; //correct answer for question
    private int MyScore = 0; //current total score
    private int MyQuestionNumber = 0; //current question number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setup screen for the first question with four alternative to answer
        choice1 = (Button)findViewById(R.id.choice1);
        choice2 = (Button)findViewById(R.id.choice2);
        choice3 = (Button)findViewById(R.id.choice3);
        choice4 = (Button)findViewById(R.id.choice4);
        score = (TextView)findViewById(R.id.score);
        question = (TextView)findViewById(R.id.question);
        updateQuestion();
        // show current total score for the user
        updateScore(MyScore)
    }

    private void updateQuestion() {
        //check if we are not outside array bounds for questions
        if (MyQuestionNumber < MyQuestions.getLength()){
     //set the text for new question and new 4 alternatives to answer on four buttons
            question.setText(MyQuestions.getQuestions(MyQuestionNumber));
            choice1.setText(MyQuestions.getChoice(MyQuestionNumber, 1));
            choice2.setText(MyQuestions.getChoice(MyQuestionNumber, 2));
            choice3.setText(MyQuestions.getChoice(MyQuestionNumber, 3));
            choice4.setText(MyQuestions.getChoice(MyQuestionNumber, 4));
            MyAnswer = MyQuestions.getCorrectAnswer(MyQuestionNumber);
            MyQuestionNumber++;
        }else{
            Toast.makeText(MainActivity.this, "It was the last question"
                    , Toast.LENGTH_SHORT).show();
            //last question, create new activity & show current and highest score
            //ve use intent which is responsible for providing switch between current activity and new
            Intent intent = new Intent(MainActivity.this,HighestScoreActivity.class)
                    intent.putExtra("score", MyScore); //pass the current score to the second screen
            startActivity(intent);
        }
    }

    private void updateScore(int myScore) {
    score.setText("",+MyScore + "/" + MyQuestions.getLength());
    }
public void onClick(View view){
        //all logic for all answer buttons in one method
    Button answer = (Button) view;
    //if the answer is correct increase the score
    if (answer.getText() == MyAnswer) {
        MyScore = MyScore + 1;
        Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(MainActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
        //show current total score for the user
        updateScore(MyScore);
        //Once the user answers the question we move on to the next one
        updateQuestion();

    }
}
}

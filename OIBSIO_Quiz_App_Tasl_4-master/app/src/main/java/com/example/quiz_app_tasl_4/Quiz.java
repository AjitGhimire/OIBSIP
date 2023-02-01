package com.example.quiz_app_tasl_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalquestions,showquestions;
    Button one,two,three,four,next;
    int score=0;
    int count=dataset.questions.length;
    int currentquestionindex=0;
    String selectedanswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        totalquestions=findViewById(R.id.shown_of_questions);
        showquestions=findViewById(R.id.shown_questions);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        next=findViewById(R.id.next);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        next.setOnClickListener(this);

        totalquestions.setText("Total questions are:"+count);

        loadNewQueations();
    }

    private void loadNewQueations() {
        if (currentquestionindex == count){
            finishQuiz();
            return;
        }
        showquestions.setText(dataset.questions[currentquestionindex]);
        one.setText(dataset.choices[currentquestionindex][0]);
        two.setText(dataset.choices[currentquestionindex][1]);
        three.setText(dataset.choices[currentquestionindex][2]);
        four.setText(dataset.choices[currentquestionindex][3]);
    }

    private void finishQuiz() {
        String passstatus="";
        if(score> count*0.60){
         passstatus="passed";
        }else{
            passstatus="failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passstatus)
                .setMessage("Score is "+score+" out of "+ count)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();

    }
    void restartQuiz(){
        score=0;
        currentquestionindex=0;
        loadNewQueations();
    }

    @Override
    public void onClick(View view) {

        one.setBackgroundColor(Color.RED);
        two.setBackgroundColor(Color.RED);
        three.setBackgroundColor(Color.RED);
        four.setBackgroundColor(Color.RED);

        Button clickedbutton= (Button) view;
        if (clickedbutton.getId() == R.id.next)
        {
                if (selectedanswer.equals(dataset.answers[currentquestionindex])) {
                    score++;
                }
                currentquestionindex++;
                loadNewQueations();



        } else{
                selectedanswer = clickedbutton.getText().toString();
                clickedbutton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
package com.example.mcqsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends AppCompatActivity {
    private int mcqNum;
    private ArrayList<MCQ> mcqs;
    private int result;
    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mcqNum = 0;
        result = 0;
        data = getIntent().getStringArrayListExtra("data");
        mcqs = arraylistToMCQ(data);
        Collections.shuffle(mcqs);
        showMCQ( mcqs , mcqNum);
    }
    private ArrayList<MCQ> arraylistToMCQ(ArrayList<String> data){
        ArrayList<MCQ> mcqs = new ArrayList<MCQ>();
        for(int i = 0; i<data.size(); i+=6)
            mcqs.add(new MCQ(data, i, i+5));
        return mcqs;
    }
    public void nextMCQ(View view){
        RadioButton[] opt = new RadioButton[4];
        opt[0] = findViewById(R.id.opt1);
        opt[1] = findViewById(R.id.opt2);
        opt[2] = findViewById(R.id.opt3);
        opt[3] = findViewById(R.id.opt4);
        for(int j = 0; j<4; j++)
            if(opt[j].isChecked()){
                if(opt[j].getText().equals(mcqs.get(mcqNum).getAnswer()))
                    result++;
                RadioGroup rdGrp = (RadioGroup) findViewById(R.id.rdGrp);
                rdGrp.clearCheck();
            }
        if(mcqNum == 9) {
            Intent seeResult = new Intent(this, Result.class);
            seeResult.putExtra("result",Integer.toString(result));
            seeResult.putStringArrayListExtra("data", data);
            seeResult.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(seeResult);
        }
        else {
            mcqNum++;
            showMCQ(mcqs, mcqNum);
        }
    }
    private void showMCQ( ArrayList<MCQ> mcqs , int i){
        TextView question = findViewById(R.id.questionView);
        question.setText(i+1+". "+mcqs.get(i).getQuestion());
        RadioButton[] opt = new RadioButton[4];
        opt[0] = findViewById(R.id.opt1);
        opt[1] = findViewById(R.id.opt2);
        opt[2] = findViewById(R.id.opt3);
        opt[3] = findViewById(R.id.opt4);
        for(int j = 0; j<4; j++)
            opt[j].setText(mcqs.get(i).getOption(j));
        if(i == 9) {
            Button submit = findViewById(R.id.nxtBtn);
            submit.setText("Submit");
        }
    }
}
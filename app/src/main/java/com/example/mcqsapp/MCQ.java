package com.example.mcqsapp;

import android.widget.TextView;

import java.util.ArrayList;

public class MCQ {
    private String question;
    private ArrayList<String> options;
    private String answer;
    public MCQ(){
        options = new ArrayList<String>();
    }
    public MCQ(ArrayList<String> data, int i, int j){
        options = new ArrayList<String>();
        question = data.get(i);
        for(int x = i+1; x<j; x++)
            options.add(data.get(x));
        answer = data.get(j);
    }
    public String getQuestion(){
        return question;
    }
    public String getOption(int i){
        return options.get(i);
    }
    public String getAnswer() {
        return answer;
    }
}

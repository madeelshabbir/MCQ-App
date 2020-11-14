package com.example.mcqsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startQuiz(View view){
        String[] dataArray = getResources().getStringArray(R.array.paper);
        final ArrayList<String> data = new ArrayList<String>(asList(dataArray));
        Intent goToQuiz = new Intent(this, Quiz.class);
        goToQuiz.putStringArrayListExtra("data", data);
        startActivity(goToQuiz);
    }
}
package com.example.mcqsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = findViewById(R.id.resultView);
        result.setText("Score: "+getIntent().getStringExtra("result"));
    }
    public void restartQuiz(View view){
        Intent restartQuiz = new Intent(this, Quiz.class);
        restartQuiz.putStringArrayListExtra("data", getIntent().getStringArrayListExtra("data"));
        startActivity(restartQuiz);
    }
    public void exitApp(View view){
        finish();
        System.exit(0);
    }
}
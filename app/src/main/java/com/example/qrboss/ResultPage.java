package com.example.qrboss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String data = intent.getStringExtra("result");
        textView.setText(data);

    }
}
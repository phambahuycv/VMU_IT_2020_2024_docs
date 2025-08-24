package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class N08_09_1 extends AppCompatActivity {
    private TextView tvwOutput;
    private void findViews() {
        tvwOutput = findViewById(R.id.tvwOutput0809);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n08091);
        findViews();
        Intent intent = getIntent();
        String str1 = intent.getStringExtra("param1");
        String str2 = intent.getStringExtra("param2");
        tvwOutput.setText(str1 + " " + str2);
    }
    public void btnReturnA_Clicked(View view) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("A"));
        setResult(RESULT_OK, intent);
        finish();
    }
    public void btnReturnB_Clicked(View view) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("B"));
        setResult(RESULT_OK, intent);
        finish();
    }
}
package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class N08_09_4 extends AppCompatActivity {
    private EditText edtMaPhongBan;
    private EditText edtTenPhongBan;
    private void findViews() {
        edtMaPhongBan = findViewById(R.id.edtMaPhongBan0809);
        edtTenPhongBan = findViewById(R.id.edtTenPhongBan0809);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n08094);
        findViews();
    }
    public void btnHuy_Clicked(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
    public void btnThem_Clicked(View view) {
        Intent intent = new Intent();
        String maPhongBan = edtMaPhongBan.getText().toString();
        String tenPhongBan = edtTenPhongBan.getText().toString();
        intent.setData(Uri.parse(maPhongBan+"-"+tenPhongBan));
        setResult(RESULT_OK, intent);
        finish();
    }
}
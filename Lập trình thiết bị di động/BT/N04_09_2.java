package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class N04_09_2 extends AppCompatActivity {
    private EditText edtInput;
    private Button btn0409;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0409);
        btn0409 = findViewById(R.id.btn0409);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n04091);
        findViews();
        btn0409.setText("Close Activity 2");
        Intent intent = getIntent();
        edtInput.setText(intent.getStringExtra("param1"));
    }

    public void btn0409_Clicked(View view) {
        //Gui du lieu tro ve
        Intent intent = new Intent();
        intent.setData(Uri.parse(edtInput.getText().toString()));
        setResult(RESULT_OK, intent);
        //Dong activity
        finish();
    }
}
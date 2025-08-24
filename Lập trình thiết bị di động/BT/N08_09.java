package com.example.ki2_2022_2023;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class N08_09 extends AppCompatActivity {
    private EditText edtInput;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0809);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0809);
        findViews();
    }
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            String str = result.getData().getDataString();
            edtInput.setText(str);
        }
    });
    public void btnRunN08091_Clicked(View view) {
        Intent intent = new Intent(this, N08_09_1.class);
        intent.putExtra("param1", edtInput.getText().toString());
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        intent.putExtra("param2", formatter.format(date));
        //startActivity(intent);
        launcher.launch(intent);
    }
}
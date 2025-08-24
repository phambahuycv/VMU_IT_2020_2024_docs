package com.example.ki2_2022_2023;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class N04_09_1 extends AppCompatActivity {
    private EditText edtInput;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0409);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n04091);
        findViews();
    }
    public void btn0409_Clicked(View view) {
        Intent intent = new Intent(this, N04_09_2.class);
        intent.putExtra("param1", edtInput.getText().toString());
        intent.putExtra("param2", "100");
        runActivityN04092launcher.launch(intent);
    }
    private ActivityResultLauncher<Intent> runActivityN04092launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            edtInput.setText(result.getData().getDataString());
        }
    });
}
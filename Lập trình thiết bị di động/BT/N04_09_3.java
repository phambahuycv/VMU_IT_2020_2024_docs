package com.example.ki2_2022_2023;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class N04_09_3 extends AppCompatActivity {
    private ArrayList<String> phongBans = new ArrayList<>();
    private ListView lsvPhongBan;
    private void findViews() {
        lsvPhongBan = findViewById(R.id.lsvPhongBan0409);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n04093);
        findViews();
    }
    private void loadLsvPhongBan() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.lit_phong_ban_0409, phongBans) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Get the data item for this position
                String phongBan = getItem(position);
                // Check if an existing view is being reused, otherwise inflate the view
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.lit_phong_ban_0409, parent, false);
                }
                // Lookup view for data population
                TextView tvwPhongBan = (TextView) convertView.findViewById(R.id.tvwPhongBan0409);
                tvwPhongBan.setText(phongBan);
                // Return the completed view to render on screen
                return convertView;
            }
        };
        lsvPhongBan.setAdapter(adapter);
    }
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            phongBans.add(result.getData().getDataString());
            loadLsvPhongBan();
        }
    });
    public void btnThem_Clicked(View view) {
        Intent intent = new Intent(this, N04_09_4.class);
        launcher.launch(intent);
    }
}
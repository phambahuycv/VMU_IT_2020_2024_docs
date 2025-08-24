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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class N08_09_3 extends AppCompatActivity {
    private ArrayList<PhongBan> phongBans = new ArrayList<>();
    private ListView lsvPhongBan;
    private void findViews() {
        lsvPhongBan = findViewById(R.id.lsvPhongBan0809);
    }
    private void loadLsvPhongBan() {
        ArrayAdapter<PhongBan> adapter = new ArrayAdapter<PhongBan>(this, R.layout.listitem_phong_ban_0809, phongBans) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Get the data item for this position
                PhongBan phongBan = getItem(position);
                // Check if an existing view is being reused, otherwise inflate the view
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_phong_ban_0809, parent, false);
                }
                // Lookup view for data population
                TextView tvwMaPhongBan = (TextView) convertView.findViewById(R.id.tvwMaPhongBan0809);
                TextView tvwTenPhongBan = (TextView) convertView.findViewById(R.id.tvwTenPhongBan0809);
                // Populate the data into the template view using the data object
                tvwMaPhongBan.setText(phongBan.getMaPhongBan().toString());
                tvwTenPhongBan.setText(phongBan.getTenPhongBan());
                return convertView;
            }
        };
        lsvPhongBan.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n08093);
        findViews();
    }
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                String[] parts = result.getData().getDataString().split("-");
                Integer maPhongBan = Integer.parseInt(parts[0]);
                String tenPhongBan = parts[1];
                PhongBan phongBan = new PhongBan(maPhongBan,tenPhongBan);
                phongBans.add(phongBan);
                loadLsvPhongBan();
            }
        }
    });
    public void btnThem_Clicked(View view) {
        Intent intent = new Intent(this, N08_09_4.class);
        launcher.launch(intent);
    }
}
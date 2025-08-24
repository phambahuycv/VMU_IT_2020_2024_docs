package com.example.ki2_2022_2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class N04_10 extends AppCompatActivity {
    private Spinner spnSanPham;
    private GridView grvSanPham;
    private void findViews() {
        spnSanPham = findViewById(R.id.spn0410);
        grvSanPham = findViewById(R.id.grv0410);
    }
    private ArrayList<String> sanPhams = new ArrayList<>();
    private ArrayList<SanPham0410> sanPhamList = new ArrayList<>();
    private void addItemsToSanPhams() {
        sanPhams.add("Sữa chua");
        sanPhams.add("Sữa đặc");
        sanPhams.add("Sữa đậu nành");
    }
    private void addItemToSanPhamList() {
        SanPham0410 sanPham1 = new SanPham0410(1, "Thạch đen", "000000");
        SanPham0410 sanPham2 = new SanPham0410(2, "Thạch xanh", "00ff00");
        SanPham0410 sanPham3 = new SanPham0410(3, "Thạch đậu đỏ", "ff0000");
        sanPhamList.add(sanPham1);
        sanPhamList.add(sanPham2);
        sanPhamList.add(sanPham3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0410);
        addItemsToSanPhams();
        addItemToSanPhamList();
        findViews();
        loadSpnSanPhamV1();
        loadGrvSanPham();
    }
    private void loadSpnSanPhamV1() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sanPhams);
        spnSanPham.setAdapter(adapter);
    }
    private void loadSpnSanPhamV2() {
        ArrayAdapter<SanPham0410> adapter =
                new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sanPhamList) {
                    @Nullable
                    @Override
                    public Object getItem(int position) {
                        SanPham0410 sanPham = sanPhamList.get(position);
                        return sanPham.getMaSanPham().toString() + " - " + sanPham.getTenSanPham();
                    }
                };
        spnSanPham.setAdapter(adapter);
    }
    private void loadGrvSanPham() {
        ArrayAdapter<SanPham0410> adapter =
                new ArrayAdapter<SanPham0410>(this, R.layout.dropdown_item_san_pham_0410, sanPhamList) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        SanPham0410 sanPham = getItem(position);
                        if (convertView == null)
                            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item_san_pham_0410, parent, false);
                        TextView tvwTenSanPham = convertView.findViewById(R.id.tvwTenSanPham0410);
                        View viwMauSac = convertView.findViewById(R.id.viwMauSac0410);
                        tvwTenSanPham.setText(sanPham.getTenSanPham());
                        viwMauSac.setBackgroundColor(Color.parseColor("#" + sanPham.getMauSac()));
                        return convertView;
                    }
                };
        grvSanPham.setAdapter(adapter);
    }
    private void loadSpnSanPhamV3() {
        ArrayAdapter<SanPham0410> adapter =
                new ArrayAdapter<SanPham0410>(this, R.layout.dropdown_item_san_pham_0410, sanPhamList) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        SanPham0410 sanPham = getItem(position);
                        if (convertView == null)
                            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item_san_pham_0410, parent, false);
                        TextView tvwTenSanPham = convertView.findViewById(R.id.tvwTenSanPham0410);
                        View viwMauSac = convertView.findViewById(R.id.viwMauSac0410);
                        tvwTenSanPham.setText(sanPham.getTenSanPham());
                        viwMauSac.setBackgroundColor(Color.parseColor("#" + sanPham.getMauSac()));
                        return convertView;
                    }

                    @Override
                    public View getDropDownView(int position, @Nullable @org.jetbrains.annotations.Nullable View convertView, @NonNull @NotNull ViewGroup parent) {
                        SanPham0410 sanPham = getItem(position);
                        if (convertView == null)
                            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item_san_pham_0410, parent, false);
                        TextView tvwTenSanPham = convertView.findViewById(R.id.tvwTenSanPham0410);
                        View viwMauSac = convertView.findViewById(R.id.viwMauSac0410);
                        tvwTenSanPham.setText(sanPham.getTenSanPham());
                        viwMauSac.setBackgroundColor(Color.parseColor("#" + sanPham.getMauSac()));
                        return convertView;
                    }
                };
        spnSanPham.setAdapter(adapter);
    }
}
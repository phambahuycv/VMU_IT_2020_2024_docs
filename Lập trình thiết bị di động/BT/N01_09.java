package com.example.ki2_2022_2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class N01_09 extends AppCompatActivity {
    private Spinner spnLop;
    private ListView lsvLop;
    private ArrayList<String> lops = new ArrayList<>();
    private ArrayList<Lop0109> lopObjects = new ArrayList<>();
    private void findViews() {
        spnLop = findViewById(R.id.spnLop0109);
        lsvLop = findViewById(R.id.lsvLop0109);
    }
    private void loadSpnLop() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, lops);
        spnLop.setAdapter(adapter);
    }
    private void loadSpnLopV2() {
        ArrayAdapter<Lop0109> adapter =
                new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, lopObjects) {
                    public Object getItem(int position) {
                        Lop0109 lop = lopObjects.get(position);
                        return lop.getMaLop().toString() + " - " + lop.getTenLop();
                    }
                };
        spnLop.setAdapter(adapter);
    }
    private void loadSpnLopV3() {
        ArrayAdapter<Lop0109> adapter =
                new ArrayAdapter<Lop0109>(this, R.layout.dropdown_item_lop, lopObjects) {
                    @NonNull
                    @Override
                    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        Lop0109 lop = getItem(position);
                        if (convertView == null)
                            convertView =
                                    LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item_lop, parent, false);
                        TextView tvwMaLop = convertView.findViewById(R.id.tvwMaLop0109);
                        TextView tvwTenLop = convertView.findViewById(R.id.tvwTenLop0109);
                        TextView tvwSiSo = convertView.findViewById(R.id.tvwSiSo0109);
                        tvwMaLop.setText(lop.getMaLop().toString());
                        tvwTenLop.setText(lop.getTenLop());
                        tvwSiSo.setText(lop.getSiSo().toString());
                        return convertView;
                    }
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        Lop0109 lop = getItem(position);
                        if (convertView == null)
                            convertView =
                                    LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item_lop, parent, false);
                        TextView tvwMaLop = convertView.findViewById(R.id.tvwMaLop0109);
                        TextView tvwTenLop = convertView.findViewById(R.id.tvwTenLop0109);
                        TextView tvwSiSo = convertView.findViewById(R.id.tvwSiSo0109);
                        tvwMaLop.setText(lop.getMaLop().toString());
                        tvwTenLop.setText(lop.getTenLop());
                        tvwSiSo.setText(lop.getSiSo().toString());
                        return convertView;
                    }
                };
        spnLop.setAdapter(adapter);
    }
    private void loadLsvLop() {
        ArrayAdapter<Lop0109> adapter =
                new ArrayAdapter<Lop0109>(this, R.layout.dropdown_item_lop, lopObjects) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        Lop0109 lop = getItem(position);
                        if (convertView == null)
                            convertView =
                                    LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item_lop, parent, false);
                        TextView tvwMaLop = convertView.findViewById(R.id.tvwMaLop0109);
                        TextView tvwTenLop = convertView.findViewById(R.id.tvwTenLop0109);
                        TextView tvwSiSo = convertView.findViewById(R.id.tvwSiSo0109);
                        tvwMaLop.setText(lop.getMaLop().toString());
                        tvwTenLop.setText(lop.getTenLop());
                        tvwSiSo.setText(lop.getSiSo().toString());
                        return convertView;
                    }
                };
        lsvLop.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0109);
        findViews();
        lops.add("CNT59CL");
        lops.add("CNT60CL");
        lops.add("CNT61CL");
        lops.add("CNT62CL");
        lopObjects.add(new Lop0109(1,"CNT60DH",35));
        lopObjects.add(new Lop0109(2,"CNT61DH",36));
        lopObjects.add(new Lop0109(3,"CNT62DH",37));
        loadSpnLopV3();
        loadLsvLop();
    }
}
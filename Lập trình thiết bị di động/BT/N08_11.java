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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class N08_11 extends AppCompatActivity {
    private ArrayList<String> countries;
    private ArrayList<Country> countryList;
    private Spinner spnCountries;
    private ListView lsvCountries;
    private GridView grvCountries;
    private void findViews() {
        spnCountries = findViewById(R.id.spnCountries);
        lsvCountries = findViewById(R.id.lsvCountries);
        grvCountries = findViewById(R.id.grvCountries);
    }
    private void initializeCountries() {
        countries = new ArrayList<>();
        countries.add("Vietnam");
        countries.add("Korea");
        countries.add("Japan");
    }
    private void initializeCountryList() {
        countryList = new ArrayList<>();
        countryList.add(new Country("1","Vietnam","ff0000"));
        countryList.add(new Country("2","Korea","00ff00"));
        countryList.add(new Country("3","Japan","0000ff"));
        countryList.add(new Country("4","America","ffff00"));
        countryList.add(new Country("5","France","00ffff"));
    }
    private void loadSpnCountriesV1() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, countries);
        spnCountries.setAdapter(adapter);
    }
    private void loadLsvCountriesV1() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, countries);
        lsvCountries.setAdapter(adapter);
    }
    private void loadSpnCountriesV2() {
        ArrayAdapter<Country> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, countryList) {
            @Nullable
            @Override
            public Object getItem(int position) {
                Country country = countryList.get(position);
                return country.getCode() + " - " + country.getName();
            }
        };
        spnCountries.setAdapter(adapter);
    }
    private void loadLsvCountriesV2() {
        ArrayAdapter<Country> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, countryList) {
            @Nullable
            @Override
            public Object getItem(int position) {
                Country country = countryList.get(position);
                return country.getCode() + " - " + country.getName();
            }
        };
        lsvCountries.setAdapter(adapter);
    }
    private void loadSpnCountriesV3() {
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, R.layout.country_item, countryList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                Country country = getItem(position);
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_item, parent, false);
                }
                TextView tvwCode = convertView.findViewById(R.id.tvwCountryCode);
                TextView tvwName = convertView.findViewById(R.id.tvwCountryName);
                View viwColor = convertView.findViewById(R.id.viwCountryColor);
                tvwCode.setText(country.getCode());
                tvwName.setText(country.getName());
                viwColor.setBackgroundColor(Color.parseColor("#"+country.getColor()));
                return convertView;
            }

            @Override
            public View getDropDownView(int position, @Nullable @org.jetbrains.annotations.Nullable View convertView, @NonNull @NotNull ViewGroup parent) {
                Country country = getItem(position);
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_item, parent, false);
                }
                TextView tvwCode = convertView.findViewById(R.id.tvwCountryCode);
                TextView tvwName = convertView.findViewById(R.id.tvwCountryName);
                View viwColor = convertView.findViewById(R.id.viwCountryColor);
                tvwCode.setText(country.getCode());
                tvwName.setText(country.getName());
                viwColor.setBackgroundColor(Color.parseColor("#"+country.getColor()));
                return convertView;
            }
        };
        spnCountries.setAdapter(adapter);
    }
    private void loadLsvCountriesV3() {
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, R.layout.country_item, countryList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                Country country = getItem(position);
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_item, parent, false);
                }
                TextView tvwCode = convertView.findViewById(R.id.tvwCountryCode);
                TextView tvwName = convertView.findViewById(R.id.tvwCountryName);
                View viwColor = convertView.findViewById(R.id.viwCountryColor);
                tvwCode.setText(country.getCode());
                tvwName.setText(country.getName());
                viwColor.setBackgroundColor(Color.parseColor("#"+country.getColor()));
                return convertView;
            }
        };
        lsvCountries.setAdapter(adapter);
    }
    private void loadGrvCountriesV() {
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, R.layout.country_grid_item, countryList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                Country country = getItem(position);
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_grid_item, parent, false);
                }
                TextView tvwCodeAndName = convertView.findViewById(R.id.tvwCodeAndName0811);
                View viwColor = convertView.findViewById(R.id.viwColor0811);
                tvwCodeAndName.setText(country.getCode() + " - " + country.getName());
                viwColor.setBackgroundColor(Color.parseColor("#"+country.getColor()));
                return convertView;
            }
        };
        grvCountries.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0811);
        initializeCountries();//Khoi tao gia tri cho mang countries
        initializeCountryList();//Khoi tao gia tri cho mang countryList
        findViews();//Anh xa cac view tren giao dien vao cac bien de lap trinh
        //loadSpnCountriesV1();//Nap du lieu len spinner
        loadSpnCountriesV3();
        loadLsvCountriesV3();
        loadGrvCountriesV();
    }
}
package com.example.ki2_2022_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class N01_04 extends AppCompatActivity {

    private EditText edtN0104;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0104);
        edtN0104 = findViewById(R.id.edtN0104);
        edtN0104.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_n0104, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Item 1")) {
            Intent intent = new Intent(this, N01_04.class);
            startActivity(intent);
        }
        else if (item.getTitle().equals("Item 2")) {
            Intent intent = new Intent(this, N01_02.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, N01_03.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Doc menu tu file XML ra bien menu
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_n0104, menu);
        //Thiet ke menu bang ma lenh
        menu.add("To lower");
        menu.add("To upper");
        menu.add("Standardlize");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private String standardlizeString(String inputString) {
        inputString = inputString.trim();
        while (inputString.contains("  "))
            inputString = inputString.replace("  "," ");
        inputString = inputString.toLowerCase();
        String[] words = inputString.split(" ");
        for (int i = 0; i < words.length; ++i)
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
        String output = words[0];
        for (int i = 1; i < words.length; ++i)
            output += " " + words[i];
        return output;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("To lower")) {
            String lowerText = edtN0104.getText().toString().toLowerCase();
            edtN0104.setText(lowerText);
        }
        else if (item.getTitle().equals("To upper")){
            String upperText = edtN0104.getText().toString().toUpperCase();
            edtN0104.setText(upperText);
        }
        else {
            String text = standardlizeString(edtN0104.getText().toString());
            edtN0104.setText(text);
        }
        return super.onContextItemSelected(item);
    }
}
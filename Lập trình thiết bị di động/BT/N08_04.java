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

public class N08_04 extends AppCompatActivity {
    private EditText edtTest;
    private void findViews() {
        edtTest = findViewById(R.id.edtTest);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0804);
        findViews();
        //Gan menu ngu canh vào edtTest
        edtTest.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Goi menu duoc thiet ke san day vao bien menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_n0804, menu);
        //Thiet ke menu bang lenh java
        //menu.add("Lua chon 1");
        //menu.add("Lua chon 2");
        //menu.add("Lua chon 3");
        //menu.add("Lua chon 4");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("N08 01")) {
            Intent intent = new Intent(this, N08_01.class);
            startActivity(intent);
        }
        else if (item.getTitle().equals("N08 02")) {
            Intent intent = new Intent(this, N08_02.class);
            startActivity(intent);
        }
        else if (item.getTitle().equals("N08 03")) {
            Intent intent = new Intent(this, N08_03.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, N08_04.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("To lower");
        menu.add("To upper");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("To lower")) {
            String lowerText = edtTest.getText().toString().toLowerCase();
            edtTest.setText(lowerText);
        }
        else if (item.getTitle().equals("To upper")) {
            String upperText = edtTest.getText().toString().toUpperCase();
            edtTest.setText(upperText);
        }
        return super.onContextItemSelected(item);
    }

    public void btnMayTinh_Clicked(View view) {
        Intent intent = new Intent(this, N08_03.class);
        startActivity(intent);
    }
}
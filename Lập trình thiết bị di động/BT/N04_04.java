package com.example.ki2_2022_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class N04_04 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0404);
        ImageView imageView = findViewById(R.id.imvThuyTien);
        imageView.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Thiet ke menu bang code
        //menu.add("Lựa chọn 1");
        //menu.add("Lựa chọn 2");
        //menu.add("Lựa chọn 3");
        //Goi ra menu thiet ke bang xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_n0404, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().toString().equals("Item 1")) {
            Intent intent = new Intent(this, N04_01.class);
            startActivity(intent);
        }
        else if (item.getTitle().toString().equals("Item 2")){
            Intent intent = new Intent(this, N04_02.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, N04_04.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().toString().equals("Item 1"))
            Toast.makeText(this, "Click item 1", Toast.LENGTH_SHORT).show();
        else if (item.getTitle().toString().equals("Item 2"))
            Toast.makeText(this, "Click item 2", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Click item 3", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_n0404, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
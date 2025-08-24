package com.example.ki2_2022_2023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class N01_11 extends AppCompatActivity {
    private EditText edtCategoryName;
    private ListView lsvCategories;
    private BookStoreDatabase database;
    private void findViews() {
        edtCategoryName = findViewById(R.id.edtCategoryName0111);
        lsvCategories = findViewById(R.id.lsvCategories0111);
    }
    private void loadLsvCategories() {
        database.connectToRead();
        Cursor cursor = database.select("categories", new String[] {"id","name"}, "1=1");
        database.close();
        ArrayList<Category> categories = new ArrayList<>();
        if (cursor==null)
            return;
        Integer id;
        String name;
        Category category;
        while (true) {
            id = cursor.getInt(0);
            name = cursor.getString(1);
            category = new Category(id, name);
            categories.add(category);
            if (cursor.isLast())
                break;
            else
                cursor.moveToNext();
        }
        ArrayAdapter<Category> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, categories) {
            @Nullable
            @Override
            public Object getItem(int position) {
                Category aCategory = categories.get(position);
                return aCategory.getId().toString() + " - " + aCategory.getName();
            }
        };
        lsvCategories.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0111);
        database = new BookStoreDatabase(this);
        findViews();
    }
    public void btnAdd_Clicked(View view) {
        String name = edtCategoryName.getText().toString();
        database.connectToWrite();
        database.insert("categories", new String[] {"name"}, new String[] {name});
        database.close();
        loadLsvCategories();
    }
}
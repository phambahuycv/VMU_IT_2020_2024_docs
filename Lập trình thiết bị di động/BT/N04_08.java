package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class N04_08 extends AppCompatActivity {
    private N0408Database database;
    private ArrayList<Lop> lops = new ArrayList<>();
    private EditText edtMaLop;
    private EditText edtTenLop;
    private void findViews() {
        edtMaLop = findViewById(R.id.edtMaLop0408);
        edtTenLop = findViewById(R.id.edtTenLop0408);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0408);
        database = new N0408Database(this);
        findViews();
        try {
            readLops();
        } catch (Exception ex) {
            Toast.makeText(this,ex.toString(), Toast.LENGTH_LONG).show();
        }
    }
    private void readLops() throws SQLException {
        database.connectToRead();
        Cursor cursor = database.select("Lop",new String[] {"MaLop","TenLop"}, "1=1");
        do {
            int maLop = cursor.getInt(0);
            String tenLop = cursor.getString(1);
            Lop lop = new Lop(maLop,tenLop);
            lops.add(lop);
        } while (cursor.moveToNext());
        database.close();
        Toast.makeText(this, Integer.toString(lops.size()),Toast.LENGTH_LONG).show();
    }
    public void btnThem_Clicked(View view) {
        database.connectToWrite();
        String tenLop = edtTenLop.getText().toString();
        try {
            database.insert("Lop", new String[]{"TenLop"}, new String[]{tenLop});
        }
        catch (Exception ex) {
            Toast.makeText(this,ex.toString(), Toast.LENGTH_LONG).show();
        }
        database.close();
        Toast.makeText(this,"Thêm dữ liệu thành công", Toast.LENGTH_LONG).show();
    }
}
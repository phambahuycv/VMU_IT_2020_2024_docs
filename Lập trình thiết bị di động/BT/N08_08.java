package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class N08_08 extends AppCompatActivity {
    private ArrayList<Lop> lops;
    private EditText edtMaLop;
    private EditText edtTenLop;
    private void findViews() {
        edtMaLop = findViewById(R.id.edtMaLop0808);
        edtTenLop = findViewById(R.id.edtTenLop0808);
    }
    private void loadLops() throws SQLException {
        N0808Database database = new N0808Database(this);
        database.connectToRead();
        Cursor cursor = database.select("Lop",new String[] {"MaLop","TenLop"},"");
        lops = new ArrayList<>();
        while (cursor != null) {
            int maLop = cursor.getInt(0);
            String tenLop = cursor.getString(1);
            Lop lop = new Lop(maLop, tenLop);
            lops.add(lop);
            if (!cursor.isLast())
                cursor.moveToNext();
            else
                break;
        }
        Toast.makeText(this,Integer.toString(lops.size()),Toast.LENGTH_LONG).show();
        database.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0808);
        findViews();
        try {
            loadLops();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void btnThem_Clicked(View view) {
        N0808Database database = new N0808Database(this);
        database.connectToWrite();
        database.insert("Lop",new String[] {"TenLop"}, new String[] {edtTenLop.getText().toString()});
        database.close();
        Toast.makeText(this,"Thêm thành công", Toast.LENGTH_LONG).show();
    }
}
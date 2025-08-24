package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class N01_07 extends AppCompatActivity {
    private ArrayList<SinhVien> sinhViens = new ArrayList<>();
    private EditText edtMaSinhVien;
    private EditText edtHoTen;
    private EditText edtNgaySinh;
    private void findViews() {
        edtMaSinhVien = findViewById(R.id.edtMaSinhVien0107);
        edtHoTen = findViewById(R.id.edtHoTen0107);
        edtNgaySinh = findViewById(R.id.edtNgaySinh0107);
    }
    private void readFile() throws IOException, ParseException {
        FileInputStream stream = openFileInput("n0107.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = "";
        while (line != null) {
            line = reader.readLine();
            if (line != null) {
                String[] parts = line.split("\t");
                int maSinhVien = Integer.parseInt(parts[0]);
                String hoTen = parts[1];
                Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(parts[2]);
                SinhVien sinhVien = new SinhVien(maSinhVien,hoTen,ngaySinh);
                sinhViens.add(sinhVien);
            }
        }
        reader.close();
        streamReader.close();
        stream.close();
    }
    private void writeFile() throws IOException {
        FileOutputStream stream = openFileOutput("n0107.txt", MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < sinhViens.size(); ++i)
            writer.write(Integer.toString(sinhViens.get(i).getMaSinhVien()) + "\t"
                    + sinhViens.get(i).getHoTen() + "\t"
                    + new SimpleDateFormat("dd/MM/yyyy").format(sinhViens.get(i).getNgaySinh()) + "\n");
        writer.close();
        stream.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0107);
        findViews();
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void btnThem_Clicked(View view) throws ParseException, IOException {
        //Lay ra du lieu tu cac edittext
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        String hoTen = edtHoTen.getText().toString();
        Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString());
        //Dem cac du lieu lay duoc tao ra 1 sinh vien, dua sinh vien vao danh sach
        SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, ngaySinh);
        sinhViens.add(sinhVien);
        //Ghi du lieu nay vao file n0107.txt
        writeFile();
    }

    public void btnXoa_Clicked(View view) throws IOException {
        //Lay ra ma sinh vien tren edittext
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        //Duyet danh sach sinh vien tim ra sinh vien co ma giong ben tren
        //Tim duoc thi xoa sinh vien do di
        for (int i = 0; i < sinhViens.size(); ++i)
            if (sinhViens.get(i).getMaSinhVien() == maSinhVien)
                sinhViens.remove(i);
        //Dong bo danh sach voi file
        writeFile();
    }
}
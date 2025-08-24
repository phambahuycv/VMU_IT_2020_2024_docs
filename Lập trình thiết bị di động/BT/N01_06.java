package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class N01_06 extends AppCompatActivity {
    private EditText edtN0106;
    private int currentIndex = -1;
    private ArrayList<String> lines = new ArrayList<>();
    private void findViews() {
        edtN0106 = findViewById(R.id.edtN0106);
    }
    //Doc du lieu tu file, moi dong se la 1 phan tu cua mang lines
    private void readFile() throws IOException {
        FileInputStream stream = openFileInput("n0106.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line="";
        while (line != null) {
            line = reader.readLine();
            if (line != null)
                lines.add(line);
        }
        reader.close();
        streamReader.close();
        stream.close();
        if (lines.size() == 0) {
            edtN0106.setText("");
            currentIndex = -1;
        }
        else {
            edtN0106.setText(lines.get(0));
            currentIndex = 0;
        }
    }
    //Ghi du lieu vào file, moi phan tu se la 1 dong cua file
    private void writeFile() throws IOException {
        FileOutputStream stream = openFileOutput("n0106.txt",MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < lines.size(); i++)
            writer.write(lines.get(i) + "\n");
        writer.close();
        stream.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0106);
        findViews();
        try {
            readFile();
        } catch (Exception e) {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public void btnSave_Clicked(View view) throws IOException {
        //Lay ra noi dung cua edittext
        String text = edtN0106.getText().toString();
        //Ghi noi dung do vao file n0106.txt
        //B1: Tao ra 1 luong output du lieu
        FileOutputStream stream = openFileOutput("n0106.txt",MODE_PRIVATE);
        //B2: Tao ra 1 bo ghi du lieu
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        //B3: Ghi du lieu vao file text
        writer.write(text);
        //B4: Dong bo ghi du lieu va luong lai
        writer.close();
        stream.close();
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }
    public void btnLoad_Clicked(View view) throws IOException {
        //Doc du lieu tu file text ra
        //B1: Tao ra 1 luong input du lieu
        FileInputStream stream = openFileInput("n0106.txt");
        //B2: Tao ra 1 bo doc luong
        InputStreamReader streamReader = new InputStreamReader(stream);
        //B3: Chuyen sang bo doc bo dem
        BufferedReader reader = new BufferedReader(streamReader);
        //B4: Doc du lieu
        String text = reader.readLine();
        //Dong tat ca lai
        reader.close();
        streamReader.close();
        stream.close();
        //Nap du lieu len edittext
        edtN0106.setText(text);
    }
    public void btnAdd_Clicked(View view) throws IOException {
        //Lay ra noi dung cua edittext
        String text = edtN0106.getText().toString();
        //Kiem tra xem lines co chua text ko
        //Neu ko chua thi add text vao mang lines
        if (!lines.contains(text))
            lines.add(text);
        //dong bo voi file
        writeFile();
        //hien thi phan tu dau tien neu co
        if (lines.size() == 0) {
            edtN0106.setText("");
            currentIndex = -1;
        }
        else {
            edtN0106.setText(lines.get(0));
            currentIndex = 0;
        }
    }
    public void btnRemove_Clicked(View view) throws IOException {
        //Lay ra noi dung cua edittext
        String text = edtN0106.getText().toString();
        //Neu noi dung nay nam trong lines thi remove phan tu
        if (lines.contains(text))
            lines.remove(text);
        //dong bo voi file
        writeFile();
        //hien thi phan tu dau tien neu co
        if (lines.size() == 0) {
            edtN0106.setText("");
            currentIndex = -1;
        }
        else {
            edtN0106.setText(lines.get(0));
            currentIndex = 0;
        }
    }
    public void btnPrevious_Clicked(View view) {
        if (currentIndex==-1)
            return;
        if (currentIndex == 0)
            currentIndex = lines.size()-1;
        else if (currentIndex > 0)
            currentIndex--;
        edtN0106.setText(lines.get(currentIndex));
    }
    public void btnNext_Clicked(View view) {
        if (currentIndex==-1)
            return;
        if (currentIndex == lines.size()-1)
            currentIndex = 0;
        else if (currentIndex < lines.size() - 1)
            currentIndex++;
        edtN0106.setText(lines.get(currentIndex));
    }
}
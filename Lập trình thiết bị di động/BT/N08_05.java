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

public class N08_05 extends AppCompatActivity {
    private ArrayList<String> lines = new ArrayList<String>();
    private int currentIndex = -1;
    private EditText edtN0805;
    private void findViews() {
        edtN0805 = findViewById(R.id.edtN0805);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0805);
        findViews();
        try {
            loadLines();
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void loadLines() throws IOException {
        //Doc du lieu tu file text va bo vao bien lines
        FileInputStream stream = openFileInput("n0805.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = "a";
        while (line != null) {
            line = reader.readLine();
            if (line != null)
                lines.add(line);
        }
        //day phan tu dau tien len edittext neu co
        if (lines.size() > 0) {
            edtN0805.setText(lines.get(0));
            currentIndex = 0;
        }
        else {
            edtN0805.setText("");
            currentIndex = -1;
        }
    }

    public void btnSave_Clicked(View view) throws IOException {
        //Lay ra noi dung edittext
        String text = edtN0805.getText().toString();
        //Ghi noi dung do vao file
        //Buoc 1: Tao ra luong (stream) toi file can xuat du lieu
        FileOutputStream stream = openFileOutput("n0805.txt", MODE_PRIVATE);
        //Buoc 2: Tao ra bo ghi du lieu (writer) theo luong vua tao
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        //Buoc 3: Su dung writer de ghi du lieu
        writer.write(text);
        //Buoc 4: Dong bo ghi du lieu va luong lai
        writer.close();
        stream.close();
        Toast.makeText(this, "Finished", Toast.LENGTH_LONG).show();
    }

    public void btnLoad_Clicked(View view) throws IOException {
        //Doc du lieu tu file n0805.txt
        //Buoc 1: Tao luong toi file can doc
        FileInputStream stream = openFileInput("n0805.txt");
        //Buoc 2: Tao bo doc tu luong vua tao
        InputStreamReader streamReader = new InputStreamReader(stream);
        //Buoc 3: Tao bo doc bo dem tu bo doc vua tao
        BufferedReader reader = new BufferedReader(streamReader);
        //Buoc 4: Doc du lieu
        String text = reader.readLine();
        //Buoc 5: Dong cac bo doc va luong lai
        reader.close();
        streamReader.close();
        stream.close();
        //Gan du lieu doc duoc len edittext
        edtN0805.setText(text);
    }

    public void btnAdd_Clicked(View view) throws IOException {
        //Lay ra noi dung text o edittext
        String text = edtN0805.getText().toString();
        //Kiem tra noi dung nay co nam trong bien lines
        //neu co thi ko lam gi
        //neu khong thi add no vao lines
        if (!lines.contains(text)) {
            lines.add(text);
            //ghi ca bien lines vao file text
            writeFile();
        }
    }

    private void writeFile() throws IOException {
        FileOutputStream stream = openFileOutput("n0805.txt", MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < lines.size(); ++i)
            writer.write(lines.get(i) + "\n");
        writer.close();
        stream.close();
        //tro ve dau danh sach sau khi ghi file
        if (lines.size() > 0) {
            edtN0805.setText(lines.get(0));
            currentIndex = 0;
        }
        else {
            edtN0805.setText("");
            currentIndex = -1;
        }
    }

    public void btnPrevious_Clicked(View view) {
        if (currentIndex == -1)
            return;
        if (currentIndex == 0)
            currentIndex = lines.size() - 1;
        else
            currentIndex--;
        edtN0805.setText(lines.get(currentIndex));
    }

    public void btnNext_Clicked(View view) {
        if (currentIndex == -1)
            return;
        if (currentIndex == lines.size() - 1)
            currentIndex = 0;
        else
            currentIndex++;
        edtN0805.setText(lines.get(currentIndex));
    }

    public void btnRemove_Clicked(View view) throws IOException {
        //lay ra noi dung cua edittext
        String currentText = edtN0805.getText().toString();
        //kiem tra xem lines co chua noi dung nay ko
        //neu co, xoa phan tu do di, ghi file
        if (lines.contains(currentText)) {
            lines.remove(currentText);
            writeFile();
        }
    }
}
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

public class N08_14 extends AppCompatActivity {
    private ArrayList<Student0814> students;
    private EditText edtInput;
    private EditText edtID;
    private EditText edtName;
    private EditText edtAge;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0814);
        edtID = findViewById(R.id.edtID0814);
        edtName = findViewById(R.id.edtName0814);
        edtAge = findViewById(R.id.edtAge0814);
    }
    private void loadStudents() {
        students = new ArrayList<>();
        try {
            FileInputStream stream = openFileInput("students.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; ++i) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                Student0814 student = new Student0814(id, name,age);
                students.add(student);
            }
            reader.close();
            streamReader.close();
            stream.close();
        }
        catch (Exception exception) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0814);
        findViews();
        loadStudents();
    }
    public void btnAdd_Clicked(View view) throws IOException {
        int id = Integer.parseInt(edtID.getText().toString());
        String name = edtName.getText().toString();
        int age = Integer.parseInt(edtAge.getText().toString());
        Student0814 student = new Student0814(id,name,age);
        students.add(student);
        save();
    }

    private void save() throws IOException {
        FileOutputStream stream = openFileOutput("students.txt",MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        writer.write(Integer.toString(students.size()) + "\n");
        for (int i = 0; i < students.size(); ++i) {
            Student0814 student = students.get(i);
            writer.write(student.getId().toString() + "," + student.getName() + "," + student.getAge().toString() + "\n");
        }
        writer.close();
        stream.close();
    }

    public void btnLoad_Clicked(View view) {
        int id = Integer.parseInt(edtID.getText().toString());
        for(int i = 0; i < students.size(); ++i)
            if (students.get(i).getId() == id) {
                edtName.setText(students.get(i).getName());
                edtAge.setText(students.get(i).getAge().toString());
                return;
            }
        Toast.makeText(this,"NOT FOUND",Toast.LENGTH_LONG).show();
    }

    public void btnRemove_Clicked(View view) throws IOException {
        int id = Integer.parseInt(edtID.getText().toString());
        for(int i = 0; i < students.size(); ++i)
            if (students.get(i).getId() == id) {
                students.remove(i);
                save();
                return;
            }
        Toast.makeText(this,"NOT FOUND",Toast.LENGTH_LONG).show();
    }

    public void btnSave2_Clicked(View view) throws IOException {
        FileOutputStream stream = openFileOutput("array.txt",MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        writer.write(edtInput.getText().toString());
        writer.close();
        stream.close();
    }

    public void btnLoad2_Clicked(View view) throws IOException {
        FileInputStream stream = openFileInput("array.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = reader.readLine();
        String[] parts = line.split(" ");
        int sum = 0;
        for (int i = 0; i < parts.length; ++i)
            sum += Integer.parseInt(parts[i]);
        Toast.makeText(this, "THE SUM IS " + Integer.toString(sum), Toast.LENGTH_LONG).show();
        reader.close();
        streamReader.close();
        stream.close();
    }

    public void btnSave1_Clicked(View view) throws IOException {
        FileOutputStream stream = openFileOutput("array.txt",MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        String line = edtInput.getText().toString();
        String[] parts = line.split(" ");
        writer.write(Integer.toString(parts.length) + "\n");
        for (int i = 0; i < parts.length; ++i)
            writer.write(parts[i] + "\n");
        writer.close();
        stream.close();
    }
    public void btnLoad1_Clicked(View view) throws IOException {
        FileInputStream stream = openFileInput("array.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        int n = Integer.parseInt(reader.readLine());
        int sum = 0;
        for (int i = 0; i < n; ++i)
            sum += Integer.parseInt(reader.readLine());
        Toast.makeText(this, "THE SUM IS " + Integer.toString(sum), Toast.LENGTH_LONG).show();
        reader.close();
        streamReader.close();
        stream.close();
    }
}
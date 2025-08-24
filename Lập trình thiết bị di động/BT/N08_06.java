package com.example.ki2_2022_2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class N08_06 extends AppCompatActivity {
    private EditText edtMaSinhVien;
    private EditText edtHoTen;
    private EditText edtNgaySinh;
    private ListView lvwSinhVien;
    private TextView tvwMaSinhVienError;
    private TextView tvwHoTenError;
    private TextView tvwNgaySinhError;
    private void findViews() {
        edtMaSinhVien = findViewById(R.id.edtMaSinhVien0806);
        edtHoTen = findViewById(R.id.edtHoTen0806);
        edtNgaySinh = findViewById(R.id.edtNgaySinh0806);
        lvwSinhVien = findViewById(R.id.lvwSinhVien0806);
        tvwMaSinhVienError = findViewById(R.id.tvwMaSinhVienError0807);
        tvwHoTenError = findViewById(R.id.tvwHoTenError0807);
        tvwNgaySinhError = findViewById(R.id.tvwNgaySinhError0807);
    }
    private void loadLvwSinhVien() {
        ArrayAdapter<SinhVien> adapter = new ArrayAdapter<SinhVien>(this,R.layout.listitem_sinhvien0806,sinhViens){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //Sinh ra giao dien cho doi tuong du lieu thu position
                // Get the data item for this position
                SinhVien sinhVien = getItem(position);
                // Check if an existing view is being reused, otherwise inflate the view
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_sinhvien0806, parent, false);
                }
                // Lookup view for data population
                TextView tvwMaSinhVien = (TextView) convertView.findViewById(R.id.tvwMaSinhVien0806);
                TextView tvwHoTen = (TextView) convertView.findViewById(R.id.tvwHoTen0806);
                TextView tvwNgaySinh = (TextView) convertView.findViewById(R.id.tvwNgaySinh0806);

                // Populate the data into the template view using the data object
                tvwMaSinhVien.setText(Integer.toString(sinhVien.getMaSinhVien()));
                tvwHoTen.setText(sinhVien.getHoTen());
                tvwNgaySinh.setText(new SimpleDateFormat("dd/MM/yyyy").format(sinhVien.getNgaySinh()));
                //Add click event on the layout
                ConstraintLayout layout = (ConstraintLayout) convertView.findViewById(R.id.laySinhVien0807);
                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtMaSinhVien.setText(Integer.toString(sinhVien.getMaSinhVien()));
                        edtHoTen.setText(sinhVien.getHoTen());
                        edtNgaySinh.setText(new SimpleDateFormat("dd/MM/yyyy").format(sinhVien.getNgaySinh()));
                    }
                });
                // Return the completed view to render on screen
                return convertView;
            }
        };
        lvwSinhVien.setAdapter(adapter);
    }
    private ArrayList<SinhVien> sinhViens = new ArrayList<SinhVien>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0806);
        findViews();
        try {
                readFile();
        }
        catch (Exception ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
        }
        loadLvwSinhVien();

    }

    private void readFile() throws IOException, ParseException {
        FileInputStream stream = openFileInput("n0806.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = "";
        int maSinhVien;
        String hoTen;
        Date ngaySinh;
        SinhVien sinhVien = null;
        while (line != null) {
            line = reader.readLine();
            if (line != null) {
                String[] parts = line.split("\t");
                maSinhVien = Integer.parseInt(parts[0]);
                hoTen = parts[1];
                ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(parts[2]);
                sinhVien = new SinhVien(maSinhVien,hoTen,ngaySinh);
                sinhViens.add(sinhVien);
            }
        }
        reader.close();
        streamReader.close();
        stream.close();
    }
    private void writeFile() throws IOException {
        FileOutputStream stream = openFileOutput("n0806.txt",MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        int len = sinhViens.size();
        for (int i = 0; i < len; ++i)
            writer.write(Integer.toString(sinhViens.get(i).getMaSinhVien()) + "\t"
                    + sinhViens.get(i).getHoTen() + "\t"
                    + new SimpleDateFormat("dd/MM/yyyy").format(sinhViens.get(i).getNgaySinh()) + "\n");
        writer.close();
        stream.close();
    }

    public void btnThem_Clicked(View view) throws ParseException, IOException {
        tvwMaSinhVienError.setText("");
        tvwHoTenError.setText("");
        tvwNgaySinhError.setText("");
        boolean error = false;
        if (edtMaSinhVien.getText().toString().equals("")){
            tvwMaSinhVienError.setText("Chưa điền mã sinh viên");
            error = true;
        }
        else {
            try {
                int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
                int len = sinhViens.size();
                for (int i = 0; i < len; ++i)
                    if (sinhViens.get(i).getMaSinhVien() == maSinhVien) {
                        tvwMaSinhVienError.setText("Trùng mã sinh viên");
                        error = true;
                    }
            }
            catch (Exception ex) {
                tvwMaSinhVienError.setText("Mã sinh viên sai định dạng");
                error = true;
            }
        }
        if (edtHoTen.getText().toString().equals("")) {
            tvwHoTenError.setText("Chưa điền họ tên");
            error = true;
        }
        if (edtNgaySinh.getText().toString().equals("")) {
            tvwNgaySinhError.setText("Chưa điền ngày sinh");
            error = true;
        }
        else {
            try {
                Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString());
            }
            catch (Exception ex) {
                tvwNgaySinhError.setText("Điền ngày sinh sai định dạng");
                error = true;
            }
        }
        if (error)
            return;
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        String hoTen = edtHoTen.getText().toString();
        Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString());
        SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, ngaySinh);
        sinhViens.add(sinhVien);
        writeFile();
        loadLvwSinhVien();
    }
    public void btnSua_Clicked(View view) throws IOException, ParseException {
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        int len = sinhViens.size();
        boolean found = false;
        for (int i = 0; i < len; ++i)
            if (sinhViens.get(i).getMaSinhVien() == maSinhVien) {
                sinhViens.get(i).setHoTen(edtHoTen.getText().toString());
                sinhViens.get(i).setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString()));
                found = true;
                break;
            }
        if (found) {
            writeFile();
            loadLvwSinhVien();
        }
        else
            Toast.makeText(this,"Không tìm thấy sinh viên",Toast.LENGTH_LONG).show();
    }
    public void btnXoa_Clicked(View view) throws IOException {
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        int len = sinhViens.size();
        boolean found = false;
        for (int i = 0; i < len; ++i)
            if (sinhViens.get(i).getMaSinhVien() == maSinhVien) {
                sinhViens.remove(i);
                found = true;
                break;
            }
        if (found) {
            writeFile();
            loadLvwSinhVien();
        }
        else
            Toast.makeText(this,"Không tìm thấy sinh viên",Toast.LENGTH_LONG).show();
    }
}
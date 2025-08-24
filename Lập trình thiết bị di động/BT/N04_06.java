package com.example.ki2_2022_2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
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

public class N04_06 extends AppCompatActivity {
    private ArrayList<SinhVien> sinhViens;
    private EditText edtMaSinhVien;
    private EditText edtHoTen;
    private EditText edtNgaySinh;
    private ListView lvwSinhViens;
    private TextView tvwMaSinhVienError;
    private TextView tvwHoTenError;
    private TextView tvwNgaySinhError;
    private void findViews() {
        edtMaSinhVien = findViewById(R.id.edtMaSinhVienN0406);
        edtHoTen = findViewById(R.id.edtHoTenN0406);
        edtNgaySinh = findViewById(R.id.edtNgaySinhN0406);
        lvwSinhViens = findViewById(R.id.lvwSinhViens0406);
        tvwMaSinhVienError = findViewById(R.id.tvwMaSinhVienError0407);
        tvwHoTenError = findViewById(R.id.tvwHoTenError0407);
        tvwNgaySinhError = findViewById(R.id.tvwNgaySinhError0407);
    }
    private void loadSinhViens() throws IOException, ParseException {
        sinhViens = new ArrayList<>();
        FileInputStream stream = openFileInput("n0406.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = "";
        int maSinhVien = 0;
        String hoTen = "";
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
        Toast.makeText(this, Integer.toString(sinhViens.size()), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0406);
        findViews();
        try {
            loadSinhViens();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        loadLvwSinhVien();
    }
    private void clearErrors() {
        tvwMaSinhVienError.setText("");
        tvwHoTenError.setText("");
        tvwNgaySinhError.setText("");
    }
    private boolean checkForm() {
        boolean isFine = true;
        clearErrors();
        if (edtMaSinhVien.getText().toString().equals("")) {
            tvwMaSinhVienError.setText("Chưa điền mã sinh viên");
            isFine = false;
        }
        if (edtHoTen.getText().toString().equals("")) {
            tvwHoTenError.setText("Chưa điền họ tên");
            isFine = false;
        }
        Date ngaySinh = null;
        try {
            ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString());
        }
        catch (Exception ex) {
            tvwNgaySinhError.setText("Điền ngày tháng sai định dạng");
            isFine = false;
        }
        return isFine;
    }
    public void btnThem_Clicked(View view) throws ParseException, IOException {
        if (checkForm() == false)
            return;
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        //duyet danh sach sinh vien xem co sinh vien nao co ma giong maSinhVien ko
        //neu co thi dung
        int len = sinhViens.size();
        for (int i = 0; i < len; ++i)
            if (sinhViens.get(i).getMaSinhVien() == maSinhVien) {
                tvwMaSinhVienError.setText("Trùng mã sinh viên");
                return;
            }
        String hoTen = edtHoTen.getText().toString();
        Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString());
        SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, ngaySinh);
        sinhViens.add(sinhVien);
        saveSinhViens();
        loadLvwSinhVien();
    }
    private void saveSinhViens() throws IOException {
        FileOutputStream stream = openFileOutput("n0406.txt", MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < sinhViens.size(); ++i)
            writer.write(Integer.toString(sinhViens.get(i).getMaSinhVien()) + "\t"
                    + sinhViens.get(i).getHoTen() + "\t"
                    + new SimpleDateFormat("dd/MM/yyyy").format(sinhViens.get(i).getNgaySinh()) + "\n");
        writer.close();
        stream.close();
    }
    private void loadLvwSinhVien() {
        //Day du lieu tu ArrayList sinhViens sang ArrayAdapter
        //Day du lieu tu ArrayAdapter sang ListView
        ArrayAdapter<SinhVien> adapter = new ArrayAdapter<SinhVien>(this,R.layout.listitem_sinhvien0406,sinhViens) {
            //Hien thi du lieu thu position len listview
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Get the data item for this position
                SinhVien sinhVien = getItem(position);
                // Check if an existing view is being reused, otherwise inflate the view
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_sinhvien0406, parent, false);
                }
                // Lookup view for data population
                TextView tvwMaSinhVien = (TextView) convertView.findViewById(R.id.tvwMaSinhVien0406);
                TextView tvwHoTen = (TextView) convertView.findViewById(R.id.tvwHoTen0406);
                TextView tvwNgaySinh = (TextView) convertView.findViewById(R.id.tvwNgaySinh0406);
                ConstraintLayout layout = (ConstraintLayout) convertView.findViewById(R.id.layItemSinhVien0406);
                if (position % 2 ==0)
                    layout.setBackgroundColor(Color.rgb(255,255,255));
                else
                    layout.setBackgroundColor(Color.rgb(235,235,235));
                // Populate the data into the template view using the data object
                tvwMaSinhVien.setText(Integer.toString(sinhVien.getMaSinhVien()));
                tvwHoTen.setText(sinhVien.getHoTen());
                tvwNgaySinh.setText(new SimpleDateFormat("dd/MM/yyyy").format(sinhVien.getNgaySinh()));
                //Tao su kien click cho item tren listview
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
        lvwSinhViens.setAdapter(adapter);
    }
    public void btnSua_Clicked(View view) throws ParseException, IOException {
        if (checkForm() == false)
            return;
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        int len = sinhViens.size();
        boolean sua = false;
        for (int i = 0; i < len; i ++)
            if (sinhViens.get(i).getMaSinhVien() == maSinhVien) {
                sinhViens.get(i).setHoTen(edtHoTen.getText().toString());
                sinhViens.get(i).setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(edtNgaySinh.getText().toString()));
                sua = true;
                break;
            }
        if (!sua)
            Toast.makeText(this,"Không tìm thấy sinh viên", Toast.LENGTH_LONG).show();
        else {
            saveSinhViens();
            loadLvwSinhVien();
            Toast.makeText(this,"Sửa sinh viên thành công", Toast.LENGTH_LONG).show();
        }
    }
    public void btnXoa_Clicked(View view) throws IOException {
        boolean error = true;
        clearErrors();
        if (edtMaSinhVien.getText().toString().equals("")) {
            tvwMaSinhVienError.setText("Chưa điền mã sinh viên");
            error = false;
        }
        if (error == false)
            return;
        int maSinhVien = Integer.parseInt(edtMaSinhVien.getText().toString());
        int len = sinhViens.size();
        boolean xoa = false;
        for (int i = 0; i < len; i ++)
            if (sinhViens.get(i).getMaSinhVien() == maSinhVien) {
                sinhViens.remove(i);
                xoa = true;
                break;
            }
        if (!xoa)
            Toast.makeText(this,"Không tìm thấy sinh viên", Toast.LENGTH_LONG).show();
        else {
            saveSinhViens();
            loadLvwSinhVien();
            Toast.makeText(this,"Xóa sinh viên thành công", Toast.LENGTH_LONG).show();
        }
    }
}
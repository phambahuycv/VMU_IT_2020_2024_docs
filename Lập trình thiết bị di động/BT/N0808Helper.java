package com.example.ki2_2022_2023;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class N0808Helper extends SQLiteOpenHelper {
    private static String databaseName = "N0808";
    private static int databaseVersion = 2;
    private static String createTableLopCommand = "CREATE TABLE Lop(MaLop INTEGER PRIMARY KEY AUTOINCREMENT, TenLop TEXT NOT NULL)";
    private static String createTableHocSinhCommand = "CREATE TABLE HocSinh(MaHocSinh INTEGER PRIMARY KEY AUTOINCREMENT,HoTen TEXT NOT NULL,MaLop INTEGER NOT NULL)";
    private static String dropTableLopCommand = "DROP TABLE IF EXISTS Lop";
    private static String dropTableHocSinhCommand = "DROP TABLE IF EXISTS HocSinh";
    public N0808Helper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(createTableLopCommand);
            db.execSQL(createTableHocSinhCommand);
        }
        catch (Exception ex) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(dropTableLopCommand);
            db.execSQL(dropTableHocSinhCommand);
            db.execSQL(createTableLopCommand);
            db.execSQL(createTableHocSinhCommand);
        }
        catch (Exception ex) {

        }
    }
}

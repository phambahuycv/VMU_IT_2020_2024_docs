package com.example.ki2_2022_2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

public class N0408Database {
    private static String databaseName = "N0408";
    private static String databaseTag = "N0408";
    private static int version = 2;
    private static String createTableLopCommand = "CREATE TABLE Lop(MaLop INTEGER PRIMARY KEY AUTOINCREMENT, TenLop TEXT NOT NULL)";
    private static String createTableHocSinhCommand = "CREATE TABLE HocSinh(MaHocSinh INTEGER PRIMARY KEY AUTOINCREMENT,HoTen TEXT NOT NULL,MaLop INTEGER NOT NULL)";
    private static String dropTableLopCommand = "DROP TABLE IF EXISTS Lop";
    private static String dropTableHocSinhCommand = "DROP TABLE IF EXISTS HocSinh";

    public static String getDatabaseName() {
        return databaseName;
    }

    public static String getDatabaseTag() {
        return databaseTag;
    }

    public static int getVersion() {
        return version;
    }

    public static String getCreateTableLopCommand() {
        return createTableLopCommand;
    }

    public static String getCreateTableHocSinhCommand() {
        return createTableHocSinhCommand;
    }

    public static String getDropTableLopCommand() {
        return dropTableLopCommand;
    }

    public static String getDropTableHocSinhCommand() {
        return dropTableHocSinhCommand;
    }

    private Context context;
    private N0408Helper helper;
    private SQLiteDatabase database;

    public N0408Database(Context context) {
        this.context = context;
        helper = new N0408Helper(context);
    }
    public N0408Database connectToRead() {
        database = helper.getReadableDatabase();
        return this;
    }
    public N0408Database connectToWrite() {
        database = helper.getWritableDatabase();
        return this;
    }
    public void close() {
        helper.close();
    }
    public long insert(String tableName, String[] columnNames, String[] values) {
        ContentValues row = new ContentValues();
        int len =columnNames.length;
        for (int i=0;i<len;++i)
            row.put(columnNames[i], values[i]);
        return database.insert(tableName, null, row);
    }
    public boolean update(String tableName, String[] columnNames, String[] values, String condition) {
        ContentValues row = new ContentValues();
        int len =columnNames.length;
        for (int i=0;i<len;++i)
            row.put(columnNames[i], values[i]);
        return database.update(tableName, row, condition, null) > 0;
    }
    public boolean delete(String tableName, String condition) {
        return database.delete(tableName, condition, null) > 0;
    }
    public Cursor select(String tableName, String[] columnNames, String condition) throws SQLException {
        Cursor cursor;
        if (condition != "")
            cursor = database.query(true, tableName, columnNames, condition, null, null, null, null, null);
        else
            cursor = database.query(true, tableName, columnNames, null, null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }



}

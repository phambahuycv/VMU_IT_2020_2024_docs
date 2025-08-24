package com.example.ki2_2022_2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Ket noi de doc, ghi hoac dong
 * Truy van du lieu, them, sua, xoa
 */
public class BookStoreDatabase {
    private Context context;
    private BookStoreHelper helper;
    private SQLiteDatabase database;
    public BookStoreDatabase(Context context) {
        this.context = context;
        helper = new BookStoreHelper(context);
    }
    public void connectToWrite() {
        database = helper.getWritableDatabase();
    }
    public void connectToRead() {
        database = helper.getReadableDatabase();
    }
    public void close() {
        database.close();
    }
    public void insert(String tableName, String[] columnNames, String[] columnValues) {
        ContentValues row = new ContentValues();
        int columnNumber = columnNames.length;
        for (int i = 0; i < columnNumber; ++i)
            row.put(columnNames[i], columnValues[i]);
        database.insert(tableName,null, row);
    }
    public long update(String tableName, String[] columnNames, String[] columnValues, String condion) {
        ContentValues row = new ContentValues();
        int columnNumber = columnNames.length;
        for (int i = 0; i < columnNumber; ++i)
            row.put(columnNames[i], columnValues[i]);
        return database.update(tableName, row, condion, null);
    }
    public long delete(String tableName, String condition) {
        return database.delete(tableName, condition, null);
    }
    public Cursor select(String tableName, String[] columnNames, String condition) {
        Cursor cursor = database.query(tableName, columnNames, condition, null, null,null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }
}

package com.example.ki2_2022_2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

public class N0808Database {
    private Context context;
    private N0808Helper helper;
    private SQLiteDatabase database;
    public N0808Database(Context context) {
        this.context = context;
        helper = new N0808Helper(context);
    }
    public void connectToWrite() {
        database = helper.getWritableDatabase();
    }
    public void connectToRead() {
        database = helper.getReadableDatabase();
    }
    public void close() {
        database.close();
        helper.close();
    }
    public long insert(String tableName, String[] columnNames, String[] values) {
        ContentValues record = new ContentValues();
        int len =columnNames.length;
        for (int i=0;i<len;++i)
            record.put(columnNames[i], values[i]);
        return database.insert(tableName, null, record);
    }
    public long update(String tableName, String[] columnNames, String[] values, String condition) {
        ContentValues record = new ContentValues();
        int len =columnNames.length;
        for (int i=0;i<len;++i)
            record.put(columnNames[i], values[i]);
        return database.update(tableName, record, condition, null);
    }
    public long delete(String tableName, String condition) {
        return database.delete(tableName, condition, null);
    }
    public Cursor select(String tableName, String[] columnNames, String condition) throws SQLException {
        Cursor cursor;
        if (condition != "")
            cursor = database.query(true, tableName, columnNames, condition, null, null, null,
                    null, null);
        else
            cursor = database.query(true, tableName, columnNames, null, null, null, null, null,
                    null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

}

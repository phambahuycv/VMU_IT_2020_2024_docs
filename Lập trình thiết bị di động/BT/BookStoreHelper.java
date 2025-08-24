package com.example.ki2_2022_2023;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Tao ra CSDL trong lan dau chay
 * Tao ra cac the hien cua CSDL de doc hoac ghi du lieu
 */
public class BookStoreHelper extends SQLiteOpenHelper {
    public static String dbName = "BookStore";
    public static String categoriesTableCreateSQLCommand = "CREATE TABLE categories(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);";
    public static String booksTableCreateSQLCommand = "CREATE TABLE books(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, categoryid INTEGER NOT NULL);";
    public BookStoreHelper(@Nullable Context context) {
        super(context, BookStoreHelper.dbName, null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(BookStoreHelper.categoriesTableCreateSQLCommand);
            db.execSQL(BookStoreHelper.booksTableCreateSQLCommand);
        }
        catch (Exception ex) { }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

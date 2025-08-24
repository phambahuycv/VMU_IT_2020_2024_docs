package com.example.ki2_2022_2023;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class N0408Helper extends SQLiteOpenHelper {
    public N0408Helper(Context context){
        super(context, N0408Database.getDatabaseName(), null, N0408Database.getVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(N0408Database.getCreateTableLopCommand());
            db.execSQL(N0408Database.getCreateTableHocSinhCommand());
        }
        catch (Exception ex) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(N0408Database.getCreateTableLopCommand());
        db.execSQL(N0408Database.getCreateTableHocSinhCommand());
        onCreate(db);
    }
}

package com.brunoocasali.milibros.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bruno Casali on 24/04/2015.
 */
public class BookHelper extends SQLiteOpenHelper {
    public BookHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE books (" +
                      " _id INTEGER PRIMARY KEY, " +
                      " title TEXT, " +
                      " author TEXT, " +
                      " rate REAL, " +
                      " status INTEGER);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.thejan.smarthome.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static SQLiteDatabase database;
    private static final String DB_NAME = "smart-home-android.db";
    private static final int DB_VERSION = 1;

    private static final String SQL_CREATE_TABLE = "create table records if not exists (" +
            "_ID INTEGER PRIMARY KEY, " +
            "TURN_ON TEXT, " +
            "TURN_OFF TEXT, " +
            "TEMP_UP TEXT, " +
            "TEMP_DOWN TEXT" +
            ")";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    public static SQLiteDatabase getDatabase(){
        return DBHelper.database;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        database.execSQL(SQL_CREATE_TABLE);

        DBHelper.database = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

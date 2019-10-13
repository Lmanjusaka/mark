package com.example.eyesmart.DbUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String KEY_ROWID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMPNO = "empno";
    private static final String KEY_SEX = "sex";
    private static final String KEY_CARDID = "idcard";
    private static final String KEY_TELEPHONE = "telephone";
    private static final String KEY_PHOTO = "photo";
    private static final String KEY_ADMINISTRATOR = "administrator";
    private static final String KEY_TIME = "time";
    private static final String KEY_DEVICEID = "deviceid";

    private static DBHelper mdbHelper;
    private static final String DATABASE_NAME = "EyeMark";
    private static final String SQLITE_TABLE_1 = "employee";
    private static final String SQLITE_TABLE_2 = "record";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_1 = "create table if not exists " + SQLITE_TABLE_1 +
            "(" + KEY_ROWID + " integer PRIMARY KEY autoincrement," + KEY_NAME + "," + KEY_EMPNO +
            "," + KEY_SEX + "," + KEY_CARDID + "," + KEY_TELEPHONE + "," + KEY_PHOTO +
            " blob," + KEY_ADMINISTRATOR + ")";
    private static final String DATABASE_CREATE_2 = "create table if not exists " + SQLITE_TABLE_2 +
            "(" + KEY_ROWID + " integer PRIMARY KEY autoincrement," + KEY_NAME + "," + KEY_EMPNO +
            "," + KEY_SEX + "," + KEY_CARDID + "," + KEY_TELEPHONE + "," + KEY_PHOTO +
            " blob," + KEY_TIME + "," + KEY_DEVICEID + ")";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_1);
        db.execSQL(DATABASE_CREATE_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

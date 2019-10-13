package com.example.eyesmart;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbAdapter {
    public static final String  KEY_ROWID = "_id";
    public static final String  KEY_NAME = "name";
    public static final String  KEY_NUMBER = "number";
    public static final String  KEY_CARDID = "card_id";
    public static final String  IMG_PATH = "img_path";

    public  static final String TAG = "UserDbAapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    private final Context mCtx;

    public static final String DATABASE_NAME = "EyeSmart";
    public static final String SQLITE_TABLE = "User";
    public static final int DATABASE_VERSION = 2;
    public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE_CREATE = "create table if not exists " +
                SQLITE_TABLE + "(" + KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                KEY_NUMBER + "," + KEY_NAME + ","  + KEY_CARDID + "," + IMG_PATH + "," + " UNIQUE (" + KEY_NUMBER +
                "));";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
            onCreate(db);

        }
    }

    public UserDbAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    public UserDbAdapter open() throws SQLException{
        mDbHelper = new DatabaseHelper(mCtx);

        mDb = mDbHelper.getWritableDatabase();

        return this;
    }

    public void close(){
        if(mDbHelper != null){
            mDbHelper.close();
        }
    }

    public long createUser(String number, String name, String card_id, String img_path) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NUMBER, number);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_CARDID, card_id);
        initialValues.put(IMG_PATH, img_path);

        return mDb.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAllUsers(){
        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_TABLE, null, null);
        return doneDelete > 0;
    }
//    public boolean deleteUsersById(String [] args){
//        int doneDelete = 0;
//        doneDelete = mDb.delete(SQLITE_TABLE, "_id = ?", args);
//        return doneDelete > 0;
//    }
    public Cursor fetchUsersByName(String inputText) throws SQLException{
        Log.w(TAG,inputText);
        Cursor cursor = null;
        if (inputText == null || inputText.length() == 0){
            cursor = mDb.query(SQLITE_TABLE,new String[]{KEY_ROWID, KEY_NUMBER, KEY_NAME, KEY_CARDID},
                    null, null, null, null,null);
        }
        else {
            cursor = mDb.query(true, SQLITE_TABLE, new String[]{KEY_ROWID, KEY_NUMBER, KEY_NAME, KEY_CARDID},
                    KEY_NAME + " like '%" + inputText + "%'", null, null, null, null, null);
        }
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchAllUsers(){
        Cursor mCursor =  mDb.query(SQLITE_TABLE, new String[]{KEY_ROWID, KEY_NUMBER, KEY_NAME, KEY_CARDID},
                null, null, null, null,null);
        if (mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public void insertSomeUsers(){
        createUser("100","张三","1000", "");
        createUser("101","李四","1001", "");
        createUser("102","王五","1002", "");
        createUser("103","赵六","1003", "");
    }
}

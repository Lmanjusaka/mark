package com.example.eyesmart.DbUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eyesmart.entity.Employee;

import java.util.List;

public class DBTool {
    private static SQLiteDatabase mDb;
    private static DBHelper mDbHelper;
    private final Context mCtx;
    public DBTool(Context mCtx) {
        this.mCtx = mCtx;
    }
    public DBTool open(){
        mDbHelper = new DBHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        if (mDbHelper != null){
            mDbHelper.close();
        }
    }
    public static long createEmployee(Employee employee){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",employee.getName());
        contentValues.put("sex",employee.getSex());
        contentValues.put("idcard",employee.getIdcard());
        contentValues.put("empno",employee.getEmpno());
        contentValues.put("telephone",employee.getTelephone());
        contentValues.put("photo",employee.getPhoto());
        if(employee.isAdministrator()){
            contentValues.put("administrator",Employee.MALE);
        }else {
            contentValues.put("administrator",Employee.FEMALE);
        }
        return mDb.insert("employee",null,contentValues);
    }
    public static void createEmployees(List<Employee> list){
        for (Employee employee: list) {
            createEmployee(employee);
        }
    }
    public long getEmployeeNum(){
        Cursor cursor = mDb.rawQuery("select count(*) from employee",null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public Cursor fechAllEmployee(){
        if (mDb == null || !mDb.isOpen()){
        }
        Cursor mCursor = mDb.query("employee",new String[]{"name","empno","cardid","sex", "telephone"},
                null,null,null,null,null);
        //Cursor mCursor = mDb.rawQuery("select * from employee",null);
        return mCursor;

    }
    public boolean deleteAllUsers(){
        int donedelete;
        donedelete = mDb.delete("employee",null,null);
        return donedelete > 0;
    }
}

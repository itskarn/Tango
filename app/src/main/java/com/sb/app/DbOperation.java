package com.sb.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Chandan on 3/8/15.
 */
public class DbOperation extends SQLiteOpenHelper
{
    public static final int database_version = 1;
    public String CREATE_QUERY ="CREATE TABLE "+DbData.DbInfo.TABLE_NAME+"("+DbData.DbInfo.USER_NAME+" TEXT,"+DbData.DbInfo.PASS_WORD+" TEXT)";
    public DbOperation(Context context)
    {
        super(context,DbData.DbInfo.DB_NAME,null,database_version);
        Log.d("DataBase Operation",CREATE_QUERY);
    }

    //Create Table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.d("DataBase Operation",CREATE_QUERY);
    }

    //insert into table
    public void putInformation(DbOperation dop,String username,String password)
    {
        SQLiteDatabase SD =dop.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(DbData.DbInfo.USER_NAME,username);
        cv.put(DbData.DbInfo.PASS_WORD,password);
        long k = SD.insert(DbData.DbInfo.TABLE_NAME,null,cv);
        Log.d("DataBase Operation","One Row Created");
    }

    //retrive from table
    public Cursor getInformation(DbOperation dp)
    {
        SQLiteDatabase SQ=dp.getReadableDatabase();
        String[] column ={DbData.DbInfo.USER_NAME,DbData.DbInfo.PASS_WORD};
        Cursor cr=SQ.query(DbData.DbInfo.TABLE_NAME,column,null,null,null,null,null);
        return cr;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}


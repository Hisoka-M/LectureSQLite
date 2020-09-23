package com.example.lecturesqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteDB extends SQLiteOpenHelper {

    public MySQLiteDB(Context context) {
        super(context, "dbTown", null, 3);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" Create Table TblTown("
                + "id INTEGER not null Primary key autoincrement,"
                + " townName TEXT not null);");
        String towns[] = { "Paris", "Marseille","Grenoble", "Bordeaux", "Lyon", "Toulouse", "Lille", "Nice", "Nantes", "Strasbourg", "Montpellier"};
        for (String town : towns){
            db.execSQL("Insert into tblTown (townName) Values ('" + town + "');");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" Drop table if exists TblTown");
        onCreate(db);
    }

    public String townBeginningWith(String TownBeginning){
        String ch = "";
        String req = "SELECT townName from tblTown WHERE townName LIKE'" + TownBeginning + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(req, null);
        if (cursor.moveToFirst()){
            do {
                ch = ch + "-" + cursor.getString(0) + "\n";
            }
            while (cursor.moveToNext());
        }
        return ch;
    }
}
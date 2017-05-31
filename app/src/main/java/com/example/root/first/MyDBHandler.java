package com.example.root.first;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "playerDB.db";
    public static final String TABLE_PLAYERS = "players";
    public static final String COLUMN_POS = "pos";
    public static final String COLUMN_PLAYERNAME = "playername";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME , factory, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PLAYERS + "(" +
                COLUMN_POS + " VARCHAR(5), " +
                COLUMN_PLAYERNAME + " VARCHAR(15) PRIMARY KEY" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        onCreate(db);
    }

    public void addPlayer(Player x){
        ContentValues values = new ContentValues();
        values.put(COLUMN_POS , x.getPosition());
        values.put(COLUMN_PLAYERNAME , x.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PLAYERS, null, values);
        db.close();
    }

    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PLAYERS + " WHERE " + COLUMN_PLAYERNAME + "=\"" + productName + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PLAYERS + " WHERE 1";// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("playername")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("playername"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String[] printList(){


        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_PLAYERS + " WHERE 1";
        Cursor c = db.rawQuery(query,null);
        String[] a = new String[c.getCount()];
        c.moveToFirst(); int i=0;


        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("playername")) != null) {
                String lala = c.getString(c.getColumnIndex("playername"));

                a[i] = lala;
                i++;
            }
            c.moveToNext();
        }
        db.close();

        return a;
    }

}

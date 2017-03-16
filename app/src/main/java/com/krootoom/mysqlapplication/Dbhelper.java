package com.krootoom.mysqlapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DEN on 10/2/2560.
 */

public class Dbhelper extends SQLiteOpenHelper {
    private static final String databaseName = "dbtodolist.sqlite";
    private static final int databaseVersion = 1;
    Context myContext;

    private static final String SQLCreateTable =
            "CREATE TABLE tbtodo_list (" +
                    "taskid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "taskname TEXT)";

    public Dbhelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateTable);
        String insertData1 = "INSERT INTO tbtodo_list (taskname) VALUES ('homework1')";
        String insertData2 = "INSERT INTO tbtodo_list (taskname) VALUES ('homework2')";
        String insertData3 = "INSERT INTO tbtodo_list (taskname) VALUES ('homework3')";
        String insertData4 = "INSERT INTO tbtodo_list (taskname) VALUES ('homework4')";
        String insertData5 = "INSERT INTO tbtodo_list (taskname) VALUES ('homework5')";
        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);
        db.execSQL(insertData4);
        db.execSQL(insertData5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

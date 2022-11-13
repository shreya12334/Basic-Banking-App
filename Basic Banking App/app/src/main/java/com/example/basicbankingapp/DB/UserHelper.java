package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7861,'Mohd Anas', 'manas8084@gmail.com','7586','9568929573', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Mohd Arif', 'aarif@gmail.com','1258','8630902019', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Dr Farhat Al Nawaz', 'farhatn@gmail.com','8896','9548449854', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Devansh Prabhakar', 'devansh@gmail.com','7752','7078532185', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Rihan Ansari', 'rihan@gmail.com','3669','8433116114', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Nikhil Panwar', 'nikhil@gmail.com','9985','8077709775', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Shaful khan', 'shafu@gmail.com','1207','9058972685', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Mohd Muzahid', 'mujahid@gmail.com','4522','8433199219', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Rakshak Saini', 'rakshak@gmail.com','6582','9045860324', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Jalaj Panwar', 'jalaj@gmail.com','5450','9548709748', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Anurag Sharma', 'anurag@gmail.com','2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hitish Kumar', 'hitish@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Naveen Chaturvedi', 'naveen@gmail.com','5566','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Gauri Parashar', 'gauri@gmail.com','2236','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Farhan Khan', 'farhan@gmail.com','6692','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
package com.snhu.weight_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class WeightRecordsDatabase extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "weight_records.db";

    private static WeightRecordsDatabase instance;

    private WeightRecordsDatabase(Context context) { super(context, DATABASE_NAME, null, VERSION);}

    private static WeightRecordsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new WeightRecordsDatabase(context);
        }

        return instance;
    }

    private static final class WeightRecordsTable {
        private static final String TABLE = "weight_records";
        private static final String COL_ID = "_id";
        private static final String COL_WEIGHT = "name";
        private static final String COL_DATE = "descripion";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + WeightRecordsTable.TABLE + "( " +
                WeightRecordsTable.COL_ID + " integer primary key autoincrement, " +
                WeightRecordsTable.COL_WEIGHT + ", " +
                WeightRecordsTable.COL_DATE + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + WeightRecordsTable.TABLE);
        onCreate(db);
    }

    public List<WeightRecord> getWeightRecords(AuthenticatedUser user) {
        List<WeightRecord> weightRecords = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM " + WeightRecordsTable.TABLE;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getInt(0);
                float weight = cursor.getFloat(1);
                String date = cursor.getString(2);
                WeightRecord weightRecord = new WeightRecord(id, weight, date);
                weightRecords.add(weightRecord);
            } while (cursor.moveToNext());
        }
        return weightRecords;
    }

    public WeightRecord getWeightRecordById(long recordId) {
        WeightRecord weightRecord = null;

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + WeightRecordsTable.TABLE + " WHERE " + WeightRecordsTable.COL_ID + " = " + recordId;
        Cursor cursor = db.rawQuery(sql, new String[]{Long.toString(recordId)});

        if (cursor.moveToFirst()) {
            float weight = cursor.getFloat(1);
            String date = cursor.getString(2);

            weightRecord = new WeightRecord(recordId, weight, date);
        }
        return weightRecord;
    }

    public long addWeightRecord(WeightRecord weightRecord) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeightRecordsTable.COL_WEIGHT, weightRecord.getWeight());
        values.put(WeightRecordsTable.COL_DATE, weightRecord.getDate());

        return db.insert(WeightRecordsTable.TABLE, null, values);
    }

    public boolean editWeightRecord(long recordId, float newWeight) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeightRecordsTable.COL_WEIGHT, newWeight);
//        values.put(WeightRecordsTable.COL_DATE, weightRecord.getDate());
        int result = db.update(
                WeightRecordsTable.TABLE, values, WeightRecordsTable.COL_ID + " = " + recordId, null
        );

        return result == 1;
    }
}

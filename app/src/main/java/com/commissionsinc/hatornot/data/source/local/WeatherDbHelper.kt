package com.commissionsinc.hatornot.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class WeatherDbHelper(context: Context,
                      databaseName: String,
                      databaseVersion: Int) : SQLiteOpenHelper(context, databaseName, null, databaseVersion) {

    val DATABASE_VERSION = 1
    val DATABASE_NAME = "weather.db"
    val TEXT_TYPE = " TEXT"
    val BOOLEAN_TYPE = " INTEGER"
    val COMMA_SEP = ","

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE " + WeatherPersistenceContract.WeatherEntry.TABLE_NAME + " (" +
        WeatherPersistenceContract.WeatherEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
        WeatherPersistenceContract.WeatherEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
        WeatherPersistenceContract.WeatherEntry.COLUMN_NAME_ENTRY_TEMPERATURE + TEXT_TYPE + COMMA_SEP +
        WeatherPersistenceContract.WeatherEntry.COLUMN_NAME_ENTRY_CLOUDY + BOOLEAN_TYPE + COMMA_SEP + ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // do nothing
    }
}

package com.example.chi_95_sqlitecoroutinesretrofit

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(
    context, DB_NAME, null, DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createBooksSql = "CREATE TABLE ${Animal.TABLE} (" +
                Animal.ID + " INTEGER PRIMARY KEY, " +
                Animal.NAME + " TEXT, " +
                Animal.LATIN_NAME + " TEXT, " +
                Animal.ANIMAL_TYPE + " TEXT, " +
                Animal.ACTIVE_TIME + " TEXT, " +
                Animal.LENGTH_MIN + " REAL, " +
                Animal.LENGTH_MAX + " REAL, " +
                Animal.WEIGHT_MIN + " REAL, " +
                Animal.WEIGHT_MAX + " REAL, " +
                Animal.LIFESPAN + " INTEGER, " +
                Animal.HABITAT + " TEXT," +
                Animal.DIET + " TEXT, " +
                Animal.GEO_RANGE + " TEXT, " +
                Animal.IMAGE_LINK + " TEXT);"
        db?.execSQL(createBooksSql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${Animal.TABLE};")
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "myDataBase"
        private const val DB_VERSION = 1
    }
}
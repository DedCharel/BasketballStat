package ru.nvg_soft.basketballstat.models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class DBManager{
    val dbName = "BasketStat"
    val dbVersion = 1
    val dbTable="Person"
    val sqlCreateTablePerson ="CREATE TABLE IF NOT EXISTS Person (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT," +
            " DOB INTEGER, Height INTEGER, Weight INTEGER, Image blob )"
    var sqlDB:SQLiteDatabase?=null

    constructor(context:Context){
        var db=DatabaseHelperStat(context)
        sqlDB=db.writableDatabase
    }

    inner class  DatabaseHelperStat:SQLiteOpenHelper{
        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        var context:Context?=null
        constructor(context:Context):super(context,dbName,null,dbVersion){
            this.context=context
        }
        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCreateTablePerson)
            Toast.makeText(this.context," database is created", Toast.LENGTH_LONG).show()

        }

       fun Insert(values: ContentValues,dbTable:String):Long{

            val ID= sqlDB!!.insert(dbTable,"",values)
            return ID
        }
    }

    fun Insert(values:ContentValues):Long{

        val ID= sqlDB!!.insert(dbTable,"",values)
        return ID
    }
    fun Delete(selection:String,selectionArgs:Array<String>):Int{

        val count=sqlDB!!.delete(dbTable,selection,selectionArgs)
        return  count
    }

    fun Update(values:ContentValues,selection:String,selectionargs:Array<String>):Int{

        val count=sqlDB!!.update(dbTable,values,selection,selectionargs)
        return count
    }

    fun  Query(projection:Array<String>,selection:String,selectionArgs:Array<String>,sorOrder:String):Cursor{

        val qb=SQLiteQueryBuilder()
        qb.tables=dbTable
        val cursor=qb.query(sqlDB,projection,selection,selectionArgs,null,null,sorOrder)
        return cursor
    }
}
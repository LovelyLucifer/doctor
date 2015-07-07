package com.doctorstudiodoctor.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper 
{

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) 
	{
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists user_info("
		 + "id integer primary key autoincrement,"
		 + "userId integer unique,"
		 + "userName varchar,"
		 +"account varchar,"
		 + "password varchar,"
		 +"motto varchar default '',"
		 +"sex integer default 0,"
		 +"city varchar default '',"	 
		 +"face varchar default '',"
		 +"clientFace varchar default '',"
		 +"point integer default 0,"	 
		 +"address varchar default '',"	 
		 +"phoneNumber varchar default ''"	 
		 +")"
		 );
		db.execSQL("create table if not exists baby_info("
		 + "id integer primary key autoincrement,"
		 + "babyId integer unique,"
		 +"userId integer,"
		 +"sex integer,"
		 +"name varchar,"	 
		 +"birthday varchar "	 
		 +")"
		 );
		db.execSQL("create table if not exists person_info("
		 + "id integer primary key autoincrement,"
		 + "type integer,"
		 +"personId integer unique,"
		 +"userId integer,"
		 +"sex integer,"
		 +"userName varchar,"	 
		 +"userFace varchar "	 
		 +")"
		 );
		db.execSQL("create table if not exists showbaby("
		 +"id integer primary key autoincrement,"
		 +"babyId integer,"
		 +"contentId integer unique,"
		 +"title varchar,"
		 +"userId integer,"
		 +"userName varchar,"
		 +"userFace varchar,"
		 +"praiseCount integer,"
		 +"commentCount integer,"
		 +"serverContentPath varchar,"	 
		 +"serverImgPath varchar,"	 
		 +"allThumbPath varchar,"
		 +"clientContentPath varchar,"	 
		 +"clientImgPath varchar,"	 
		 +"uptime varchar"
		 +")"
		 );
		db.execSQL("create table if not exists photo("
		 +"id integer primary key autoincrement,"
		 +"babyId integer,"
		 +"contentId integer unique,"
		 +"title varchar,"
		 +"userId integer,"
		 +"userName varchar,"
		 +"userFace varchar,"
		 +"praiseCount integer,"
		 +"commentCount integer,"
		 +"serverContentPath varchar,"	 
		 +"serverImgPath varchar,"	
		 +"allThumbPath varchar,"
		 +"clientContentPath varchar,"	 
		 +"clientImgPath varchar,"	 
		 +"uptime varchar"
		 +")"
		 );
		db.execSQL("create table if not exists praise("
		 +"id integer primary key autoincrement,"
		 +"praiseId integer,"
		 +"contentId integer,"
		 +"userId integer,"
		 +"userName varchar"
		 +")"
		 );
		 db.execSQL("create table if not exists picturewall("
		 +"id integer primary key autoincrement,"
		 +"pictureId integer,"
		 +"type integer,"
		 +"imgPath varchar,"
		 +"link varchar,"
		 +"uptime varchar"
		 +")"
		 );
		 db.execSQL("create table if not exists news("
		 +"id integer primary key autoincrement,"
		 +"contentId integer unique,"
		 +"title varchar,"
		 +"author varchar,"
		 +"authorTime varchar,"
		 +"readCount integer,"
		 +"commentCount integer,"
		 +"serverContentPath varchar,"	 
		 +"serverImgPath varchar,"	 
		 +"descContent varchar,"	  
		 +"uptime varchar,"
		 +"iconPath varchar"
		 +")"
		 );
		 db.execSQL("create table if not exists notice("
		 +"id integer primary key autoincrement,"
		 +"type integer,"
		 +"userId integer,"
		 +"contentId integer,"
		 +"personId integer"
		 +")"
		 );
		 db.execSQL("create table if not exists download_info("
		 +"id integer primary key autoincrement,"
		 +"thread_id integer,"
		 +"start_pos integer,"
		 +"end_pos integer,"
		 +"compelete_size integer,"
		 +"url varchar"
		 +")"
		 );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		
	}

}

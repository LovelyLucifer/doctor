package com.doctorstudiodoctor.database;

import java.util.ArrayList;
import java.util.List;

import com.doctorstudiodoctor.bean.PersonInfo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonExecute 
{
	private static String DBPath="redboy/database";
	private static String DBName="redboydb.db";
	
	private SQLiteDatabase db;
	private Cursor c;
	private DBHelper myHelper;
	private String sql="";
	
	public PersonExecute(Context context) 
	{
		// TODO Auto-generated constructor stub
		DBContext dbContext=new DBContext(context,DBPath);
		myHelper=new DBHelper(dbContext, DBName, null, 1);
	}
	
	public void setPerson(List<PersonInfo> newsList)
	{
		sql="insert or ignore into person_info(type,personId,userId,sex,userName,userFace) "
				+ "values(?,?,?,?,?,?)";
		db = myHelper.getWritableDatabase();
		for(int i=0;i<newsList.size();i++)
		{
			Object[] params = new Object[]{newsList.get(i).getType(),
													newsList.get(i).getPersonId(),
													newsList.get(i).getUserId(), 
													newsList.get(i).getSex(),
													newsList.get(i).getUserName(),
													newsList.get(i).getUserFace()};
			db.execSQL(sql,params);
		}
		db.close();
	}
	
	public void setPerson(PersonInfo newsList)
	{
		sql="insert into person_info(type,personId,userId,sex,userName,userFace) "
				+ "values(?,?,?,?,?,?)";
		db = myHelper.getWritableDatabase();
		
		Object[] params = new Object[]{newsList.getType(),
												newsList.getPersonId(),
												newsList.getUserId(), 
												newsList.getSex(),
												newsList.getUserName(),
												newsList.getUserFace()};
		db.execSQL(sql,params);
		db.close();
	}
	
	public List<PersonInfo> getPerson(int userId,int type)
	{
		sql="SELECT type,personId,userId,sex,userName,userFace FROM person_info where userId=? and type=?";
		
		db = myHelper.getWritableDatabase();
		String[] params = new String[]{String.valueOf(userId),String.valueOf(type)};
		ArrayList<PersonInfo> newsList = new ArrayList<PersonInfo>();
		c = db.rawQuery(sql,params);
			
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{ 
			PersonInfo newsInfo = new PersonInfo();
			newsInfo.setType(c.getInt(c.getColumnIndex("type")));
			newsInfo.setPersonId(c.getInt(c.getColumnIndex("personId")));
			newsInfo.setUserId(c.getInt(c.getColumnIndex("userId")));
			newsInfo.setSex(c.getInt(c.getColumnIndex("sex")));
			newsInfo.setUserName(c.getString(c.getColumnIndex("userName")));
			newsInfo.setUserFace(c.getString(c.getColumnIndex("userFace")));
			newsList.add(newsInfo);
		}
		c.close();
		db.close();
		return newsList;
	}
	
	public PersonInfo selectPerson(int personId,int userId )
	{
		sql="SELECT * FROM person_info where personId=? and userId=? ";
		db = myHelper.getWritableDatabase();
		String[] params = new String[]{String.valueOf(personId), String.valueOf(userId)};
		c = db.rawQuery(sql,params);
		if(c.moveToFirst())
		{
			PersonInfo newsInfo = new PersonInfo();
			newsInfo.setType(c.getInt(c.getColumnIndex("type")));
			newsInfo.setPersonId(c.getInt(c.getColumnIndex("personId")));
			newsInfo.setUserId(c.getInt(c.getColumnIndex("userId")));
			newsInfo.setSex(c.getInt(c.getColumnIndex("sex")));
			newsInfo.setUserName(c.getString(c.getColumnIndex("userName")));
			newsInfo.setUserFace(c.getString(c.getColumnIndex("userFace")));
			c.close();
			db.close();
			return newsInfo;
		}
		else
		{
			c.close();
			db.close();
			return null;
		}
	}
	
	public int deletePerson(int personId,int userId)
	{
		db = myHelper.getWritableDatabase();
		String[] params = new String[]{String.valueOf(personId),String.valueOf(userId)};
		int delete=db.delete("person_info", "personId=? and userId=?", params);
		db.close();
		
		return delete;
	}
	
	public int deleteAllPerson(int userId,int type)
	{
		db = myHelper.getWritableDatabase();
		String[] params = new String[]{String.valueOf(userId), String.valueOf(type)};
		int delete=db.delete("person_info", "userId=? and type=?", params);
		db.close();
		
		return delete;
	} 
	
	public void updatePerson(int type,int userId,int personId)
	{
		sql="update person_info set type=? where userId=? and personId=?";
		db = myHelper.getWritableDatabase();
		Object[] params = new Object[]{type,userId,personId};
		db.execSQL(sql,params);
		db.close();
	}

}

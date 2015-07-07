package com.doctorstudiodoctor.database;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DBContext extends ContextWrapper 
{
	private Context mContext;
	private String dirName;

	public DBContext(Context base) 
	{
		super(base);
		// TODO Auto-generated constructor stub
		this.mContext = base;
	}

	public DBContext(Context base, String dirName) 
	{
		super(base);
		this.mContext = base;
		this.dirName = dirName;
	}

	/*
	 * ������ݿ�·������������ڣ��򴴽��������
	 * 
	 */
	@Override
	public File getDatabasePath(String name) 
	{
		// TODO Auto-generated method stub
		//�ж��Ƿ����sd��
	    boolean sdExist = android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
	    if(!sdExist)
	    {//���������,
	        Log.e("SD������", "SD�������ڣ������SD��");
	        return null;
	    }
	    else
	    {
	    	//�������
	        //��ȡsd��·��
	        String dbDir=android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
	    //	String dbDir="/sdcard";
	        dbDir += "/"+ ((dirName == null || "".equals(dirName)) ?  mContext.getPackageName() : dirName);//���ݿ�����Ŀ¼
	        String dbPath = dbDir+"/"+name;//���ݿ�·��
	        //�ж�Ŀ¼�Ƿ���ڣ��������򴴽���Ŀ¼
	        File dirFile = new File(dbDir);
	        if(!dirFile.exists())
	        {
	            dirFile.mkdirs();
	        }
	        //���ݿ��ļ��Ƿ񴴽��ɹ�
	        boolean isFileCreateSuccess = false;
	        //�ж��ļ��Ƿ���ڣ��������򴴽����ļ�
	        File dbFile = new File(dbPath);
	        if(!dbFile.exists())
	        {
	            try 
	            {                   
	                isFileCreateSuccess = dbFile.createNewFile();//�����ļ�
	            } 
	            catch (IOException e) 
	            {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        else    
	            isFileCreateSuccess = true;
	         
	        //�������ݿ��ļ�����
	        if(isFileCreateSuccess)
	            return dbFile;
	        else
	            return null;
	    }
	}
	
	/**
	 * ���������������������SD���ϵ����ݿ�ģ�android 2.3�����»�������������
	 * @param    name
	 * @param    mode
	 * @param    factory
	 */
	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
	        SQLiteDatabase.CursorFactory factory) 
	{
	    SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
	    return result;
	}
	/**
	 * Android 4.0����ô˷�����ȡ���ݿ�(�˷���ֻ��4.0���ϲ�֧�֣�����ᱨ��)��
	 * @see android.content.ContextWrapper#openOrCreateDatabase(java.lang.String, int,
	 *              android.database.sqlite.SQLiteDatabase.CursorFactory,
	 *              android.database.DatabaseErrorHandler)
	 * @param    name
	 * @param    mode
	 * @param    factory
	 * @param     errorHandler
	 */
	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
	        DatabaseErrorHandler errorHandler) 
	{
	    SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
	    return result;
	}

}

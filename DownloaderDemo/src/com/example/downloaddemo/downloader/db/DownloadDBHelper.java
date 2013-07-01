/*
 * 文件名：DownloadDBHelper.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-6-8
 * 修改人：xiaoying
 * 修改时间：2013-6-8
 * 版本：v1.0
 */

package com.example.downloaddemo.downloader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.downloaddemo.utils.LogUtil;

/**
 * 功能：下载日志数据库
 * @author xiaoying
 *
 */
public class DownloadDBHelper extends SQLiteOpenHelper {
	
	private static final String DB_NAME = "download.db";
	
	private static final int DB_VERSION = 1;
	
	public static DownloadDBHelper mDBHelper = null;
	
	public DownloadDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	public static DownloadDBHelper getInstance(Context context) {
		if(mDBHelper == null) {
			mDBHelper = new DownloadDBHelper(context);
		}
		return mDBHelper;
	}
	
	public static SQLiteDatabase getReadableDatabase(Context context) {
//		return getInstance(context).getReadableDatabase();
		return new DownloadDBHelper(context).getReadableDatabase();
	}
	
	public static SQLiteDatabase getWriteableDatabase(Context context) {
		return new DownloadDBHelper(context).getWritableDatabase();
//		return getInstance(context).getWritableDatabase();
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//下载进度表，各个线程的进度
		db.execSQL("CREATE TABLE IF NOT EXISTS download_log(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT, thread_id INTEGER, downloaded_size)");
		
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		LogUtil.d("DonwloadDBHelper", "Database has opened ++++++++++++++++>>>>>>>>>>>>");
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		dropAllTables(db);
		onCreate(db);
	}
	
	private void dropAllTables(SQLiteDatabase db) {
		db.execSQL("drop table if exists download_log");
		
		onCreate(db);
	}
}

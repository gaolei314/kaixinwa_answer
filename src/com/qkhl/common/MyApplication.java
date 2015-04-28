package com.qkhl.common;


import android.app.Application;

public class MyApplication extends Application {

	private static MyApplication instance;
	
	
	public static MyApplication getInstance() {
		return instance;
	}

	private boolean isDownload;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		isDownload = false;
	}

	public boolean isDownload() {
		return isDownload;
	}

	public void setDownload(boolean isDownload) {
		this.isDownload = isDownload;
	}
	
}

package com.qkhl.activity;

import java.io.IOException;

import com.qkhl.fragment.AnswerFragment;
import com.qkhl.fragment.FoundFragment;
import com.qkhl.kaixinwa_android.R;
import com.zbar.lib.CameraManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	public static TextView tv;
	public static FoundFragment foundFragment;
	public static AnswerFragment ansFragment;
	private static FragmentManager fragmentManager;

	private View AnswerView;
	private View FoundView;
	private View MyView;
	private boolean CamerisClosed=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Initialization();
		fragmentManager = getSupportFragmentManager();
		setTabSelection(1);

	}

	// 初始化控件
	public void Initialization() {
		foundFragment = null;
		AnswerView = findViewById(R.id.answerlayout);
		FoundView = findViewById(R.id.foundlayout);
		MyView = findViewById(R.id.mylayout);
		tv = (TextView) findViewById(R.id.daohang);

		AnswerView.setOnClickListener(new ViewClickListener());
		FoundView.setOnClickListener(new ViewClickListener());
		MyView.setOnClickListener(new ViewClickListener());

	}

	// 更换的页面，Fragment的切换
	public void setTabSelection(int index) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 隐藏Fragment
		hideFragments(transaction);
		switch (index) {
		case 1:

			if(CamerisClosed){
				ansFragment.onStart();
				CamerisClosed=false;
			}

			if (ansFragment == null) {
				// 若不存在则新建一个
				ansFragment = new AnswerFragment();
				transaction.add(R.id.content, ansFragment);
			} else {
				// 若存在则直接显示
				transaction.show(ansFragment);
			}

			break;

		case 2:
			ansFragment.onPause();
			CamerisClosed=true;
			//ansFragment.onDestroy();
			if (foundFragment == null) {
				foundFragment = new FoundFragment();
				transaction.add(R.id.content, foundFragment);
			} else {
				transaction.show(foundFragment);
			}

			break;
		case 3:
			Intent intent = new Intent(MainActivity.this, myselfActivity.class);
			startActivity(intent);
			break;

		}
		transaction.commit();
	}

	// 隐藏所有的Fragment
	public static void hideFragments(FragmentTransaction transaction) {
		if (foundFragment != null) {
			transaction.hide(foundFragment);
		}

		if (ansFragment != null) {
			transaction.hide(ansFragment);
		}

	}

	// 监听事件
	public class ViewClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.answerlayout:
				setTabSelection(1);
				tv.setText("答案");
				break;

			case R.id.foundlayout:
				setTabSelection(2);
				tv.setText("发现");
				break;
			case R.id.mylayout:
				setTabSelection(3);
				tv.setText("我的");
			default:
				break;
			}

		}

	}
}

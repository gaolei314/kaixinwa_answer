package com.qkhl.activity;


import com.qkhl.kaixinwa_android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class myselfActivity extends Activity implements OnClickListener{
	private View setup_me;
	private Button my_missionbut,my_sharebut,my_goodsbut,my_codebut,my_friendsbut,my_messagebut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me);
		initViews();

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.me_setup_layout:
			setTabSelection(0);
			break;
		case R.id.mission_button:
			setTabSelection(1);
			break;
		case R.id.share_button:
			setTabSelection(2);
			break;
		case R.id.goods_button:
			setTabSelection(3);
			break;
		case R.id.code_button:
			setTabSelection(4);
			break;
		case R.id.friends_button:
			setTabSelection(5);
			break;
		case R.id.message_button:
			setTabSelection(6);
			break;

		default:
			break;
		}
		
	}
	private void initViews(){
		setup_me=findViewById(R.id.me_setup_layout);
		my_missionbut=(Button) findViewById(R.id.mission_button);
		my_sharebut=(Button) findViewById(R.id.share_button);
		my_goodsbut=(Button) findViewById(R.id.goods_button);
		my_codebut=(Button) findViewById(R.id.code_button);
		my_friendsbut=(Button) findViewById(R.id.friends_button);
		my_messagebut=(Button) findViewById(R.id.message_button);
		setup_me.setOnClickListener(this);
		my_missionbut.setOnClickListener(this);
		my_sharebut.setOnClickListener(this);
		my_goodsbut.setOnClickListener(this);
		my_codebut.setOnClickListener(this);
		my_friendsbut.setOnClickListener(this);
		my_messagebut.setOnClickListener(this);
		
	}
	private void setTabSelection(int index){
		switch (index) {
		case 0:
			  Intent intent = new Intent(myselfActivity.this, setup_meActivity.class);
			  startActivity(intent);
			  myselfActivity.this.finish();
			break;
		case 1:
			  Intent intent1 = new Intent(myselfActivity.this, my_missionActivity.class);
			  startActivity(intent1);
			  myselfActivity.this.finish();
			break;
		case 2:
			  Intent intent2 = new Intent(myselfActivity.this, my_shareActivity.class);
			  startActivity(intent2);
			  myselfActivity.this.finish();
			break;
		case 3:
			  Intent intent3 = new Intent(myselfActivity.this, my_goodsActivity.class);
			  startActivity(intent3);
			  myselfActivity.this.finish();
			break;
		case 4:
			  Intent intent4 = new Intent(myselfActivity.this, my_codeActivity.class);
			  startActivity(intent4);
			  myselfActivity.this.finish();
			break;
		case 5:
			  Intent intent5 = new Intent(myselfActivity.this, my_friendsActivity.class);
			  startActivity(intent5);
			  myselfActivity.this.finish();
			break;
		case 6:
			  Intent intent6 = new Intent(myselfActivity.this, my_messageActivity.class);
			  startActivity(intent6);
			  myselfActivity.this.finish();
			break;

		default:
			break;
		}
	}

}

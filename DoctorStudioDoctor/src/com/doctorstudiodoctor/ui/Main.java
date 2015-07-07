package com.doctorstudiodoctor.ui;

import com.doctorstudiodoctor.instance.AppContext;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends BaseActivity 
{
	AppContext ac;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ac = (AppContext)getApplication();
		context = Main.this;
	    setContentView(R.layout.login);
	    findViewById(R.id.app_login_btngetbackpassword).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(context,GetBackPassword.class);
			    startActivity(i);
			}
		});
	    findViewById(R.id.app_login_login_btn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(context,YYT.class);
				startActivity(i);
			}
		});
	}

}

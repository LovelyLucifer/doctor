package com.doctorstudiodoctor.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class GetBackPassword extends BaseActivity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.forget_password);
			findViewById(R.id.app_getbackpassword_btn).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			
			findViewById(R.id.app_forget_submitbtn).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//finish();
//					AlertDialog()
//					new AlertDialog.Builder(GetBackPassword.this)
//					 .setTitle("标题")
//					 .setMessage("简单消息框")
//					 	.setPositiveButton("确定", null)
//					 	.show();
//					new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom))
					
					
				}
			});
			
			//setContentView(layoutResID);
		}
}

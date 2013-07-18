package com.studicafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudiCafeHomeActivity extends StudiCafeBaseActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studicafehomescreen);
		Button marketstButton = (Button)findViewById(R.id.marketst_button);
		Button studicafeBlvdButton = (Button)findViewById(R.id.studicafeblvd);
		Button studiroomButton = (Button)findViewById(R.id.studiroom);
		ButtonClickListener listener = new ButtonClickListener();
		marketstButton.setOnClickListener(listener);
		studicafeBlvdButton.setOnClickListener(listener);
		studiroomButton.setOnClickListener(listener);
	}

	
	class ButtonClickListener implements View.OnClickListener {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent;
			switch (v.getId()) {
			case R.id.marketst_button:
				intent = new Intent(StudiCafeHomeActivity.this,StudiCafeMarketStActivity.class);
				startActivity(intent);
				break;

			case R.id.studicafeblvd:
				intent = new Intent(StudiCafeHomeActivity.this,StudiCafeBlvdActivity.class);
				startActivity(intent);
				break;
			case R.id.studiroom:
				intent = new Intent(StudiCafeHomeActivity.this,StudiCafeStudiRoomActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
		
	}

}

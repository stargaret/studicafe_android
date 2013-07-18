package com.studicafe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class StudiCafeBaseActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onBackPressed() {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

		// set title for the alert dialog to be displayed on the screen
		
		alertDialogBuilder.setTitle("Your Title");

		// set dialog message testing
		alertDialogBuilder.setMessage("Are you sure you want to Logout?");
		alertDialogBuilder.setCancelable(true);
		alertDialogBuilder.setPositiveButton("Logout", new OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				StudiCafeBaseActivity.this.onBackPressed();
			}
		});
		alertDialogBuilder.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

}

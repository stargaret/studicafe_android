package com.studicafe.dialogs;

import android.app.ProgressDialog;
import android.content.Context;

public class StudicafeProgressDialog implements IStudicafeProgressDialog {
	
	public StudicafeProgressDialog() {
		// TODO Auto-generated constructor stub
	}

	private ProgressDialog _dialog = null;
	
	
	private static IStudicafeProgressDialog _instance = null;
	
	public static IStudicafeProgressDialog getInstance() {
		if( _instance == null ) {
			_instance = new StudicafeProgressDialog();
		}
		return _instance;
	}
	public void show(Context context, String title, String message) {
		if( _dialog == null ) {
			_dialog = ProgressDialog.show(context, title, message);
		} else {
			_dialog.cancel();
			_dialog = ProgressDialog.show(context, title, message);
		}
		//return _instance;
	}
	public void cancel() {
		if( _dialog != null) {
			_dialog.cancel();
		}
		
	}

}

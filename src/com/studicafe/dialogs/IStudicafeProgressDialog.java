package com.studicafe.dialogs;

import android.content.Context;

public interface IStudicafeProgressDialog {

	public void show(Context context, String title, String message);
	public void cancel();
	public String s = "test";
}

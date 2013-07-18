package com.studicafe;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.studicafe.R;
import com.studicafe.R.id;
import com.studicafe.R.layout;
import com.studicafe.dialogs.StudicafeProgressDialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudicafeLoginActivity extends Activity {

	protected static final int STUDICAFEREGISTER = 0;

	protected static final int STUDICAFEHOME_TESTING = 1;
	protected static final int STUDICAFEHOME = 1;

	EditText usrNameTxt;
	EditText passwdTxt;
	/** Called when the activity is first created. */

	String result = "";

	public Handler _loginMsgHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case STUDICAFEREGISTER:

			case STUDICAFEHOME:

			}
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studicafelogin);
		// username text field
		usrNameTxt = (EditText) findViewById(R.id.et_un);

		// password text field
		passwdTxt = (EditText) findViewById(R.id.et_pw);

		// login button
		Button loginBtn = (Button) findViewById(R.id.btn_login);
		loginBtn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// call authentication service

				// once authenticated successfully go to cafe

				// start studio cafe home activity
				StudicafeloginAsyncTask loginAsyncTask = new StudicafeloginAsyncTask();
				loginAsyncTask.execute();
				StudicafeProgressDialog.getInstance().show(StudicafeLoginActivity.this, "", "Loading");
			}

		});
		
		Button signupBtn = (Button) findViewById(R.id.btn_signup);
		signupBtn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent signUpAcitvity = new Intent(StudicafeLoginActivity.this, StudiCafeSignUpActivity.class);
				startActivity(signUpAcitvity);
				
			}

		});
	}

	public void callWebService() throws UnsupportedEncodingException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost request = new HttpPost("http://studicafeapp.appspot.com/app/signup");
		request.addHeader("Accept", "application/json");
		request.addHeader("Accept", "application/json;text/html");
		 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		 nameValuePairs.add(new BasicNameValuePair("username", "12345"));
		 nameValuePairs.add(new BasicNameValuePair("password", "AndDev is Cool!"));
		 nameValuePairs.add(new BasicNameValuePair("email", "AndDev is Cool!"));
		 nameValuePairs.add(new BasicNameValuePair("confirmPassowrd", ""));
		 request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		ResponseHandler<String> handler = new BasicResponseHandler();
		try {
			result = httpclient.execute(request, handler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpclient.getConnectionManager().shutdown();
		Log.i("testing", result);
	}

	private class StudicafeloginAsyncTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... params) {
			try {
				callWebService();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			// start progress dialog here
			// TODO: All the strings need to be extracted from the xml
			// (localization)
			StudicafeProgressDialog.getInstance().show(
					StudicafeLoginActivity.this, "", "loading.....");

		}

		@Override
		protected void onPostExecute(Object result) {
			// result is the value returned from doInBackground
			// ProgressDialog.
			StudicafeProgressDialog.getInstance().cancel();
			Intent homeActivity = new Intent(StudicafeLoginActivity.this, StudiCafeHomeActivity.class);
			startActivity(homeActivity);
		}

	}
}

/*
 * ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
 * postParameters.add(new BasicNameValuePair("username",
 * usrNameTxt.getText().toString())); postParameters.add(new
 * BasicNameValuePair("password", passwdTxt.getText().toString())); String
 * response = null; try { response = CustomHttpClient.executeHttpPost(
 * "<target page url>", postParameters); String res = response.toString(); res =
 * res.replaceAll("\\s+", ""); if (res.equals("1"))
 * error.setText("Correct Username or Password"); else
 * error.setText("Sorry!! Incorrect Username or Password");
 * 
 * } catch (Exception e) { un.setText(e.toString());
 * 
 * }
 */
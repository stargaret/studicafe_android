package com.studicafe;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.studicafe.dialogs.StudicafeProgressDialog;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudiCafeSignUpActivity extends Activity {
	
	
	private EditText username;
	private EditText pass;
	private EditText confirmPass;
	private EditText email;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.studicafesignup);
		
		username = (EditText) findViewById(R.id.username);
		pass = (EditText) findViewById(R.id.password);
		confirmPass = (EditText) findViewById(R.id.confirmpassword);
		email = (EditText) findViewById(R.id.emailid);
		
		Button signUpButton = (Button) findViewById(R.id.btn_signup);
		signUpButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// call authentication service

				// once authenticated successfully go to cafe

				// start studio cafe home activity
				StudicafeSignUpAsyncTask signUpAsyncTask = new StudicafeSignUpAsyncTask();
				signUpAsyncTask.execute();

				StudicafeProgressDialog.getInstance().show(StudiCafeSignUpActivity.this, "", "Signing up");
			}
  
		});
	}
	
	public void callWebService() throws UnsupportedEncodingException, JSONException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost request = new HttpPost("http://studicafeapp.appspot.com/app/signup");
		
		JSONObject obj = new JSONObject();
		obj.put("username", username.getText().toString());
		obj.put("password", pass.getText().toString());
		obj.put("email", email.getText().toString());
		obj.put("confirmPassword", confirmPass.getText().toString());
		StringEntity ent = new StringEntity(obj.toString());
		request.setEntity(ent);
		request.addHeader("User-Agent",System.getProperty("http.agent"));
		request.addHeader("Content-Type","application/json");
		request.addHeader("Accept", "application/json;text/html");
		try {
			HttpResponse response = httpclient.execute(request);
			Log.i("Response", response.toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpclient.getConnectionManager().shutdown();
	}

	private class StudicafeSignUpAsyncTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... params) {
			try {
				callWebService();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
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
					StudiCafeSignUpActivity.this, "", "loading.....");

		}

		@Override
		protected void onPostExecute(Object result) {
			// result is the value returned from doInBackground
			// ProgressDialog.
			StudicafeProgressDialog.getInstance().cancel();
			Intent studicafeLoginActivity = new Intent(StudiCafeSignUpActivity.this, StudicafeLoginActivity.class);
			startActivity(studicafeLoginActivity);
		}

	}

}

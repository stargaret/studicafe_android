package com.studicafe;

public class StudicafeLoginController {
	
	private static StudicafeLoginController _instance = null;
	
	public static StudicafeLoginController getInstance() {
		if( _instance == null ) {
			_instance = new StudicafeLoginController();
		}
		return _instance;
	}
	
	// authenticate user rest service call
	// studicafe login service is created here 
	public void authenticateUser() {
		
	}

}

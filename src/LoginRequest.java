// Login request test git pull push (sergiu - nandeesh)
public class LoginRequest  extends BaseHttpClient{
	
	public LoginRequest(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	
	//git repository testing
	//method to create login request--> to be called by the activities along with the parameters
	public void AuthenticateUser(String Username, String pass) {
		addHeader("Accept", "application/json");
		
	}

}

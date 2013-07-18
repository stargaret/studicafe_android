
public class StudicafeServiceHelper {
	private static StudicafeServiceHelper _studicafeServiceHelper = null;
	
	public static StudicafeServiceHelper getStudicafeServiceInstance() {
		if ( _studicafeServiceHelper == null) {
			_studicafeServiceHelper = new StudicafeServiceHelper();
		}
		return _studicafeServiceHelper;
	}
	
	private StudicafeServiceHelper() {
		
	}
	
	//send requests to the server


}

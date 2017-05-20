import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class TestManager {
	
	public static void main(String[] args) throws MalformedURLException, NotBoundException, Exception{
		//Adaptor adaptor = new Adaptor("localhost", 1099);
		Manager manager = new Manager("128.199.187.85", 1099);
		
		manager.startTesting();
	}
}

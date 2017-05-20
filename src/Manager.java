import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Manager {
	private RmiMethods adaptor;
	
	public Manager(String host, int port) throws MalformedURLException, RemoteException, NotBoundException, Exception{
		this.adaptor = getAdaptor(host, port, "Adaptor");
	}
	
	private RmiMethods getAdaptor(String host, int port, String bindName) throws MalformedURLException, RemoteException, NotBoundException, Exception{
		RmiMethods adaptor = (RmiMethods) RMIUtils.getRemoteObject(host, port, bindName);
		return adaptor;
	}
	
	public void startTesting(){
		Thread t1 = new Thread(new Player(adaptor));
		t1.start();
	}
}

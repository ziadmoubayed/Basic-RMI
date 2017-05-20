import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class Adaptor extends UnicastRemoteObject implements RmiMethods {

	private Logger logger = Logger.getGlobal();
	
	public Adaptor(String host, int port) throws RemoteException{
		logger.info("Adaptor -->> Before Bind");
		bind(host, port);
		logger.info("Adaptor -->> After Bind");
	}
	
	
	
	
	public void bind(String host, int port){
		try {
			RMIUtils.bindObject(host, port, "Adaptor", this);
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String sendThroughRmi(String value) throws RemoteException {
		logger.info("Calling method sendThroughRmi on Adaptor - " + value);
		return value;		
	}

}

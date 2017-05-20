import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class RMIUtils {
    private static Logger logger = Logger.getGlobal();
	
    public static Remote getRemoteObject(String host, int port, String objectName)
    	    throws MalformedURLException, RemoteException, NotBoundException, Exception
        {
    	logger.info("RmiUtils.getRemoteObject -> " + host + ":" + port + " - " + objectName);
    	Registry registry = LocateRegistry.getRegistry(host, port);
    	logger.info("RmiUtils.getRemoteObject - after getRegistry");
    	return registry.lookup(objectName);
        }

	public static void bindObject(String host, int port, String bindingName, Remote toBindObj) throws RemoteException, MalformedURLException, AlreadyBoundException
    {
	String path = "//" + host + ":" + port + "/" + bindingName;
	try
	{
	    // special exception handler for registry creation
	    LocateRegistry.createRegistry(port);
	    logger.info("java RMI registry created.");
	} catch (RemoteException e)
	{
		e.printStackTrace();
		logger.severe("ERROR in RmiUtils.bindObject");
		logger.severe("ERROR in RmiUtils.bindObject -> java RMI registry already exists.");
	}
	// Bind this object instance
	Naming.bind(path, toBindObj);
	logger.info("RMI - bound in registry: " + path);
    }

}

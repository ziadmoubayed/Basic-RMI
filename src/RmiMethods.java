import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiMethods extends Remote{
	public String sendThroughRmi(String value) throws RemoteException;
}

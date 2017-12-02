package core;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Abstract Adaptor
 * 
 * @author ziad
 */
public interface RemoteAdaptor extends Remote
{
    public String append(String value) throws RemoteException;
}

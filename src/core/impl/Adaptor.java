package core.impl;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

import core.RemoteAdaptor;
import utils.RMIUtils;

/**
 * Adaptor needs host and port of the registry it will bind itself to.
 * After starting. It will wait for the manager to connect.
 * 
 * @author ziad
 */
public class Adaptor extends UnicastRemoteObject implements RemoteAdaptor, Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //
    private Logger logger = Logger.getGlobal();

    public Adaptor(String host, int port) throws RemoteException {
	logger.info("Adaptor -->> Before Bind");
	bind(host, port);
	logger.info("Adaptor -->> After Bind");
    }

    public void bind(String host, int port)
    {
	try
	{
	    RMIUtils.setServeHostnameConfiguration(host);
	    RMIUtils.bindObject(host, port, "Adaptor", this);
	} catch (RemoteException | MalformedURLException | AlreadyBoundException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public String append(String value) throws RemoteException
    {
	logger.info("Appending Value: - " + value);
	return "Appended: " + value;
    }
}

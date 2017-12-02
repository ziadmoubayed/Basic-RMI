package core.impl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.logging.Logger;

import core.RemoteAdaptor;
import utils.RMIUtils;

public class Manager implements Runnable
{
    private Logger logger = Logger.getGlobal();

    private RemoteAdaptor adaptor;
    //
    private String host;
    private int port;

    public Manager(String host, int port) {
	this.host = host;
	this.port = port;
    }

    private RemoteAdaptor getAdaptor(String host, int port, String bindName)
	    throws MalformedURLException, RemoteException, NotBoundException, Exception
    {
	RemoteAdaptor adaptor = (RemoteAdaptor) RMIUtils.getRemoteObject(host, port, bindName);
	return adaptor;
    }

    @Override
    public void run()
    {
	while (true)
	{
	    // Step 1: Connect to Adaptors.
	    try
	    {
		logger.info("Connecting to adaptor at " + host + ":" + port);;
		this.adaptor = null;
		this.adaptor = getAdaptor(host, port, "Adaptor");
		logger.info("Connected!");;
	    } catch (Exception e)
	    {
		e.printStackTrace();
	    }
	    if(null == this.adaptor)
	    {
		try
		{
		    Thread.sleep(2000);
		} catch (InterruptedException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		continue;
	    }
	    else
	    {
		try
		{
		    String ss = String.valueOf(System.currentTimeMillis());
		    logger.info("Sending " + ss + " to the adaptor");
		    ss = this.adaptor.append(ss);
		    logger.info("Got back " + ss + " from the adaptor");
		} catch (RemoteException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		try
		{
		    Thread.sleep(500);
		} catch (InterruptedException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    
	}
    }
}

package standalone;

import java.rmi.RemoteException;

import core.impl.Adaptor;

public class StartAdaptor
{
    public static void main(String[] args) throws Exception
    {
	if (args == null || args.length != 2)
	    throw new Exception("Please specify correct host and port");

	try
	{
	    new Adaptor(args[0], Integer.valueOf(args[1]));
	} catch (RemoteException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}

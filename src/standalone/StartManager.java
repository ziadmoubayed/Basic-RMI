package standalone;

import core.impl.Manager;

public class StartManager
{
    public static void main(String[] args) throws Exception
    {
	if (args == null || args.length != 2)
	    throw new Exception("Please specify correct host and port");

	Thread t = new Thread(new Manager(args[0], Integer.valueOf(args[1])));
	t.start();
    }
}

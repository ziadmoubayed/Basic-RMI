package standalone;

public class AllInOne
{
    public static void main(String[] args) throws Exception
    {
	new StartAdaptor().main(new String[]{"192.168.15.100", "1099"});
	new StartManager().main(new String[]{"192.168.15.100", "1099"});
    }
}

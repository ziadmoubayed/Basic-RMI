import java.util.logging.Logger;

public class Player implements Runnable{
	private RmiMethods rmiClass;
	private Logger logger = Logger.getGlobal();

	public Player(RmiMethods rmiClass){
		this.rmiClass = rmiClass;
	}
	
	public void run(){
		int count = 0;
		
		while(true){
			logger.info("Playyer in start of loop");
			try {
				this.rmiClass.sendThroughRmi("String Value: " + count++);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				logger.info("Playyer sleeping");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

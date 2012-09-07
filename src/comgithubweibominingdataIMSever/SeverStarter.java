package comgithubweibominingdataIMSever;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import saqib.rasul.RmiStarter;

public class SeverStarter extends RmiStarter {

	public SeverStarter() {
		super(SeverRMI.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCustomRmiHandling() {
		// TODO Auto-generated method stub
        try {
            Sever s = new Sever();
            SeverRMI modelRMIStub = (SeverRMI)UnicastRemoteObject.exportObject(s.mRMI, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(SeverRMI.SERVICE_NAME, modelRMIStub);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SeverStarter();

	}

}

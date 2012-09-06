package comgithubweibominingdataIMSever;

import java.rmi.Remote;
import java.rmi.RemoteException;

import comgithubweibominingdataIMClient.ChattingHistory;
import comgithubweibominingdataIMClient.UsersManager;
import comgithubweibominingdataIMClient.Usr;

public interface SeverRMI extends Remote {
	
	public static final String SERVICE_NAME = "IMSever";
	
	boolean usrRegister(Usr u) throws RemoteException;
	void usrUpdateStatus(Usr u) throws RemoteException;
	void usrUpdateMessage(Usr u, String m) throws RemoteException;
	void usrUpdateEditingStatus(Usr u) throws RemoteException;
	void usrUpdateTopic(String topic) throws RemoteException;
	void usrRetriveInfor(UsersManager m, ChattingHistory h, String topic) throws RemoteException;
	void usrLeaves(Usr u) throws RemoteException;
}

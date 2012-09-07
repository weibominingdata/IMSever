package comgithubweibominingdataIMSever;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import comgithubweibominingdataIMClient.ChattingHistory;
import comgithubweibominingdataIMClient.Usr;

public interface SeverRMI extends Remote {
	
	public static final String SERVICE_NAME = "IMSever";
	
	Usr usrRegister() throws RemoteException;
	void usrUpdateStatus(Usr u) throws RemoteException;
	void usrUpdateMessage(Usr u, String m) throws RemoteException;
	void usrUpdateEditingStatus(Usr u) throws RemoteException;
	void usrUpdateTopic(String topic) throws RemoteException;
	Vector<Usr> usrRetriveUsersList() throws RemoteException;
	ChattingHistory usrRetriveChattingHistory() throws RemoteException;
	String usrRetriveTopic() throws RemoteException;
	void usrLeaves(Usr u) throws RemoteException;
}

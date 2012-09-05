package comgithubweibominingdataIMSever;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SeverRMI extends Remote {
	void usrRegister() throws RemoteException;
	void usrUpdateStatus() throws RemoteException;
	void usrUpdateMessage() throws RemoteException;
	void usrUpdateEditingStatus() throws RemoteException;
	void usrUpdateTopic() throws RemoteException;
	void usrRetriveInfor() throws RemoteException;
}

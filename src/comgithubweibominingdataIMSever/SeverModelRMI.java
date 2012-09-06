package comgithubweibominingdataIMSever;

import java.rmi.RemoteException;

import comgithubweibominingdataIMClient.ChattingHistory;
import comgithubweibominingdataIMClient.UsersManager;
import comgithubweibominingdataIMClient.Usr;

public class SeverModelRMI implements SeverRMI {
	
	protected SeverModel m = new SeverModel();

	public SeverModelRMI(SeverModel m) {
		// TODO Auto-generated constructor stub
		this.m = m;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized boolean usrRegister(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		boolean successful = m.generateAUsr(u);
		if (successful){
			this.m.updateView();
		}
		return successful;
	}

	@Override
	public synchronized void usrUpdateStatus(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < m.m.usrList.size(); ++i) {
			if (u.getUsrID() == m.m.usrList.get(i).getUsrID()) {
				m.m.usrList.get(i).setUsrStatus(u.getUsrStatus());
			}
		}
		this.m.updateView();
		
	}

	@Override
	public synchronized void usrUpdateMessage(Usr u, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < m.m.usrList.size(); ++i) {
			if (u.getUsrID() == m.m.usrList.get(i).getUsrID()) {
				// this usr exists
				String msgTobeStored = u.getUsrName() + "Says :" + msg;
				m.h.addAChat(msgTobeStored);
			}
		}
		this.m.updateView();
		
		
	}

	@Override
	public synchronized void usrUpdateEditingStatus(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < m.m.usrList.size(); ++i) {
			if (u.getUsrID() == m.m.usrList.get(i).getUsrID()) {
				m.m.usrList.get(i).setUsrEditingStatus(u.getUsrEditingStatus());
			}
		}
		this.m.updateView();
	}

	@Override
	public synchronized void usrUpdateTopic(String topic) throws RemoteException {
		// TODO Auto-generated method stub
		m.topic = topic;
	}

	@Override
	public synchronized void usrRetriveInfor(UsersManager m, ChattingHistory h, String topic)
			throws RemoteException {
		// TODO Auto-generated method stub
		m = this.m.m;
		h = this.m.h;
		topic = this.m.topic;
	}

	@Override
	public synchronized void usrLeaves(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		this.m.usrLeaves(u);	
	}

}

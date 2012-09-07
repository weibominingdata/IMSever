package comgithubweibominingdataIMSever;

import java.rmi.RemoteException;
import java.util.Vector;

import comgithubweibominingdataIMClient.ChattingHistory;
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
	public Usr usrRegister() throws RemoteException {
		// TODO Auto-generated method stub
		Usr t = new Usr();
		boolean successful = m.generateAUsr(t);
		if (successful){
			System.out.println(this.m.m.usrList.size());
			this.m.updateView();
		}
		return t;
	}

	@Override
	public void usrUpdateStatus(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < m.m.usrList.size(); ++i) {
			if (u.getUsrID() == m.m.usrList.get(i).getUsrID()) {
				m.m.usrList.get(i).setUsrStatus(u.getUsrStatus());
			}
		}
		this.m.updateView();
		
	}

	@Override
	public void usrUpdateMessage(Usr u, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < m.m.usrList.size(); ++i) {
			if (u.getUsrID() == m.m.usrList.get(i).getUsrID()) {
				// this usr exists
				String msgTobeStored = "["+u.getUsrName() + " Says: ]" + msg;
				m.h.addAChat(msgTobeStored);
			}
		}
		this.m.updateView();
		
		
	}

	@Override
	public void usrUpdateEditingStatus(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < m.m.usrList.size(); ++i) {
			if (u.getUsrID() == m.m.usrList.get(i).getUsrID()) {
				m.m.usrList.get(i).setUsrEditingStatus(u.getUsrEditingStatus());
			}
		}
		this.m.updateView();
	}

	@Override
	public void usrUpdateTopic(String topic) throws RemoteException {
		// TODO Auto-generated method stub
		m.topic = topic;
	}


	@Override
	public void usrLeaves(Usr u) throws RemoteException {
		// TODO Auto-generated method stub
		this.m.usrLeaves(u);	
	}

	@Override
	public Vector<Usr> usrRetriveUsersList() throws RemoteException {
		// TODO Auto-generated method stub
		return m.m.usrList;
	}

	@Override
	public ChattingHistory usrRetriveChattingHistory() throws RemoteException {
		// TODO Auto-generated method stub
		return m.h;
	}

	@Override
	public String usrRetriveTopic() throws RemoteException {
		// TODO Auto-generated method stub
		return m.topic;
	}

}

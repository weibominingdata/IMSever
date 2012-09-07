package comgithubweibominingdataIMSever;

import java.util.Enumeration;
import java.util.Vector;

import comgithubweibominingdataIMClient.ChattingHistory;
import comgithubweibominingdataIMClient.UsersManager;
import comgithubweibominingdataIMClient.Usr;
import comgithubweibominingdataIMClient.UsrEditingStatus;
import comgithubweibominingdataIMClient.UsrStatus;

public class SeverModel {
	
	protected SeverControl control;
	protected SeverView view;
	
	protected UsersManager m = new UsersManager();
	protected ChattingHistory h = new ChattingHistory();
	protected UsrsGenerator ug = new UsrsGenerator();
	protected String topic = new String();

	public SeverModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	protected boolean generateAUsr(Usr u) {
		Vector<String> n = new Vector<String>();
		int id = ug.getUsrNameAndID(n);
		if (id == -1) {
			return false;
		}
		else {
			u.setUsrID(id);
			u.setUsrName(n.get(0));
			u.setUsrStatus(UsrStatus.Available);
			u.setUsrEditingStatus(UsrEditingStatus.NotEntered);
            boolean added = false;
			for(int i = 0; i < m.usrList.size(); ++i) {
				if (m.usrList.get(i).getUsrID()>id){
					m.usrList.add(i, u);
					added = true;
					break;					}
			}
			if (!added) {
				// it means it should be added to the end of the list
				m.usrList.add(u);
			}
			this.h.addAChat(n+" joins the chatting");
			updateView();
			return true;
		}
	}
	
	protected void usrLeaves(Usr u) {
		ug.removeAUsr(u.getUsrID());
		this.h.addAChat("[" + u.getUsrName() + "]" + " leaves the chatting");
		for(int i = 0; i < this.m.usrList.size(); ++i) {
			if (this.m.usrList.get(i).getUsrID() == u.getUsrID()) {
				this.m.usrList.remove(i);
				break;
			}
		}
		updateView();
	}
	
	protected void updateView(){
		String list = "";
        Enumeration<Usr> e = m.usrList.elements();
        while(e.hasMoreElements()){
        	Usr temp = (Usr)e.nextElement();
        	list += temp;//"("+ Usr.getUsrStatusString(temp.getUsrStatus()).charAt(0)+ ")" + temp.getUsrName() + ":" + temp.getUsrEditingStatus() + "\n";
        	
        }
        this.view.textAreaUsrs.setText(list);
        
        list = "";
        Enumeration<String> chatting = this.h.getChattingHistory().elements();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		while(chatting.hasMoreElements()) {
			list += (String)chatting.nextElement() + "\n";//"["+ dateFormat.format(new Date()) + "]"+(String)chatting.nextElement() + "\n";
		}
		this.view.textLogs.setText(list);
	}

}

package comgithubweibominingdataIMSever;



public class Sever {
	private SeverModel model = new SeverModel();
	private SeverControl control = new SeverControl();
	private SeverView view = new SeverView();
	protected SeverModelRMI mRMI = new SeverModelRMI(model);

	public Sever() {
		// TODO Auto-generated constructor stub
		model.control = this.control;
		model.view = this.view;
		control.model = this.model;
		control.view = this.view;
		view.control = this.control;
		view.model = this.model;
		
		view.setVisible(true);
		model.updateView();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sever();

	}

}

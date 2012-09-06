package comgithubweibominingdataIMSever;

import java.util.Arrays;
import java.util.Vector;

public class UsrsGenerator {
	private Vector<String> name = new Vector<String>();
	private Vector<Boolean> usedID = new Vector<Boolean>();

	public UsrsGenerator() {
		// TODO Auto-generated constructor stub
		name.add("Adam");
		name.add("Bob");
		name.add("Carol");
		name.add("David");
		name.add("Eddie");
		name.add("Frank");
		name.add("George");
		name.add("Harry");
		name.add("Ike");
		name.add("Jim");
		name.add("Kenny");
		name.add("Larry");
		name.add("Mary");
		name.add("Nancy");
		name.add("Oliver");
		name.add("Pter");
		name.add("Quincy");
		name.add("Roger");
		name.add("Sam");
		name.add("Thomas");
		name.add("Uncle");
		name.add("Vincent");
		name.add("William");
		name.add("Xavier");
		name.add("Yogi");
		name.add("Zachary");
		
		Boolean[] a = {Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,
				Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,
				Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,
				Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,};
		usedID = new Vector<Boolean>(Arrays.asList(a));
		
	}
	
	protected void removeAUsr(int id) {
		if (id<0 || id>=26) {
			System.err.println("ID out of range input");
			return;
		}
		usedID.set(id, Boolean.FALSE);
	}
	
	protected int getUsrNameAndID(String n) {
		int i = 0;
		for(;i<26;++i){
			if (usedID.get(i)==Boolean.FALSE){
				break;
			}
		}
		if (i==26){
			return -1;
		}
		else {
			n = name.get(i);
			return i;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

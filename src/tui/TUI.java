package tui;

import java.util.*;

import data.IOperatorDAO.DALException;
import functionality.Function;
import functionality.IFunction;

public class TUI implements ITUI {
	private IFunction f;
	private Scanner in = new Scanner(System.in);
	private int oprId;

	public TUI() {
		f = new Function();
	}

	public void dialog() throws DALException {
		f.init();
		System.out.println("Login:\nEnter user ID");
		try{
			oprId = Integer.parseInt(in.next());
			System.out.println("Password:");
			String psw = in.next();
			if(f.login(oprId, psw))
				menu(oprId == 10);
			else {
				System.out.println("Wrong password or user ID.");
				dialog();
			}
		} catch(Exception e) {
			System.out.println("Invalid input: " + e.getMessage());
			dialog();
		}
	}

	public void menu(boolean admin) {
		if(admin) {
			System.out.println("You have admin rights.");
			System.out.println("1. Create operator\n2. Delete operator\n3. Update operator\n4. List operators\n0. logout");
			try{
				int input = Integer.parseInt(in.next());
				switch(input) {
				case 0: System.out.println("Goodbye");
				dialog();
				break;
				case 1: createOpr();
				break;
				case 2: removeOpr();
				break;
				case 3: updateOpr();
				break;
				case 4: listOpr();
				break;
				default: System.out.println("invalid ipnut");
				menu(admin);
				}
			} catch(DALException e) {
				System.out.println(e.getMessage());
				menu(admin);
			} catch(Exception e) {
				System.out.println("Invalid input");
				menu(admin);
			}
		} else {
			System.out.println("1. Change password\n2. Test weight\n0. Quit");
			try{
				int input = Integer.parseInt(in.next());
				switch(input) {
				case 0: System.out.println("Goodbye");
				break;
				case 1: changePass();
				break;
				case 2: testWeight();
				break;
				default: System.out.println("invalid ipnut");
				menu(admin);
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
				menu(false);
			}
		}
		menu(admin);
	}

	public void createOpr() {
		System.out.println("Enter operator name:");
		in.nextLine();
		String oprName = in.nextLine();
		System.out.println("Enter operator initials:");
		String ini = in.next();
		System.out.println("Enter operator CPR:");
		String cpr = in.next();
		try {
			System.out.println(f.createOperator(oprName, ini, cpr));
			
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeOpr() {
		System.out.println("Enter operator ID:");
		try {
			int input = Integer.parseInt(in.next());
			try{
				f.deleteOperator(input);
			} catch(DALException e) {
				System.out.println(e.getMessage());
			}
		} catch(Exception e) {
			System.out.println("Wrong input.");
		}
		menu(true);
	}

	public void updateOpr() {
		int id = 0;
		System.out.println("Enter operator name:");
		in.nextLine();
		String oprName = in.nextLine();;
		System.out.println("Enter operator initials:");
		String ini = in.next();
		System.out.println("Enter operator CPR:");
		String cpr = in.next();
		System.out.println("Enter operator ID:");
		try {
			id = Integer.parseInt(in.next());
		} catch(Exception e) {
			System.out.println("Please enter a number");
			updateOpr();
		}

		try {
			f.updateOperator(oprName, ini, cpr, id);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listOpr() {
		try {
			f.getOprList();
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
		menu(true);
	}

	public void changePass() throws DALException{
		String temp0, temp1, psw;
		System.out.println("Password must be at least 6 characters and must fit at least 3 of the following criteria:\n"
				+ "At least one lower case letter, "
				+ "at least one upper case letter,"
				+ "\nat least one number,\n"
				+ "at least one of the following symbols:\n"
				+ "'.', '-', '_', '+'. '=', '!', '?'");
		System.out.println("Enter old password");
		psw = in.next();
		if(f.login(oprId, psw)) {
			System.out.println("Enter new password");
			temp0 = in.next();
			System.out.println("Confirm new password");
			temp1 = in.next();
			System.out.println(f.makeNewPassword(oprId, temp0, temp1));
		} else
			System.out.println("Wrong password.");
		menu(false);
	}

	public void testWeight() {
		System.out.println("Enter tare weight");
		int tara = Integer.parseInt(in.next());
		System.out.println("Enter brutto weight");
		int brutto = Integer.parseInt(in.next());
		try {
			System.out.println("Net weight is " + f.calculateWeight(tara, brutto));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		menu(false);
	}
}

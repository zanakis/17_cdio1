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
		menu();
	}

	public void menu() throws DALException{
		login();
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
			}
		} catch(Exception e) {
			System.out.println("Invalid input.");
			menu();
		}
	}

	public void login() {
		System.out.println("Login:\nEnter user ID");
		try{
			oprId = Integer.parseInt(in.next());
			System.out.println("Password:");
			String psw = in.next();
			if(f.login(oprId, psw))
				adminMenu(oprId == 10);
			else {
				System.out.println("Wrong password or user ID.");
				login();
			}
		} catch(Exception e) {
			System.out.println("Invalid input.");
			login();
		}
	}

	public void adminMenu(boolean admin) {
		System.out.println("You have admin rights.");
		System.out.println("1. Create operator\n2. Delete operator\n3. Update operator\n4. List operators\n0. logout");
		try{
			int input = Integer.parseInt(in.next());
			switch(input) {
			case 0: System.out.println("Goodbye");
			break;
			case 1: createOpr();
			break;
			case 2: removeOpr();
			break;
			case 3: updateOpr();
			break;
			case 4: listOpr();
			break;
			}
		} catch(Exception e) {
			System.out.println("Invalid input.");
			adminMenu(true);
		}
	}

	public void createOpr() {
		System.out.println("Enter operator name:");
		String oprName = in.next();
		System.out.println("Enter operator initials:");
		String ini = in.next();
		System.out.println("Enter operator CPR:");
		String cpr = in.next();
		try {
			f.createOperator(oprName, ini, cpr);
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
		adminMenu(true);
	}
	
	public void updateOpr() {
		
	}
	
	public void listOpr() {
		try {
			f.getOprList();
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
		adminMenu(true);
	}

	public void changePass() throws DALException{
		String temp0, temp1, psw;
		System.out.println("Enter old password");
		psw = in.next();
		if(psw.equals('0'))
			menu();
		if(f.login(oprId, psw)) {
			System.out.println("Enter new password");
			temp0 = in.next();
			System.out.println("Confirm new password");
			temp1 = in.next();
			System.out.println(f.makeNewPassword(oprId, temp0, temp1));
		} else {
			System.out.println("Wrong password. Enter 0 to quit.");
		}
		adminMenu(true);
	}

	public void testWeight() {

	}
}

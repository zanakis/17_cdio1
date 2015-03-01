package test;

import static org.junit.Assert.*;

import org.junit.*;

import data.*;
import data.IOperatorDAO.DALException;
import functionality.*;
import tui.*;

public class Test {
	IOperatorDAO d;
	IFunction f;
	ITUI t;

	@Before
	public void setup() {
		d = new OperatorDAO();
		f = new Function();
		t = new TUI();
	}

	@org.junit.Test
	public void testChangeWrongPassword() {
		try {
			d.createOperator(new OperatorDTO("MJ", "MJ", "1000", 11));
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
		IPasswordGen passGen = new PasswordGen();
		if(passGen.checkCriteria("meyo")) {
			if("meyo".equals("meyo")) {
				try {
					d.getOperator(11).setPassword("meyo");
				} catch (DALException e) {
					System.out.println("???");
				}
				System.out.println("Password changed");
			} else System.out.println("Passwords didn't match");
		} else System.out.println("New password does not match the criteria");
	}

	@org.junit.Test
	public void testChangeRightPassword() {
		try {
			d.createOperator(new OperatorDTO("MJ", "MJ", "1000", 11));
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
		IPasswordGen passGen = new PasswordGen();
		if(passGen.checkCriteria("!wreU4")) {
			if("!wreU4".equals("!wreU4")) {
				try {
					d.getOperator(11).setPassword("!wreU4");
				} catch (DALException e) {
					System.out.println("???");
				}
				System.out.println("Password changed");
			}
		} else System.out.println("New password does not match the criteria");
	}
	
	@org.junit.Test
	public void testChangeNoMatchtPassword() {
		try {
			d.createOperator(new OperatorDTO("MJ", "MJ", "1000", 11));
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
		IPasswordGen passGen = new PasswordGen();
		if(passGen.checkCriteria("!wreU4")) {
			if("!wreU4".equals("!3Erfd")) {
				try {
					d.getOperator(11).setPassword("!wreU4");
				} catch (DALException e) {
					System.out.println("???");
				}
				System.out.println("Password changed");
			} else System.out.println("passwords didn't match");
		} else System.out.println("New password does not match the criteria");
	}
}

package test;

import static org.junit.Assert.*;

import org.junit.*;

import data.*;
import data.IOperatorDAO.DALException;
import functionality.*;
import tui.*;

public class Test {
	IFunction f;

	@Before
	public void setup() throws DALException {
		f = new Function();
		f.init();
	}
	
	@org.junit.Test
	public void testChangeWrongPassword() {
		String psw = "";
		try {
			psw = f.getOprArrayList().get(11).getPassword();
			System.out.println(f.makeNewPassword(11, "meyo", "meyo"));
			assertEquals(psw, f.getOprArrayList().get(11).getPassword());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	@org.junit.Test
	public void testChangeRightPassword() {
		try {
			System.out.println(f.makeNewPassword(11, "!wreU4", "!wreU4"));
			assertEquals("!wreU4", f.getOprArrayList().get(11).getPassword());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void testChangeNoMatchtPassword() {
		String psw = "";
		try {
			psw = f.getOprArrayList().get(11).getPassword();
			System.out.println(f.makeNewPassword(11, "!wreU4", "!3Erfd"));
			assertEquals(psw, f.getOprArrayList().get(11).getPassword());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void testUpdateOutOfBounds() {
		try {
			f.updateOperator("Test", "T", "ttt-ttt", 17);
		} catch (DALException e) {
			
		}
	}
}

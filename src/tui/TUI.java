package tui;

import java.util.*;

import data.IOperatorDAO.DALException;
import functionality.Function;
import functionality.IFunction;

public class TUI implements ITUI {
	private IFunction f;
	private Scanner in = new Scanner(System.in);
	
	public TUI() {
		f = new Function();
	}
	
	public void dialog() {
		System.out.println("1. ");
	}
}

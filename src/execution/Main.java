package execution;

import data.IOperatorDAO;
import data.OperatorDAO;
import functionality.*;
import tui.*;

public class Main {
	public static void main(String[] args) {
		IOperatorDAO d = new OperatorDAO();
		IFunction f = new Function();
		ITUI t = new TUI();
//		t.dialog();
	}
}

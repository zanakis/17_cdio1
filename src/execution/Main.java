package execution;

import data.IOperatorDAO;
import data.OperatorDAO;
import data.IOperatorDAO.DALException;
import functionality.*;
import tui.*;

public class Main {
	public static void main(String[] args) throws DALException {
		ITUI t = new TUI();
		t.dialog();
	}
}

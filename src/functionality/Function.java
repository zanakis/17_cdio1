package functionality;

import java.util.ArrayList;

import data.*;
import data.IOperatorDAO.DALException;

public class Function implements IFunction {
	private IOperatorDAO data;
	
	public Function() {
		data = new OperatorDAO();
	}
	
	public void init() throws DALException {
		data.createOperator(new OperatorDTO("Michael Jensen", "MJ", "200384-9311", data.getOperatorList().size()));
		data.createOperator(new OperatorDTO("Nina Jensen", "NJ", "130282-9312", data.getOperatorList().size()));
		data.createOperator(new OperatorDTO("Jan Past", "JP", "20038-9311", data.getOperatorList().size()));
	}

	public String createOperator(String oprName, String ini, String cpr) throws DALException {
		OperatorDTO opr = new OperatorDTO(oprName, ini, cpr, data.getOperatorList().size());
		data.createOperator(opr);
		return "Operator " + (data.getOperatorList().size()-1) + "\tPassword: "
		+ data.getOperator(data.getOperatorList().size()-1).getPassword();
	}

	public void deleteOperator(int oprId) throws DALException {
		data.deleteOperator(data.getOperator(oprId));
	}

	public void updateOperator(String oprName, String ini, String cpr, int oprId) throws DALException {
		data.updateOperator(new OperatorDTO(oprName, ini, cpr, oprId));
	}

	public String makeNewPassword(int oprId, String psw1, String psw2) throws DALException {
		IPasswordGen passGen = new PasswordGen();
		if(passGen.checkCriteria(psw1)) {
			if(psw1.equals(psw2)) {
				data.getOperator(oprId).setPassword(psw1);
				return "Password changed";
			}
		} else return "New password does not match the criteria";
		return "Passwords didn't match";
	}

	public void getOprList() throws DALException {
		for(int i = 0; i < data.getOperatorList().size(); i++) {
			if((data.getOperatorList().get(i) != null) && !data.getOperator(i).getAdmin())
				System.out.println(data.getOperator(i).getOprName() + "\t" + data.getOperator(i).getIni() + "\t" +
						data.getOperator(i).getOprId() + "\t" + data.getOperator(i).getCpr() +
						"\t" + data.getOperator(i).getPassword());
		}
	}
	
	public ArrayList<OperatorDTO> getOprArrayList() throws DALException {
		return data.getOperatorList();
	}

	public boolean login(int oprId, String psw) throws DALException {
		return psw.equals(data.getOperator(oprId).getPassword()) && (oprId > 9);
	}
	
	public int calculateWeight(int tara, int brutto) throws DALException {
		return brutto - tara;
	}
}

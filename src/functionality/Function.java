package functionality;

import data.*;
import data.IOperatorDAO.DALException;

public class Function implements IFunction {
	private IOperatorDAO data;
	
	public Function() {
		data = new OperatorDAO();
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
				System.out.println(data.getOperatorList().get(i).getOprName() + "\t" + data.getOperatorList().get(i).getIni() + "\t" +
						data.getOperatorList().get(i).getOprId() + "\t" + data.getOperatorList().get(i).getCpr());
		}
	}

	public boolean login(int oprId, String psw) throws DALException {
		return psw.equals(data.getOperator(oprId).getPassword()) && (oprId > 9);
	}
	
	public int calculateWeight(int tara, int brutto) throws DALException {
		return brutto - tara;
	}
}

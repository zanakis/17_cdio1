package functionality;

import data.*;
import data.IOperatorDAO.DALException;

public class Function implements IFunction {
	private IOperatorDAO data = new OperatorDAO();

	public void createOperator(String oprName, String ini, String cpr) throws DALException {
		OperatorDTO opr = new OperatorDTO(oprName, ini, cpr);
		data.createOperator(opr);
	}

	public void deleteOperator(OperatorDTO opr) throws DALException {
		data.deleteOperator(opr);
	}

	public void updateOperator(String oprName, String ini, String cpr, int oprId) throws DALException {
		data.updateOperator(new OperatorDTO(oprName, ini, cpr));

	}

	public void makeNewPassword(int oprId, String psw1, String psw2) throws DALException {
		IPasswordGen passGen = new PasswordGen();
		if(passGen.checkCriteria(psw1)) {
			if(psw1.equals(psw2))
				data.getOperator(oprId).setPassword(psw1);
		}
	}

	public void getOprList() throws DALException {
		for(int i = 0; i < data.getOperatorList().size(); i++) {
			if(data.getOperatorList().get(i) != null)
				System.out.println(data.getOperatorList().get(i).getOprName() + "\t" + data.getOperatorList().get(i).getIni() + "\t" +
						data.getOperatorList().get(i).getOprId() + "\t" + data.getOperatorList().get(i).getCpr());
		}
	}

	public void login() {
		// TODO Auto-generated method stub

	}

}

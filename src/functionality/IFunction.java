package functionality;

import data.OperatorDTO;
import data.IOperatorDAO.DALException;

public interface IFunction {
	void createOperator(String oprName, String ini, String cpr) throws DALException;
	void deleteOperator(OperatorDTO opr) throws DALException;
	void updateOperator(String oprName, String ini, String cpr, int oprId) throws DALException;
	void makeNewPassword(int oprId, String psw1, String psw2) throws DALException;
	void getOprList() throws DALException;
	void login();
}

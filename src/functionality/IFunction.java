package functionality;

import data.OperatorDTO;
import data.IOperatorDAO.DALException;

public interface IFunction {
	void createOperator(String oprName, String ini, String cpr) throws DALException;
	void deleteOperator(int oprId) throws DALException;
	void updateOperator(String oprName, String ini, String cpr, int oprId) throws DALException;
	void getOprList() throws DALException;
	String makeNewPassword(int oprId, String psw1, String psw2) throws DALException;
	boolean login(int oprId, String psw) throws DALException;
}

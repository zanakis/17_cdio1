package data;

import java.util.ArrayList;

public interface IOperatorDAO {
	OperatorDTO getOperator(int oprId) throws DALException;
	ArrayList<OperatorDTO> getOperatorList() throws DALException;
	void createOperator(OperatorDTO opr) throws DALException;
	void updateOperator(OperatorDTO opr) throws DALException;
	void deleteOperator(OperatorDTO opr) throws DALException;

	public class DALException extends Exception {
		private static final long serialVersionUID = 1L;

		public DALException(String message) {
			super(message);
		}
	}
}


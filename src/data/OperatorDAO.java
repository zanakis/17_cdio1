package data;

import java.util.*;

import data.IOperatorDAO.DALException;

public class OperatorDAO implements IOperatorDAO {
	ArrayList<OperatorDTO> operators;

	//laver operat�rer 0-9 null
	public OperatorDAO() {
		operators = new ArrayList<OperatorDTO>();
		for(int i = 0; i < 10; i++)
			operators.add(null);
		operators.add(new OperatorDTO(true));
	}

	public OperatorDTO getOperator(int oprId) throws DALException {
		try {
			if(oprId < 10)
				throw new DALException("Operator " + oprId + " does not exist.");
			return operators.get(oprId);
		} catch(Exception e) {
			throw new DALException("Operator " + oprId + " does not exist.");
		}
	}

	public ArrayList<OperatorDTO> getOperatorList() throws DALException {
		return operators;
	}

	public void createOperator(OperatorDTO opr) throws DALException {
		if(opr.getOprId() < 99)
			operators.add(opr);
		else throw new DALException("Too many operators");
	}

	public void updateOperator(OperatorDTO opr) throws DALException {
		operators.set(opr.getOprId(), opr);
	}

	public void deleteOperator(OperatorDTO opr) throws DALException {
		try{
			operators.remove(opr.getOprId());
		} catch(Exception e) {
			throw new DALException("Operator is not in database.");
		}
	}
}

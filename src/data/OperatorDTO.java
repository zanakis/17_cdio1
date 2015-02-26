package data;

import functionality.PasswordGen;

public class OperatorDTO {
	static int userId = 11;
	static PasswordGen passGen = new PasswordGen();
	int oprId;
	boolean admin;
	String oprName; 
	String ini;
	String cpr; 
	String password;
	
	public OperatorDTO(String oprName, String ini, String cpr) {
		oprId = userId;
		this.oprName = oprName;
		this.ini = ini;
		this.cpr = cpr;
		admin = false;
		userId++;
		password = passGen.generate();
	}
	
	public OperatorDTO(boolean admin) {
		if(admin) {
			oprId = 10;
			this.admin = admin;
			oprName = "sysadmin";
			ini = "N/A";
			cpr = "N/A";
			password = "02324it!";
		}
	}
	
	public int getOprId() {
		return oprId;
	}

	public String getOprName() {
		return oprName;
	}

	public void setOprName(String oprName) {
		this.oprName = oprName;
	}
	
	public String getIni() {
		return ini;
	}

	public void setIni(String ini) {
		this.ini = ini;
	}
	
	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	
	public boolean getAdmin() {
		return admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package functionality;

public class PasswordGen implements IPasswordGen{
	String psw;
	char[] symbols = {'.', '-', '_', '+', '!', '?', '=' };

	public String generate() {
		boolean criteria = false;
		do {
			psw = "";
			makePassword();
			criteria = checkCriteria();
		}while(!criteria);
		return psw;
	}

	public void makePassword() {
		for(int i = 0; i < 6; i++) {
			int letters = (int)(Math.random()*4);
			switch(letters) {
			case 0: addNumber();
			break;
			case 1: addUpperCase();
			break;
			case 2: addLowerCase();
			break;
			case 3: addChar();
			break;
			default: System.out.println("eeeee");
			}
		}
	}

	public void addNumber() {
		int x = (int)(Math.random()*10);
		psw += x;
	}

	public void addUpperCase() {
		int x = (int)(Math.random()*26)+'A';
		psw += (char)x;
	}

	public void addLowerCase() {
		int x = (int)(Math.random()*26)+'a';
		psw += (char)x;
	}

	public void addChar() {
		int x = (int)(Math.random()*7);
		char[] symbols = {'.', '-', '_', '+', '!', '?', '=' };
		psw += symbols[x];
	}

	public boolean checkCriteria() {
		int x = 0;
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isLowerCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isUpperCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isDigit(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isLowerCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		if(symbolsCheck())
			x++;
		return x > 2;

	}

	public boolean checkCriteria(String psw) {
		int x = 0;
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isLowerCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isUpperCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isDigit(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isLowerCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		if(symbolsCheck())
			x++;
		return x > 2;

	}

	public boolean symbolsCheck() {
		for(int i = 0; i < symbols.length; i++) {
			for(int j = 0; j < psw.length(); j++) {
				if(psw.charAt(j) == symbols[i])
					return true;
			}
		}
		return false;
	}
}

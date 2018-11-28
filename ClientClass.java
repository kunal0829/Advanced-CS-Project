import java.util.Scanner;
public class ClientClass {
	public static void main(String [] args) {
		char choice = 'A';
		
		Scanner scan = new Scanner(System.in);	
		while (choice != 'Q') {
			System.out.print("Encrypt (E), Decrypt (D), or Quit(Q) : ");
			choice = scan.nextLine().charAt(0);
			if (choice == 'Q')
				return;
			
			String message = getMessage();
			String key = getKey();
		
			if (choice == 'E')
				System.out.println(encryptMessage(message, key));
			else if(choice == 'D')
				System.out.println(decryptMessage(message, key));
		}
		scan.close();
	}
	
	public static String getMessage() {
		Scanner scan = new Scanner(System.in);	
		System.out.print("Enter Line: ");
		return scan.nextLine();	
	}
	
	public static String getKey() {//need to check to make sure all are letters
		Scanner scan = new Scanner(System.in);	
		System.out.print("Enter Key: ");
		return scan.nextLine().toUpperCase();	
		
	}
	
	public static String encryptMessage(String originalMessage, String key) {
		String newMessage = "";

		for (int i = 0; i < originalMessage.length(); i++) {	
			newMessage += encryptCharacter(originalMessage.charAt(i), key.charAt(i % key.length()));
		}
		
		return newMessage;
	}
	
	public static char encryptCharacter(char originalCharacter, char key) {
		int keyNum = (int) key - 65;
		//ASCII 32-126 only https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html		
		int newCharacterNum = 0;
		
		if (keyNum + (int) originalCharacter <= 126)
			newCharacterNum = keyNum + (int) originalCharacter;
		else 
			newCharacterNum = ((keyNum + (int) originalCharacter) - 126) + 31;
		
		char newChar = (char) newCharacterNum;
		
		return newChar;
	}
	
	public static String decryptMessage(String originalMessage, String key) {
		String newMessage = "";


		for (int i = 0; i < originalMessage.length(); i++) {	
			newMessage += decryptCharacter(originalMessage.charAt(i), key.charAt(i % key.length()));
		}
		
		return newMessage;
	}
	
	public static char decryptCharacter(char originalCharacter, char key) {
		int keyNum = (int) key - 65;
		//ASCII 32-126 only https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html		
		int newCharacterNum = 0;
		
		if ((int) originalCharacter - keyNum >= 32)
			newCharacterNum = (int) originalCharacter - keyNum;
		else 
			newCharacterNum = 95 + ((int) originalCharacter - keyNum);
		
		char newChar = (char) newCharacterNum;
		
		return newChar;
	}
	
}

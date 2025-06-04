import java.util.Scanner;
public class Tester{
	public static void main(String[] args){
		Scanner inputData = new Scanner(System.in);
		Authentication auth = new Authentication();
		String username, password, phoneNO;
		boolean isValid = true;
		while(isValid){
			System.out.print("Enter username: ");
			username = inputData.nextLine();

			System.out.print("Enter password: ");
			password = inputData.nextLine();

			System.out.print("Enter phone number: ");
			phoneNO = inputData.nextLine();	
			try {
				// Register user
				if (auth.register(username, password, phoneNO)) {
					System.out.println("User registered successfully.");
				}
				// Register status check
				if (auth.registerStatus(username, password, phoneNO)) {
					System.out.println("Register status: Success.");
				}
				// Login user
				if (auth.login(username, password)) {
					System.out.println("Login successful.");
				}
				// Login status check
				if (auth.loginStatus(username, password)) {
					System.out.println("Login status: Success.");
				}

			} 
			catch (IllegalArgumentException iae) {
				System.out.println("Error: " + iae.getMessage());
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			finally{
				System.out.println("******************************THE END OF PROGRAM******************************");
			}
			
			System.out.print("would you like to continue add or register another user: (Y/N) ");
			char respond = Character.toUpperCase(inputData.nextLine().charAt(0));
			if(respond == 'N'){
				isValid = false;
			}
		}
	}
}
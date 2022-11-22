package securitydevice;

import java.util.*;

public class App {

	int readInput(Scanner sc) {
		int in = -1;
		boolean found;

		found = false;
		while (!found) {			
			try {
				sc.skip("[^0-9]*");
				in = sc.nextInt();
				found = true;
			} catch (InputMismatchException e) {
				found = false;
			} catch (NoSuchElementException e) {
				found = false;
			}
		}
		return in;		
	}

	int intruderCheck() {
		int count = 0;
		String out;
		FSM fsm = new FSM();
		Random rand = new Random();

		int[] code = {8, 4, 7, 2, 4}; // student ID
		int i = 0; 
		boolean codeFound = false;
		boolean unlocked = false;

		while(!unlocked) {
			if(!codeFound){
				int generateRandomNum = rand.nextInt(10);
				count++; // everytime a number is generated count goes up
				if(generateRandomNum == code[i]){
					if (i < code.length - 1){ i++; }

					else if(i == code.length - 1){ codeFound = true; }
				}
				
				else if(generateRandomNum == code[0]) { i = 1; }
				
				else{ i = 0; }
			}
			else if(codeFound){
				int otherRandomNum = rand.nextInt(10);
				count++;
				fsm.input(otherRandomNum);
				out = fsm.output();

				if (out.equals("Unlock")) {
					codeFound = false;
					unlocked = true;
					i = 0;
				}
				else if (otherRandomNum == code[0]){
					i = 0;
					codeFound = false; 
					i++;
				}
				else {
					i = 0;
					codeFound = false; 
				}
			}
		}

		return count;
	}

	private void securityDevice() {
		String out;
		int in, lockInput;
		Scanner sc = new Scanner(System.in);
		FSM fsm = new FSM();

		int[] code = {8, 4, 7, 2, 4}; // student ID
		int i = 0; 
		boolean codeFound = false;

		while (true) {
			if(!codeFound) {
				in = readInput(sc);
				if(in == code[i]){
					if (i < code.length - 1){ i++; }

					else if(i == code.length - 1){ codeFound = true; }
				}

				else if(in == code[0]) { i = 1; }
				
				else{ i = 0; }
			}

			if(codeFound){
				lockInput = readInput(sc);
				fsm.input(lockInput);
				out = fsm.output();
				if (lockInput == 1 || lockInput == 4) {
					i = 0;
					System.out.println(out);
					codeFound = false;
				}
				else if (lockInput == code[0]){
					i = 0;
					codeFound = false; 
					i++;
				}
				else {
					i = 0;
					codeFound = false; 
				}
			}
		}
	}
	

	public static void main(String[] args) {
		App app = new App();
		Scanner sc = new Scanner(System.in);
		System.out.println("Which part of the Project would you like to access? Part 1 or 2?");
		System.out.println("Type 'one' for Part 1 and 'two' for Part 2.");


		String part = sc.next();
		if(part.equals("one")) {
			System.out.println("Enter code: ");
			app.securityDevice();
		}
		else if(part.equals("two")) {
			System.out.println("The intruder took " + app.intruderCheck() + " tries to unlock the lock.");

			System.out.println("Do you want to see statistics for this part? 'yes' or 'no'");
			String ask = sc.next();
			if(ask.equals("yes")) {
				int max = 0;
				int min = Integer.MAX_VALUE;
				int total = 0;

				System.out.println("How many trials do you want to run?");
				int trials = sc.nextInt();

				for(int i=0;i<trials;i++) {
					int attempt = app.intruderCheck();
					total += attempt;
					if(attempt > max) {
						max = attempt;
					}
					if (attempt < min) {
						min = attempt;
					}
				}

				System.out.println("In " + trials + " tries, the maximum amount of tries that was attempted was " + max);
				System.out.println("In " + trials + " tries, the minimum amount of tries that was attempted was " + min);
				System.out.println("In " + trials + " tries, the average amount of tries that was attempted was " + total/trials);
			}				

			else if(ask.equals("no")) { System.exit(1); }
		}

	}
}

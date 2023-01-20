import java.util.Scanner;
import java.util.Random;

public class Main
{
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static int randNum = generateNumber(0);
	public static void main(String[] args) {
    System.out.println("Guess the number");
		char answer = 'Y';
		while (answer == 'y' || answer == 'Y') {
			int guess = 0;
			do {
				guess = enterGuess();
				displayMessage(guess);
			} while (guess != randNum);
			randNum = generateNumber(0);
			System.out.println("Would you like to play again? Input 'y' if yes, and 'n' if no");
			answer = sc.next().charAt(0);
		}
		System.out.println("Thanks for using the program");
	}
	static int generateNumber(int x) {
	 	return x = rand.nextInt(1000);
	}
	static int enterGuess() {
		int x;
		return x = sc.nextInt();
	}
	static void displayMessage(int guess) {
		if (guess > randNum)
			System.out.println("Too High..");
		else if (guess < randNum)
			System.out.println("Too Low");
		else
			System.out.println("Congratulation, you guessed the number");
	}
}
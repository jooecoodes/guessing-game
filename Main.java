import java.util.*;
public class Main {
  /****************VARIABLES****************/
  static Scanner sc = new Scanner(System.in);
  static Random rand = new Random();
  static final int[] randnum = {4,3,2,1,0,-1,-2,-3,-4};
  static String[] deck = new String[20], forDeck = {"W", "S", "D", "B"}, selector = new String[20];
  static int randnum2, sentinel = 0, points = 0, sum = 0;
  /****************  MAIN  ****************/
  public static void main(String[] args) {
    newArray();
    selectArray();
    System.out.printf("|----------------------------------------------------------|%n");
    System.out.printf("                         PLAYING%n");
    System.out.printf("             HARRY POTTER AND THE AMAZING WIZARD%n");
    System.out.printf("|----------------------------------------------------------|%n");
    System.out.printf("|----------------WHAT DO YOU WANT TO DO?-------------------|%n");
    System.out.printf("|       [0] - QUIT        |        [1] - GENERATE MOVE     |%n");
    sentinel = sc.nextInt();
    while (sentinel != 0) {
        randnum2 = randnum[rand.nextInt(8)];
        if (randnum2 < 0) {
            System.out.printf("|------------------  YOUR MOVE IS: %d  --------------------|%n", randnum2);
            System.out.printf("|------------------  YOU'RE MOVING DOWN  ------------------|%n", randnum2); }
        else {
            System.out.printf("|------------------  YOUR MOVE IS: %d  ---------------------|%n", randnum2);
            System.out.printf("|------------------  YOU'RE MOVING UP  --------------------|%n", randnum2); }
        sum += randnum2;
        if (sum < 0)
            sum = 0;
        else if (sum > 19)
            sum = 19;
        selector[sum] = "^";
        System.out.println(Arrays.toString(deck).replace("[", "|").replace("]", "|").replace(",", "|"));
        System.out.println(Arrays.toString(selector).replace(",", " ").replace("[", "|").replace("]", "|"));
        if (deck[sum] == "W") {
            System.out.printf("|------------------YOU PICKED UP A WIZARD------------------|%n");
            System.out.printf("|------------------YOU RECEIVED 3 POINTS-------------------|%n");
            points += 3;
        } else if (deck[sum] == "S") {
            System.out.printf("|------------------YOU PICKED UP A SWORD-------------------|%n");
            System.out.printf("|------------------YOU RECEIVED 4 POINTS-------------------|%n");
            points += 4;
        } else if (deck[sum] == "D") {
            System.out.printf("|------------------A DEMON HAS ATTACKED!-------------------|%n");
            System.out.printf("|--------------------YOU LOST 5 POINTS---------------------|%n");
            points += -5;
        } else if (deck[sum] == "B") {
            System.out.printf("|------------------YOU PICKED A SAFE PLACE-----------------|%n");
            System.out.printf("|------------------YOU RECEIVED 2 POINTS-------------------|%n");
            points += 2;
        }
        System.out.printf("|----------------------------------------------------------|%n");
        System.out.printf("|----------------WHAT DO YOU WANT TO DO?-------------------|%n");
        System.out.printf("|       [0] - QUIT        |        [1] - GENERATE MOVE     |%n");
        sentinel = sc.nextInt();
        selectArray();
    }
    if (points < 0) {
          System.out.printf("|------------------YOUR TOTAL POINTS IS : %3d--------------|%n", points );
          System.out.printf("|----------------------YOU ARE KILLED----------------------|%n"); 
    } else {
        System.out.printf("|----------------------------------------------------------|%n");
        System.out.printf("|-------------------CONGRATULATIONS!-----------------------|%n");
        System.out.printf("|--------------------YOU WON THE GAME----------------------|%n");
        System.out.printf("|------            YOU EARNED %3d POINTS           --------|%n",points); }
  }
  /**************** METHODS ****************/
  static void newArray() {
    for (int i = 0; i < forDeck.length; i++) {
			int randomItoS = rand.nextInt(forDeck.length);
			String first = forDeck[randomItoS];
			forDeck[randomItoS] = forDeck[i];
			forDeck[i] = first;
		}
    for (int i = 0; i < 18; i+=4) {
      deck[i] = forDeck[0];
      deck[i+1] = forDeck[1];
      deck[i+2] = forDeck[2];
      deck[i+3] = forDeck[3];
    }

  }
  static void selectArray() {
      for (int i = 0; i < selector.length; i++)
        selector[i] = " ";
  }
}
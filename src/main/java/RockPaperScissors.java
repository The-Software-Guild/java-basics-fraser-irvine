import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        //initialise the scanner
        Scanner scanner = new Scanner(System.in);

        //start program with a do while loop to control if player wishes to play again
        boolean replay;
        do {

            replay = false;

            //get how many rounds with input validation
            int roundCount;
            do {
                System.out.println("How many rounds would you like to play?");
                do {
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error, value is not a number, try again");
                        scanner.next();
                    } else {
                        break;
                    }
                } while (true);

                roundCount = scanner.nextInt();
                if (roundCount <= 0 || roundCount > 10) {
                    System.out.println("error, round count out of bounds 1 - 10 try again");
                } else {
                    break;
                }
            } while (true);

            //store game history
            ArrayList<String> gameHistory = new ArrayList<>();

            //store win statistics
            int playerWins = 0;
            int computerWins = 0;
            int ties = 0;

            for (int i = 1; i <= roundCount; i++) {

                //make separator and round number
                System.out.println("=====================");
                System.out.println("Round: " + i);

                int playerMove;

                while (true) {
                    System.out.println("Choose your move:\n" +
                            "1) Rock\n" +
                            "2) Paper\n" +
                            "3) Scissors");

                    do {
                        if (!scanner.hasNextInt()) {
                            System.out.println("error, value is not a number, try again");
                            scanner.next();
                        } else {
                            break;
                        }
                    } while (true);
                    int selectedMove = scanner.nextInt();
                    //validate move is within bounds
                    if (selectedMove > 3 || selectedMove < 1) {
                        System.out.println("Invalid Move, try again");
                    } else {
                        playerMove = selectedMove;
                        break;
                    }
                }

                int computerMove = computerPlay();

                String result = roundOutcome(playerMove, computerMove);

                //announce the outcome of the round and increment statistics
                switch (result) {
                    case "Tie":
                        ties++;
                        gameHistory.add("Tie");
                        printRoundSummary(playerMove, computerMove);
                        System.out.println("Its a tie");
                        break;
                    case "Player Win":
                        playerWins++;
                        gameHistory.add("Player Win");
                        printRoundSummary(playerMove, computerMove);
                        System.out.println("You win this round");
                        break;
                    case "Computer Win":
                        computerWins++;
                        gameHistory.add("Computer Win");
                        printRoundSummary(playerMove, computerMove);
                        System.out.println("Computer wins this round");
                        break;
                }
            }

            //print game summary
            System.out.println(gameHistory);
            System.out.println("Player wins: " + playerWins);
            System.out.println("Computer wins: " + computerWins);
            System.out.println("Ties: " + ties);

            if (playerWins > computerWins) {
                System.out.println("You are the overall winner!");
            } else if (computerWins > playerWins) {
                System.out.println("The computer is the overall winner!");
            } else {
                System.out.println("The game has ended in a draw");
            }

            //check for player replay with input validation
            do {
                System.out.println("Would you like to play again? [yes/no]");
                String userInput = scanner.next();
                if (userInput.equals("yes")) {
                    replay = true;
                    break;
                } else if (userInput.equals("no")) {
                    System.out.println("Thank you for playing!");
                    break;
                } else {
                    System.out.println("invalid input, try again");
                }
            } while (true);

        } while (replay);

    }

    //method to output the summary of the round
    public static void printRoundSummary(int playerMove, int computerMove) {
        System.out.println("You played: " + getMoveName(playerMove) + "\nComputer Played: " + getMoveName(computerMove));
    }

    //method to randomly generate computer move
    public static int computerPlay() {
        Random rng = new Random();
        return rng.nextInt(3) + 1;
    }

    //method to easily convert "play ids" to the string counterpart
    //this method should never give errors as this method gets called with program generated parameters.
    public static String getMoveName(int play) {
        switch (play) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Error";
        }
    }

    //perform rock paper scissors logic
    public static String roundOutcome(int player, int computer) {
        if (player == computer) {
            return "Tie";
        } else if (player == 1 && computer == 3) {
            return "Player Win";
        } else if (player == 2 && computer == 1) {
            return "Player Win";
        } else if (player == 3 && computer == 2) {
            return "Player Win";
        } else {
            return "Computer Win";
        }
    }

}

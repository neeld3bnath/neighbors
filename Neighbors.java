import java.util.Scanner;

public class Neighbors {
    public static void main(String[] args) {
        Board playerBoard = new Board(5);
        Board computerBoard = new Board(5);
        Scanner scan = new Scanner(System.in);
        Rand compRand = new Rand(5, 5);
        Rand rand = new Rand(10);

        while (!playerBoard.isGridFull()) {
            int randomNum = rand.roll();
            System.out.println("Your board:");
            System.out.println(playerBoard.toString());
            System.out.printf("The random number is %d. Where are you going to place it? ", randomNum);
            System.out.println("Enter the coordinates of where you want to place it: x,y.");
            String input = scan.nextLine();

            String[] coordinates = input.split(",");
            boolean legalMove = playerBoard.isLegalMove(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            while (!legalMove) {
                System.out.println("Invalid move. Try again.");
                input = scan.nextLine();
                coordinates = input.split(",");
                legalMove = playerBoard.isLegalMove(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            }
            playerBoard.addNumberToBoard(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]),
                    randomNum);

            System.out.println("The computer is thinking...");
            int compX = compRand.getCompX()+1;
            int compY = compRand.getCompY()+1;
            

            boolean computerMove = computerBoard.isLegalMove(compX, compY);
            while (!computerMove) {
                compX = compRand.getCompX();
                compY = compRand.getCompY();
                computerMove = computerBoard.isLegalMove(compX, compY);
            }
            System.out.printf("Computer's move: %d, %d. ", compX, compY);
            computerBoard.addNumberToBoard(compX, compY, randomNum);

            System.out.println("Computer's board:");
            System.out.println(computerBoard.toString());

        }

        if (playerBoard.isGridFull()) {
            scan.close();
            System.out.println("Game over.");
            System.out.println("Tallying up the results...");
            System.out.println("Your board:");
            System.out.println(playerBoard.toString());
            System.out.println("Computer's board:");
            System.out.println(computerBoard.toString() + "\n");
            System.out.println("Your score: " + playerBoard.finalScore());
            System.out.println("Computer score: " + computerBoard.finalScore());
            if (playerBoard.finalScore() > computerBoard.finalScore()) {
                System.out.println("You win!");
            } else if (playerBoard.finalScore() < computerBoard.finalScore()) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("Impossible! It's a tie!");
            }

        }

    }
}

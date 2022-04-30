import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {

    public static void main (String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] gameBoard = new String[10];
        Arrays.fill(gameBoard, " ");
        boolean gameInPlay = true;
        boolean playersTurn = true;
        int playCount = 0;

        drawGameBoard(gameBoard);
        while (gameInPlay) {
            if (playersTurn) {
                System.out.print("Your Decision: ");
                int scannerSelection = scanner.nextInt();
                gameBoard[scannerSelection] = "X";
                playersTurn = false;
                playCount++;
            } else {
                computerSelection(random, gameBoard);
                playCount++;
                playersTurn = true;
            }
            drawGameBoard(gameBoard);
            gameInPlay = boardCheck(gameBoard);
        }
        if (playersTurn) System.out.println("Winner is : Computer");
        else System.out.println("Winner is : Player");
    }

    private static void computerSelection(Random random, String[] gameBoard) throws InterruptedException {
        int computerSelection = random.nextInt(1,9);
        while (!Objects.equals(gameBoard[computerSelection], " ")){
            computerSelection = random.nextInt(1,9);
        }
        gameBoard[computerSelection] = "0";
        Thread.sleep(1000);
        System.out.println("Computer Decision: "+ computerSelection);
        Thread.sleep(500);
    }

    private static boolean boardCheck(String[] gameBoard) {
        for(int xCheck = 1; xCheck < 8; xCheck+=3){
            if(gameBoard[xCheck].equals(gameBoard[xCheck+1]) && gameBoard[xCheck].equals(gameBoard[xCheck+2]) && gameBoard[xCheck]!= " ") return false;

        }
        for(int yCheck = 1; yCheck < 4; yCheck++){
            if(gameBoard[yCheck].equals(gameBoard[yCheck+3]) && gameBoard[yCheck].equals(gameBoard[yCheck+6])&& gameBoard[yCheck]!= " ") return false;
        }
        if(gameBoard[1].equals(gameBoard[5]) && gameBoard[1].equals(gameBoard[9])&& !gameBoard[1].equals(" ")) return false;
        return !gameBoard[3].equals(gameBoard[5]) || !gameBoard[3].equals(gameBoard[7]) || gameBoard[3].equals(" ");
    }

    private static void drawGameBoard(String[] gameBoard) {
        System.out.println("||===========||");
        System.out.println("|| "+ gameBoard[1]+" | "+ gameBoard[2]+" | "+ gameBoard[3]+" ||");
        System.out.println("||---|---|---||");
        System.out.println("|| "+ gameBoard[4]+" | "+ gameBoard[5]+" | "+ gameBoard[6]+" ||");
        System.out.println("||---|---|---||");
        System.out.println("|| "+ gameBoard[7]+" | "+ gameBoard[8]+" | "+ gameBoard[9]+" ||");
        System.out.println("||===========||");
    }
}

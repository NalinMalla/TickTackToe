package Socket_Programming.TickTackToe;

import java.util.ArrayList;
import java.util.Scanner;

public class TickTackToe {
    Scanner sc;
    char symbol = '?';
    char winner = '?';
    ArrayList<Integer> xCapturedBoxes;
    ArrayList<Integer> oCapturedBoxes;
    int[] bboxSize = {300, 300};
    int[][] frameBuffer;

    void setSymbol() {
        while (symbol == '?') {
            System.out.print("\033[H\033[2J");      // Clears output terminal
            System.out.println("TICK-TACK-TOE");
            System.out.println("-------------");
            System.out.print("Pick a symbol among the following alphabets: \nInput 'o' to make the first move.\nInput 'x' otherwise.\n>: ");
            symbol = sc.nextLine().charAt(0);

            if (symbol != 'x' & symbol != 'o') {
                symbol = '?';
                System.out.print("\033[H\033[2J");      // Clears output terminal
                System.out.println("Error: Invalid symbol input.");
                System.out.println("Press Enter to continue.");
                sc.nextLine();
            }
        }
    }

    TickTackToe() {
        sc = new Scanner(System.in);
        xCapturedBoxes = new ArrayList<>();
        oCapturedBoxes = new ArrayList<>();
        setSymbol();
    }

    void checkForWinner(Integer boxToCapture, ArrayList<Integer> capturedBox) {
        switch (boxToCapture) {
            case 1:
                if ((capturedBox.contains(2) && capturedBox.contains(3))
                        || (capturedBox.contains(4) && capturedBox.contains(7))
                        || (capturedBox.contains(5) && capturedBox.contains(9))
                ) {
                    winner = symbol;
                }

            case 2:
                if ((capturedBox.contains(1) && capturedBox.contains(3))
                        || (capturedBox.contains(5) && capturedBox.contains(8))
                ) {
                    winner = symbol;
                }

            case 3:
                if ((capturedBox.contains(2) && capturedBox.contains(1))
                        || (capturedBox.contains(6) && capturedBox.contains(9))
                        || (capturedBox.contains(5) && capturedBox.contains(7))
                ) {
                    winner = symbol;
                }

            case 4:
                if ((capturedBox.contains(5) && capturedBox.contains(6))
                        || (capturedBox.contains(1) && capturedBox.contains(7))
                ) {
                    winner = symbol;
                }

            case 5:
                if ((capturedBox.contains(4) && capturedBox.contains(6))
                        || (capturedBox.contains(2) && capturedBox.contains(8))
                        || (capturedBox.contains(1) && capturedBox.contains(9))
                        || (capturedBox.contains(3) && capturedBox.contains(7))
                ) {
                    winner = symbol;
                }

            case 6:
                if ((capturedBox.contains(5) && capturedBox.contains(4))
                        || (capturedBox.contains(3) && capturedBox.contains(9))
                ) {
                    winner = symbol;
                }

            case 7:
                if ((capturedBox.contains(8) && capturedBox.contains(9))
                        || (capturedBox.contains(4) && capturedBox.contains(1))
                        || (capturedBox.contains(5) && capturedBox.contains(3))
                ) {
                    winner = symbol;
                }

            case 8:
                if ((capturedBox.contains(7) && capturedBox.contains(9))
                        || (capturedBox.contains(5) && capturedBox.contains(2))
                ) {
                    winner = symbol;
                }

            case 9:
                if ((capturedBox.contains(8) && capturedBox.contains(7))
                        || (capturedBox.contains(6) && capturedBox.contains(3))
                        || (capturedBox.contains(5) && capturedBox.contains(1))
                ) {
                    winner = symbol;
                }

        }
    }

    void displayFrame() {

    }

    void play() {
        while (winner == '?') {
            displayFrame();

            System.out.print("Which box do you wish to capture between 1 to 9.\n>:");
            Integer boxToCapture = sc.nextInt();

            if (boxToCapture < 1 || boxToCapture > 9) {
                System.out.println("Error: Invalid Input.\nInput a number between 1 to 9.");
                System.out.println("Press Enter to continue.");
                sc.nextLine();
                continue;
            }

            if (oCapturedBoxes.contains(boxToCapture) && xCapturedBoxes.contains(boxToCapture)) {
                System.out.println("Box " + boxToCapture + " has already been captured.\nChoose a different box which is hasn't been claimed.");
                System.out.println("Press Enter to continue.");
                sc.nextLine();
                continue;
            }

            if (symbol == 'o') {
                oCapturedBoxes.add(boxToCapture);
                checkForWinner(boxToCapture, oCapturedBoxes);
            }

            if (symbol == 'x') {
                xCapturedBoxes.add(boxToCapture);
                checkForWinner(boxToCapture, xCapturedBoxes);
            }
        }

        System.out.println("GAME OVER");
        System.out.println("---------");
        System.out.println("Winner: " + winner);
        System.out.println("Press Enter to exit.");
        displayFrame();
        sc.nextLine();
    }

    public static void main(String[] args) {
        TickTackToe game = new TickTackToe();
        game.play();
    }
}

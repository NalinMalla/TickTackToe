package Socket_Programming.TickTackToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TickTackToe {
    Scanner sc;
    char symbol = '?';
    char winner = '?';
    Integer[] winningHand;
    String winningStreak = "";
    ArrayList<Integer> xCapturedBoxes;
    ArrayList<Integer> oCapturedBoxes;

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
                if (capturedBox.contains(2) && capturedBox.contains(3)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 2, 3};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(4) && capturedBox.contains(7)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 4, 7};
                    winningStreak = "vertical";
                }
                if (capturedBox.contains(5) && capturedBox.contains(9)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 5, 9};
                    winningStreak = "lDiagonal";
                }
                break;

            case 2:
                if (capturedBox.contains(1) && capturedBox.contains(3)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 2, 3};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(5) && capturedBox.contains(8)) {
                    winner = symbol;
                    winningHand = new Integer[]{2, 5, 8};
                    winningStreak = "vertical";
                }
                break;

            case 3:
                if (capturedBox.contains(2) && capturedBox.contains(1)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 2, 3};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(6) && capturedBox.contains(9)) {
                    winner = symbol;
                    winningHand = new Integer[]{3, 6, 9};
                    winningStreak = "vertical";
                }
                if (capturedBox.contains(5) && capturedBox.contains(7)) {
                    winner = symbol;
                    winningHand = new Integer[]{3, 5, 7};
                    winningStreak = "rDiagonal";
                }
                break;

            case 4:
                if (capturedBox.contains(5) && capturedBox.contains(6)) {
                    winner = symbol;
                    winningHand = new Integer[]{4, 5, 6};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(1) && capturedBox.contains(7)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 4, 7};
                    winningStreak = "vertical";
                }
                break;

            case 5:
                if (capturedBox.contains(4) && capturedBox.contains(6)) {
                    winner = symbol;
                    winningHand = new Integer[]{4, 5, 6};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(2) && capturedBox.contains(8)) {
                    winner = symbol;
                    winningHand = new Integer[]{2, 5, 8};
                    winningStreak = "vertical";
                }
                if (capturedBox.contains(1) && capturedBox.contains(9)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 5, 9};
                    winningStreak = "lDiagonal";
                }
                if (capturedBox.contains(3) && capturedBox.contains(7)) {
                    winner = symbol;
                    winningHand = new Integer[]{3, 5, 7};
                    winningStreak = "rDiagonal";
                }
                break;

            case 6:
                if (capturedBox.contains(5) && capturedBox.contains(4)) {
                    winner = symbol;
                    winningHand = new Integer[]{4, 5, 6};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(3) && capturedBox.contains(9)) {
                    winner = symbol;
                    winningHand = new Integer[]{3, 6, 9};
                    winningStreak = "vertical";
                }
                break;

            case 7:
                if (capturedBox.contains(8) && capturedBox.contains(9)) {
                    winner = symbol;
                    winningHand = new Integer[]{7, 8, 9};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(4) && capturedBox.contains(1)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 4, 7};
                    winningStreak = "vertical";
                }
                if (capturedBox.contains(5) && capturedBox.contains(3)) {
                    winner = symbol;
                    winningHand = new Integer[]{3, 5, 7};
                    winningStreak = "rDiagonal";
                }
                break;

            case 8:
                if (capturedBox.contains(7) && capturedBox.contains(9)) {
                    winner = symbol;
                    winningHand = new Integer[]{7, 8, 9};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(5) && capturedBox.contains(2)) {
                    winner = symbol;
                    winningHand = new Integer[]{2, 5, 8};
                    winningStreak = "vertical";
                }
                break;

            case 9:
                if (capturedBox.contains(8) && capturedBox.contains(7)) {
                    winner = symbol;
                    winningHand = new Integer[]{7, 8, 9};
                    winningStreak = "horizontal";
                }
                if (capturedBox.contains(6) && capturedBox.contains(3)) {
                    winner = symbol;
                    winningHand = new Integer[]{3, 6, 9};
                    winningStreak = "vertical";
                }
                if (capturedBox.contains(5) && capturedBox.contains(1)) {
                    winner = symbol;
                    winningHand = new Integer[]{1, 5, 9};
                    winningStreak = "lDiagonal";
                }
                break;
        }
    }

    class Display {
        String[][] frameBuffer;

        Display() {
            frameBuffer = new String[][]{
                    {"|   ", "|   ", "|   |"},
                    {"|   ", "|   ", "|   |"},
                    {"|   ", "|   ", "|   |"},
            };
        }

        int[] getBoxPosition(int box) {
            int row = (box - 1) / 3;
            int column = (box - 1) % 3;
            return new int[]{row, column};
        }

        void setWinningBoxInFrameBuffer(int box, char symbolToPrint) {
            int[] boxPosition = getBoxPosition(box);
            String boxGraphics = "";

            if (winningStreak.equals("vertical")) {
                boxGraphics = "||" + symbolToPrint + "||";
                if (boxPosition[1] != 2) {      // Last column
                    int[] adjacentBoxPosition = getBoxPosition(box + 1);
                    frameBuffer[adjacentBoxPosition[0]][adjacentBoxPosition[1]] = frameBuffer[adjacentBoxPosition[0]][adjacentBoxPosition[1]].substring(1);
                }
                frameBuffer[boxPosition[0]][boxPosition[1]] = boxGraphics;
            }
            if (winningStreak.equals("rDiagonal")) {
                if (box != 3) {
                    int[] adjacentBoxPosition = getBoxPosition(box + 1);
                    frameBuffer[adjacentBoxPosition[0]][adjacentBoxPosition[1]] = frameBuffer[adjacentBoxPosition[0]][adjacentBoxPosition[1]].substring(1);
                }
                boxGraphics = "/ " + symbolToPrint + " /";
                frameBuffer[boxPosition[0]][boxPosition[1]] = boxGraphics;
            }
            if (winningStreak.equals("lDiagonal")) {
                if (box != 9) {
                    int[] adjacentBoxPosition = getBoxPosition(box + 1);
                    frameBuffer[adjacentBoxPosition[0]][adjacentBoxPosition[1]] = frameBuffer[adjacentBoxPosition[0]][adjacentBoxPosition[1]].substring(1);
                }
                boxGraphics = "\\ " + symbolToPrint + " \\";
                frameBuffer[boxPosition[0]][boxPosition[1]] = boxGraphics;
            }
        }

        void setBoxInFrameBuffer(int box, char symbolToPrint) {
            int[] boxPosition = getBoxPosition(box);
            String boxGraphics = "";

            if (winner == '?' || winningStreak.equals("horizontal")) {
                boxGraphics = "| " + symbolToPrint + " ";
                if (boxPosition[1] == 2) {      // Last column
                    boxGraphics = "| " + symbolToPrint + " |";
                }
                frameBuffer[boxPosition[0]][boxPosition[1]] = boxGraphics;
            }

            if (winner == symbolToPrint && winningHand != null && Arrays.asList(winningHand).contains(box)) {
                for (int winningBox : winningHand) {
                    setWinningBoxInFrameBuffer(winningBox, symbolToPrint);
                }
            }
        }

        void displayHorizontalLine(int row, int lineType) {
            if (lineType == 1) {
                if (winningStreak.equals("horizontal") && winningHand != null && (Arrays.asList(winningHand).contains((row + 1) * 3) || Arrays.asList(winningHand).contains((row) * 3))) {
                    System.out.println("=============");
                } else {
                    System.out.println("-------------");
                }
            }

            if (lineType == 2) {
                if (winningStreak.equals("horizontal") && winningHand != null && Arrays.asList(winningHand).contains((row + 1) * 3)) {
                    System.out.println("=============");
                } else {
                    System.out.println("-------------");
                }
            }
        }

        void displayFrame() {
            for (int row = 0; row < 3; row++) {
                displayHorizontalLine(row, 1);
                for (int column = 0; column < 3; column++) {
                    System.out.print(frameBuffer[row][column]);
                }
                System.out.println();
            }
            displayHorizontalLine(2, 2);
        }
    }

    void play() {
        Display display = new Display();

        while (winner == '?') {
            System.out.print("\033[H\033[2J");      // Clears output terminal
            display.displayFrame();

            System.out.print("\nWhich box do you wish to capture between 1 to 9.\n>:");
            Integer boxToCapture = sc.nextInt();

            if (boxToCapture < 1 || boxToCapture > 9) {
                System.out.println("Error: Invalid Input.\nInput a number between 1 to 9.");
                System.out.println("Press Enter to continue.");
                sc.nextLine();
                continue;
            }

            if (oCapturedBoxes.contains(boxToCapture) || xCapturedBoxes.contains(boxToCapture)) {
                System.out.println("Box " + boxToCapture + " has already been captured.\nChoose a different box which is hasn't been claimed.");
                System.out.println("Press Enter to continue.");
                sc.nextLine();
                continue;
            }

            if (symbol == 'o') {
                oCapturedBoxes.add(boxToCapture);
                checkForWinner(boxToCapture, oCapturedBoxes);
                display.setBoxInFrameBuffer(boxToCapture, symbol);    // should be below checkForWinner()
            }

            if (symbol == 'x') {
                xCapturedBoxes.add(boxToCapture);
                checkForWinner(boxToCapture, xCapturedBoxes);
                display.setBoxInFrameBuffer(boxToCapture, symbol);    // should be below checkForWinner()
            }
        }

        System.out.print("\033[H\033[2J");      // Clears output terminal
        System.out.println("GAME OVER");
        System.out.println("---------");
        System.out.println("Winner: " + winner);
        display.displayFrame();
    }

    public static void main(String[] args) {
        TickTackToe game = new TickTackToe();
        game.play();
    }
}

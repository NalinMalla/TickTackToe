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

    void checkForWinner(){

    }

    void displayFrame(){

    }

    void play(){
        while (winner == '?'){
            checkForWinner();
            displayFrame();
            System.out.print("Which box do you wish to capture between 1 to 9.\n>:");
            Integer boxToCapture = sc.nextInt();
            if(oCapturedBoxes.contains(boxToCapture) && xCapturedBoxes.contains(boxToCapture)){
                System.out.println("Box "+boxToCapture+ " has already been captured.\nChoose a different box which is hasn't been claimed.");
                System.out.println("Press Enter to continue.");
                sc.nextLine();
                continue;
            }

            if(symbol=='o'){
                oCapturedBoxes.add(boxToCapture);
            }

            if(symbol=='x'){
                xCapturedBoxes.add(boxToCapture);
            }
        }

        System.out.println("GAME OVER");
        System.out.println("---------");
        System.out.println("Winner: " + winner);
        System.out.println("Press Enter to continue.");
        sc.nextLine();
    }

    public static void main(String[] args) {
        TickTackToe game = new TickTackToe();
        game.play();
    }
}

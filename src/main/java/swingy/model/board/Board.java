package swingy.model.board;

import java.util.Scanner;

import swingy.view.HeroView;

public class Board {
    int row = 8;
    int col = 8;
    String[][] board = new String[row][col];

    public void fillBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = " ";
            }
        }
        board[3][1] = "P";
        board[3][2] = "D";

        board[0][0] = "*";
        board[2][1] = "*";
        board[2][3] = "*";
        board[3][5] = "*";
        board[3][6] = "*";
        board[3][7] = "*";
        board[5][2] = "*";
        board[5][3] = "*";
        board[7][2] = "*";
        board[7][3] = "*";
        board[7][4] = "*";

        board[4][0] = "*";
        board[5][0] = "*";
        board[6][0] = "*";
        board[7][0] = "*";
        board[0][7] = "*";
        board[0][6] = "*";
    }

    public void presentBoard() {
        System.out.print("\033[H\033[2J");
        HeroView.GameHeading();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[ " + board[i][j] + " ]");
            }
            System.out.println();
        }
    }

    public void move() {
        int i = 0;
        int j = 0;

        System.out.println();
        System.out.println("** You have two options **");
        System.out.println(" [Fight]  : which engages him in a battle with the villain");
        System.out.println(
                " [Run]   : which gives him a 50% chance of returning to the previous position.\n      If the odds aren’t on his side, he must fight the villain.");
        System.out.println();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { 
            String input = in.nextLine();
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    if (board[i][j].equals("P")) {
                        break;
                    }
                }
                if (j != 8)
                    break;
            }

            if (input.equalsIgnoreCase("w")) {
                if (board[i - 1][j] != "*") {
                    board[i][j] = " ";
                    board[i - 1][j] = "P";
                }
            }
            if (input.equalsIgnoreCase("z")) {
                if (board[i + 1][j] != "*") {
                    board[i][j] = " ";
                    board[i + 1][j] = "P";
                }
            }
            if (input.equalsIgnoreCase("a")) {
                if (board[i][j - 1] != "*") {
                    board[i][j] = " ";
                    board[i][j - 1] = "P";
                }
            }
            if (input.equalsIgnoreCase("d")) {
                if (board[i][j + 1] != "*") {
                    board[i][j] = " ";
                    board[i][j + 1] = "P";
                }
            }
            System.out.print("\033[H\033[2J");
            HeroView.GameHeading();
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    System.out.print("[ " + board[i][j] + " ]" + " ");
                }
                System.out.println();
            }
        }
        in.close();
    }
}

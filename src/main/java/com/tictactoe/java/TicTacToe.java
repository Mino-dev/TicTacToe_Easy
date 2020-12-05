package com.tictactoe.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TicTacToe {
    
    char[][] field;
    final int SIDE = 3;
    int totalMoves;
    final void initGame() {
        field = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        totalMoves = 9;
    }
    public void showField(char symbol) {

        System.out.print(" ");
        for (int i = 0; i < SIDE; ++i) {
            System.out.printf("%2d ", i);
        }
        System.out.println("\n ---------");
        for (int i = 0; i < SIDE; ++i) {
            System.out.printf("%d| ", i);
            for (int j = 0; j < SIDE; ++j) {
                System.out.printf("%c " ,field[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(" ---------");

        System.out.printf("You are Player[%c]%n", symbol);
    }

    public boolean checkGame() {
        byte ret = getScores();
        if (ret != 0) {
            if (ret  == 10) {
                System.out.println("Player 1(X) Wins!");
            } else {
                System.out.println("Player 2(O) Wins!");
            }
            return true;
        } else if (totalMoves == 0) {
            System.out.println("It's a Draw!");
            return true;
        }
        return false;
    }
    public byte getScores() {
        for (int i = 0; i < SIDE; i++) {
            if(field[i][0] == field[i][1] && field[i][1]  == field[i][2]) {
                if (Character.isAlphabetic(field[i][0])) {
                    if (field[i][0] == 'X') {
                        return 10;
                    } else {
                        return -10;
                    }
                }
            }
        }
        for (int i = 0; i < SIDE; i++) {
            if(field[0][i] == field[1][i] && field[1][i]  == field[2][i]) {
                if (Character.isAlphabetic(field[0][i])) {
                    if (field[0][i] == 'X') {
                        return 10;
                    } else {
                        return -10;
                    }
                }
            }
        }
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            if (Character.isAlphabetic(field[0][0])) {
                if (field[0][0] == 'X') {
                    return 10;
                } else {
                    return -10;
                }
            }
        } else if (field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            if (Character.isAlphabetic(field[0][2])) {
                if (field[0][2] == 'X') {
                    return 10;
                } else {
                    return -10;
                }
            }
        }
        return 0;
    }
    void playGame(){

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            char symbol;
            boolean playerOne = true;
            initGame();
            do {
                symbol = playerOne ? 'X' : 'O';
                playerOne = !playerOne;
                boolean flag  = false;
                do {
                    showField(symbol);
                    System.out.print("Enter the coordinates of your input (e.g. 0 0): ");
                    try {
                        int[] input = Arrays.stream(br.readLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        System.out.println(input[0] + " - " + input[1]);
                        if (input[0] > SIDE || input[1] > SIDE ||
                                input[0] < 0 || input[1] < 0) {
                            System.out.println("You are out of bounds");
                        } else {
                            if (Character.isSpaceChar(field[input[0]][input[1]])) {
                                System.out.printf("Placing %c in %d %d %n", symbol, input[0], input[1]);
                                field[input[0]][input[1]] = symbol;
                                totalMoves--;
                                flag = true;
                            } else {
                                System.out.println("This cell is occupied. Choose another one!");
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Numbers only");
                    }
                } while (!flag);
            } while (!checkGame());
        } catch (IOException ignored) {}
    }

    public static void main(String[] args) {
        new TicTacToe().playGame();
    }
    
}

package com.tictactoe.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TicTacToe {
    
    int [] squares = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void board() {
        System.out.println("P1 = O\nP2 = X\n");
        System.out.println(squares[0]+" "+squares[1]+" "+squares[2]);
        System.out.println(squares[3]+" "+squares[4]+" "+squares[5]);
        System.out.println(squares[6]+" "+squares[7]+" "+squares[8]);
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
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            board();
            int turn = 1;
            int input;
            while (turn != 10){
                if (turn % 2 == 0){
                    System.out.print("\nP1 move (enter cell index): ");
                }else{
                    System.out.print("\nP2 move (enter cell index): ");
                }
                try{
                    input = Integer.parseInt(br.readLine());
                    while (index < 1 || index > 9 || squares[index - 1] != index){
                        if (turn % 2 == 0){
                            System.out.print("Invalid cell! P1 move: ");
                        }else{
                            System.out.print("Invalid cell! P2 move: ");
                        }
                    }
                    if (turn % 2 == 0){
                        squares[index - 1] = "O";
                    }else{
                        squares[index - 1] = "X"
                    }
                }catch(){
                    System.out.println("Numbers only");
                }
            }
            
            /**
            do {
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
            */
            
        } catch (IOException ignored) {}
    }
    
}

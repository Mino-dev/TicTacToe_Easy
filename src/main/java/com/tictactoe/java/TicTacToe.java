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
    public boolean check(){
        int [] ranges = new int[]{0,7,3}
        for(int i = 0; i < 3; i ++){
            if (squares[ranges[i]] == squares[ranges[i] + 1] == squares[ranges[i] + 2]){
                if (turn % 2 != 0){
                    System.out.println("P1 wins YAY!");
                }else{
                    System.out.println("P2 wins YAY!");
                }
                return true;
            }
        }
        for (int i=0; i < 3; i ++){
            if (squares[i] == squares[i + 3] || squares[i + 3] == squares[i + 6]){
                if (turn % 2 != 0){
                    System.out.println("P1 wins YAY!");
                }else{
                    System.out.println("P2 wins YAY!");
                }
                return true;
            }
        }
        ranges = new int[]{0,3,2};
        for(int i = 0; i < 3; i ++){
            if (squares[ranges[i]] == squares[4] == squares[ranges[i] + (8 - 2 * i)]){
                if (turn % 2 != 0){
                    System.out.println("P1 wins YAY!");
                }else{
                    System.out.println("P2 wins YAY!");
                }
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            board();
            int turn = 1;
            int input;
            if (turn % 2 == 0){
                System.out.print("\nP1 move (enter cell index): ");
            }else{
                System.out.print("\nP2 move (enter cell index): ");
            }
            while (turn != 10){
                try{
                    input = Integer.parseInt(br.readLine());
                    while (index < 1 || index > 9 || squares[index - 1] != index){
                        if (turn % 2 == 0){
                            System.out.println("Invalid cell! P1 move: ");
                        }else{
                            System.out.println("Invalid cell! P2 move: ");
                        }
                        input = Integer.parseInt(br.readLine());
                    }
                    if (turn % 2 != 0){
                        squares[index - 1] = "O";
                    }else{
                        squares[index - 1] = "X"
                    }
                    if (check(squares)){
                        board();
                        if (turn % 2 != 0){
                            System.out.println("P1 wins YAY!");
                        }else{
                            System.out.println("P2 wins YAY!");
                        }
                        break;
                    }
                    board();
                    if (turn != 9){
                        turn += 1;
                    }else{
                        System.out.println("DRAW");
                        break;
                    }
                }catch(){
                    System.out.println("Numbers only");
                    if (turn % 2 == 0){
                        System.out.println("Invalid cell! P1 move: ");
                    }else{
                        System.out.println("Invalid cell! P2 move: ");
                    }
                }
            }
        } catch (IOException ignored) {}
    }
    
}

/* -*- coding: utf-8 -*-
Created on Jan 30 14:26:57 2020

Purpous of this lab is touse more object oriented aproaches to this lab without useing any inheritance*/

import java.util.Scanner;

class Lab02 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean Repeat = true;
        while(Repeat){
            System.out.println("What Are your Chess Pieces Attributes?");
            System.out.println("Type of Piece");
            String type = userInput.next();
            System.out.println("Color of Piece");
            String color = userInput.next();
            System.out.println("X position of Piece (a-h)");
            String xPosString = userInput.next();
            /*if(!"a".equalsIgnoreCase(xPos) || !"b".equalsIgnoreCase(xPos) || !"c".equalsIgnoreCase(xPos) || !"d".equalsIgnoreCase(xPos) || !"e".equalsIgnoreCase(xPos) || !"f".equalsIgnoreCase(xPos) || !"g".equalsIgnoreCase(xPos) || !"h".equalsIgnoreCase(xPos)){
                System.out.println("Not a valid position. Need to start over.");
                continue;
            }*/
            char xPos = xPosString.charAt(0);
            System.out.println("Y position of Piece(1-8)");
            int yPos = userInput.nextInt();
            /*if(yPos != 1 ||yPos != 2 ||yPos != 3 ||yPos != 4 ||yPos != 5 ||yPos != 6 ||yPos != 7 ||yPos != 8){
                System.out.println("Not a valid position. Need to start over.");
                continue;
            }*/
            System.out.println("");
            System.out.println("Where would you like to move the piece?");
            System.out.println("EX): D4 ");
            String newPos = userInput.next();
            switch(type) {
                case "rook":
                                RookObj rookPiece = new RookObj(type, color, xPos, yPos);
                                rookPiece.isValidMove(newPos);
                                break;
                case "queen":
                                QueenObj queenPiece = new QueenObj(type, color, xPos, yPos);
                                queenPiece.isValidMove(newPos);
                                break;
                case "king":
                                KingObj kingPiece = new KingObj(type, color, xPos, yPos);
                                kingPiece.isValidMove(newPos);
                                break;
                case "bishop":
                                BishopObj bishopPiece = new BishopObj(type, color, xPos, yPos);
                                bishopPiece.isValidMove(newPos);
                                break;
                case "knight":
                                KnightObj knightPiece = new KnightObj(type, color, xPos, yPos);
                                knightPiece.isValidMove(newPos);
                                break;
                case "pawn":
                                PawnObj pawnPiece = new PawnObj(type, color, xPos, yPos);
                                pawnPiece.isValidMove(newPos);
                                break;
            }
            System.out.println("If you want to exit now type 'exit'");
            System.out.println("If you want to try another piece type 'continue' ");
            String exitOption = userInput.next();
            if(exitOption.equalsIgnoreCase("exit")){
                Repeat = false;
            }
        }
        
    }
}
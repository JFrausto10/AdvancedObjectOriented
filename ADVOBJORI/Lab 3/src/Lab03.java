/* -*- coding: utf-8 -*-
Created on Feb 9 14:26:57 2020

The goal of this lab is to read a file and useing polymorphism, determin if the user defined pathng is a valid move or not.
author: Justus Frausto*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Lab03 {
    // reads file and returns list of type string[]
    public static List<String[]> readChessBoard()throws IOException {
        List<String[]> wholeFile = new ArrayList<String[]>();// This is an array list used to prevent having to read the file twice.
        FileReader inFile = new FileReader("chessList.txt");
        BufferedReader inStream = new BufferedReader(inFile);
        while (inStream.ready()) {
            String[] curLine = inStream.readLine().split(",");
            for (int i = 0; i < curLine.length; i++) {
                curLine[i] = curLine[i].trim(); // this removes the uneven spaces in the inventory file
            }
            wholeFile.add(curLine);
        }
        inStream.close();
        return wholeFile;
    }

    public static chessPiece[] determineValidity(String newPos, List<String[]> wholeFile){
        chessPiece[] Piece = new chessPiece[wholeFile.size()];
        int counter = 0;
        for(String[] curLine: wholeFile){// for every line in wholefile it reads the data and creates new object type of correct type
            String rankName = curLine[0];
            curLine[0] = curLine[0].substring(0, curLine[0].length() - 2);// removes piece location in rankTypename
            switch(curLine[0]) {
                case "Rook":
                    rook rookPiece = new rook(curLine[0], curLine[1], curLine[2].charAt(0), Integer.parseInt(curLine[3]), rankName);
                    rookPiece.isValidMove(newPos);
                    Piece[counter] = rookPiece;
                    break;
                case "Queen":
                    queen queenPiece = new queen(curLine[0], curLine[1], curLine[2].charAt(0), Integer.parseInt(curLine[3]), rankName);
                    queenPiece.isValidMove(newPos);
                    Piece[counter] = queenPiece;
                    break;
                case "King":
                    king kingPiece = new king(curLine[0], curLine[1], curLine[2].charAt(0), Integer.parseInt(curLine[3]), rankName);
                    kingPiece.isValidMove(newPos);
                    Piece[counter] = kingPiece;
                    break;
                case "Bishop":
                    bishop bishopPiece = new bishop(curLine[0], curLine[1], curLine[2].charAt(0), Integer.parseInt(curLine[3]), rankName);
                    bishopPiece.isValidMove(newPos);
                    Piece[counter] = bishopPiece;
                    break;
                case "Knight":
                    knight knightPiece = new knight(curLine[0], curLine[1], curLine[2].charAt(0), Integer.parseInt(curLine[3]), rankName);
                    knightPiece.isValidMove(newPos);
                    Piece[counter] = knightPiece;
                    break;
                case "Pawn":
                    pawn pawnPiece = new pawn(curLine[0], curLine[1], curLine[2].charAt(0), Integer.parseInt(curLine[3]), rankName);
                    pawnPiece.isValidMove(newPos);
                    Piece[counter] = pawnPiece;
                    break;
            }
            counter++;
        }
        return Piece;
    }

    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String[]> wholeFile = readChessBoard();
        System.out.println("What position do you want to check all the pieces for?");
        System.out.println("EX): D4 ");
        String userPos = scanner.next();
        chessPiece[] pieceArray = determineValidity(userPos, wholeFile);
        System.out.println();
        System.out.println("This list is just to show i have different objects in a single array");
        for(chessPiece a : pieceArray){
            String rank = a.getRank();
            System.out.println(rank);
        }
    }
}

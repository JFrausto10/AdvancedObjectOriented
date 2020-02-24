/* -*- coding: utf-8 -*-
Created on Tue Jan 21 14:26:57 2020

Purpous of this lab is to take input file and verify pathing that is user submitted.
author: Justus Frausto*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Lab01 {

    //takes file name and reads/assigns it to an array
    public static ChessPieceObj[] readChessBoard()throws IOException {
        List<String[]> wholeFile = new ArrayList<String[]>();// This is an array list used to prevent having to read the file twice.
        FileReader inFile = new  FileReader("Lab01/WarmUp-Lab01/ChessPos.txt");
        BufferedReader inStream = new BufferedReader(inFile);
        while (inStream.ready()){
            String[] curLine = inStream.readLine().split(",");
            for (int i = 0; i < curLine.length; i++) {
                curLine[i] = curLine[i].trim(); // this removes the uneven spaces in the inventory file
            }
            wholeFile.add(curLine);
        }
        inStream.close();
        ChessPieceObj[] Piece = new ChessPieceObj[wholeFile.size()];
        int counter = 0;
        for(String[] curLine: wholeFile){
            Piece[counter] = new ChessPieceObj(curLine[0], curLine[1], curLine[2], curLine[3]);
            counter++;
        }
        return Piece;
    }

    //Takes current Chesspiece Object and determines its rank.
    public static String checkPieceType(ChessPieceObj currPiece){
        String rank = currPiece.getRank();
        return rank;
    }

    // takes a string and converts it to its number equivalent.
    public static int yPositionChartoInt(String yPos){
        switch(yPos){
            case "A"    :   return 0;
            case "B"    :   return 1;
            case "C"    :   return 2;
            case "D"    :   return 3;
            case "E"    :   return 4;
            case "F"    :   return 5;
            case "G"    :   return 6;
            case "H"    :   return 7;
        }
        return -1;
    }

    //Depending on the Rank of the ChessPiece this method routs it to the correct method to determine pathing.
    public static void determinPathing(String Rank, ChessPieceObj currPiece, String userPos){
        switch(Rank){
            case "Pawn"  :  pawnMoveCheck(currPiece,userPos);
                            break;
            case "Queen" :  queenMoveCheck(currPiece,userPos);
                            break;
            case "Rook"  :  rookMoveCheck(currPiece,userPos);
                            break;
            case "Knight":  knightMoveCheck(currPiece,userPos);
                            break;
            case "Bishop":  bishopMoveCheck(currPiece,userPos);
                            break;
            case "King"  :  kingMoveCheck(currPiece,userPos);
                            break;
        }
    }

    //This Method checks the validity of the pawns move
    public static void pawnMoveCheck(ChessPieceObj currPiece, String userPos){
        try {
            String[] DefinedPos = userPos.split(" ");
            int yPos = yPositionChartoInt(DefinedPos[0]);
            int xPos = Integer.parseInt(DefinedPos[1]);
            if(yPos != currPiece.getYLocation()){
                System.out.println("Not a valid move for PAWN");
            }
            else if(xPos > xPos-currPiece.getXLocation()){
                System.out.println("Not a valid move for PAWN");
            }
            else{
                System.out.println("This is a valid move for PAWN");
            }

        }
        catch (Exception e){
            System.out.println("Not a valid move for PAWN");
        }
    }

    //This Method checks the validity of the queens move
    public static void queenMoveCheck(ChessPieceObj currPiece, String userPos){
        try{
            int[][] chessBoard = new int[8][8];
            for (int x = 0; x < chessBoard.length; x++){
                for (int y = 0; y < chessBoard[0].length; y++) {
                    chessBoard[x][y] = 0;
                }
            }
            String[] DefinedPos = userPos.split(" ");
            int yPos = yPositionChartoInt(DefinedPos[0]);
            int xPos = Integer.parseInt(DefinedPos[1]);
            chessBoard[currPiece.getYLocation()][currPiece.getXLocation()] = 1;
            chessBoard[xPos][yPos] = 1;
            if ((yPos == currPiece.getXLocation()) ||(xPos == currPiece.getYLocation())){
                System.out.println("This is a valid move for QUEEN");
            }

        }
        catch (Exception e){
            System.out.println("Not a valid move for QUEEN");
        }
    }

    //This Method checks the validity of the rooks move
    public static void rookMoveCheck(ChessPieceObj currPiece, String userPos){
        try{
            String[] DefinedPos = userPos.split(" ");
            int yPos = yPositionChartoInt(DefinedPos[0]);
            int xPos = Integer.parseInt(DefinedPos[1]);
            if ((yPos == currPiece.getXLocation()) ||(xPos == currPiece.getYLocation())){
                System.out.println("This is a valid move for ROOK");
            }
        }
        catch (Exception e){
            System.out.println("Not a valid move for ROOK");
        }
    }

    //This Method checks the validity of the knights move
    public static void knightMoveCheck(ChessPieceObj currPiece, String userPos){
        try{
            int[][] chessBoard = new int[8][8];
            for (int x = 0; x < chessBoard.length; x++){
                for (int y = 0; y < chessBoard[0].length; y++) {
                    chessBoard[x][y] = 0;
                }
            }
            String[] DefinedPos = userPos.split(" ");
            int yPos = yPositionChartoInt(DefinedPos[0]);
            int xPos = Integer.parseInt(DefinedPos[1]);
            chessBoard[currPiece.getYLocation()][currPiece.getXLocation()] = 1;
            chessBoard[xPos][yPos] = 1;
            if (knightMoveCheckHelper(chessBoard, currPiece)){
                System.out.println("This is a valid move for KNIGHT");
            }
            else {
                System.out.println("Not a valid move for KNIGHT");
            }
        }
        catch (Exception e){
            System.out.println("Not a valid move for KNIGHT");
        }
    }

    //This Method helps the knightMoveCheck by returning a boolean value if the conditions for truth are met
    public static boolean knightMoveCheckHelper(int[][] chessBoard, ChessPieceObj curPiece){
        if(chessBoard[curPiece.getYLocation() + 2][curPiece.getXLocation()+1] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation() + 2][curPiece.getXLocation() - 1] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation() + 1][curPiece.getXLocation()+2] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation() + 1][curPiece.getXLocation()-2] == 1){
            return true;
        }
        else{
            return false;
        }
    }

    //This Method checks the validity of the bishops move
    public static void bishopMoveCheck(ChessPieceObj currPiece, String userPos){
        try{
            int[][] chessBoard = new int[8][8];
            for (int x = 0; x < chessBoard.length; x++){
                for (int y = 0; y < chessBoard[0].length; y++) {
                    chessBoard[x][y] = 0;
                }
            }
            String[] DefinedPos = userPos.split(" ");
            int yPos = yPositionChartoInt(DefinedPos[0]);
            int xPos = Integer.parseInt(DefinedPos[1]);
            chessBoard[currPiece.getYLocation()][currPiece.getXLocation()] = 1;
            chessBoard[xPos][yPos] = 1;
            System.out.println("Not a valid move for BISHOP");
        }
        catch (Exception e){
            System.out.println("Not a valid move for BISHOP");
        }
    }

    //This Method checks the validity of the kings move
    public static void kingMoveCheck(ChessPieceObj currPiece, String userPos){
        try{
            int[][] chessBoard = new int[8][8];
            for (int x = 0; x < chessBoard.length; x++){
                for (int y = 0; y < chessBoard[0].length; y++) {
                    chessBoard[x][y] = 0;
                }
            }
            String[] DefinedPos = userPos.split(" ");
            int yPos = yPositionChartoInt(DefinedPos[0]);
            int xPos = Integer.parseInt(DefinedPos[1]);
            chessBoard[currPiece.getYLocation()][currPiece.getXLocation()] = 1;
            chessBoard[xPos][yPos] = 1;
            if (kingMoveCheckHelper(chessBoard, currPiece)){
                System.out.println("This is a valid move for KING");
            }
            else {
                System.out.println("Not a valid move for KING");
            }
        }
        catch (Exception e){
            System.out.println("Not a valid move for KING");
        }
    }

    //This Method helps the kingMoveCheck by returning a boolean value if the conditions for truth are met
    public static boolean kingMoveCheckHelper(int[][] chessBoard, ChessPieceObj curPiece){
        if(chessBoard[curPiece.getYLocation()][curPiece.getXLocation()+1] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation()+1][curPiece.getXLocation()+1] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation()+1][curPiece.getXLocation()] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation()+1][curPiece.getXLocation()-1] == 1){
            return true;
        }
        else if(chessBoard[curPiece.getYLocation()][curPiece.getXLocation()-1] == 1){
            return true;
        }
        else{
            return false;
        }
    }

    //Main Method
    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(System.in);
        ChessPieceObj[] chessPieces = readChessBoard();
        System.out.println("Here are all the piece in the list");
        for(ChessPieceObj a : chessPieces){
            System.out.println(a.getRank() + ", ");
        }
        System.out.println("What position do you want to check?");
        String userPos = scanner.next();
        for(ChessPieceObj a : chessPieces){
            String rank = checkPieceType(a);
            determinPathing(rank, a, userPos);
        }

    }
}
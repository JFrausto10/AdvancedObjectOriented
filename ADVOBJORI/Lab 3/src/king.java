public class king extends chessPiece{

    private String rankName;

    public king() {}

    public king(String Rank, String Color, char xLocation, int yLocation, String rankName){
        this.setRank(Rank);
        this.setColor(Color);
        this.setxLocation(xLocation);
        this.setyLocation(yLocation);
        this.rankName = rankName;
    }
    @Override
    public String getRank(){
        return rankName;
    }

    public void isValidMove(String newPos){
        try {
            int newXPos = this.charToInt(newPos.charAt(0));
            int newYPos = newPos.charAt(1) - 1;
            if ((newXPos == this.getXLocation()) && (newYPos == this.getYLocation())) {
                System.out.println("This is the same location");
            }
            int[][] chessBoard = new int[8][8];
            for (int x = 0; x < chessBoard.length; x++) {
                for (int y = 0; y < chessBoard[0].length; y++) {
                    chessBoard[x][y] = 0;
                }
            }
            chessBoard[this.getXLocation()][this.getYLocation()] = 1;
            chessBoard[newXPos][newYPos] = 1;
            if (kingMoveCheckHelper(chessBoard)) {
                System.out.println("This is a valid move for " + rankName);
            } else {
                System.out.println("This is not a valid move for " + rankName);
            }
        }
        catch (Exception e){
            System.out.println("This is not a valid move for " + rankName);
        }
    }

    private boolean kingMoveCheckHelper(int[][] chessBoard){
        if(chessBoard[this.getXLocation()][this.getYLocation()+1] == 1){
            return true;
        }
        else if(chessBoard[this.getXLocation()+1][this.getYLocation()+1] == 1){
            return true;
        }
        else if(chessBoard[this.getXLocation()+1][this.getYLocation()] == 1){
            return true;
        }
        else if(chessBoard[this.getXLocation()+1][this.getYLocation()-1] == 1){
            return true;
        }
        else if(chessBoard[this.getXLocation()][this.getYLocation()-1] == 1){
            return true;
        }
        else{
            return false;
        }
    }
}

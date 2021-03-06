class BishopObj {
    private String Rank;
    private String Color;
    private int yLocation;
    private int xLocation;

    public BishopObj() {}

    public BishopObj(String Rank, String Color, char xLocation, int yLocation){
        this.Rank = Rank;
        this.Color = Color;
        switch (xLocation){
            case 'A':   this.xLocation = 0;
                break;
            case 'B':   this.xLocation = 1;
                break;
            case 'C':   this.xLocation = 2;
                break;
            case 'D':   this.xLocation = 3;
                break;
            case 'E':   this.xLocation = 4;
                break;
            case 'F':   this.xLocation = 5;
                break;
            case 'G':   this.xLocation = 5;
                break;
            case 'H':   this.xLocation = 5;
                break;
        }
        this.yLocation = yLocation-1;
    }

    public String getRank(){
        return Rank;
    }

    public String getColor(){
        return Color;
    }

    public int getYLocation(){
        return yLocation;
    }

    public int getXLocation(){
        return xLocation;
    }

    public void isValidMove(String newPos){
        int newXPos = letterToIntHelper(newPos.charAt(0));
        int newYPos = newPos.charAt(1)-1;
        int[][] chessBoard = new int[8][8];
        for (int x = 0; x < chessBoard.length; x++){
            for (int y = 0; y < chessBoard[0].length; y++) {
                chessBoard[x][y] = 0;
            }
        }
        chessBoard[this.xLocation][this.yLocation] = 1;
        chessBoard[newXPos][newYPos] = 1;
        int counter = 1;
        try {
            for (int xLoc = this.xLocation; xLoc < 8; xLoc++) {
                if (chessBoard[xLoc][this.yLocation + counter] == 1) {
                    System.out.println("This is a valid move.");
                }
                counter++;
            }
        }
        catch(Exception e){
            System.out.println("This is not a valid move.");
        }
    }

    private int letterToIntHelper(char xPosChar){
        int xPos;
        switch (xPosChar){
            case 'A':   xPos = 0;
                return xPos;
            case 'B':   xPos = 1;
                return xPos;
            case 'C':   xPos = 2;
                return xPos;
            case 'D':   xPos = 3;
                return xPos;
            case 'E':   xPos = 4;
                return xPos;
            case 'F':   xPos = 5;
                return xPos;
            case 'G':   xPos = 5;
                return xPos;
            case 'H':   xPos = 5;
                return xPos;
        }
        return -1;
    }

}
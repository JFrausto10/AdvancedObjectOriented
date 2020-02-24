class QueenObj {
    private String Rank;
    private String Color;
    private int yLocation;
    private int xLocation;

    public QueenObj() {}

    public QueenObj(String Rank, String Color, char xLocation, int yLocation){
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
        if(newXPos == this.xLocation || newYPos == this.yLocation){  //same code as rook and bishop
            System.out.println("This is a Valid Move.");
        }
        else{
            System.out.println("This is Not a valid move.");
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
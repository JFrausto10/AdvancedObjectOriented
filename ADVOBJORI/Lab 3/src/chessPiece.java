public class chessPiece{
    private String rank;
    private String color;
    private int yLocation;
    private int xLocation;

    public chessPiece(){}

    public chessPiece(String Rank, String Color, char xLocation, int yLocation){
        this.rank = Rank;
        this.color = Color;
        this.xLocation = charToInt(xLocation);
        this.yLocation = yLocation-1;
    }

    public void setRank(String rank){this.rank = rank;}

    public void setColor(String color){this.color = color;}

    public void setxLocation(char xLocation){this.xLocation = charToInt(xLocation);}

    public void setyLocation(int yLocation){this.yLocation = yLocation;}

    public String getRank(){
        return rank;
    }

    public int getYLocation(){
        return yLocation;
    }

    public int getXLocation(){
        return xLocation;
    }

    public int charToInt(char Char){
        switch (Char){
            case 'A':   return 0;
            case 'B':   return 1;
            case 'C':   return 2;
            case 'D':   return 3;
            case 'E':   return 4;
            case 'F':   return 5;
            case 'G':   return 6;
            case 'H':   return 7;
            case 'a':   return 0;
            case 'b':   return 1;
            case 'c':   return 2;
            case 'd':   return 3;
            case 'e':   return 4;
            case 'f':   return 5;
            case 'g':   return 6;
            case 'h':   return 7;
        }
        return -1;
    }

}

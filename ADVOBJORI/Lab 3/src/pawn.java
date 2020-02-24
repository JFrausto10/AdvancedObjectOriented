public class pawn extends chessPiece {

    private String rankName;

    public pawn() {
    }

    public pawn(String Rank, String Color, char xLocation, int yLocation, String rankName){
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
        int newXPos = charToInt(newPos.charAt(0));
        int newYPos = newPos.charAt(1)-1;
        if((newXPos == this.getXLocation()) && (newYPos == this.getYLocation())){
            System.out.println("This is the same location");
        }
        if(newXPos != this.getXLocation()){
            System.out.println("This is not a valid move for " + rankName);
        }
        else if(newYPos > (this.getYLocation() + 2)){
            System.out.println("This is not a valid move for " + rankName);
        }
        else{
            System.out.println("This is a valid move for " + rankName);
        }
    }

}

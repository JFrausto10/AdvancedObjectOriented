public class bishop extends chessPiece {

    private String rankName;

    public bishop() {
    }

    public bishop(String Rank, String Color, char xLocation, int yLocation, String rankName){
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

    public void isValidMove(String newPos) {
        int newXPos = this.charToInt(newPos.charAt(0));
        int newYPos = newPos.charAt(1)-1;
        if((newXPos == this.getXLocation()) && (newYPos == this.getYLocation())){
            System.out.println("This is the same location");
        }
        if ((newXPos - this.getXLocation()) == (newYPos - this.getYLocation())) {
            System.out.println("This is a Valid Move for " + rankName);
        } else {
            System.out.println("This is Not a valid move for " + rankName);
        }

    }
}
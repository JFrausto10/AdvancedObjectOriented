class ChessPieceObj {
    private String Rank;
    private String Color;
    private int YLocation;
    private int XLocation;

    public ChessPieceObj(String Rank, String Color, String YLocation, String XLocation){
        this.Rank = Rank;
        this.Color = Color;
        char caseVariable = YLocation.charAt(0);
        switch (caseVariable){
            case 'A':   this.YLocation = 0;
                        break;
            case 'B':   this.YLocation = 1;
                        break;
            case 'C':   this.YLocation = 2;
                        break;
            case 'D':   this.YLocation = 3;
                        break;
            case 'E':   this.YLocation = 4;
                        break;
        }
        this.XLocation = Integer.parseInt(XLocation);
    }

    public String getRank(){
        return Rank;
    }

    public int getYLocation(){
        return YLocation;
    }

    public int getXLocation(){
        return XLocation;
    }

}
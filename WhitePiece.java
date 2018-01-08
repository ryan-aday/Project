
public class WhitePiece extends Pieces{

    private int x, y;
    private int color=1;
    private int numValidMoves;
    private int[] allPoints={};

    public void showValidMoves(){}

    public void setColor(int x, int y){
	super.colors[x][y]=color;
    }

    public void addToPoints(int x, int y){
	int[] point={x+10*y};
        int[] comb= new int[allPoints.length+1];
	for (int count=0; count<comb.length-1; count++){
	    comb[count]=allPoints[count];
	}comb[comb.length-1]=point[0];
	allPoints=comb;
    }
    
    public int getX(int loc){
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (super.locations[rcount][ccount]==loc){
		    return rcount;
		}
	    }
	}
	return -1;
    }

    public int getY(int loc){
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (super.locations[rcount][ccount]==loc){
		    return ccount;
		}
	    }
	}
	return -1;
    }

    public void flip(){}

    public WhitePiece(int x, int y){}
}


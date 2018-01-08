
public class BlackPiece extends Pieces{

    private int x, y;
    private int color=0;
    private int numValidMoves;
    private int[] allPoints={};

    public void showValidMoves(){}

    public void setColor(int x, int y){
	super.colors[x][y]=0;
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

    public BlackPiece(int x, int y){}
}

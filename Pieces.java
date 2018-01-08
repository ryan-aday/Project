public abstract class Pieces{
    public int[][] locations={ {11, 12, 13, 14, 15, 16, 17, 18},
				{21, 22, 23, 24, 25, 26, 27, 28},
				{31, 32, 33, 34, 35, 36, 37, 38},
				{41, 42, 43, 44, 45, 46, 47, 48},
				{51, 52, 53, 54, 55, 56, 57, 58},
				{61, 62, 63, 64, 65, 66, 67, 68},
				{71, 72, 73, 74, 75, 76, 77, 78},
				{81, 82, 83, 84, 85, 86, 87, 88}};
    public int[][] colors= new int[8][8];
    
    abstract void showValidMoves();

    private int getColor(int loc){
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (locations[rcount][ccount]==loc){
		    return colors[rcount][ccount];
		}
	    }
	}
	return -1;
    }

    abstract void setColor(int x, int y);

    abstract void addToPoints(int x, int y);

    abstract void flip();

}

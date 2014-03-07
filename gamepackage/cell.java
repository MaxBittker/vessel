package gamepackage;

import gamepackage.entities.Entity;

public class cell {

	public int x, y;
	   
	public int color= 000000;
	public int medium = 0; //0 = dirt, 1 = air, 2 = occupido?
	public Entity Resident;

	public cell(int xf, int yf, int colorf, int mediumf) {
	    x = xf;
	    y = yf;
	    medium = mediumf;
	    color = colorf*medium;
	}
		




	
}

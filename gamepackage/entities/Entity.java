package gamepackage.entities;

import java.awt.Color;

import gamepackage.GameClass;
import gamepackage.cell;

public abstract class Entity {

	public int x, y;
	
	public int color= 000000;
	
	public int life = 0;

	public int ready= 0;
	
	
	
	public Entity(int xf, int yf, int colorf, int lifef) {
	    x = xf;
	    y = yf;
	    color = colorf;
	    life = lifef;
	    //body[0] = bitMap[xf][yf];
	}
	
	public abstract void tick();
	
	public abstract void birth();
	
	public abstract void kill();



	public abstract void move(int x, int y);

	
	
		



	
}

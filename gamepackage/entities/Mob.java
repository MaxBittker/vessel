package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;


public class Mob extends Entity {
	
	//public cell[] body = new cell[10];
	public cell body;
	public int decision;
	
	public Mob(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		body = bitMap.Map[xf][yf];
		body.color = colorf;
		// TODO Auto-generated constructor stub
	}
	
	
	public void birth(){
	life = 1000;
	color =(int) Math.floor(Math.random()*999999);
	}
	
	public void kill(){
	    if (life == 0){ 
	    	color = 000000;}
	}
	

	
	
	public void tick(){
	decision = (int)Math.random()*4;
      switch (decision) {
          case 0: move(1,1);
                   break;
          case 1: move(1,-1);
                   break;
          case 2:  move(-1,1);
                   break;
          case 3: move(-1,-1);
                   break;
         
          default:
                   break;
		
	}
		
	}


	@Override
	public void move(int x, int y) {
		try{
			if(!(bitMap.Map[(body.x)+x][(body.y)+y].equals(null)))
				
			{
			int colorhold = body.color;
			body.color=(body.x+body.y);
			body.Resident= null;
			body= bitMap.Map[body.x+x][body.y+y];
			body.Resident = this;
			body.color = colorhold;}
			}catch(ArrayIndexOutOfBoundsException e ){
				
			}
		
		
	}




}
	

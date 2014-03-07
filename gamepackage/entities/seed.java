package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;

import java.util.Random;


public class seed extends Entity {
	
	//public cell[] body = new cell[10];
	public cell body;
	
	Random random = new Random();
	
	public seed(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		body = bitMap.Map[xf][yf];
		body.Resident= this;
		body.color = colorf;
	
	
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void kill(){
		
	    body.Resident = new sprout(body.x,body.y,29220,10);
	}
	
	public void birth(){
	   // if (life == 0){ 
	    	//color = 000000;}
	}
	
	
	
	public void tick(){
		//body.color = body.color*2;
		//life = life -1;
	
	if(ready ==1){
		//if(life<0)
		//	return;
	
    move(0,1);
     }
  
     }
	
		
	


	@Override
	public void move(int x, int y) {
		try{
			if((bitMap.Map[(body.x)][(body.y)+1].Resident==null)&&bitMap.Map[(body.x)+x][(body.y)+y].medium==1)	
			{
			int colorhold = body.color;
			body.color=(6340095-body.y);
			body.Resident= null;
			body= bitMap.Map[body.x+x][body.y+y];
			body.Resident = this;
			body.color = colorhold;
			ready = 0;}
			else{
			 kill();
			}
			}catch(ArrayIndexOutOfBoundsException e ){
				//not sure
			}
		
		
		
	}




}
	

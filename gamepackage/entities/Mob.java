package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;


public class Mob extends Entity {
	
	//public cell[] body = new cell[10];
	public cell[] body;
	public static int decision;
	public int direction;

	
	public Mob(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		body =  new cell[10];
		body[0] = bitMap.Map[xf][yf];
		body[0].color = colorf;
		direction = 0;
	
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
		//body.color = body.color*2;
		//life = life -1;
	decision = (int)(Math.random()*4);
	
	if(ready ==1){
		//if(life<0)
		//	return;
      switch (decision) {
          case 0: 
         // move(1,1);
                   break;
          case 1: if(direction == 0)
          {  direction = 7;}
        	  direction--;
        	  // move(1,-1);
                   break;
          case 2:  direction++;
          if(direction==7)
          {direction =0;}
                   break;
          case 3: 
                   break;
          default:
                   break;
      }
      //decision = decision % 7;
     switch(direction){
     case 0: 
    	 move(-1,-1);
    	break;
     case 1:
    	 move(0,-1);
    	 break;
     case 2:
    	 move(1,-1);
    	 break;
     case 3:
    	 move(1,0);
    	 break;
     case 4:
    	 move(1,1);
    	 break;
     case 5:
    	 move(0,1);
    	 break;
     case 6:
    	 move(-1,1);
    	 break;	 
     case 7:
    	 move(-1,0);
    	 break;	 
     }
     body[0].color = 777000000+ (direction*4444);
     }
	}
		
	


	@Override
	public void move(int x, int y) {
		try{
			if((bitMap.Map[(body[0].x)+x][(body[0].y)+y].Resident==null))	
			{
			int colorhold = body[0].color;
			body[0].color=(body[0].x+body[0].y);
			body[0].Resident= null;
			body[0]= bitMap.Map[body[0].x+x][body[0].y+y];
			body[0].Resident = this;
			body[0].color = colorhold;
			ready = 0;}
			else{
				direction = ((direction+4)%8);
			}
			}catch(ArrayIndexOutOfBoundsException e ){
				direction = ((direction+4)%8);
			}
		
		
		
	}




}
	

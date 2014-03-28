package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;

import java.util.Random;


public class bird extends Entity {
	
	//public cell[] body = new cell[10];
	public cell[] body;
	public static int decision;
	public int direction;
	public int ATE = 0;
	Random random = new Random();
	
	public bird(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		body =  new cell[15];
		body[0] = bitMap.Map[xf][yf];
		body[0].color = colorf;
		direction = 0;
		body[0].Resident= this;
	
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
	decision = random.nextInt(5);

	if(ready ==1){
		//if(life<0)
		//	return;
		int fruitahead = 0;
		int dx =0;
		int dy = 0;
		
		switch(direction){
	     case 0: 
	    	 dx = -1;
	    	 dy = -1;
	    	
	    	break;
	     case 1:
	    	 dx = 0;
	    	 dy = -1;
	    	
	    	 break;
	     case 2:
	    	 dx = 1;
	    	 dy = -1;
	    	 break;
	     case 3:
	    	 dx = 1;
	    	 dy = 0;
	    	 break;
	     case 4:
	    	 dx = 1;
	    	 dy = 1;
	    	 break;
	     case 5:
	    	 dx = 0;
	    	 dy = 1;
	    	 break;
	     case 6:
	    	 dx = -1;
	    	 dy = 1;
	    	 break;	 
	     case 7:
	    	 dx = -1;
	    	 dy = 0;
	    	 break;	 }
		
	    	 for(int i = 0; i<10; i++){
		
			try {
					if(bitMap.Map[body[0].x +(dx*i)][body[0].y+(dy*i)].color == 16773424)
						fruitahead = 1;
				
					if(fruitahead == 1 && i == 1)
						eat(dx,dy);
			} catch (Exception e) {}
		}
	    	 if(fruitahead == 0){
      switch (decision) {
          case 0: 
         // move(1,1);
                   break;
          case 1: if(direction <= 0)
          {  direction = 7;}
          else  direction--;
        	  // move(1,-1);
                   break;
          case 2:  
          if(direction>=8)
          {direction =0;}
          else direction++;
                   break;
          case 3: 
        	 decision = random.nextInt(60);
        	 if(decision==50)
        	  bitMap.Map[body[0].x][body[0].y+1].Resident = new seed(body[0].x, body[0].y+1,0,16);
                   break;
          default:
        	  ready = 0;
                   break;
      }}
      
	    	 //body[0].color = 12762623+ (direction*2*255);
	         if(ATE>0 &&ready ==1)
	         {
	        	body[0].color =  (16726648* ATE);
	        	ATE-=1;
	        	if(ATE ==1)
	        	kill();
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
     
     }
	
	}
		
	


	@Override
	public void move(int x, int y) {
		try{
			if((bitMap.Map[(body[0].x)+x][(body[0].y)+y].Resident==null)&&bitMap.Map[(body[0].x)+x][(body[0].y)+y].medium==1)	
			{
			int colorhold = body[0].color;
			body[0].color=(6340095-body[0].y);
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
	public void eat(int x, int y) {
		try{
			//if((bitMap.Map[(body[0].x)+x][(body[0].y)+y].Resident.color == 16773424))
			//{
			int colorhold = body[0].color; 
			body[0].color=(6340095-body[0].y); //set color to sky
			
			bitMap.Map[body[0].x+x][body[0].y+y].Resident.life = 96; //-= 101;
			
			body[0].Resident = null; //set  current resident to nothing
			body[0]= bitMap.Map[body[0].x+x][body[0].y+y];
			body[0].Resident = this;
			body[0].color = colorhold;
			ready = 0;
			ATE =200;
			//}
			//else{
				direction = ((direction+4)%8);
			//}
			}catch(ArrayIndexOutOfBoundsException e ){
				direction = ((direction+4)%8);
			}}



}
	

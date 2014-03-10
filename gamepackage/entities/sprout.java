package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;

import java.util.Random;


public class sprout extends Entity {
	
	//public cell[] body = new cell[10];
	public cell[] body;
	public static int decision;

	public int length;
	Random random = new Random();
	
	public sprout(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		body =  new cell[16];
		body[0] = bitMap.Map[xf][yf];
		body[0].color = colorf;
	
	
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
	decision = random.nextInt(25);

	if(ready ==1){
		//if(life<0)
		//	return;
      switch (decision) {
          case 0: 
         // move(1,1);
                   break;
          case 1: grow(-1,-1);
        	  
                   break;
          case 2:  
        	  	grow(0,-1);
                   break;
          case 3: 
        	   grow(1,-1);
        	   
                   break;
          case 4: 
        	  if(length>6)
        		body[length].color = 16773424;
        //	  body[length].branch.viable = 0;
        	  break;

          default:
        	  ready = 0;
                   break;}}
	 

     
	
	}
		
	


	@Override
	public void move(int x, int y) {
		System.out.println("dont move plant");
			}
	
	
		

	public int grow(int dx, int dy) {
	
		
	
		 try{
				if(length<16 &&(bitMap.Map[body[length].x+dx][ body[length].y+dy].Resident==null))	
				{
					length += 1;
			        body[length] = bitMap.Map[body[length-1].x+dx][ body[length-1].y+dy];
					body[length].color = (body[length-1].color -20);
					body[length].Resident = body[0].Resident;
							//(int)(body[length-1].color*1.1);
					
					return 1;
				}
				else{
					System.out.println("grow failed!");
					return 0;
				}
				}catch(ArrayIndexOutOfBoundsException e ){
					return 0;
				}  
		

	}


}
	
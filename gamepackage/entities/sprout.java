package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;

import java.util.Random;


public class sprout extends Entity {
	
	//public cell[] body = new cell[10];
	public cell[] body;
	public static int decision;
	public int maxLength;

	public int length;
	Random random = new Random();
	
	public sprout(int xf, int yf, int colorf, int lifef, int maxLengthc) {
		super(xf, yf, colorf, lifef);
		body =  new cell[16];
		body[0] = bitMap.Map[xf][yf];
		body[0].color = colorf;
		maxLength = maxLengthc;
	
	
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
	decision = random.nextInt(30);

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
        	  decision = random.nextInt(10);
        	  
        	  
        	  
        	  try{
        		  
            	  if(decision == 6 && bitMap.Map[body[length].x+1][body[length].y].medium==1)
            	  bitMap.Map[body[length].x+1][body[length].y].Resident = new sprout(body[length].x,body[length].y,29220,10, (maxLength-length));
            	  else if(decision == 7 && bitMap.Map[body[length].x-1][body[length].y].medium==1)
            		  bitMap.Map[body[length].x-1][body[length].y].Resident = new sprout(body[length].x,body[length].y,29220,10, (maxLength-length)); 
            	  
            	  
            	  else if(decision == 8){
            		  if(length>6)
                  		{body[length].color = 16773424;
                  	    maxLength = 0;}}
  				}catch(ArrayIndexOutOfBoundsException e ){
  					System.out.println("branch failed");
  					return;
  				}  
        	  
        	  
        	
        		 

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
				if(length<maxLength &&(bitMap.Map[body[length].x+dx][ body[length].y+dy].Resident==null))	
				{
					length += 1;
			        body[length] = bitMap.Map[body[length-1].x+dx][ body[length-1].y+dy];
					body[length].color = (body[length-1].color -2*255);
					body[length].Resident = body[0].Resident;
							//(int)(body[length-1].color*1.1);
					
					return 1;
				}
				else{
					System.out.println("sprout grow failed!");
					return 0;
				}
				}catch(ArrayIndexOutOfBoundsException e ){
					return 0;
				}  
		

	}


}
	

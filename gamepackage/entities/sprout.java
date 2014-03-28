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
	
	public sprout(int xf, int yf, int colorf, int lifef, int maxLengthc) throws ArrayIndexOutOfBoundsException {
		super(xf, yf, colorf, lifef);
		if(maxLengthc<1) 
		throw( new ArrayIndexOutOfBoundsException());
		maxLength = maxLengthc;
		body =  new cell[maxLengthc+1];
		body[0] = bitMap.Map[xf][yf];
		body[0].color = colorf;
	
	
	}
	
	
	public void birth(){
	
	}
	
	public void kill(){
	 	for (cell cell : body)
		{cell.color= 6340095 - random.nextInt(3) + random.nextInt(3)*255;
	
		cell.Resident = null;
        cell.medium = 1;//}
		}
	 	body = null;


	}
	
	public void wilt(){
		if(life<100 && ready ==1)
		{
			ready = 0;
			//if(random.nextInt(11) ==10)
			life -=1;
			
		 	for (cell cell : body)
    		{cell.color= cell.color -= 255*255 + 256; //change color
    		
    		}

		}
			
			
			if( life<=0)
			{
				kill();
			}
			
		
		}

	
	
	public void tick(){
		//body.color = body.color*2;
		//life = life -1;
wilt();
	
	
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
        	  decision = random.nextInt(20);
        	  
        	  
        	  
        	  try{
        		  
            	  if(decision == 6 && bitMap.Map[body[length].x+1][body[length].y].medium==1)
            	  bitMap.Map[body[length].x+1][body[length].y].Resident = new sprout(body[length].x,body[length].y,29220,100, (maxLength-length));
            	  else if(decision == 7 && bitMap.Map[body[length].x-1][body[length].y].medium==1)
            		  bitMap.Map[body[length].x-1][body[length].y].Resident = new sprout(body[length].x,body[length].y,29220,100, (maxLength-length)); 
            	  
            	  
            	  else if(decision < 3){
            		  if(length>6)
                  		{body[length].color = 16773424; 
                  		life += 100;
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
					ready = 0;
					System.out.println("sprout grow failed!");
					return 0;
				}
				}catch(ArrayIndexOutOfBoundsException e ){
					return 0;
				}  
		

	}


}
	

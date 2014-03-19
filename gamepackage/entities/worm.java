package gamepackage.entities;

import gamepackage.bitMap;
import gamepackage.cell;

import java.util.Random;


public class worm extends Entity {
	

	public cell[] body;
	public int length;
	public static int decision;
	public int direction;
	Random random = new Random();

	public worm(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		
		body =  new cell[17];
		body[0] = bitMap.Map[xf][yf];
		body[0].color = colorf;
		length = 0;  //0 index
		direction = 0;
		body[0].Resident= this;
	
	}
	
	public int grow(int growdirection) {
	
		
		int dx  =0;
		int dy = 0;
		
		 switch (growdirection) {
         case 0: 
        	dx = 0;
        	dy = -1;
                  break;
         case 1: 
        	dx = 1;
            dy = 0;
                  break;
         case 2:  
        	 dx = 0;
        	 dy = 1;
         	     break;
         case 3: 
        	dx = -1;
          	dy = 0;
              break;
         default:
                System.out.println("invalid growdirection");
                break;
		 }
		 try{
				if(length<14 && ready ==1 &&(bitMap.Map[body[length].x+dx][ body[length].y+dy].Resident==null))	
				{
					length += 1;
			        body[length] = bitMap.Map[body[length-1].x+dx][ body[length-1].y+dy];
			        if(length == 1)
			        {body[length].color =11916201;}
			        else
					body[length].color = (body[length-1].color + 255*2 + 4);
					body[length].Resident = body[0].Resident;
							//(int)(body[length-1].color*1.1);
					ready =0;
					return 1;
				}
				else{
					System.out.println("grow failed!");
					ready =0;
					return 0;
				}
				
				}catch(ArrayIndexOutOfBoundsException e ){
					ready =0;
					return 0;
				}  
		

	}
	
	
	public void birth(){
//	life = 1000;
	//color =(int) Math.floor(Math.random()*999999);
	}
	
	public void kill(){
	    if (life == 0){ 
	    	int xhold = this.body[0].x;
	    	int yhold = this.body[0].y;
	    	
	    	
	    	for (cell cell : body)
	    		{cell.color= 8545569 + random.nextInt(50);
	            cell.Resident = null;
	            cell.medium = 0;
	    		}
	       bitMap.Map[xhold][yhold].Resident =new worm(xhold, yhold, 00, 50);
	    	}
	
	}
	

	
	
	public void tick(){
		//body.color = body.color*2;
		//life = life -1;
	if(life <= 0)
	kill();
	
	else
	{
	decision = random.nextInt(5);

	if(ready ==1){
		//if(life<0)
		//	return;
      switch (decision) {
          case 0: 
         // move(1,1);
                   break;
          case 1: if(direction <= 0)
          {  direction = 3;}
          else  
        	  direction--;
        	 
                   break;
          case 2:  
          if(direction>=4)
          {direction =0;}
          else 
        	  direction++;
                   break;
          case 3: 
        	grow(random.nextInt(3));
                   break;
          default:
        		System.out.println("invalid decision in worm");
        		ready = 0;
        		life-=1; 
        		break;
                   
              
      
      }
      //decision = decision % 7;
     switch(direction){
     case 0: 
    	 move(0,-1);
    	break;
     case 1:
    	 move(1,0);
    	 break;
     case 2:
    	 move(0,1);
    	 break;
     case 3:
    	 move(-1,0);
    	 break;
default:
	System.out.println("invalid direction in worm");
	break;
     }
     
 //	grow(0, 666999000, 4);
     }
	}
	}
		
	


	@Override
	public void move(int x, int y) {
		try{
			if((bitMap.Map[(body[0].x)+x][(body[0].y)+y].Resident==null)&&bitMap.Map[(body[0].x)+x][(body[0].y)+y].medium==0)	
			{
				
				int[] xyhold = {body[0].x,body[0].y};
				bitMap.Map[body[0].x+x][body[0].y+y].color = body[0].color;
				body[0]= bitMap.Map[body[0].x+x][body[0].y+y];
				body[0].Resident = this;
				
				for(int i = 1; i  <= length; i++){

			int xhold = body[i].x;
			int	yhold = body[i].y;
			 bitMap.Map[xyhold[0]][xyhold[1]].color = body[i].color;
			body[i]= bitMap.Map[xyhold[0]][xyhold[1]];
			xyhold[0] = xhold;
			xyhold[1] = yhold;
			body[i].Resident = this;
		
			if(i == length){
				bitMap.Map[xhold][yhold].color=(5963797+255*10);
				bitMap.Map[xhold][yhold].Resident= null;
			}
			
			
			}
				if(length == 0)
				{	bitMap.Map[xyhold[0]][xyhold[1]].color = (5963798+255*10);
					bitMap.Map[xyhold[0]][xyhold[1]].Resident = null;
				}
			
			
		
			
			}
			
		
			
			else{
				direction = ((direction+1)%4);
				
			}
			}catch(ArrayIndexOutOfBoundsException e ){
				direction = ((direction+1)%4);
			}
		ready = 0;
		
		
	}




}
	

package gamepackage;


import java.util.Random;

import gamepackage.entities.bird;
import gamepackage.entities.seed;
import gamepackage.entities.worm;


public class bitMap extends GameClass {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public static Entity[][] bitMap = new Entity[100][100];
	
	public static cell[][] Map = new cell[GameClass.WIDTH][GameClass.HEIGHT];

	static Random random = new Random();

	
public static void genesis(){
for( int x = 0;x<60; x+=20)
{for(int y = 30; y<60; y+=20){
	
	wormbirth(x,y);
}

}
Populate(20,10);
Populate(21,10);
Populate(21,1);
Populate(20,1);
Populate(21,6);
Populate(23,1);
seedbirth(1,1);
seedbirth(2,2);
seedbirth(10,1);
seedbirth(20,2);

}

	public static void Populate(int x, int y)
	{
	bird temp= new bird(x,y,12762623,16);//color then life
	Map[x][y].Resident= temp;
	}
	
	public static void seedbirth(int x, int y)
	{
	seed temp= new seed(x,y,11916201,16);//color then life
	Map[x][y].Resident= temp;
	}
	
	
	public static void wormbirth(int x, int y)
	{
		if(Map[x][y].medium == 0){
	worm temp= new worm(x,y,6761471,55);//color then life
	Map[x][y].Resident= temp;}
		
	
	
	}

	public static void initCells(){
	//populate();
		 for(int i =0;i < GameClass.WIDTH; i++)
	 		{
		 for(int j =0;j <GameClass.HEIGHT; j++)
		 		{
	
	Map[i][j] = new cell(i,j,6340095 - random.nextInt(j+1) + random.nextInt(j+1)*255,1);
				
		 		}
		
	}
		 int floatdepth = 33;
		 for(int i =0;i < GameClass.WIDTH; i++)
	 		{
			 if(i%2 ==0){
			  floatdepth += random.nextInt(2);
			  floatdepth -= random.nextInt(2);}
		 for(int j =0;j <GameClass.HEIGHT; j++)
		 		{
	
	 if(Map[i][j].y>floatdepth)
	 { Map[i][j].medium=0;
	 Map[i][j].color = 5963793 + random.nextInt(10) + random.nextInt(10)*255 - random.nextInt(7)*255*255;
	 }	
		 		}
		
		
	}
	
	
	}
	public static int[] mark(){

	//populate();
		 for(int i =0;i < WIDTH; i++)
	 		{
		 for(int j =0;j < HEIGHT; j++)
		 		{
		
	//Map[i][j] = new cell(i,j,(i-j)*(10000));
			
			pixels[((j*WIDTH)+i)] = Map[i][j].color;
			// pixels[((i*100)+j)] = 300000;

				
		 		}
		 
	}
		return pixels;
	
	
	}
	
}

package gamepackage;

import gamepackage.entities.Mob;


public class bitMap extends GameClass {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public static Entity[][] bitMap = new Entity[100][100];
	
	public static cell[][] Map = new cell[100][100];



	
public static void genesis(){
for( int x = 5;x<95; x+=13)
{for(int y = 5; y<95; y+=13){
	Populate(x,y);
}}
}

	public static void Populate(int x, int y)
	{
	Mob temp= new Mob(x,y,90000,10);//color then life
	Map[x][y].Resident= temp;
	}
	

	public static void initCells(){
	//populate();
		 for(int i =0;i < 100; i++)
	 		{
		 for(int j =0;j < 100; j++)
		 		{
		
	Map[i][j] = new cell(i,j,(i+j));
		
				
		 		}
		 
	}

	
	
	}
	public static int[] mark(){

	//populate();
		 for(int i =0;i < 100; i++)
	 		{
		 for(int j =0;j < 100; j++)
		 		{
		
	//Map[i][j] = new cell(i,j,(i-j)*(10000));
			
			pixels[((i*100)+j)] = Map[i][j].color;
			// pixels[((i*100)+j)] = 300000;

				
		 		}
		 
	}
		return pixels;
	
	
	}
	
}

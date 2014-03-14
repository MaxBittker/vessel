package gamepackage;


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



	
public static void genesis(){
for( int x = 0;x<60; x+=20)
{for(int y = 30; y<60; y+=20){
	
	wormbirth(x,y);
}

}Populate(20,10);
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
	seed temp= new seed(x,y,0,16);//color then life
	Map[x][y].Resident= temp;
	}
	
	
	public static void wormbirth(int x, int y)
	{
	worm temp= new worm(x,y,11916201,55);//color then life
	Map[x][y].Resident= temp;
	temp.grow(1);
	temp.grow(1);
	//temp.grow(2, 88005555, 4);
	
	
	}

	public static void initCells(){
	//populate();
		 for(int i =0;i < GameClass.WIDTH; i++)
	 		{
		 for(int j =0;j <GameClass.HEIGHT; j++)
		 		{
	
	Map[i][j] = new cell(i,j,6340095,1);
				
		 		}
		
	}
		 for(int i =0;i < GameClass.WIDTH; i++)
	 		{
		 for(int j =0;j <GameClass.HEIGHT; j++)
		 		{
	
	 if(Map[i][j].y>26)
	 { Map[i][j].medium=0;
	 Map[i][j].color = 5963793;
	 }	
		 		}
		
		
	}
		// Map[1][20].color = 250*250;
		 //System.out.println(Map[1][20].x);
		 /*for(cell[] cellarray: Map)
			 for(cell cell:cellarray)
			 {
				 if(cell.x>26)
				 { cell.medium=0;
				 cell.color = 6291456;}
				 
			 }
	*/
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

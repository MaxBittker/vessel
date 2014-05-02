package gamepackage.entities;

public class wormseed extends seed {

	public wormseed(int xf, int yf, int colorf, int lifef) {
		super(xf, yf, colorf, lifef);
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
	
	@Override
	public void kill(){
		
	    body.Resident = new worm(body.x,body.y,29220,100);
	}
	
	

}

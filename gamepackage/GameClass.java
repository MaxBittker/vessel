package gamepackage;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;


public class GameClass extends Canvas implements Runnable{

	
	private static final long serialVersionUID = 1L;


	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;
	public static final int SCALE = 11;
	public static final String NAME = "JAR";


	
	private JFrame frame;
	
	public Boolean running = false;
	public int tickCount = 0;
	
	private static BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	public static int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	//public int[][] bitMap = new int[100][100];
	
	public GameClass(){
		setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
	
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start(){
	running = true;
		new Thread(this).start();
	}

	public synchronized void stop(){
		running = false;
	}
	@Override
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 200000000;//200000000
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			while( delta >= 1){
				ticks++;
				tick();
				delta -=1;
				shouldRender = true;
			}
			try{
			Thread.sleep(2);
		}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(shouldRender){
			frames++;
			render();
			}
			
			if(System.currentTimeMillis()-lastTimer >=1000){
				lastTimer +=1000;
				System.out.println(frames + ","+ ticks);
				frames = 0;
				ticks = 0;
			}
		}
	
	}
	public void tick(){
		tickCount++;	
		
		for(cell[] p1: bitMap.Map){  // foreach grade in grades
			for(cell q1: p1){
				
				try{
					q1.Resident.ready = 1;
	
				}catch(NullPointerException e ){
				}
			}}
				
		for(cell[] p: bitMap.Map){  // foreach grade in grades
		for(cell q: p){
			
			try{
				q.Resident.tick();
				
			//	q.Resident.move(-1,1);
			}catch(NullPointerException e ){
			}
		}  }
		
	

		//pixels[i] = i + tickCount;
		 //pixels[i] = i % tickCount * tickCount;
		pixels = bitMap.mark();}
		// for(int x =0;x < 100; x++)
		// 		{
		//	 for(int y =0;y < 100; y++)
			 	//	{
		//			//pixels[((x*100)+y)] = bitMap.bitMap[x][y].color;
					//bitMap[x][y]=(x*y*y %tickCount * tickCount *20000);
		//	 			}
			 
	//	}
			 
	
	

	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.drawImage(image, 0,0,getWidth(),getHeight(),null);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
	{new GameClass().start();
	bitMap.initCells();
	bitMap.genesis();
	}
	
	
	
	}

}

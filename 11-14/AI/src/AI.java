import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}

class MainCanvas extends Canvas
{
	Image imgd,imgu,imgl,imgr,currentImg;
	public MainCanvas()
	{
		try
		{
			imgd=Image.createImage("/sayo10.png");
			imgu=Image.createImage("/sayo14.png");
			imgl=Image.createImage("/sayo12.png");
			imgr=Image.createImage("/sayo16.png");
			currentImg=imgd;

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			currentImg=imgl;
			System.out.println("向左转");
			repaint();
		}

		if(action==RIGHT){
			currentImg=imgr;
			System.out.println("向右转");
			repaint();
		}

		if(action==DOWN){
			currentImg=imgd;
			System.out.println("向下转");
			repaint();
		}

		if(action==UP){
			currentImg=imgu;
			System.out.println("向上转");
			repaint();
		}

}
}
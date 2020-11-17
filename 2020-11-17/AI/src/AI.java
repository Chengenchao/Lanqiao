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
	Image imgd,imgd1,imgd2,imgu,imgu1,imgu2,imgl,imgl1,imgl2,imgr,imgr1,imgr2,currentImg;
	int x = 100;
	int y = 100;
	int flag = 1;
	public MainCanvas()
	{
		try
		{
			imgd=Image.createImage("/sayo10.png");
			imgd1=Image.createImage("/sayo00.png");
			imgd2=Image.createImage("/sayo20.png");

			imgu=Image.createImage("/sayo14.png");
			imgu1=Image.createImage("/sayo04.png");
			imgu2=Image.createImage("/sayo24.png");

			imgl=Image.createImage("/sayo12.png");
			imgl1=Image.createImage("/sayo02.png");
			imgl2=Image.createImage("/sayo22.png");

			imgr=Image.createImage("/sayo16.png");
			imgr1=Image.createImage("/sayo06.png");
			imgr2=Image.createImage("/sayo26.png");

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
		g.drawImage(currentImg,x,y,0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			currentImg=imgl;
			//System.out.println("向左转");

			if(flag==1){
				currentImg=imgl1;
				flag+=1;
			}
			else if (flag == 2){
				currentImg=imgl2;
				flag = 1;
			}
			if(x>=2&&x<240){
				x-=2;
			}
			
			repaint();


	}

		if(action==RIGHT){
			currentImg=imgr;
			//System.out.println("向右转");
			if(flag==1){
				currentImg=imgr1;
				flag+=1;
			}
			else if (flag == 2){
				currentImg=imgr2;
				flag = 1;
			}
			if(x>=0&&x<=240){
				x+=2;
			}
			repaint();
		}

		if(action==DOWN){
			currentImg=imgd;
			//System.out.println("向下转");
			if(flag==1){
				currentImg=imgd1;
				flag+=1;
			}
			else if (flag == 2){
				currentImg=imgd2;
				flag = 1;
			}
			if(y>=0&&y<=320){
				y+=2;
			}
			repaint();
		}

		if(action==UP){
			currentImg=imgu;
			//System.out.println("向上转");
			if(flag==1){
				currentImg=imgu1;
				flag+=1;
			}
			else if (flag == 2){
				currentImg=imgu2;
				flag = 1;
			}
			if(y>=2&&y<320){
				y-=2;
			}
			repaint();
		}

}
}
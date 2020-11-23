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
	Image heroLeftImg[] = new Image[3];
	Image heroDownImg[] = new Image[3];
	Image heroUpImg[] = new Image[3];
	Image heroRightImg[] = new Image[3];
	Image currentImg;
	//Image imgd,imgd1,imgd2,imgu,imgu1,imgu2,imgl,imgl1,imgl2,imgr,imgr1,imgr2,currentImg;
	int x = 100;
	int y = 100;
	int i;
	int flag = 1;
	public MainCanvas()
	{
		try
		{	//下
			/*imgd1=Image.createImage("/sayo00.png");
			imgd=Image.createImage("/sayo10.png");
			imgd2=Image.createImage("/sayo20.png");*/
			for(i=0;i<3;i++){
				heroDownImg[i] = Image.createImage("/sayo"+i+"0.png");
			}

	
			//上
			/*imgu1=Image.createImage("/sayo04.png");
			imgu=Image.createImage("/sayo14.png");
			imgu2=Image.createImage("/sayo24.png");*/
			for(i=0;i<3;i++){
				heroUpImg[i] = Image.createImage("/sayo"+i+"4.png");
			}

			//左
			/*imgl1=Image.createImage("/sayo02.png");
			imgl=Image.createImage("/sayo12.png");
			imgl2=Image.createImage("/sayo22.png");*/
			for(i=0;i<3;i++){
				heroLeftImg[i] = Image.createImage("/sayo"+i+"2.png");
			}


			//右
			/*imgr1=Image.createImage("/sayo06.png");
			imgr=Image.createImage("/sayo16.png");
			imgr2=Image.createImage("/sayo26.png");*/
			for(i=0;i<3;i++){
				heroRightImg[i] = Image.createImage("/sayo"+i+"6.png");
			}

			currentImg= heroDownImg[0];

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);  //颜色参数
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			currentImg=heroLeftImg[1];
			//System.out.println("向左转");

			if(flag==1){
				currentImg=heroLeftImg[0];
				flag+=1;
			}
			else if (flag == 2){
				currentImg=heroLeftImg[2];
				flag = 1;
			}
			if(x>=2&&x<240){
				x-=2;
			}
			
			repaint();


	}

		if(action==RIGHT){
			currentImg=heroRightImg[1];
			//System.out.println("向右转");
			if(flag==1){
				currentImg=heroRightImg[0];
				flag+=1;
			}
			else if (flag == 2){
				currentImg=heroRightImg[2];
				flag = 1;
			}
			if(x>=0&&x<=240){
				x+=2;
			}
			repaint();
		}

		if(action==DOWN){
			currentImg=heroDownImg[1];
			//System.out.println("向下转");
			if(flag==1){
				currentImg=heroDownImg[0];
				flag+=1;
			}
			else if (flag == 2){
				currentImg=heroDownImg[2];
				flag = 1;
			}
			if(y>=0&&y<=320){
				y+=2;
			}
			repaint();
		}

		if(action==UP){
			currentImg=heroUpImg[1];
			//System.out.println("向上转");
			if(flag==1){
				currentImg=heroUpImg[0];
				flag+=1;
			}
			else if (flag == 2){
				currentImg=heroUpImg[2];
				flag = 1;
			}
			if(y>=2&&y<320){
				y-=2;
			}
			repaint();
		}

}
}
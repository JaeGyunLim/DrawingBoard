package test;
import java.awt.*;
import java.util.*;

public class FreeLine {
	public Vector<Integer> xList;
	public Vector<Integer> yList;
	public Color color;
	public int bold;
	public FreeLine(){
		xList = new Vector<Integer>();
		yList = new Vector<Integer>();
	}
	
	public void addPoint(int x,int y,Color c,int bold){
		xList.add(x);	  
		yList.add(y); 
		this.color = c;
		this.bold = bold;
	}

	public void drawFreeLine(Graphics g){
		g.setColor(color);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(bold));
		for(int i = 0; i < xList.size() - 1; i++){
			g.drawLine((int)xList.get(i), (int)yList.get(i), (int)xList.get(i+1), (int)yList.get(i+1));
		}
		
	}
}

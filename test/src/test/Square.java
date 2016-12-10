package test;

import java.awt.*;
import java.util.*;

public class Square {
	public Vector<Integer> xList;
	public Vector<Integer> yList;
	public Color color;
	public int bold;
	public Square(){
		xList = new Vector<Integer>();
		yList = new Vector<Integer>();
	}
	public void addPoint(int x,int y,Color c,int bold){
		xList.add(x);
		yList.add(y);
		this.color = c;
		this.bold = bold;
	}
	public void drawSquare(Graphics g){
		g.setColor(color);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(bold));
		for(int i = 0; i < yList.size() -1;i++){	
			if((xList.get(i+1) - xList.get(i)) > 0){
				if(yList.get(i+1) - yList.get(i) > 0){
					g.drawRect(xList.get(i), yList.get(i),  xList.get(i+1) - xList.get(i),yList.get(i+1) - yList.get(i));
				}
				else{
					g.drawRect(xList.get(i), yList.get(i+1),  xList.get(i+1) - xList.get(i),yList.get(i) - yList.get(i+1));
				}
			}
			else{
				if(yList.get(i+1) - yList.get(i) > 0){
					g.drawRect(xList.get(i+1), yList.get(i), xList.get(i) - xList.get(i+1), yList.get(i+1) - yList.get(i));
				}
				else{
					g.drawRect(xList.get(i+1), yList.get(i+1),  xList.get(i) - xList.get(i+1),yList.get(i) - yList.get(i+1));
				}
			}
		}
	}
}

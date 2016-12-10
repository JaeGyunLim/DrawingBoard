package test;

import java.awt.*;
import java.util.*;

public class Triangle {
	public Vector<Integer> xList;
	public Vector<Integer> yList;
	public Color color;
	public int bold;
	public Triangle(){
		xList = new Vector<Integer>();
		yList = new Vector<Integer>();
	}
	public void addPoint(int x,int y,Color c,int bold){
		xList.add(x);
		yList.add(y);
		this.color = c;
		this.bold = bold;
	}
	public void drawTriangle(Graphics g){
		g.setColor(color);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(bold));
		int i =0;
		int point = ((int)xList.get(i+1) - (int)xList.get(i))/2;
		int[] x = {(int)xList.get(i)+point,(int)xList.get(i),(int)xList.get(i+1)};
		int[] y = {(int)yList.get(i),(int)yList.get(i+1),(int)yList.get(i+1)};
		g.drawPolygon(x, y, x.length);
		
	}
}

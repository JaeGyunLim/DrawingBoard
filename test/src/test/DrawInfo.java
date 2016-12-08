package test;
import java.awt.Color;

public class DrawInfo
{
	int px1;
	int py1;
	int px2;
	int py2;
	Color colors;
	int bolds;
	
	public DrawInfo(int x1, int y1, int x2, int y2, Color color, int bold)
	{
		px1 = x1;
		py1 = y1;
		px2 = x2;
		py2 = y2;
		colors = color;
		bolds = bold;
	}

	public int getPx1() {
		return px1;
	}

	public void setPx1(int px1) {
		this.px1 = px1;
	}

	public int getPy1() {
		return py1;
	}

	public void setPy1(int py1) {
		this.py1 = py1;
	}

	public int getPx2() {
		return px2;
	}

	public void setPx2(int px2) {
		this.px2 = px2;
	}

	public int getPy2() {
		return py2;
	}

	public void setPy2(int py2) {
		this.py2 = py2;
	}

	public Color getColors() {
		return colors;
	}

	public void setColors(Color colors) {
		this.colors = colors;
	}

	public int getBolds() {
		return bolds;
	}

	public void setBolds(int bolds) {
		this.bolds = bolds;
	}

	
}

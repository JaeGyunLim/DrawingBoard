package test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class t extends JFrame {

	private JPanel ContentPane;
	Color color;	//색 지정
	int bold = 1; //굵기 < 1로 초기 설정
	public int btnSelect = 1; // 도형 그리기 버튼 선택 < 펜으로 초기 설정
	private JTextField TextField; //굵기 변경
	public List<FreeDrawLineList> lines = new ArrayList<FreeDrawLineList>();//자유 도형 그리기 x,y좌표 저장
	public FreeDrawLineList freeLine; // 현재선
	
	//private Vector<DrawPoint> vecStartPoint;
	//private Vector<DrawPoint> vecEndPoint;
	private DrawPoint startPoint;
	private DrawPoint endPoint;	
	Point start = null;
	Point end = null;
	
	//메인
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t frame = new t();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public t() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(t.class.getResource("/test/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("그림판");
		setBounds(100, 100, 550, 300);
		
		JMenuBar MenuBar = new JMenuBar();
		setJMenuBar(MenuBar);
		
		JMenu MenuOption = new JMenu("옵션");
		MenuBar.add(MenuOption);
		
		JMenuItem MItemColor = new JMenuItem("색상");
		MenuOption.add(MItemColor);		
		
		//옵션 - 색상
		MItemColor.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();
				if(cmd.equals("색상"))
				{
					color = JColorChooser.showDialog(null, "Color", Color.BLACK);
				}
			}
		});
		
		JMenuItem MItemGet = new JMenuItem("불러오기");
		MenuOption.add(MItemGet);
		
		
		JMenuItem MItemSave = new JMenuItem("저장");
		MenuOption.add(MItemSave);
		
		//저장하기
		MItemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem MItemExit = new JMenuItem("나가기");
		MenuOption.add(MItemExit);
		
		//옵션 - 나기기 누를 경우 종료
		MItemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPane);
		ContentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel OptionPanel = new JPanel();
		ContentPane.add(OptionPanel, BorderLayout.NORTH);
		OptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel ToolPanel = new JPanel();
		OptionPanel.add(ToolPanel);
		
		JToolBar toolBar = new JToolBar();
		ToolPanel.add(toolBar);
		
		JButton btnTextBox = new JButton("텍스트상자");
		toolBar.add(btnTextBox);
		
		JPanel FigurePanel = new JPanel();
		OptionPanel.add(FigurePanel);
		
		JToolBar toolBar_1 = new JToolBar();
		FigurePanel.add(toolBar_1);
		
		JButton btnPen = new JButton("펜");
		toolBar_1.add(btnPen);
		
		JButton btnLine = new JButton("선");
		toolBar_1.add(btnLine);
		
		JButton btnOval = new JButton("원");
		toolBar_1.add(btnOval);
		
		JButton btnSquare = new JButton("네모");
		toolBar_1.add(btnSquare);
		
		btnPen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSelect = 1;
				System.out.println("펜");
			}
		});
		
		
		
		btnLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSelect = 2;
				System.out.println("선" + btnSelect);
			}
		});
		
		
		btnOval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				btnSelect = 3;
				System.out.println("원" );
			}
		});
		btnSquare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSelect = 4;
				System.out.println("네모");
			}
		});
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar ToolBar_2 = new JToolBar();
		SizePanel.add(ToolBar_2);
		
		TextField = new JTextField();
		ToolBar_2.add(TextField);
		TextField.setColumns(2);
		TextField.setText(bold + "");
		//TextField에 숫자 입력 후 변경 버튼을 누르면 굵기 변경
		JButton BtnSizeChange = new JButton("변경");
		BtnSizeChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bold = (Integer.parseInt(TextField.getText().trim()));
			}
		});
		
		BtnSizeChange.setVerticalAlignment(SwingConstants.BOTTOM);
		ToolBar_2.add(BtnSizeChange);
		
		JPanel ColorPanel = new JPanel();
		OptionPanel.add(ColorPanel);
		
		JToolBar ToolBar_3 = new JToolBar();
		ColorPanel.add(ToolBar_3);
		
		JButton BtnRED = new JButton("");
		BtnRED.setBackground(Color.RED);
		ToolBar_3.add(BtnRED);
		BtnRED.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.RED;
			}
		});
		
		JButton BtnORANGE = new JButton("");
		BtnORANGE.setBackground(Color.ORANGE);
		ToolBar_3.add(BtnORANGE);
		
		BtnORANGE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.ORANGE;
			}
		});
		
		JButton BtnYELLOW = new JButton("");
		BtnYELLOW.setBackground(Color.YELLOW);
		ToolBar_3.add(BtnYELLOW);
		
		BtnYELLOW.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.YELLOW;
			}
		});
		
		JButton BtnGREEN = new JButton("");
		BtnGREEN.setBackground(Color.GREEN);
		ToolBar_3.add(BtnGREEN);
		
		BtnGREEN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.GREEN;
			}
		});
		JButton BtnBLUE = new JButton("");
		BtnBLUE.setBackground(Color.BLUE);
		ToolBar_3.add(BtnBLUE);
		
		BtnBLUE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.BLUE;
			}
		});
		JButton BtnPINK = new JButton("");
		BtnPINK.setBackground(Color.PINK);
		ToolBar_3.add(BtnPINK);
		
		BtnPINK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.PINK;
			}
		});

		JButton BtnBLACK = new JButton("");
		BtnBLACK.setBackground(Color.BLACK);
		ToolBar_3.add(BtnBLACK);
		
		BtnBLACK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.BLACK;
			}
		});
		
		JButton BtnLIGHT_GRAY = new JButton("");
		BtnLIGHT_GRAY.setBackground(Color.LIGHT_GRAY);
		ToolBar_3.add(BtnLIGHT_GRAY);
		
		BtnLIGHT_GRAY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.LIGHT_GRAY;
			}
		});
		
		JButton BtnWHITE = new JButton("");
		BtnWHITE.setBackground(Color.WHITE);
		ToolBar_3.add(BtnWHITE);
		
		BtnWHITE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.WHITE;
			}
		});
		
		
			//PaintFreeLine paintFL = new PaintFreeLine();       
			//lines.add(freeLine);
			//ContentPane.add(paintFL,BorderLayout.CENTER);


			DrawLine drawLine = new DrawLine();
			ContentPane.add(drawLine, BorderLayout.CENTER);
			
			//DrawCircle drawCircle = new DrawCircle();
			//ContentPane.add(drawCircle,BorderLayout.CENTER);
			//DrawSquare drawSquare = new DrawSquare();
			//ContentPane.add(drawSquare, BorderLayout.CENTER);


	} //t


	public class PaintFreeLine extends JPanel {// 자유선 그리기 (펜)
		
		public PaintFreeLine(){
			this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
	        	freeLine = new FreeDrawLineList();
	            lines.add(freeLine);
	            freeLine.addPoint(e.getX(), e.getY());
	         }
	      });
	     this.addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) {
	           freeLine.addPoint(e.getX(), e.getY());
	           repaint(); 
	         }
	      });
		}
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);	                 
	        	 for (FreeDrawLineList line: lines) {	        	 
	        		if(line != null)
	        		 line.draw(g);	
	        	 }	       
	      }
	   }
	
	class DrawLine extends JPanel //직선
	{
		private Vector<DrawPoint> vecStartPoint;
		private Vector<DrawPoint> vecEndPoint;
		Point start = null;
		Point end = null;
		
		public DrawLine()
		{		
			vecStartPoint = new Vector<DrawPoint>();
			vecEndPoint = new Vector<DrawPoint>();
			
			this.addMouseListener(new MouseAdapter()
			{
				public void mouseMoved(MouseEvent e)
				{
					end = e.getPoint();
				}
				public void mouseDragged(MouseEvent e)
				{
					end = e.getPoint();
					repaint();					
				}
				public void mousePressed(MouseEvent e)
				{				
					start = e.getPoint();
					int x = e.getX();
					int y = e.getY();
					
					startPoint = new DrawPoint();
					startPoint.setX(x);
					startPoint.setY(y);	
				}
				public void mouseReleased(MouseEvent e)
				{
					int x = e.getX();
					int y = e.getY();
					
					endPoint = new DrawPoint();
					endPoint.setX(x);
					endPoint.setY(y);
					
					vecStartPoint.add(startPoint);
					vecEndPoint.add(endPoint);
					repaint();					
				}
			});
		}
		public void paintComponent(Graphics g)
		{
			
			super.paintComponent(g);
			Graphics gr = getGraphics();
			g.setColor(color);
			Graphics2D g2d = (Graphics2D)gr;
			g2d.setStroke(new BasicStroke(bold));
			for(int i = 0; i < vecStartPoint.size() ; i++)
			{
				
				int x1 = vecStartPoint.get(i).getX();
				int y1 = vecStartPoint.get(i).getY();
				int x2 = vecEndPoint.get(i).getX();
				int y2 = vecEndPoint.get(i).getY();		
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
	class DrawSquare extends JPanel{ //사각형
		public Point start;
		public Point end;
		public DrawSquare(){
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					start = e.getPoint();
					
				}
				public void mouseReleased(MouseEvent e){
					end = e.getPoint();
					repaint();
				}	
			});		
		}
		
		public void paintComponent(Graphics g)
		{
			int sx,sy,ex,ey;
			super.paintComponent(g);
			
			
			if(start != null && end != null){
				sx = (int) start.getX();
				sy = (int) start.getY();
				ex = (int) end.getX();
				ey = (int) end.getY();
				g.drawRect(sx, sy, ex - sx,ey - sy);
			}
		}
	}
	
	class DrawCircle extends JPanel{
		public Point start;
		public Point end;
		public DrawCircle(){
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					start = e.getPoint();
					
				}
				public void mouseReleased(MouseEvent e){
					end = e.getPoint();
					repaint();
				}	
			});		
		}
		
		public void paintComponent(Graphics g)
		{
			int sx,sy,ex,ey,tx,ty;
			super.paintComponent(g);
			if(start != null && end != null){
				sx = (int) start.getX();
				sy = (int) start.getY();
				ex = (int) end.getX();
				ey = (int) end.getY();
				tx = ex - sx;
				ty = ey = ey;
				g.drawOval(sx, sy, ex - sx,ey - sy);
			}
		}			
	}
}

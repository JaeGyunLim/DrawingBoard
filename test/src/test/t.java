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
	Color color;	//�� ����
	float bold = 2; //���� < 2�� �ʱ� ����
	int btnSelect = 0; // ���� �׸��� ��ư ���� < ������ �ʱ� ����
	private JTextField TextField; //���� ����
	
	
	private Vector<DrawPoint> vecStartPoint;
	private Vector<DrawPoint> vecEndPoint;	
	private DrawPoint startPoint;
	private DrawPoint endPoint;
	
	Point start = null;
	Point end = null;
	
	
	public FreeDrawLineList freeLine; // ���缱

	//����
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
		
		vecStartPoint = new Vector<DrawPoint>();
		vecEndPoint = new Vector<DrawPoint>();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(t.class.getResource("/test/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�׸���");
		setBounds(100, 100, 500, 300);
		
		JMenuBar MenuBar = new JMenuBar();
		setJMenuBar(MenuBar);
		
		JMenu MenuOption = new JMenu("�ɼ�");
		MenuBar.add(MenuOption);
		
		JMenuItem MItemColor = new JMenuItem("����");
		MenuOption.add(MItemColor);		
		
		//�ɼ� - ����
		MItemColor.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();
				if(cmd.equals("����"))
				{
					color = JColorChooser.showDialog(null, "Color", Color.BLACK);
				}
			}
		});
		
		JMenuItem MItemGet = new JMenuItem("�ҷ�����");
		MenuOption.add(MItemGet);
		
		
		JMenuItem MItemSave = new JMenuItem("����");
		MenuOption.add(MItemSave);
		
		//�����ϱ�
		MItemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem MItemExit = new JMenuItem("������");
		MenuOption.add(MItemExit);
		
		//�ɼ� - ����� ���� ��� ����
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
		
		JButton btnTextBox = new JButton("�ؽ�Ʈ����");
		toolBar.add(btnTextBox);
		
		JPanel FigurePanel = new JPanel();
		OptionPanel.add(FigurePanel);
		
		JToolBar toolBar_1 = new JToolBar();
		FigurePanel.add(toolBar_1);
		
		JButton btnPen = new JButton("��");
		toolBar_1.add(btnPen);
		
		btnPen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSelect = 0;
				System.out.println("��");
			}
		});
		
		JButton btnLine = new JButton("��");
		toolBar_1.add(btnLine);
		
		btnLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSelect = 1;
				System.out.println("��");
			}
		});
		JButton btnOval = new JButton("��");
		toolBar_1.add(btnOval);
		
		btnOval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSelect = 2;
				System.out.println("��");
			}
		});
		
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar ToolBar_2 = new JToolBar();
		SizePanel.add(ToolBar_2);
		
		TextField = new JTextField();
		ToolBar_2.add(TextField);
		TextField.setColumns(2);
		
		//TextField�� ���� �Է� �� ���� ��ư�� ������ ���� ����
		JButton BtnSizeChange = new JButton("����");
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
		
			
		//====================================== �׸���
		addMouseMotionListener(new MouseMotionAdapter(){
			
			public void mouseMoved(MouseEvent e) {
				end = e.getPoint();
			}
			public void mouseDragged(MouseEvent e) {
				end = e.getPoint();
				repaint();
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				endPoint = new DrawPoint();
				endPoint.setX(x);
				endPoint.setY(y);
				
				vecStartPoint.add(startPoint);
				vecEndPoint.add(endPoint);
				repaint();
			}
			
			public void mousePressed(MouseEvent e) {
				start = e.getPoint();
				int x = e.getX();
				int y = e.getY();
				
				startPoint = new DrawPoint();
				startPoint.setX(x);
				startPoint.setY(y);

			}
		});
		
	} //t
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		Graphics gr = getGraphics();
		g.setColor(color);
		Graphics2D g2d = (Graphics2D)gr;
		g2d.setStroke(new BasicStroke(bold));
		
		if(btnSelect == 0) // ������ �׸���
		{
			if(start != null)
			{
				g.drawLine(start.x, start.y, end.x, end.y);
			}
			for(int i = 0; i < vecStartPoint.size() ; i++)
			{
				
				int x1 = vecStartPoint.get(i).getX();
				int y1 = vecStartPoint.get(i).getY();
				int x2 = vecEndPoint.get(i).getX();
				int y2 = vecEndPoint.get(i).getY();		
				g.drawLine(x1, y1, x2, y2);
			}			
		}
		
		else if(btnSelect == 1) // ���� �׸���
		{
			
		}
		
		else if(btnSelect == 2) // �� �׸���
		{
			
		}
		
	}
}

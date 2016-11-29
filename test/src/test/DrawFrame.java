package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class DrawFrame extends JFrame {

	private JPanel contentPane;
	Color color;	//색 지정
	float bold = 3; //굵기
	int btnSelect = 0; // 도형 그리기 버튼 선택
	private JTextField TextField; //굵기 변경
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawFrame frame = new DrawFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DrawFrame() {
		setTitle("그림판");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DrawFrame.class.getResource("/test/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuOption = new JMenu("옵션");
		menuBar.add(MenuOption);
		
		JMenuItem MItemColor = new JMenuItem("\uC0C9\uC0C1");
		MenuOption.add(MItemColor);
		
		JMenuItem MItemGet = new JMenuItem("\uBD88\uB7EC\uC624\uAE30");
		MenuOption.add(MItemGet);
		
		JMenuItem MItemSave = new JMenuItem("\uC800\uC7A5");
		MenuOption.add(MItemSave);
		
		JMenuItem MItemExit = new JMenuItem("New menu item");
		MenuOption.add(MItemExit);
		contentPane = new DrawPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel OptionPanel = new JPanel();
		contentPane.add(OptionPanel, BorderLayout.NORTH);
		
		JPanel ToolPanel = new JPanel();
		OptionPanel.add(ToolPanel);
		
		JToolBar toolBar = new JToolBar();
		ToolPanel.add(toolBar);
		
		JButton btnTextBox = new JButton("\uD14D\uC2A4\uD2B8\uC0C1\uC790");
		toolBar.add(btnTextBox);
		
		JPanel FigurePanel = new JPanel();
		OptionPanel.add(FigurePanel);
		
		JToolBar toolBar_1 = new JToolBar();
		FigurePanel.add(toolBar_1);
		
		JButton btnPen = new JButton("\uD39C");
		toolBar_1.add(btnPen);
		
		JButton btnLine = new JButton("\uC120");
		toolBar_1.add(btnLine);
		
		JButton btnOval = new JButton("\uC6D0");
		toolBar_1.add(btnOval);
		
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar toolBar_2 = new JToolBar();
		SizePanel.add(toolBar_2);
		
		TextField = new JTextField();
		toolBar_2.add(TextField);
		TextField.setColumns(2);
		
		JButton BtnSizeChange = new JButton("\uBCC0\uACBD");
		SizePanel.add(BtnSizeChange);
		
		JPanel ColorPanel = new JPanel();
		OptionPanel.add(ColorPanel);
		
		JToolBar toolBar_3 = new JToolBar();
		ColorPanel.add(toolBar_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
	}
}

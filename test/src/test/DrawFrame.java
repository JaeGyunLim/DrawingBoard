package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class DrawFrame extends JFrame {

	private JPanel contentPane;
	Color color;	//색 지정
	DrawPoint bold;
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
		contentPane = new DrawPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuOption = new JMenu("옵션");
		menuBar.add(MenuOption);
		
		JMenuItem MItemColor = new JMenuItem("색상");
		MenuOption.add(MItemColor);
		
		//옵션 - 색상
		MItemColor.addActionListener(new ActionListener()
		{
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
		
		JMenuItem MItemExit = new JMenuItem("나가기");
		MenuOption.add(MItemExit);
		
		//옵션 - 나기기 누를 경우 종료
		MItemExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		JPanel OptionPanel = new JPanel();
		contentPane.add(OptionPanel, BorderLayout.NORTH);
		
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
		
		JButton btnLine = new JButton("직선");
		toolBar_1.add(btnLine);
		
		JButton btnOval = new JButton("원");
		toolBar_1.add(btnOval);
		
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar toolBar_2 = new JToolBar();
		SizePanel.add(toolBar_2);
		
		TextField = new JTextField();
		toolBar_2.add(TextField);
		TextField.setColumns(2);
		
		JButton BtnSizeChange = new JButton("변경");
		SizePanel.add(BtnSizeChange);
		
		BtnSizeChange.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//bold = (Integer.parseInt(TextField.getText().trim()));
			}
		});
		
		JPanel ColorPanel = new JPanel();
		OptionPanel.add(ColorPanel);
		
		JToolBar toolBar_3 = new JToolBar();
		ColorPanel.add(toolBar_3);
		
		
	}
}

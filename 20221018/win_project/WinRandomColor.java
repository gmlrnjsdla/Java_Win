package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WinRandomColor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinRandomColor frame = new WinRandomColor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinRandomColor() {
		setTitle("Random Color");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {	// 더블클릭
					int red   = (int)(Math.random()*256);
					int green = (int)(Math.random()*256);
					int blue  = (int)(Math.random()*256);
					
					contentPane.setBackground(new Color(red, green, blue));
					setTitle("RGB ("+red+","+green+","+blue+")");
				}
			}
		});
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					int red   = (int)(Math.random()*256);
					int green = (int)(Math.random()*256);
					int blue  = (int)(Math.random()*256);
					
					contentPane.setBackground(new Color(red, green, blue));
					setTitle("RGB ("+red+","+green+","+blue+")");
				}
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);
	}

}

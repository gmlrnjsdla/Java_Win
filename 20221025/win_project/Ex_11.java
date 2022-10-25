package win_project;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ex_11 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex_11 frame = new Ex_11();
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
	public Ex_11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 182, 193));
		lblNewLabel.setBounds(43, 40, 173, 145);
		contentPane.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int year = Integer.parseInt(textField.getText());
				String animal[] = {"신","유","술","해","자","축","인","묘","진","사","오","미"};
				int index = year % 12;
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					ImageIcon image =new ImageIcon(".\\images\\"+animal[index]+".png");
					Image pic = image.getImage();  // 크기 조정을 위한 구문들 ..아래3줄
		            pic = pic.getScaledInstance(173, 145, Image.SCALE_SMOOTH);
		            ImageIcon convImage = new ImageIcon(pic);
		            lblNewLabel.setIcon(convImage);

				}
			}
		});
		textField.setBounds(124, 227, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("연도 입력 : ");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 230, 87, 15);
		contentPane.add(lblNewLabel_1);
	}
}

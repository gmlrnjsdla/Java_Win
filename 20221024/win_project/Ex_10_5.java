package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class Ex_10_5 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex_10_5 frame = new Ex_10_5();
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
	public Ex_10_5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Love Java");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 10));
		
		lblNewLabel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				Font F = lblNewLabel.getFont().getSize();
//				int size = F.getSize();
				
				if(e.getKeyChar()== '+') {
					lblNewLabel.setFont(new Font("굴림", Font.PLAIN, lblNewLabel.getFont().getSize()+5));
					
				}
				if(e.getKeyChar()== '-') {
					lblNewLabel.setFont(new Font("굴림", Font.PLAIN, lblNewLabel.getFont().getSize()-5));
				}
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 410, 241);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFocusable(true);
		lblNewLabel.requestFocus();
	}
}

package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_GBB extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_GBB frame = new Win_GBB();
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
	public Win_GBB() {
		setTitle("가위바위보 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHuman = new JLabel("");
		lblHuman.setIcon(new ImageIcon(".\\images\\가위.png"));
		lblHuman.setBackground(new Color(255, 0, 255));
		lblHuman.setBounds(56, 52, 100, 100);
		contentPane.add(lblHuman);
		lblHuman.setOpaque(true);
		
		JLabel lblComputer = new JLabel("");
		lblComputer.setIcon(new ImageIcon(".\\images\\보.png"));
		lblComputer.setBackground(new Color(255, 255, 0));
		lblComputer.setBounds(280, 52, 100, 100);
		contentPane.add(lblComputer);
		lblComputer.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(56, 28, 69, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblCom = new JLabel("COM");
		lblCom.setFont(new Font("굴림", Font.BOLD, 15));
		lblCom.setBounds(280, 28, 57, 18);
		contentPane.add(lblCom);
		
		JLabel lblNewLabel_1 = new JLabel("VS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 32));
		lblNewLabel_1.setBounds(179, 83, 79, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblresult = new JLabel("결과");
		lblresult.setFont(new Font("굴림", Font.BOLD, 15));
		lblresult.setHorizontalAlignment(SwingConstants.CENTER);
		lblresult.setBounds(106, 224, 231, 27);
		contentPane.add(lblresult);
		
		JButton btnNewButton = new JButton("시작");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String GBB[] = {"가위", "바위", "보"};
				int human = (int)(Math.random()*3);
				int computer = (int)(Math.random()*3);
				lblHuman.setIcon(new ImageIcon(".\\images\\"+GBB[human]+".png"));
				lblComputer.setIcon(new ImageIcon(".\\images\\"+GBB[computer]+".png"));
				
				if((human == 0 && computer == 2) || (human == 1 && computer == 0) || (human == 2 && computer == 1)) {
					lblresult.setText("USER가 이겼습니다.");
				}
				else if((human == 0 && computer == 1) || (human == 1 && computer == 2) || (human == 2 && computer == 0)) {
					lblresult.setText("USER가 졌습니다.");
				}
				else {
					lblresult.setText("비겼습니다.");
				}
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(179, 167, 79, 40);
		contentPane.add(btnNewButton);
		
		
	}
}

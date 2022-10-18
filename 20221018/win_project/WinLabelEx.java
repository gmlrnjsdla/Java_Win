package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class WinLabelEx extends JFrame {

	private JPanel contentPane;
	private JTextField tf_type;
	private JLabel lblPic;
	private JButton btnGawi;
	private JButton btnBawi;
	private JButton btnBo;
	private JLabel lblComPic;
	private JLabel lblNewLabel;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinLabelEx frame = new WinLabelEx();
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
	public WinLabelEx() {
		setTitle("레이블 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisplay = new JLabel("Typing...");
		lblDisplay.setFont(new Font("굴림", Font.BOLD, 20));
		lblDisplay.setBounds(43, 10, 347, 44);
		contentPane.add(lblDisplay);
		
		tf_type = new JTextField();
		tf_type.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String txt = tf_type.getText();
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					lblDisplay.setText(txt);
					tf_type.setText("");
				}
			}
		});
		tf_type.setToolTipText("입력 후 Enter");
		tf_type.setBounds(43, 64, 347, 21);
		contentPane.add(tf_type);
		tf_type.setColumns(10);
		
		lblPic = new JLabel("");
		
		lblPic.setBackground(new Color(255, 255, 0));
		lblPic.setBounds(43, 95, 347, 248);
		lblPic.setOpaque(true);		//추가
		contentPane.add(lblPic);
		
		btnGawi = new JButton("가위");
		btnGawi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon("images/가위.png");
				lblPic.setIcon(image);
				String Choice[] = {"가위", "바위", "보"};
				int index = (int)(Math.random()*3);
				ImageIcon image1 = new ImageIcon("images/"+Choice[index]+".png");
				lblComPic.setIcon(image1);
				
				if(index == 0) {
					lblResult.setText("비겼습니다.");
				}
				else if(index == 1) {
					lblResult.setText("졌습니다.");
				}
				else {
					lblResult.setText("이겼습니다!!");
				}
			}
		});
		btnGawi.setBounds(43, 354, 97, 23);
		contentPane.add(btnGawi);
		
		btnBawi = new JButton("바위");
		btnBawi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon("images/바위.png");
				lblPic.setIcon(image);
				String Choice[] = {"가위", "바위", "보"};
				int index = (int)(Math.random()*3);
				ImageIcon image1 = new ImageIcon("images/"+Choice[index]+".png");
				lblComPic.setIcon(image1);
				
				if(index == 1) {
					lblResult.setText("비겼습니다.");
				}
				else if(index == 2) {
					lblResult.setText("졌습니다.");
				}
				else {
					lblResult.setText("이겼습니다!!");
				}
			}
		});
		btnBawi.setBounds(168, 353, 97, 23);
		contentPane.add(btnBawi);
		
		btnBo = new JButton("보");
		btnBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon("images/보.png");
				lblPic.setIcon(image);
				String Choice[] = {"가위", "바위", "보"};
				int index = (int)(Math.random()*3);
				ImageIcon image1 = new ImageIcon("images/"+Choice[index]+".png");
				lblComPic.setIcon(image1);
				
				if(index == 2) {
					lblResult.setText("비겼습니다.");
				}
				else if(index == 0) {
					lblResult.setText("졌습니다.");
				}
				else {
					lblResult.setText("이겼습니다!!");
				}
			}
		});
		btnBo.setBounds(293, 353, 97, 23);
		contentPane.add(btnBo);
		
		lblComPic = new JLabel("Computer");
		lblComPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblComPic.setOpaque(true);
		lblComPic.setBackground(new Color(192, 192, 192));
		lblComPic.setBounds(428, 95, 347, 248);
		contentPane.add(lblComPic);
		
		lblNewLabel = new JLabel("VS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(369, 198, 79, 38);
		contentPane.add(lblNewLabel);
		
		lblResult = new JLabel("결과");
		lblResult.setFont(new Font("굴림", Font.BOLD, 21));
		lblResult.setBounds(489, 354, 184, 48);
		contentPane.add(lblResult);
	}

}

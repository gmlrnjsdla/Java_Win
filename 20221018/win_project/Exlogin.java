package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Exlogin extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exlogin frame = new Exlogin();
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
	public Exlogin() {
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 48, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(36, 79, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tf_id = new JTextField();
		tf_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					tf_pw.requestFocus();
				}
			}
		});
		tf_id.setBounds(105, 45, 141, 21);
		contentPane.add(tf_id);
		tf_id.setColumns(10);
		
		tf_pw = new JTextField();
		tf_pw.setBounds(105, 76, 141, 21);
		contentPane.add(tf_pw);
		tf_pw.setColumns(10);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = tf_id.getText();
				String PW = tf_pw.getText();
				if(ID.equals("ici") && PW.equals("123")) {
					System.out.println("로그인 성공했습니다.");
					ExSuccess exSuccess = new ExSuccess();
					exSuccess.setVisible(true);
				}
				else {
					System.out.println("실패!");
					ExFail exFail = new ExFail();
					exFail.setVisible(true);
				}
				
			}
		});
		btnLogin.setBounds(258, 44, 89, 56);
		contentPane.add(btnLogin);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExJoin exJoin = new ExJoin();
				exJoin.setVisible(true);
			}
		});
		btnJoin.setFont(new Font("굴림", Font.BOLD, 15));
		btnJoin.setBounds(240, 121, 97, 23);
		contentPane.add(btnJoin);
	}
}

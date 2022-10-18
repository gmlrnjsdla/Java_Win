package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ExJoin extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_pw;
	private JTextField tf_name;
	private JTextField tf_phone;
	private JTextField tf_mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExJoin frame = new ExJoin();
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
	public ExJoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 15, 15));
		
		JLabel lblNewLabel = new JLabel("아이디 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		tf_id = new JTextField();
		contentPane.add(tf_id);
		tf_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		tf_pw = new JTextField();
		contentPane.add(tf_pw);
		tf_pw.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("이름 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		tf_name = new JTextField();
		contentPane.add(tf_name);
		tf_name.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호 : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);
		
		tf_phone = new JTextField();
		contentPane.add(tf_phone);
		tf_phone.setColumns(20);
		
		JLabel lblNewLabel_4 = new JLabel("이메일 : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);
		
		tf_mail = new JTextField();
		contentPane.add(tf_mail);
		tf_mail.setColumns(20);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(btnJoin);
	}

}

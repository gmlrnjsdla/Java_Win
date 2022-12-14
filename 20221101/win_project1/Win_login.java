package win_project1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Win_login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfId;
	private JTextField tfPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_login dialog = new Win_login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_login() {
		setTitle("Login");
		setBounds(100, 100, 414, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(43, 43, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			tfId = new JTextField();
			tfId.setBounds(112, 40, 152, 21);
			contentPanel.add(tfId);
			tfId.setColumns(20);
		}
		{
			JLabel lblPw = new JLabel("PW");
			lblPw.setHorizontalAlignment(SwingConstants.CENTER);
			lblPw.setBounds(43, 88, 57, 15);
			contentPanel.add(lblPw);
		}
		{
			tfPw = new JTextField();
			tfPw.setColumns(20);
			tfPw.setBounds(112, 85, 152, 21);
			contentPanel.add(tfPw);
		}
		{
			JButton btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String id = tfId.getText();
						String pw = tfPw.getText();
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection
								("jdbc:mysql://localhost:3306/sqldb", "root","1234");
						System.out.println("DB Connected...");
						
						String sql = "SELECT pw FROM logintbl WHERE id=?";
						
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, id);
						
						ResultSet rs = pstmt.executeQuery();
						
						if(rs.next()) {
							String dbpw = rs.getString("pw");
							if(dbpw.equals(pw)) {
								JOptionPane.showMessageDialog(null, "로그인 성공");
								WinMain winMain = new WinMain();
								setVisible(false);
								winMain.setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "비밀번호 틀림");
							}
						}else {
							JOptionPane.showMessageDialog(null, "비회원");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
				}
			});
			btnLogin.setBounds(276, 39, 78, 64);
			contentPanel.add(btnLogin);
		}
		{
			JButton btnInsert = new JButton("Insert");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String id = tfId.getText();
						String pw = tfPw.getText();
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection
								("jdbc:mysql://localhost:3306/sqldb", "root","1234");
						System.out.println("DB Connected...");
						
						Statement stmt = conn.createStatement();
						
												
						stmt.executeUpdate("INSERT INTO logintbl(id,pw)"
								+ "VALUES ('"+id+"','"+pw+"')");
						
						
						JOptionPane.showMessageDialog(null, "회원가입 성공!");
						
							
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "실패! 중복된 아이디");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			btnInsert.setBounds(53, 122, 97, 23);
			contentPanel.add(btnInsert);
		}
		{
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String id = tfId.getText();
						String pw = tfPw.getText();
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection
								("jdbc:mysql://localhost:3306/sqldb", "root","1234");
						System.out.println("DB Connected...");
						
						
						String prevPw = JOptionPane.showInputDialog("기존 비밀번호 입력");
						String sql = "SELECT pw FROM logintbl WHERE id=?";
						PreparedStatement pstmt1 = conn.prepareStatement(sql);
						pstmt1.setString(1, id);
						ResultSet rs = pstmt1.executeQuery();
						
						if(rs.next()) {
							String dbpw = rs.getString("pw");
							if(dbpw.equals(prevPw)) {
								sql = "UPDATE logintbl SET pw=? WHERE id=?";
														
								PreparedStatement pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, pw);
								pstmt.setString(2, id);
								
								pstmt.executeUpdate();
								JOptionPane.showMessageDialog(null, "업데이트 성공!");
							}
							else {
								JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "아이디가 틀렸습니다.");
						}
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			btnUpdate.setBounds(162, 122, 97, 23);
			contentPanel.add(btnUpdate);
		}
		{
			JButton btndelete = new JButton("Delete");
			btndelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String id = tfId.getText();
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection
								("jdbc:mysql://localhost:3306/sqldb", "root","1234");
						System.out.println("DB Connected...");
						
						String prevPw = JOptionPane.showInputDialog("비밀번호 확인");
						String sql = "SELECT pw FROM logintbl WHERE id=?";
						PreparedStatement pstmt1 = conn.prepareStatement(sql);
						pstmt1.setString(1, id);
						ResultSet rs = pstmt1.executeQuery();
						int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
						
						if(result == JOptionPane.YES_OPTION) {
							if(rs.next()) {
								String dbpw = rs.getString("pw");
								if(dbpw.equals(prevPw)) {
									sql = "DELETE FROM logintbl WHERE id=?";
													
									PreparedStatement pstmt = conn.prepareStatement(sql);
									pstmt.setString(1, id);
									
									pstmt.executeUpdate();
									JOptionPane.showMessageDialog(null, "삭제되었습니다.");
									
								}
								else {
									JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
									}
							}
							else {
								JOptionPane.showMessageDialog(null, "아이디가 틀렸습니다.");
								}
						}	
						else {
							JOptionPane.showMessageDialog(null, "취소되었습니다.");
						}
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			btndelete.setBounds(271, 122, 97, 23);
			contentPanel.add(btndelete);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}

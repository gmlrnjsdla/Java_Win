package win_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class curdate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfToday;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDay;
	private JTextField tfday1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			curdate dialog = new curdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public curdate() {
		setBounds(100, 100, 336, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("오늘날짜");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(37, 55, 57, 15);
		contentPanel.add(lblNewLabel);
		
		tfToday = new JTextField();
		tfToday.setBounds(110, 52, 116, 21);
		contentPanel.add(tfToday);
		tfToday.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("년도");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(37, 122, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(110, 119, 116, 21);
		contentPanel.add(tfYear);
		
		JLabel lblNewLabel_2 = new JLabel("월");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(37, 150, 57, 15);
		contentPanel.add(lblNewLabel_2);
		
		tfMonth = new JTextField();
		tfMonth.setColumns(10);
		tfMonth.setBounds(110, 147, 116, 21);
		contentPanel.add(tfMonth);
		
		JLabel lblNewLabel_3 = new JLabel("일");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(37, 178, 57, 15);
		contentPanel.add(lblNewLabel_3);
		
		tfDay = new JTextField();
		tfDay.setColumns(10);
		tfDay.setBounds(110, 175, 116, 21);
		contentPanel.add(tfDay);
		
		JLabel lblDiff = new JLabel("diff");
		lblDiff.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiff.setBounds(37, 27, 57, 15);
		contentPanel.add(lblDiff);
		
		JSpinner tfDiff = new JSpinner();
		tfDiff.setModel(new SpinnerNumberModel(Integer.valueOf(100), null, null, Integer.valueOf(10)));
		tfDiff.setBounds(110, 20, 116, 22);
		contentPanel.add(tfDiff);
		
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/sqldb", "root","1234");
					
					String diff = tfDiff.getValue().toString();
					String sql = "SELECT curdate() as 현재날짜, ADDDATE(curdate(), INTERVAL "+diff+" DAY),"
							+ "CASE dayofweek(ADDDATE(curdate(), INTERVAL "+diff+" DAY)) "
							+ "when 1 then '일요일'"
							+ "when 2 then '월요일'"
							+ "when 3 then '화요일'"
							+ "when 4 then '수요일'"
							+ "when 5 then '목요일'"
							+ "when 6 then '금요일'"
							+ "when 7 then '토요일' end";
					
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						String date = rs.getString("현재날짜");
						String date2 = rs.getString(2);
						String day = rs.getString(3);
						tfToday.setText(date);
						
						tfYear.setText(date2.substring(0, 4)+"년");
						tfMonth.setText(date2.substring(5, 7)+"월");
						tfDay.setText(date2.substring(8, 10)+"일");
						tfday1.setText(day);
						
						
					}
					
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
			
		});
		btnNewButton.setBounds(236, 52, 60, 21);
		contentPanel.add(btnNewButton);
		
		
		JLabel lblNewLabel_4 = new JLabel("▼");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(134, 90, 57, 15);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("요일");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setBounds(37, 206, 57, 15);
		contentPanel.add(lblNewLabel_3_1);
		
		tfday1 = new JTextField();
		tfday1.setColumns(10);
		tfday1.setBounds(110, 203, 116, 21);
		contentPanel.add(tfday1);
		
		JButton btncreate = new JButton("CREATE DB");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/sqldb", "root","1234");
					
					String sql = "CREATE DATABASE moviedb";
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		btncreate.setBounds(110, 249, 109, 23);
		contentPanel.add(btncreate);
		
		
	}
}

package win_project;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WinModelTable extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextField tfTotal;
	private JTextField tfAverage;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinModelTable dialog = new WinModelTable();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinModelTable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfName.requestFocus();
			}
		});
		setBounds(100, 100, 505, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name : ");
		lblNewLabel.setBounds(33, 27, 57, 15);
		contentPanel.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(102, 24, 116, 21);
		contentPanel.add(tfName);
		tfName.setColumns(10);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(102, 52, 116, 21);
		contentPanel.add(tfKor);
		
		JLabel lblKorean = new JLabel("Korean : ");
		lblKorean.setBounds(33, 55, 57, 15);
		contentPanel.add(lblKorean);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(102, 83, 116, 21);
		contentPanel.add(tfEng);
		
		JLabel lblEnglish = new JLabel("English : ");
		lblEnglish.setBounds(33, 86, 57, 15);
		contentPanel.add(lblEnglish);
		
		tfMath = new JTextField();
		tfMath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int sum = Integer.parseInt(tfKor.getText());
					sum += Integer.parseInt(tfEng.getText());
					sum += Integer.parseInt(tfMath.getText());
					tfTotal.setText(Integer.toString(sum));
					tfAverage.setText(Double.toString(sum/3));
					
//					DefaultTableModel model = (DefaultTableModel)table.getModel();
//					String record[] = new String [6];
//					record[0] = tfName.getText();
//					record[1] = tfKor.getText();
//					record[2] = tfEng.getText();
//					record[3] = tfMath.getText();
//					record[4] = tfTotal.getText();
//					record[5] = tfAverage.getText();
//					
//					model.addRow(record);
//					clearAll();
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection
								("jdbc:mysql://localhost:3306/sqldb", "root","1234");
						
						String name = tfName.getText();
						String kor = tfKor.getText();
						String eng = tfEng.getText();
						String math = tfMath.getText();
						String total = tfTotal.getText();
						String avr = tfAverage.getText();
						
						String sql ="INSERT INTO scoretbl(name,korean,english,math,total,average) "
								+ "VALUES('"+name+"','"+kor+"','"+eng+"','"+math+"','"+total+"','"+avr+"')"; 
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(sql);
						
						} catch (Exception e1) {
						e1.printStackTrace();
						}
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					table();
					
				}
			}
		});
		tfMath.setColumns(10);
		tfMath.setBounds(102, 114, 116, 21);
		contentPanel.add(tfMath);
		
		JLabel lblMath = new JLabel("Math : ");
		lblMath.setBounds(33, 117, 57, 15);
		contentPanel.add(lblMath);
		
		tfTotal = new JTextField();
		tfTotal.setEnabled(false);
		tfTotal.setColumns(10);
		tfTotal.setBounds(102, 145, 116, 21);
		contentPanel.add(tfTotal);
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setBounds(33, 148, 57, 15);
		contentPanel.add(lblTotal);
		
		tfAverage = new JTextField();
		tfAverage.setEnabled(false);
		tfAverage.setColumns(10);
		tfAverage.setBounds(102, 176, 116, 21);
		contentPanel.add(tfAverage);
		
		JLabel lblNewLabel_4_1 = new JLabel("Average : ");
		lblNewLabel_4_1.setBounds(33, 179, 70, 15);
		contentPanel.add(lblNewLabel_4_1);
		
		
		
		JButton btnAdd = new JButton("레코드 추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel model = (DefaultTableModel)table.getModel();
//				String record[] = new String [6];
//				record[0] = tfName.getText();
//				record[1] = tfKor.getText();
//				record[2] = tfEng.getText();
//				record[3] = tfMath.getText();
//				record[4] = tfTotal.getText();
//				record[5] = tfAverage.getText();
//				
//				model.addRow(record);
//				clearAll();
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/sqldb", "root","1234");
					
					String name = tfName.getText();
					String kor = tfKor.getText();
					String eng = tfEng.getText();
					String math = tfMath.getText();
					String total = tfTotal.getText();
					String avr = tfAverage.getText();
					
					String sql ="INSERT INTO scoretbl(name,korean,english,math,total,average) "
							+ "VALUES('"+name+"','"+kor+"','"+eng+"','"+math+"','"+total+"','"+avr+"')"; 
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				table();
			}

			
		});
		btnAdd.setBounds(269, 175, 110, 23);
		contentPanel.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 225, 465, 205);
		contentPanel.add(scrollPane);
		
		
		String header[]= {"NO","Name","Korean","English","Math","Total","Average"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getSelectedRow());
			}
		});
		table();
		scrollPane.setViewportView(table);
		
		JButton btnAdd_1 = new JButton("레코드 삭제");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				if(idx != -1) {
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection
								("jdbc:mysql://localhost:3306/sqldb", "root","1234");
						
						String no = (String)table.getValueAt(table.getSelectedRow(),0);  
						
						String sql ="DELETE FROM scoretbl WHERE idx = '"+no+"'"; 
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(sql);
//						model.removeRow(idx);
						
						} catch (Exception e1) {
						e1.printStackTrace();
						}
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					table();
					
				}
				else
					JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요");
			}
		});
		btnAdd_1.setBounds(269, 144, 110, 23);
		contentPanel.add(btnAdd_1);
	}
	
	
	private void clearAll() {
		// TODO Auto-generated method stub
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMath.setText("");
		tfTotal.setText("");
		tfAverage.setText("");
		tfName.requestFocus();
	}
	
	private void table() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sqldb", "root","1234");
			
			String sql ="SELECT * FROM scoretbl ORDER BY idx DESC"; 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String idx = rs.getString("idx");
				String name = rs.getString("name");
				String korean = rs.getString("korean");
				String english = rs.getString("english");
				String math = rs.getString("math");
				String total = rs.getString("total");
				String average = rs.getString("average");
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String record[] = new String [7];
				record[0] = idx;
				record[1] = name;
				record[2] = korean;
				record[3] = english;
				record[4] = math;
				record[5] = total;
				record[6] = average;
				
				
				model.addRow(record);
				clearAll();
			}
			
			} catch (Exception e1) {
			e1.printStackTrace();
			}
	}
}

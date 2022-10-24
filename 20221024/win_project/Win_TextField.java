package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Win_TextField extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_TextField frame = new Win_TextField();
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
	public Win_TextField() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txt_Name = new JTextField();
		txt_Name.setText("홍길동");
		panel.add(txt_Name);
		txt_Name.setColumns(15);
		
		JCheckBox ckEditable = new JCheckBox("편집 가능");
		ckEditable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ckEditable.isSelected()) {
//					txt_Name.setEditable(true);
					txt_Name.setEnabled(true);
				}
				else {
//					txt_Name.setEditable(false);
					txt_Name.setEnabled(false);
				}
			}
		});
		ckEditable.setSelected(true);
		panel.add(ckEditable);
		
	}
}

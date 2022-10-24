package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Win_list extends JFrame {

	private JPanel contentPane;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_list frame = new Win_list();
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
	public Win_list() {
		setTitle("list");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(list.getSelectedIndex());
//				System.out.println(list.getSelectedValue());
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"쥐", "소", "호랑이", "토끼", "용", "뱀", "원숭이"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(38, 33, 115, 116);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("출력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int idx [] = list.getSelectedIndices();
		            for(int i=0; i< idx.length; i++) {
		               list.setSelectedIndex(idx[i]);               
		               System.out.println(list.getSelectedValue());
		            }
		            list.setSelectedIndices(idx);	
		            System.out.println(comboBox.getSelectedIndex());
		            System.out.println(comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setBounds(195, 33, 103, 116);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"홍길동", "홍길순", "이길동", "김길동", "김기동", "황길동", "윤길동", "임길동", "고길동", "차길동"}));
		comboBox.setBounds(193, 159, 105, 28);
		comboBox.setSelectedIndex(9);
		contentPane.add(comboBox);
	}
}

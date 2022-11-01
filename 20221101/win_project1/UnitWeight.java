package win_project1;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UnitWeight extends JPanel {
	private JTextField tfValue;
	JLabel lblResult;
	
	public UnitWeight() {
		setLayout(null);
		
		tfValue = new JTextField();
		tfValue.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValue.setFont(new Font("����", Font.BOLD, 20));
		tfValue.setColumns(10);
		tfValue.setBounds(30, 150, 116, 21);
		add(tfValue);
		
		JComboBox cbUnit1 = new JComboBox();
		cbUnit1.setModel(new DefaultComboBoxModel(new String[] {"kg", "oz", "lb", "\uADFC"}));
		cbUnit1.setFont(new Font("����", Font.BOLD, 20));
		cbUnit1.setBounds(160, 150, 79, 23);
		add(cbUnit1);
		
		JComboBox cbUnit2 = new JComboBox();
		cbUnit2.setModel(new DefaultComboBoxModel(new String[] {"kg", "oz", "lb", "\uADFC"}));
		cbUnit2.setFont(new Font("����", Font.BOLD, 20));
		cbUnit2.setBounds(298, 150, 79, 23);
		add(cbUnit2);
		
		JButton btnConvert = new JButton("\uBCC0\uD658");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(tfValue.getText());
				String unit1 = cbUnit1.getSelectedItem().toString();
				String unit2 = cbUnit2.getSelectedItem().toString();
				double Unit[][] ={ 
						{1,        35.273962, 2.204623,   1.666667},
						{0.02835,  1,         0.0625,     0.047249},
						{0.453592, 16,        1,          0.755987},
						{0.6,      21.164377, 1.322774,   1}				
				}; 
				double result = 0;
				
				result = (double)value*Unit[cbUnit1.getSelectedIndex()][cbUnit2.getSelectedIndex()];
				
				lblResult.setText(result + unit2);
			}
		});
		btnConvert.setFont(new Font("����", Font.BOLD, 20));
		btnConvert.setBounds(394, 150, 97, 23);
		add(btnConvert);
		
		lblResult = new JLabel("\uACB0\uACFC:");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("����", Font.BOLD, 20));
		lblResult.setBounds(160, 204, 219, 39);
		add(lblResult);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = cbUnit1.getSelectedIndex();
				int j = cbUnit2.getSelectedIndex();				
				
				cbUnit1.setSelectedIndex(j);
				cbUnit2.setSelectedIndex(i);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\FileIO\\images\\switch.png"));
		lblNewLabel.setBounds(251, 127, 50, 50);
		add(lblNewLabel);
	}

}

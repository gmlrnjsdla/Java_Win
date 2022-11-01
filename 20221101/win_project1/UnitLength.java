package win_project1;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UnitLength extends JPanel {
	private JTextField tfValue;
	JLabel lblResult;
	
	public UnitLength() {
		setLayout(null);
		
		tfValue = new JTextField();
		tfValue.setBounds(27, 62, 156, 30);
		tfValue.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValue.setFont(new Font("����", Font.BOLD, 20));
		tfValue.setColumns(10);
		add(tfValue);
		
		JComboBox cbUnit1 = new JComboBox();
		cbUnit1.setModel(new DefaultComboBoxModel(new String[] {"cm", "km", "yard", "mile"}));
		cbUnit1.setBounds(183, 61, 85, 32);
		cbUnit1.setFont(new Font("����", Font.BOLD, 20));
		add(cbUnit1);
		
		JComboBox cbUnit2 = new JComboBox();
		cbUnit2.setModel(new DefaultComboBoxModel(new String[] {"cm", "km", "yard", "mile"}));
		cbUnit2.setBounds(315, 61, 85, 32);
		cbUnit2.setFont(new Font("����", Font.BOLD, 20));
		add(cbUnit2);
		
		JLabel lblNewLabel = new JLabel("<>");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = cbUnit1.getSelectedIndex();
				int j = cbUnit2.getSelectedIndex();				
				
				cbUnit1.setSelectedIndex(j);
				cbUnit2.setSelectedIndex(i);
			}
		});
		lblNewLabel.setBounds(274, 65, 34, 24);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		add(lblNewLabel);
		
		JButton btnConvert = new JButton("\uBCC0\uD658");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(tfValue.getText());
				String unit1 = cbUnit1.getSelectedItem().toString();
				String unit2 = cbUnit2.getSelectedItem().toString();
				double Unit[][] ={ 
						{1, 0.00001, 0.010936,0.000006},
						{100000, 1, 1093.6133,0.621371},
						{0.000568, 0.000914, 1,0.000568},
						{160934.4, 1.609344, 1760,1}				
				}; 
				double result = 0;
				
				result = (double)value*Unit[cbUnit1.getSelectedIndex()][cbUnit2.getSelectedIndex()];
				
				lblResult.setText(result + unit2);
			}
		});
		btnConvert.setBounds(412, 61, 89, 33);
		btnConvert.setFont(new Font("����", Font.BOLD, 20));
		add(btnConvert);
		
		lblResult = new JLabel("\uACB0\uACFC:");
		lblResult.setBounds(165, 142, 177, 24);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("����", Font.BOLD, 20));
		add(lblResult);
	}

}

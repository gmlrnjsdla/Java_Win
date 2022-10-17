import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class WinCalculator_project extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int op1; // 피연산자1
	private int op2; // 피연산자2
	private String operand; // 연산자 +-*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinCalculator_project frame = new WinCalculator_project();
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
	public WinCalculator_project() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("수식입력");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(textField);
		textField.setColumns(15);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("계산 결과");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("굴림", Font.BOLD, 15));
		textField_1.setColumns(15);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"0");
			}
		});
		btn0.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn0);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"1");
			}
		});
		btn1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"2");
			}
		});
		btn2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"3");
			}
		});
		btn3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"4");
			}
		});
		btn4.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"5");
			}
		});
		btn5.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"6");
			}
		});
		btn6.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"7");
			}
		});
		btn7.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"8");
			}
		});
		btn8.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = textField.getText();
				textField.setText(value+"9");
			}
		});
		btn9.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btn9);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnCE.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btnCE);
		
		JButton btnCal = new JButton("계산");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op2 = Integer.parseInt(textField.getText());
				
				
				int result = 0;
				
				switch(operand) {
				case "+":
					result = op1 + op2;
					break;
				case "-":
					result = op1 - op2;
					break;
				case "x":
					result = op1 * op2;
					break;
				case "/":
					result = op1 / op2;
					break;
				case "**":
					result=1;
					for(int i=1; i<=op2; i++) {
						result = result * op1;
					}
				}
				
				textField_1.setText(result+"");
				
			}
		});
		btnCal.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btnCal);
		
		JButton btnNewButton_12 = new JButton("+");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("");
				operand = "+";
			}
		});
		btnNewButton_12.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("-");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("");
				operand = "-";
			}
		});
		btnNewButton_13.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("x");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("");
				operand = "x";
			}
		});
		btnNewButton_14.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("/");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("");
				operand = "/";
			}
		});
		btnNewButton_15.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(btnNewButton_15);
		
		JButton btnNewButton = new JButton("1/x");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("1/"+op1);
				textField_1.setText((double)1/op1+"");
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" x²");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText(op1+"x"+op1);
				textField_1.setText((op1*op1)+"");
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("√x");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("root("+op1+")=");
				Double result = Math.sqrt((double)op1);
				textField_1.setText(result+"");
			}
		});
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("x^y");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Integer.parseInt(textField.getText());
				textField.setText("");
				operand = "**";
			}
		});
		panel_2.add(btnNewButton_3);
	}

}

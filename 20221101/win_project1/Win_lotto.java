package win_project1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_lotto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	int number = 1;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	JLabel lbl5;
	JLabel lbl6;
	private JLabel lbl7;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_lotto dialog = new Win_lotto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_lotto() {
		setTitle("Lotto");
		setBounds(100, 100, 450, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbl1 = new JLabel("");
			lbl1.setBackground(new Color(255, 255, 255));
			lbl1.setOpaque(true);
			lbl1.setBounds(29, 67, 52, 52);
			contentPanel.add(lbl1);
		}
		{
			lbl2 = new JLabel("");
			lbl2.setOpaque(true);
			lbl2.setBackground(Color.WHITE);
			lbl2.setBounds(93, 67, 52, 52);
			contentPanel.add(lbl2);
		}
		{
			lbl3 = new JLabel("");
			lbl3.setOpaque(true);
			lbl3.setBackground(Color.WHITE);
			lbl3.setBounds(156, 67, 52, 52);
			contentPanel.add(lbl3);
		}
		{
			lbl4 = new JLabel("");
			lbl4.setOpaque(true);
			lbl4.setBackground(Color.WHITE);
			lbl4.setBounds(220, 67, 52, 52);
			contentPanel.add(lbl4);
		}
		{
			lbl5 = new JLabel("");
			lbl5.setOpaque(true);
			lbl5.setBackground(Color.WHITE);
			lbl5.setBounds(288, 67, 52, 52);
			contentPanel.add(lbl5);
		}
		{
			lbl6 = new JLabel("");
			lbl6.setOpaque(true);
			lbl6.setBackground(Color.WHITE);
			lbl6.setBounds(359, 67, 52, 52);
			contentPanel.add(lbl6);
		}
		{
			JButton btnNewButton = new JButton("Run");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int Lotto[] = new int[7];
					int count = 0, i,j,temp;
					boolean bDup = false; // 중복 x
					
					Lotto[count++] = (int)(Math.random()*45+1);
					while(true) {
						bDup = false;
						temp = (int)(Math.random()*45+1);
						for(i=0;i<count; i++) {
							if(Lotto[i] == temp) {
								bDup = true; // 중복
								break;
							}
						}
						if(bDup == false) {
							Lotto[count++] = temp;
						}
						if(count == 7) {
							break;
						}
					}
					//오름차순 정렬
					 for(i = 0; i < 5; i++) {
	                     int min_index = i;                        
	                     // 최솟값을 갖고있는 인덱스 찾기 
	                     for(j = i + 1; j < 6; j++) {
	                        if(Lotto[j] < Lotto[min_index]) {
	                           min_index = j;
	                        }
	                     }
	                     temp = Lotto[min_index];
	                     Lotto[min_index] = Lotto[i];
	                     Lotto[i] = temp;
	                  }  // 선택 정렬의 끝

					lbl1.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[0]+".png"));
					lbl2.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[1]+".png"));
					lbl3.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[2]+".png"));
					lbl4.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[3]+".png"));
					lbl5.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[4]+".png"));
					lbl6.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[5]+".png"));
					lbl7.setIcon(new ImageIcon(".\\lotto_img\\ball_"+Lotto[6]+".png"));
					

					
				}
			});
			btnNewButton.setBounds(175, 239, 97, 23);
			contentPanel.add(btnNewButton);
		}
		{
			lbl7 = new JLabel("");
			lbl7.setOpaque(true);
			lbl7.setBackground(Color.WHITE);
			lbl7.setBounds(189, 161, 52, 52);
			contentPanel.add(lbl7);
		}
		{
			lblNewLabel = new JLabel("+");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 28));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(184, 129, 57, 22);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}

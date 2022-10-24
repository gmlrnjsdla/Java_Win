package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Win_Checkbox extends JFrame {

	   private JPanel contentPane;
	   int red;
	   int green;
	   int blue;
	   JCheckBox ckRed;
	   JCheckBox ckGreen;
	   JCheckBox ckBlue;
	   /**
	    * Launch the application.
	    */
	   public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               Win_Checkbox frame = new Win_Checkbox();
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
	   public void showBGColor() {
	      if(ckRed.isSelected())
	         red = 255;
	      else
	         red = 0;
	      if(ckGreen.isSelected())
	         green = 255;
	      else
	         green = 0;
	      if(ckBlue.isSelected())
	         blue = 255;
	      else
	         blue = 0;            
	      contentPane.setBackground(new Color(red,green,blue));
	   }
	   public Win_Checkbox() {
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(100, 100, 450, 300);
	      contentPane = new JPanel();
	      contentPane.setBackground(new Color(0, 0, 0));
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	      setContentPane(contentPane);
	      
	      ckRed = new JCheckBox("Red");
	      ckRed.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	            showBGColor();
	         }
	      });
	      contentPane.add(ckRed);
	      
	      ckGreen = new JCheckBox("Green");
	      ckGreen.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	            showBGColor();
	         }
	      });
	      contentPane.add(ckGreen);
	      
	      ckBlue = new JCheckBox("Blue");
	      ckBlue.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	            showBGColor();
	         }
	      });
	      contentPane.add(ckBlue);
	   }

	}
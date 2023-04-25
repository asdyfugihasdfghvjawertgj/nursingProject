package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import java.awt.Color;

public class register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String gender;
	private JPasswordField pswconfirm;
	login l=new login();
	public JPanel panel_3;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtcontact;
	private JPasswordField txtpassword;
	private JRadioButton rdomale;
	private JRadioButton rdofemale;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			register dialog = new register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public register() {
		setBounds(0, 0, 1550, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(397, 26, 803, 733);
		panel.setBackground(new Color(255, 99, 71));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setBounds(167, 124, 146, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("GENDER:");
		lblNewLabel_1.setBounds(167, 215, 146, 26);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("AGE:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(167, 283, 146, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CONTACT-INFO:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(167, 372, 146, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(167, 512, 146, 29);
		panel.add(lblNewLabel_4);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtname.setColumns(10);
		txtname.setBounds(167, 162, 516, 43);
		panel.add(txtname);
		
		rdomale = new JRadioButton("MALE");
		rdomale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(rdomale.isSelected()) {
						rdofemale.setSelected(false);
						gender="male";
					}
			}
		});
		rdomale.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdomale.setBounds(167, 236, 103, 30);
		rdomale.setBackground(new Color(255, 99, 71));
		panel.add(rdomale);
		
		rdofemale = new JRadioButton("FEMALE");
		rdofemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdofemale.isSelected()) {
					rdomale.setSelected(false);
					gender="female";
				}
			}
		});
		rdofemale.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdofemale.setBounds(288, 236, 103, 30);
		rdofemale.setBackground(new Color(255, 99, 71));
		panel.add(rdofemale);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtage.setColumns(10);
		txtage.setBounds(164, 319, 103, 43);
		panel.add(txtage);
		
		txtcontact = new JTextField();
		txtcontact.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtcontact.setColumns(10);
		txtcontact.setBounds(167, 411, 516, 80);
		panel.add(txtcontact);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpassword.setBounds(167, 551, 516, 43);
		panel.add(txtpassword);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
				{
					txtpassword.setEchoChar((char)0);
					
				}
				else
					txtpassword.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(177, 600, 136, 21);
		chckbxNewCheckBox.setBackground(new Color(255, 99, 71));
		panel.add(chckbxNewCheckBox);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String A= txtname.getText().toString();
		         if((!Checking.IsValidName(A)) || A.charAt(0) ==' ' )
		        {
		            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
		            txtname.requestFocus();
		            txtname.selectAll();
		        }
		         else if(!Checking.IsAllDigit(txtage.getText()))
		         {
		        	 JOptionPane.showMessageDialog(null,"Please enter valid age.");
			           txtage.requestFocus();
			           txtage.selectAll();
		         }
				else if(gender==null || gender.equals(""))
		        {
		        	JOptionPane.showMessageDialog(null,"Please choose gender");
		        }
				else if(Checking.IsNull(txtage.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Age.");
		            txtage.requestFocus();
		            txtage.selectAll();
		        }
				else if(Integer.parseInt(txtage.getText())>120)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid age.");
		            txtage.requestFocus();
		            txtage.selectAll();
				}
				else if(Checking.IsNull(txtcontact.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Contact-Info.");
		            txtcontact.requestFocus();
		            txtcontact.selectAll();
		        }
				else if(Checking.IsNull(txtpassword.getText()))
		        {
					
		            JOptionPane.showMessageDialog(null, "Please enter password!");
		            txtpassword.requestFocus();
		            txtpassword.selectAll();
		        }
				else if(txtpassword.getText().length()<8)
				{
					JOptionPane.showMessageDialog(null, "Please enter password at least 8 character!");
					txtpassword.requestFocus();
					txtpassword.selectAll();
				}
				else {
					String[] str=new String[5];
	                str[0]=txtname.getText();
	                str[1]=gender;
	                str[2]=txtage.getText();
	                str[3]=txtcontact.getText();
	                str[4]=txtpassword.getText();
	                boolean save=(mySQLQueries.insertData("patient",str));
	                if(save) {
	                    JOptionPane.showMessageDialog(null,"Your Registration is successfully done!","Successfully",JOptionPane.INFORMATION_MESSAGE);
	                    //this.close();
	                    dispose();
	                    l.show();
	                	
	                }
	                else
	                    JOptionPane.showMessageDialog(null,"Failed to save record!","Save Failed",JOptionPane.INFORMATION_MESSAGE);
	                clear();
		            txtname.requestFocus();
	            }
	            
				}

			private void close() {
				// TODO Auto-generated method stub
				
			}
		});
		btnregister.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnregister.setBounds(167, 639, 142, 43);
		//btnregister.setBackground(SystemColor.info);
		panel.add(btnregister);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btncancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btncancel.setBounds(372, 639, 142, 43);
		//btncancel.setBackground(SystemColor.info);
		panel.add(btncancel);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstpage fp = new firstpage();
				fp.show();
			}
		});
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnback.setBounds(561, 639, 127, 43);
		//btnback.setBackground(SystemColor.info);
		panel.add(btnback);
		
		JLabel lblNewLabel_2_1 = new JLabel("Years");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(280, 326, 74, 26);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblRegister.setBounds(167, 38, 154, 58);
		panel.add(lblRegister);
		
	}
	public void clear()
    {
        txtname.setText("");
        rdomale.setSelected(false);
        rdofemale.setSelected(false);
        txtage.setText("");
        txtcontact.setText("");
        txtpassword.setText("");
        txtname.requestFocus();
    }

	public void register() {
		// TODO Auto-generated method stub
		
	}
}

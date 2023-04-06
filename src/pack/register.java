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
import javax.swing.ImageIcon;
import java.awt.Color;

public class register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtcontact;
	private JRadioButton rdomale;
	private JRadioButton rdofemale;
	public JButton btnregister;
	private JButton btncancel;
	private String gender;
	private JPasswordField passwordField;
	private JPasswordField pswconfirm;
	login l=new login();
	public JPanel panel_3;
	private JLabel lblNewLabel_5;
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
		contentPanel.setBackground(new Color(233, 150, 122));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtname = new JTextField();
		txtname.setBounds(1151, 14, 375, 29);
		contentPanel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(1038, 13, 74, 26);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GENDER:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(1038, 76, 86, 26);
		contentPanel.add(lblNewLabel_1);
		
		rdomale = new JRadioButton("MALE");
		rdomale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdomale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdomale.isSelected()) {
					rdofemale.setSelected(false);
					gender="male";
				}
			}
		});
		rdomale.setBounds(1263, 75, 103, 30);
		contentPanel.add(rdomale);
		
		rdofemale = new JRadioButton("FEMALE");
		rdofemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdofemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdofemale.isSelected()) {
					rdomale.setSelected(false);
					gender="female";
				}
			}
		});
		rdofemale.setBounds(1422, 76, 103, 30);
		contentPanel.add(rdofemale);
		
		JLabel lblNewLabel_2 = new JLabel("AGE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(1038, 142, 74, 26);
		contentPanel.add(lblNewLabel_2);
		
		txtage = new JTextField();
		txtage.setBounds(1151, 143, 375, 29);
		contentPanel.add(txtage);
		txtage.setColumns(10);
		
		txtcontact = new JTextField();
		txtcontact.setBounds(1151, 221, 375, 29);
		contentPanel.add(txtcontact);
		txtcontact.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CONTACT-INFO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(1038, 219, 117, 29);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(1038, 297, 103, 29);
		contentPanel.add(lblNewLabel_4);
		
		btnregister = new JButton("Register");
		btnregister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String A= txtname.getText().toString();
		         if((!Checking.IsValidName(A)) || A.charAt(0) ==' ' )
		        {
		            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
		            txtname.requestFocus();
		            txtname.selectAll();
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
				else if(Checking.IsNull(txtcontact.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Contact-Info.");
		            txtcontact.requestFocus();
		            txtcontact.selectAll();
		        }
				else if(Checking.IsNull(passwordField.getText()))
		        {
					
		            JOptionPane.showMessageDialog(null, "Please enter password!");
		            passwordField.requestFocus();
		            passwordField.selectAll();
		        }
				else if(passwordField.getText().length()<8)
				{
					JOptionPane.showMessageDialog(null, "Please enter at least 8 character!");
		            passwordField.requestFocus();
		            passwordField.selectAll();
				}
				else {
					String[] str=new String[5];
	                str[0]=txtname.getText();
	                str[1]=gender;
	                str[2]=txtage.getText();
	                str[3]=txtcontact.getText();
	                str[4]=passwordField.getText();
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
		btnregister.setBounds(1263, 435, 85, 29);
		contentPanel.add(btnregister);
		
		btncancel = new JButton("Cancel");
		btncancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btncancel.setBounds(1396, 435, 85, 29);
		contentPanel.add(btncancel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
				{
					passwordField.setEchoChar((char)0);
					
				}
				else
					passwordField.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setBounds(1151, 358, 136, 21);
		contentPanel.add(chckbxNewCheckBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(1151, 297, 375, 29);
		contentPanel.add(passwordField);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\Saved Pictures\\nurse.jpg"));
		lblNewLabel_5.setBounds(0, 0, 902, 845);
		contentPanel.add(lblNewLabel_5);
		
	}
	public void clear()
    {
        txtname.setText("");
        rdomale.isSelected();
        rdofemale.isSelected();
        txtage.setText("");
        txtcontact.setText("");
        passwordField.setText("");
        txtname.requestFocus();
    }

	public void register() {
		// TODO Auto-generated method stub
		
	}
}

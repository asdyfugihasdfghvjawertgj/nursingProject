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
		setBounds(100, 100, 573, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtname = new JTextField();
		txtname.setBounds(158, 10, 375, 29);
		contentPanel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 13, 74, 26);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GENDER:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 60, 86, 26);
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
		rdomale.setBounds(160, 56, 103, 30);
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
		rdofemale.setBounds(299, 56, 103, 30);
		contentPanel.add(rdofemale);
		
		JLabel lblNewLabel_2 = new JLabel("AGE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 124, 74, 26);
		contentPanel.add(lblNewLabel_2);
		
		txtage = new JTextField();
		txtage.setBounds(158, 104, 375, 29);
		contentPanel.add(txtage);
		txtage.setColumns(10);
		
		txtcontact = new JTextField();
		txtcontact.setBounds(158, 184, 375, 29);
		contentPanel.add(txtcontact);
		txtcontact.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CONTACT-INFO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(25, 184, 103, 29);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 268, 103, 29);
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
	                    JOptionPane.showMessageDialog(null,"Successfully save record!","Save Record",JOptionPane.INFORMATION_MESSAGE);
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
		btnregister.setBounds(158, 401, 85, 29);
		contentPanel.add(btnregister);
		
		btncancel = new JButton("Cancel");
		btncancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btncancel.setBounds(303, 401, 85, 29);
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
		chckbxNewCheckBox.setBounds(160, 329, 136, 21);
		contentPanel.add(chckbxNewCheckBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 268, 375, 29);
		contentPanel.add(passwordField);
		
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

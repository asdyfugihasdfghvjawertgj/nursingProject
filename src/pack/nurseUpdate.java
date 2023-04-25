package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Font;

public class nurseUpdate extends JDialog {
	private JTextField txtaddress;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnclose;
	private JTextField txtname;
	private JComboBox cbonurse;
	private JTextField txtexp;
	private JTextField txtphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			nurseUpdate dialog = new nurseUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public nurseUpdate() {
		setTitle("Nurse Information Update");
		setBounds(100, 100, 531, 371);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Patient Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 10, 497, 269);
			getContentPane().add(panel);
			{
				JLabel txtnurse = new JLabel("Nurse ID :");
				txtnurse.setFont(new Font("Times New Roman", Font.BOLD, 15));
				txtnurse.setBounds(20, 23, 94, 28);
				panel.add(txtnurse);
			}
			{
				JLabel lblname = new JLabel("Name :");
				lblname.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblname.setBounds(24, 68, 77, 28);
				panel.add(lblname);
			}
			{
				JLabel lblexp = new JLabel("Experience :");
				lblexp.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblexp.setBounds(20, 124, 94, 28);
				panel.add(lblexp);
			}
			{
				JLabel lblphone = new JLabel("Phone :");
				lblphone.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblphone.setBounds(20, 171, 81, 28);
				panel.add(lblphone);
			}{
				JLabel lbladdr = new JLabel("Address :");
				lbladdr.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lbladdr.setBounds(20, 218, 94, 28);
				panel.add(lbladdr);
			}
			{
				txtaddress = new JTextField();
				txtaddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
				txtaddress.setColumns(10);
				txtaddress.setBounds(193, 209, 262, 37);
				panel.add(txtaddress);
			}
			
			txtname = new JTextField();
			txtname.setFont(new Font("Times New Roman", Font.BOLD, 15));
			txtname.setColumns(10);
			txtname.setBounds(193, 68, 262, 37);
			panel.add(txtname);
			
			cbonurse = new JComboBox();
			cbonurse.setFont(new Font("Times New Roman", Font.BOLD, 15));
			cbonurse.setModel(new DefaultComboBoxModel(new String[] {"---Select---"}));
			cbonurse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbonurse.getSelectedIndex()<=0) {
						txtname.setText("");
						txtaddress.setText("");
						txtphone.setText("");
						txtexp.setText("");
					}
					
					else {
						showNurse();
					}
				}
			});
			cbonurse.setBounds(193, 20, 262, 38);
			panel.add(cbonurse);
			
			txtexp = new JTextField();
			txtexp.setFont(new Font("Times New Roman", Font.BOLD, 15));
			txtexp.setColumns(10);
			txtexp.setBounds(193, 115, 262, 37);
			panel.add(txtexp);
			
			txtphone = new JTextField();
			txtphone.setFont(new Font("Times New Roman", Font.BOLD, 15));
			txtphone.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					System.out.println("test");
				}
			});
			txtphone.setColumns(10);
			txtphone.setBounds(193, 162, 262, 37);
			panel.add(txtphone);
		}
		{
			btnclose = new JButton("Close");
			btnclose.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnclose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnclose.setBounds(398, 289, 109, 35);
			getContentPane().add(btnclose);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbonurse.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("nurse", id);
	                    	clear();
	                    	fillNurse();
	                    	dispose();
	                    	nurseUpdate pkgUpd= new nurseUpdate();
	                    	pkgUpd.show();
	                    }
	                    else
	                    {
	                    	JOptionPane.showMessageDialog(null, "Fail to delete record","Cannot Update",JOptionPane.INFORMATION_MESSAGE);
	                    }
	                } catch(Exception sqle) {
	                    sqle.printStackTrace();
	                }

				}
			});
			btnDelete.setBounds(209, 289, 109, 35);
			getContentPane().add(btnDelete);
		}
		{
			btnUpdate = new JButton("Update");
			btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String A= txtname.getText().toString();
			        if(cbonurse.getSelectedIndex()==0) 
			        {
			            JOptionPane.showMessageDialog(null, "Please choose patient id.");
			            cbonurse.requestFocus();
			        }
			        else if((!Checking.IsValidName(A)) || A.charAt(0) ==' ' )
			        {
			            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
			            txtname.requestFocus();
			            txtname.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtexp.getText().trim())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Experience.");
			            txtexp.requestFocus();
			            txtexp.selectAll();
			        }
			        else if(Checking.IsNull(txtexp.getText()))
				     {
				            JOptionPane.showMessageDialog(null, "Please enter Experience.");
				            txtexp.requestFocus();
				            txtexp.selectAll();
		             }
			        else if(Integer.parseInt(txtexp.getText())>60) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid experience year.");
			            txtexp.requestFocus();
			            txtexp.selectAll();
			        }
			        else if(Checking.IsNull(txtaddress.getText())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Address.");
			            txtaddress.requestFocus();
			            txtaddress.selectAll();
			        }
			        else if(!mySQLQueries.isPhoneNoValid((String)txtphone.getText())) {
	                	JOptionPane.showMessageDialog(null,"Phone no invalid", "Fail to update record",JOptionPane.INFORMATION_MESSAGE);

					}
			        
			        else{
			        	 String st[] = new String[4];
							st[0] = (String)txtname.getText();
							st[1] = (String)txtexp.getText();
							st[2] = (String)txtphone.getText();
							st[3] = (String)txtaddress.getText();
							
				           
						            if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) 
						            {
						                String []str = new String[4];
						                String id = cbonurse.getSelectedItem().toString();
						                str[0] = (String)txtname.getText();
										str[1] = (String)txtexp.getText();
										str[2] = (String)txtphone.getText();
										str[3] = (String)txtaddress.getText();
						               
																				
										
											
							                boolean save = mySQLQueries.updateRecord("nurse", id, str);
							                if(save) 
							                {
							                    JOptionPane.showMessageDialog(null, "Successfully update record!","Update Record.",JOptionPane.INFORMATION_MESSAGE);
							                    clear();
							                }
							                else
							                {
							                	JOptionPane.showMessageDialog(null, "Fail to update record","Cannot Update",JOptionPane.INFORMATION_MESSAGE);
							                }
										
						            }
				            
			        }
				}
			});
			clear();
			btnUpdate.setBounds(10, 289, 97, 35);
			getContentPane().add(btnUpdate);
		}
		fillNurse();
	}

    public void fillNurse()
   {
       String str[]=mySQLQueries.getIDForChoice("nurse");
       for(int i = 0 ; i<str.length ; i++)
    	   cbonurse.addItem(str[i]);
   }
    public void showNurse()
    {
        String result[]= mySQLQueries.getnurseData(cbonurse.getSelectedItem().toString());
        txtname.setText(result[0]);
        txtexp.setText(result[1]);
        txtphone.setText(result[2]);
        txtaddress.setText(result[3]);
        
        
    }
    public void clear()
    {
    	txtname.setText(" ");
        txtexp.setText(" ");
        txtphone.setText(" ");
        txtaddress.setText(" ");
        cbonurse.requestFocus();
    }
}

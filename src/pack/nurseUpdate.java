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
			panel.setBounds(10, 10, 497, 249);
			getContentPane().add(panel);
			{
				JLabel txtnurse = new JLabel("Nurse ID :");
				txtnurse.setBounds(20, 23, 81, 14);
				panel.add(txtnurse);
			}
			{
				JLabel lblname = new JLabel("Name :");
				lblname.setBounds(24, 68, 56, 14);
				panel.add(lblname);
			}
			{
				JLabel lblexp = new JLabel("Experience :");
				lblexp.setBounds(20, 105, 81, 18);
				panel.add(lblexp);
			}
			{
				JLabel lblphone = new JLabel("Phone :");
				lblphone.setBounds(33, 146, 81, 18);
				panel.add(lblphone);
			}{
				JLabel lbladdr = new JLabel("Address :");
				lbladdr.setBounds(20, 189, 81, 18);
				panel.add(lbladdr);
			}
			{
				txtaddress = new JTextField();
				txtaddress.setColumns(10);
				txtaddress.setBounds(111, 184, 241, 29);
				panel.add(txtaddress);
			}
			
			txtname = new JTextField();
			txtname.setColumns(10);
			txtname.setBounds(111, 61, 241, 29);
			panel.add(txtname);
			
			cbonurse = new JComboBox();
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
			cbonurse.setBounds(111, 20, 241, 21);
			panel.add(cbonurse);
			
			txtexp = new JTextField();
			txtexp.setColumns(10);
			txtexp.setBounds(111, 100, 241, 29);
			panel.add(txtexp);
			
			txtphone = new JTextField();
			txtphone.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					System.out.println("test");
				}
			});
			txtphone.setColumns(10);
			txtphone.setBounds(111, 141, 241, 29);
			panel.add(txtphone);
		}
		{
			btnclose = new JButton("Close");
			btnclose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnclose.setBounds(422, 281, 85, 23);
			getContentPane().add(btnclose);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbonurse.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("nurse", id);
	                    	clear();
	                    	//fillNurse();
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
			btnDelete.setBounds(221, 281, 85, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        if(cbonurse.getSelectedIndex()==0) 
			        {
			            JOptionPane.showMessageDialog(null, "Please choose patient id.");
			            cbonurse.requestFocus();
			        }
			        else if(!Checking.IsValidName(txtname.getText()))
			        {
			        	JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
			            txtname.requestFocus();
			            txtname.selectAll();
			        }
			        else if(Integer.parseInt(txtexp.getText())>60) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid experience year.");
			            txtexp.requestFocus();
			            txtexp.selectAll();
			        }else if(!Checking.IsAllDigit(txtexp.getText().trim())) 
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
			btnUpdate.setBounds(10, 281, 79, 23);
			getContentPane().add(btnUpdate);
		}
		fillNurse();
	}

    public void fillNurse()
   {
       String str[]=mySQLQueries.getIDForChoice("nurse");
       for(int i = 0 ; i<str.length ; i++)
    	   cbonurse.addItem(str[i].toString());
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
        cbonurse.setSelectedIndex(0);
    }
}

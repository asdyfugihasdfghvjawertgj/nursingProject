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

public class patientUpdate extends JDialog {
	private JTextField txtaddress;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnclose;
	private JTextField txtage;
	private JComboBox cbopatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			patientUpdate dialog = new patientUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public patientUpdate() {
		setTitle("Patient Information Update");
		setBounds(100, 100, 360, 250);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Patient Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 325, 157);
			getContentPane().add(panel);
			{
				JLabel txtpatient = new JLabel("Patient ID :");
				txtpatient.setBounds(20, 23, 81, 14);
				panel.add(txtpatient);
			}
			{
				JLabel lblage = new JLabel("Age :");
				lblage.setBounds(45, 63, 56, 14);
				panel.add(lblage);
			}
			{
				JLabel lbladdr = new JLabel("Address :");
				lbladdr.setBounds(31, 100, 81, 18);
				panel.add(lbladdr);
			}
			{
				txtaddress = new JTextField();
				txtaddress.setColumns(10);
				txtaddress.setBounds(111, 100, 169, 20);
				panel.add(txtaddress);
			}
			
			txtage = new JTextField();
			txtage.setColumns(10);
			txtage.setBounds(111, 61, 169, 20);
			panel.add(txtage);
			
			cbopatient = new JComboBox();
			cbopatient.setModel(new DefaultComboBoxModel(new String[] {"---Select---"}));
			cbopatient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbopatient.getSelectedIndex()<=0) {
						txtage.setText("");
						txtaddress.setText("");
					}
					else {
						showPatient();
					}
				}
			});
			cbopatient.setBounds(111, 20, 169, 21);
			panel.add(cbopatient);
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
			btnclose.setBounds(250, 178, 85, 23);
			getContentPane().add(btnclose);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbopatient.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("Patient", id);
	                    	fillPatient();
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
			btnDelete.setBounds(129, 178, 85, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int age= Integer.parseInt(txtage.getText());
			        if(cbopatient.getSelectedIndex()==0) 
			        {
			            JOptionPane.showMessageDialog(null, "Please choose patient id1.");
			            cbopatient.requestFocus();
			        } 
			        else if(age>120) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid age.");
			            txtage.requestFocus();
			            txtage.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtage.getText().trim())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid age.");
			            txtage.requestFocus();
			            txtage.selectAll();
			        }else if(Checking.IsNull(txtaddress.getText())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Address.");
			            txtaddress.requestFocus();
			            txtaddress.selectAll();
			        }
			         
			        
			        else{
			        	 String st[] = new String[4];
							st[0] = (String)txtage.getText();
							st[1] = (String)txtaddress.getText();
							
				            
						            if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) 
						            {
						                String []str = new String[4];
						                String id = cbopatient.getSelectedItem().toString();
						                str[0]=txtage.getText();
						                str[1]=txtaddress.getText();
						                boolean save = mySQLQueries.updateRecord("patient", id, str);
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
			btnUpdate.setBounds(10, 178, 79, 23);
			getContentPane().add(btnUpdate);
		}
		fillPatient();
	}

    public void fillPatient()
   {
       String str[]=mySQLQueries.getIDForChoice("patient");
       for(int i = 0 ; i<str.length ; i++)
    	   cbopatient.addItem(str[i].toString());
   }
    public void showPatient()
    {
        String result[]= mySQLQueries.getpatientData(cbopatient.getSelectedItem().toString());
        txtage.setText(result[0]);
        txtaddress.setText(result[1]);
        
    }
    public void clear()
    {
        
        txtaddress.setText("");
        txtage.setText("");
        cbopatient.requestFocus();
        cbopatient.setSelectedIndex(0);
    }
}

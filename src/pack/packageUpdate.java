package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pack.mySQLQueries;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import pack.mySQLQueries;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class packageUpdate extends JDialog {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			packageUpdate dialog = new packageUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private JButton btnCancel;
	private JButton btnClose;
	private JTextField txtstart;
	private JLabel lblNewLabel_2;
	private JTextField txtend;
	private JComboBox cbopackageid_1;
	private JButton btndelete;



	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public packageUpdate() throws ClassNotFoundException {
		setTitle("Package Entry");
		setBounds(100, 100, 568, 447);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Package Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 657, 223);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Package ID:");
		lblNewLabel.setBounds(20, 21, 85, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Start Date:");
		lblNewLabel_1.setBounds(20, 82, 75, 13);
		panel.add(lblNewLabel_1);
		
		txtstart = new JTextField();
		txtstart.setBounds(105, 79, 206, 19);
		panel.add(txtstart);
		txtstart.setColumns(10);
		
		lblNewLabel_2 = new JLabel("End Date:");
		lblNewLabel_2.setBounds(20, 138, 63, 13);
		panel.add(lblNewLabel_2);
		
		txtend = new JTextField();
		txtend.setBounds(105, 132, 206, 19);
		panel.add(txtend);
		txtend.setColumns(10);
		
		cbopackageid_1 = new JComboBox();
		cbopackageid_1.setModel(new DefaultComboBoxModel(new String[] {"-Selected-"}));
		cbopackageid_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbopackageid_1.getSelectedIndex()<=0) {
					txtstart.setText("");
					txtend.setText("");
				}
				else {
					showPackage();
				}
			}
		});
		cbopackageid_1.setBounds(107, 18, 204, 31);
		panel.add(cbopackageid_1);
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st[] = new String[2];
		        if(Checking.IsNull(txtstart.getText()))//true
		        {
		            JOptionPane.showMessageDialog(null, "First you must enter valid Brand name.");
		            txtstart.requestFocus();
		            txtstart.selectAll();
		        }
		        else if(Checking.IsNull(txtend.getText()))
		        {
		        	JOptionPane.showMessageDialog(null, "First you must enter valid Brand name.");
		            txtend.requestFocus();
		            txtend.selectAll();
		        }
		        else{
		            
		                String []str = new String [2];
		                String id = cbopackageid_1.getSelectedItem().toString();
		                str[0]=txtstart.getText();
		                str[1]=txtend.getText();
		                boolean save= mySQLQueries.updateRecord("package", id,str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null, "Successfully update record!","update Record.",JOptionPane.INFORMATION_MESSAGE);
		                    
		                    txtstart.setText("");
		                    txtstart.requestFocus();
		                    clear();
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null, "Failed to save new record","Cannot Saved.",JOptionPane.INFORMATION_MESSAGE);
		                  
								
							
								
							
		                }
		            }
		        }
		});
		btnUpdate.setBounds(10, 293, 89, 23);
		getContentPane().add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(141, 293, 89, 23);
		getContentPane().add(btnCancel);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(280, 293, 89, 23);
		getContentPane().add(btnClose);
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String id = cbopackageid_1.getSelectedItem().toString();
                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
                    {
                    	mySQLQueries.deleteRecord("package", id);
                    	fillPackage();
                    	
   //*******************************Refresh dialog after deleting row**************************************
                    	dispose();
                    	packageUpdate pkgUpd= new packageUpdate();
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
		btndelete.setBounds(411, 294, 85, 21);
		getContentPane().add(btndelete);
		
		fillPackage();
		
	}
	//mySQLQueries mysql=new mySQLQueries();

	public void fillPackage()
    {
    String str[]=mySQLQueries.getIDForChoice("package");
    for(int i=0 ; i<str.length ; i++)
    	cbopackageid_1.addItem(str[i].toString());
    }
	
	public void showPackage()
	{
	    String result[]= mySQLQueries.getpackData(cbopackageid_1.getSelectedItem().toString());
	    txtstart.setText(result[0]);
	    txtend.setText(result[1]);
	}

    public void clear()
    {
    	txtstart.setText(null);
    	txtend.setText(null);
    }
}
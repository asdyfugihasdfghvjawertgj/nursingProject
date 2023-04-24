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

public class PackageDetailUpdate extends JDialog {
	private JComboBox cbopackage;
	private JComboBox cbonurse;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnclose;
	private JTextField txtprice;
	private JComboBox cbonurse_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PackageDetailUpdate dialog = new PackageDetailUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PackageDetailUpdate() {
		setTitle("Price Edit");
		setBounds(100, 100, 360, 250);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 325, 157);
			getContentPane().add(panel);
			{
				JLabel lblpackageID = new JLabel("Package ID:");
				lblpackageID.setBounds(20, 23, 81, 14);
				panel.add(lblpackageID);
			}
			{
				JLabel lblnurseID = new JLabel("Nurse ID :");
				lblnurseID.setBounds(27, 63, 56, 14);
				panel.add(lblnurseID);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Price :");
				lblNewLabel_2.setBounds(45, 103, 56, 14);
				panel.add(lblNewLabel_2);
			}
			{
				cbopackage = new JComboBox();
				cbopackage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						if(cbopackage.getSelectedIndex()<=0)
//						{
//							txtprice.setText("");
//						}
//						else
//						{
//							showpackid();
//						}
//							
						
						
					}
				});
				cbopackage.setBounds(111, 19, 167, 22);
				panel.add(cbopackage);
			}
			
			cbonurse_1 = new JComboBox();
			cbonurse_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbonurse_1.getSelectedIndex()<=0 && cbopackage.getSelectedIndex()<=0)
					{
						txtprice.setText("");
					}
					else
					{
						 showprice();
					}
				}
			});
			cbonurse_1.setBounds(111, 59, 167, 22);
			panel.add(cbonurse_1);
			
			txtprice = new JTextField();
			txtprice.setBounds(111, 101, 167, 22);
			panel.add(txtprice);
			txtprice.setColumns(10);
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
	                    String id = cbopackage.getSelectedItem().toString();
	                    String nid=cbonurse_1.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deletePackageDetailRecord("packagedetail",id,nid);
	                    	fillprice();
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

			        if(cbopackage.getSelectedIndex()==0) 
			        {
			            JOptionPane.showMessageDialog(null, "Please choose package id.");
			            cbopackage.requestFocus();
			        }else if(cbonurse_1.getSelectedIndex()==0) 
			        {
			            JOptionPane.showMessageDialog(null, "Please choose nurse id.");
			            cbonurse_1.requestFocus();
			        } 
			        else if(Checking.IsNull(txtprice.getText())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Price.");
			            txtprice.requestFocus();
			            txtprice.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtprice.getText().trim())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid price.");
			            txtprice.requestFocus();
			            txtprice.selectAll();
			        } 
			        else{
						                String []str = new String[1];
						                String pid = cbopackage.getSelectedItem().toString();
						                String nid = cbonurse_1.getSelectedItem().toString();
						                str[0]=txtprice.getText();
						                boolean save = mySQLQueries.updatePackageDetailRecord("packagedetail", pid,nid, str);
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
			});
			btnUpdate.setBounds(10, 178, 79, 23);
			getContentPane().add(btnUpdate);
		}
		fillprice();
		fillnurse();
	}

    public void fillprice()
   {
       
       cbopackage.addItem("-Selected-");
      
       String str[]=mySQLQueries.getIDForChoice("package");
       for(int i = 0 ; i<str.length ; i++)
    	   cbopackage.addItem(str[i].toString());
      
			cbopackage.setSelectedIndex(0);
   }
    public void fillnurse()
    {
    String str[]=mySQLQueries.getIDForChoice("nurse");
    cbonurse_1.addItem("-Selected-");
    for(int i=0 ; i<str.length ; i++)
    	cbonurse_1.addItem(str[i].toString());
    }
    
    public void showprice()
    {
      try {  String result[]= mySQLQueries.serachPrice1(cbopackage.getSelectedItem().toString(),cbonurse_1.getSelectedItem().toString());
        txtprice.setText(result[0]);
        	
        }
      catch(Exception e)
      {
    	  JOptionPane.showMessageDialog(null, "There is no Data!");
      }

    }
    public void clear()
    {
        txtprice.setText("");
        cbopackage.requestFocus();
        cbopackage.setSelectedIndex(0);
    }
}

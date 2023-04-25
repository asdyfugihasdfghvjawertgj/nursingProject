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
import java.awt.Font;

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
		setBounds(100, 100, 493, 406);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 432, 252);
			getContentPane().add(panel);
			{
				JLabel lblpackageID = new JLabel("Package ID:");
				lblpackageID.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblpackageID.setBounds(20, 34, 99, 30);
				panel.add(lblpackageID);
			}
			{
				JLabel lblnurseID = new JLabel("Nurse ID :");
				lblnurseID.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblnurseID.setBounds(20, 102, 81, 36);
				panel.add(lblnurseID);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Price :");
				lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblNewLabel_2.setBounds(27, 173, 74, 36);
				panel.add(lblNewLabel_2);
			}
			{
				cbopackage = new JComboBox();
				cbopackage.setFont(new Font("Times New Roman", Font.BOLD, 15));
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
				cbopackage.setBounds(163, 34, 240, 30);
				panel.add(cbopackage);
			}
			
			cbonurse_1 = new JComboBox();
			cbonurse_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
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
			cbonurse_1.setBounds(163, 102, 240, 36);
			panel.add(cbonurse_1);
			
			txtprice = new JTextField();
			txtprice.setFont(new Font("Times New Roman", Font.BOLD, 15));
			txtprice.setBounds(163, 173, 240, 36);
			panel.add(txtprice);
			txtprice.setColumns(10);
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
			btnclose.setBounds(347, 298, 95, 34);
			getContentPane().add(btnclose);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbopackage.getSelectedIndex()==0)
			            JOptionPane.showMessageDialog(null,"Please choose department id!");
				else if(cbonurse_1.getSelectedIndex()==0)
			            JOptionPane.showMessageDialog(null,"Please choose duty id!");
				else {
					try {
	                    String id = cbopackage.getSelectedItem().toString();
	                    String nid=cbonurse_1.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deletePackageDetailRecord("packagedetail",id,nid);
	                    	fillprice();
	                    	dispose();
	                    	PackageDetailUpdate pkgUpd= new PackageDetailUpdate();
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
				}
					
			});
			btnDelete.setBounds(184, 298, 101, 34);
			getContentPane().add(btnDelete);
		}
		{
			btnUpdate = new JButton("Update");
			btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
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
			btnUpdate.setBounds(10, 298, 106, 34);
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
        cbonurse_1.setSelectedIndex(0);
    }
}

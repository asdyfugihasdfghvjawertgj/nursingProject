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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class packagedetailEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtprice;
	private JButton btnsave;
	private JButton btncancel;
	private JComboBox cbopackage;
	private JComboBox cbonurse;
	private JButton btnclear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			packagedetailEntry dialog = new packagedetailEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public packagedetailEntry() {
		setBounds(100, 100, 701, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Package Id:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(64, 57, 101, 29);
			contentPanel.add(lblNewLabel);
		}
		
		cbopackage = new JComboBox();
		cbopackage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbopackage.setBounds(237, 50, 414, 42);
		contentPanel.add(cbopackage);
		
		JLabel lblNewLabel_1 = new JLabel("nurse id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(64, 146, 90, 42);
		contentPanel.add(lblNewLabel_1);
		
		cbonurse = new JComboBox();
		cbonurse.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbonurse.setBounds(237, 146, 414, 42);
		contentPanel.add(cbonurse);
		
		JLabel lblNewLabel_2 = new JLabel("price");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(64, 237, 107, 42);
		contentPanel.add(lblNewLabel_2);
		
		txtprice = new JTextField();
		txtprice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtprice.setBounds(237, 238, 414, 42);
		contentPanel.add(txtprice);
		txtprice.setColumns(10);
		
		btnsave = new JButton("save");
		btnsave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbopackage.getSelectedIndex()==0)
		        {
		            JOptionPane.showMessageDialog(null, "Please choose package.");
		        }
			 	else if(cbonurse.getSelectedIndex()==0)
		            JOptionPane.showMessageDialog(null,"Please choose nurse!");
			    else if(Checking.IsNull(txtprice.getText()))
			    {
			    	JOptionPane.showMessageDialog(null, "Please enter Price.");
		            txtprice.requestFocus();
		            txtprice.selectAll();
			    }
			   
		        
		        else
		        {
	            String st[]=new String[4];
				st[0] = (String)cbopackage.getSelectedItem();
				st[1] = (String)cbonurse.getSelectedItem();
				st[2] = (String)txtprice.getText();
	          
	            boolean br=(mySQLQueries.isduplicate("packagedetail",st));
	            if(!br)
	                JOptionPane.showMessageDialog(null,"Duplicate Record!");
	            else
	            {
	                String[] str=new String[4];
	                str[0]=(String)cbopackage.getSelectedItem();
	                str[1]=(String)cbonurse.getSelectedItem();
	                Long amount=Long.parseLong(txtprice.getText().toString());
	                str[2]=amount.toString();
	           
	                boolean save=(mySQLQueries.insertData("packagedetail",str));
	                if(save)
	                    JOptionPane.showMessageDialog(null,"Successfully save record!","Save Record",JOptionPane.INFORMATION_MESSAGE);
	                else
	                    JOptionPane.showMessageDialog(null,"Failed to save record!","Save Failed",JOptionPane.INFORMATION_MESSAGE);
	            }
	            clear();
	            cbopackage.requestFocus();
	        }
			}
		});
		btnsave.setBounds(173, 366, 107, 35);
		contentPanel.add(btnsave);
		
		btncancel = new JButton("cancel");
		btncancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btncancel.setBounds(343, 366, 101, 35);
		contentPanel.add(btncancel);
		
		btnclear = new JButton("close");
		btnclear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnclear.setBounds(490, 366, 101, 35);
		contentPanel.add(btnclear);
		fillPackage();
		fillNurse();
	}
	public void fillPackage()
	{
		 String str[] = null;
			try {
				str = mySQLQueries.getIDForChoice("package");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        cbopackage.addItem("-Select-");
	        for(int i=0;i<str.length;i++)
	            cbopackage.addItem(str[i].toString());
	}
	public void fillNurse()
	{
		String str[] = null;
		try {
			str = mySQLQueries.getIDForChoice("nurse");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cbonurse.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbonurse.addItem(str[i].toString());
	}
	public void clear()
	{
		cbopackage.setSelectedItem(null);
		cbonurse.setSelectedItem(null);
		txtprice.setText(null);
		
	}
}

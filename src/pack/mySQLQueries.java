package pack;

import pack.clsDBConnection;
import java.sql.*;

import javax.swing.*;


public class mySQLQueries {
	
	private static final String String = null;
	static Connection con = null;
	static Statement stmt;
	static String query , query1;
	static ResultSet rs;
	static clsDBConnection connect = new clsDBConnection();
	public mySQLQueries() throws ClassNotFoundException
	{
	    try{
	        con=connect.getConnection();
	    }
	    catch(SQLException sqle)
	    {
	        System.out.println(sqle);
	    }catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	public static boolean insertData(String tbName , String[]data)
	{
	    if(tbName.equals("duty"))
	    {
	        query = "insert into duty values ('"+data[0]+"','"+data[1]+"');";
	    }
	    else if(tbName.equals("department"))
	    {
	        query = "insert into department values ('"+data[0]+"','"+data[1]+"')";
	    }
	    else if(tbName.equals("nurse"))
	    {
	        query = "insert into nurse(nurseid,name,depid,dutyid,gender,experience,phone,address)values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"')";
	    }
	    else if(tbName.equals("package"))
	    {
	        query = "insert into package(packageid,startdate,enddate)values('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
	    }
	    else if(tbName.equals("packagedetail"))
	    {
	    	query="insert into packagedetail(packageid,nurseid,price,oncall)values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"')";
	    }
	    try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        boolean r = stmt.execute(query);
	       //System.out.println(query+r);
	        if(r)
	        {
	            return false;
	        }
	        else return true;

	    }catch(SQLException e)
	    {
	        JOptionPane.showMessageDialog(null,e.getMessage());
	        e.printStackTrace();
	        return true;
	    }
	}
	
	public static boolean isduplicate(String tbName , String []data)
	{
	    if(tbName.equals("duty"))
	    {
	        query = "select * from duty where name='"+data[0]+"'";
	    }
	    else if(tbName.equals("department"))
	    {
	        query = "select * from department where name='"+data[0]+"'";
	    }

	    else if(tbName.equals("nurse"))
	    {
	        query = "select * from nurse where depid ='"+data[0]+"'and dutyid ='"+data[1]+"'";
	    }
	    else if(tbName.equals("package"))
	    {
	        query = "select * from package where startdate='"+data[0]+"'and enddate='"+data[1]+"'";
	    }
	    else if(tbName.equals("packagedetail"))
	    {
	    	query = "select * from packagedetail where packageid ='"+data[0]+"'and nurseid ='"+data[1]+"'and price='"+data[2]+"'and oncall='"+data[3]+"'";
	    }
	    else if(tbName.equals("customer"))
	    {
	    	query = "select * from customer where name ='"+data[0]+"'and address ='"+data[1]+"'and phoneno ='"+data[2]+"'and email='"+data[3]+"'";
	    }
	    try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(query);
	        if(rs.next())
	            return false;
	        else
	            return true;
	    }catch(SQLException e){
	        JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	}

    public static String getTypeName(String typeid)
    {
        try
        {
            String typename;
            stmt = con.createStatement();
            query = "select * from type where typeID ='"+typeid+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            typename = rs.getString(2);
            return typename;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
    public String getTypeID(String typename)
    {
        String typeid;
        try
        {
            stmt = con.createStatement();
            query = "select typeid from type where typename='"+typename+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            typeid=rs.getString(1);
            return typeid;
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
    public String getBrandID(String brandname)
    {
        try{
            String brandid;
            stmt = con.createStatement();
            query = "select brandid from brand where brandname='"+brandname+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            brandid=rs.getString(1);
            return brandid;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
     public static String getBrandName(String brandid)
    {
        try{
            String brandname;
            con=connect.getConnection();
            stmt = con.createStatement();
            query = "select * from brand where brandid='"+brandid+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            brandname=rs.getString(2);
            return brandname;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
     public static   String getAutoid(String field , String tabel , String prefix) throws ClassNotFoundException
     {
         if(tabel.equals("package"))
         {
             return connect.getPrimaryKey(field, tabel, prefix);
         }
         else
         {
             return connect.getPrimaryKey2(field, tabel, prefix);
         }

     }
     public static void main(String[] args) 
     {
    	 try {
    		 mySQLQueries q=new mySQLQueries();
    		 System.out.print(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public static String[] getIDForChoice(String tbName)
     {
    	 try
    	 {
    		 if(tbName.equals("department"))
    			 rs=connect.SQLSelect("departmentid", "department");
    		 else if(tbName.equals("duty"))
    			 rs=connect.SQLSelect("dutyid","duty");
    		 else if(tbName.equals("package"))
    			 rs=connect.SQLSelect("packageid", "package");
    		 else if(tbName.equals("nurse"))
    			 rs=connect.SQLSelect("nurseid", "nurse");
    		 int rowcount=0;
    		 while(rs.next())
    		 {
    			 rowcount++;
    		 }
    		 String[] temp=new String[rowcount];
    		 rs.beforeFirst();
    		 int i=0;
    		 while(rs.next())
    		 {
    			 temp[i]=rs.getString(1);
    			 i++;
    		 }
    		 return temp;
    	 }
    	 catch(SQLException sqle)
    	 {
    		System.out.println(sqle);
    		return null;
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 return null;
    	 }
     }
     public static String[] getNameForChoice(String tbName)
     {
    	 try
    	 {
    		 if(tbName.equals("department"))
    			 rs=connect.SQLSelect("name", "department");
    		 else if(tbName.equals("duty"))
    			 rs=connect.SQLSelect("name","duty");
    		 else if(tbName.equals("type"))
    			 rs=connect.SQLSelect("typeID","type");
    		 else if(tbName.equals("customer"))
    			 rs=connect.SQLSelect("customerID","customer");
    		 else if(tbName.equals("merchandise"))
    			 rs=connect.SQLSelect("merid","merchandise");
    		 else if(tbName.equals("brand"))
    			 rs=connect.SQLSelect("brandID","brand");
    		 int rowcount=0;
    		 while(rs.next())
    		 {
    			 rowcount++;
    		 }
    		 String[] temp=new String[rowcount];
    		 rs.beforeFirst();
    		 int i=0;
    		 while(rs.next())
    		 {
    			 temp[i]=rs.getString(1);
    			 i++;
    		 }
    		 return temp;
    	 }
    	 catch(SQLException sqle)
    	 {
    		System.out.println(sqle);
    		return null;
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 return null;
    	 }
    	 
     }
     public static String[] serachData(String tbName , String[]data)
     {
    	 try
    	 {
    		 if(tbName.equals("nurse"))
    		    {
    		        query = "select * from nurse where depid ='"+data[0]+"'and dutyid ='"+data[1]+"'and experience ='"+data[2]+"'and gender='"+data[3]+"'";
    		    }
    		con=connect.getConnection();
 	        stmt = con.createStatement();
 	        rs = stmt.executeQuery(query);
    		 int rowcount=0;
    		 while(rs.next())
    		 {
    			 rowcount++;
    		 }
    		 String[] temp=new String[rowcount];
    		 rs.beforeFirst();
    		 int i=0;
    		 while(rs.next())
    		 {
    			 temp[i]=rs.getString(2);
    			 i++;
    		 }
    		 return temp;
    	 }
    	 catch(SQLException sqle)
    	 {
    		System.out.println(sqle);
    		return null;
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 return null;
    	 }
     }
     public static String getDepid(String depname)
     {
    	 try{
             String depid;
             con=connect.getConnection();
             stmt = con.createStatement();
             query = "select departmentid from department where name='"+depname+"';";
             rs=stmt.executeQuery(query);
             rs.next();
             depid=rs.getString(1);
             return depid;
         }catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }  
    	 
     }
     
     public static String getDutyid(String dutyname)
     {
    	 
    	 try{
             String duid;
             con=connect.getConnection();
             stmt = con.createStatement();
             query = "select dutyid from duty where name='"+dutyname+"';";
             rs=stmt.executeQuery(query);
             rs.next();
             duid=rs.getString(1);
             return duid;
         }catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }  
    	 
     }
     public static String getNurseid(String nursename)
     {
    	 
    	 try{
             String nid;
             con=connect.getConnection();
             stmt = con.createStatement();
             query = "select nurseid from nurse where name='"+nursename+"';";
             rs=stmt.executeQuery(query);
             rs.next();
             nid=rs.getString(1);
             return nid;
         }catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }  
    	 
     }
     
     public static String[] getMerchandiseData(String merid)
     {
    	 try {
    		 String[] value=new String[2];
    		 con=connect.getConnection();
    		 stmt=con.createStatement();
    		 query="select * from merchandise where merid='"+merid+"';";
    		 rs=stmt.executeQuery(query);
    		 rs.next();
    		 value[0]=rs.getString(2);
    		 value[1]=rs.getString(3);
    		 return value;
    	 }
    	 catch(SQLException e)
    	 {
    		 JOptionPane.showMessageDialog(null, e.getMessage());
    		 return null;
    	 }
     }
     public static String[] getSupplierData(String supid)
     {
    	 try {
    		 String[] value=new String[4];
    		 con=connect.getConnection();
    		 stmt=con.createStatement();
    		 query="select * from supplier where supplierid='"+supid+"';";
    		 rs=stmt.executeQuery(query);
    		 if(rs.next())
    		 {
    			 for(int i=0;i<value.length;i++)
    			 {
    				 value[i]=rs.getString(i+2);
    			 }
    		 }
    		 return value;
    	 }
    	 catch(SQLException e)
    	 {
    		 JOptionPane.showMessageDialog(null, e.getMessage());
    		 return null;
    	 }
     }
     public static String[] getItemData(String itid)
     {
    	 try {
    		 String[] value=new String[6];
    		 con=connect.getConnection();
    		 stmt=con.createStatement();
    		 query="select * from item where itemID='"+itid+"';";
    		 rs=stmt.executeQuery(query);
    		 if(rs.next())
    		 {
    			 value[0]=rs.getString(1);//itemid
    			 value[1]=rs.getString(3);//itemname
    			 value[2]=rs.getString(4);//culsaleprice
    			 value[3]=rs.getString(2);//merid
    			 value[4]=rs.getString(5);//remark
    			 value[5]=rs.getString(6);//totalQty
    			 
    		 }
    		 return value;
    	 }
    	 catch(SQLException e)
    	 {
    		 JOptionPane.showMessageDialog(null, e.getMessage());
    		 return null;
    	 }
     }

     public static void P_updateitemquantity ( String tbname , String id , String nprice , String data )
     {
         int r1=0,price=0;
        // mySQLQueries msql = new mySQLQueries();
         String q = mySQLQueries.getItemData(id)[5];//qty(now)
         System.out.println("Save Qty ="+data);
         System.out.println("Save curQuantity="+q);
         if(tbname.equals("purchasedetail"))
         {
             r1=Integer.parseInt(q)+Integer.parseInt(data);
             price = Integer.parseInt(nprice)+(int)(Integer.parseInt(nprice)*0.1);
             System.out.println(price);
         }
     }
         public static  String[] serachPackage(String name)
         {
        	 try
        	 {
        		 con=connect.getConnection();
        		 stmt=con.createStatement();
        		 query="select * from packagedetail where nurseid='"+name+"';";
        		 rs=stmt.executeQuery(query);
        		 int rowcount=0;
        		 while(rs.next())
        		 {
        			 rowcount++;
        		 }
        		 String[] temp=new String[rowcount];
        		 rs.beforeFirst();
        		 //int i=0;
        		 while(rs.next())
        		 {
        			 temp[1]=rs.getString(1);
        			 temp[2]=rs.getString(2);
        			 temp[3]=rs.getString(3);
        			 temp[4]=rs.getString(4);
        			 //i++;
        		 }
        		 return temp;
        	 }
        	 catch(SQLException sqle)
        	 {
        		System.out.println(sqle);
        		return null;
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        		 return null;
        	 }
     }
         public static  String[] searchPackdate(String[] pac)
         {
        	 try
        	 {
        		 con=connect.getConnection();
        		 stmt=con.createStatement();
        		 query="select * from package where packageid='"+pac[2]+"';";
        		 rs=stmt.executeQuery(query);
        		 int rowcount=0;
        		 while(rs.next())
        		 {
        			 rowcount++;
        		 }
        		 String[] temp=new String[rowcount];
        		 rs.beforeFirst();
        		 int i=0;
        		 while(rs.next())
        		 {
        			 temp[i]=rs.getString(2);
        			// temp[1]=rs.getString(3);
        		 }
        		 return temp;
        	 }
        	 catch(SQLException sqle)
        	 {
        		System.out.println(sqle);
        		return null;
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        		 return null;
        	 }
     }


}

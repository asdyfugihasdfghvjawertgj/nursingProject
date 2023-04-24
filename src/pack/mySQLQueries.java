package pack;

import pack.clsDBConnection;
import java.sql.*;

import javax.swing.*;


public class mySQLQueries {
	
	//private static final String String = null;
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
	
	
	//****************************inserting data***************************
	public static boolean insertData(String tbName , String[]data)
	{
	    if(tbName.equals("duty"))
	    {
	        query = "insert into duty(dutyid,name) values ('"+data[0]+"','"+data[1]+"');";
	    }
	    else if(tbName.equals("department"))
	    {
	        query = "insert into department values('"+data[0]+"','"+data[1]+"')";
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
	    	query="insert into packagedetail(packageid,nurseid,price)values('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
	    }
	    else if(tbName.equals("patient"))
	    {
	    	query="insert into patient(name,gender,age,contact,password)values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"')";
	    }
	    else if(tbName.equals("calling"))
	    {
	    	query="insert into calling(packageid,nurseid,patientid,date,price)values('"+data[0]+"','"+data[1]+"','+data[2]+','"+data[3]+"','"+data[4]+"')";
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
	
	//*******************************Checking duplicate********************************
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
	    	query = "select * from packagedetail where packageid ='"+data[0]+"'and nurseid ='"+data[1]+"'and price='"+data[2]+"'";
	    }
	    else if(tbName.equals("patient"))
	    {
	    	query = "select * from patient where name ='"+data[0]+"'and gender ='"+data[1]+"'and age ='"+data[2]+"'and contact='"+data[3]+"'";
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
//***********************
	public static boolean isPhoneNoValid(String phoneno) {
		boolean boo = false;
			if(phoneno.length()==11 && (phoneno.charAt(0)=='0') && (phoneno.charAt(1)=='9') && (phoneno.charAt(2)!='0')) {
				boo = true;
				return boo;
			}
			else {
		return boo;
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
   public static String[] getPassword(String psw,String name)
    {
        try
        {
            String patientname[]=new String[2];
            con=connect.getConnection();
            stmt = con.createStatement();
            query = "select * from patient where password ='"+psw+"'and name='"+name+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            patientname[0]=rs.getString(1);
            patientname[1] = rs.getString(2);
            return patientname;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
   public static String[] getViewHistory(int cusid)
   {
	   try{
           String[] pdate = new String[4];
           con=connect.getConnection();
           stmt = con.createStatement();
           query = "select * from calling where patientid="+cusid+";";
           rs=stmt.executeQuery(query);
           rs.next();
           pdate[0]=rs.getString(2);
           pdate[1]=rs.getString(3);
           pdate[2]=rs.getString(5);
           pdate[3]=rs.getString(6);
           return pdate;
       }catch(SQLException sqle)
       {
           System.out.println(sqle);
           return null;
       } 
   }
    public static int getCusid(String cusname)
    {
        try{
            int cusid;
            stmt = con.createStatement();
            query = "select patientid from patient where name='"+cusname+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            cusid=rs.getInt(1);
            return cusid;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return (Integer) null;
        }
    }
     public static   String getAutoid(String field , String tabel , String prefix) throws ClassNotFoundException
     {
         
             return connect.getPrimaryKey2(field, tabel, prefix);
         

     }
     public static void main(String[] args) 
     {
    	 try {
    		 mySQLQueries q=new mySQLQueries();
    		 System.out.println(con);
    		 System.out.print(serachPrice1("P-00000001","NU-0000001")[0]);
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
    		 else if(tbName.equals("patient"))
    			 rs=connect.SQLSelect("patientid", "patient");
    		 else if(tbName.equals("duty"))
    			 rs=connect.SQLSelect("dutyid","duty");
    		 else if(tbName.equals("package"))
    			 rs=connect.SQLSelect("packageid", "package");
    		 else if (tbName.equals("packagedetail"))
    		 {
    			 rs=connect.SQLSelect("packageid", "price");
    		 	 rs=connect.SQLSelect("nurseid","price");
    		 }
    		 else if(tbName.equals("nurse"))
    		 { 
    			 rs=connect.SQLSelect("nurseid", "nurse");
    		 
    		 }
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
     public static  String[] serachNurse(String nid)
     {
    	 try
    	 {
    		 con=connect.getConnection();
    		 stmt=con.createStatement();
    		 query="select * from nurse where nurseid='"+nid+"';";
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
     public static String getPacid(String pacstartdate,String pacenddate)
     {
    	 
    	 try{
             String pid;
             con=connect.getConnection();
             stmt = con.createStatement();
             query = "select packageid from package where startdate='"+pacstartdate+"' and enddate='"+pacenddate+"';";
             rs=stmt.executeQuery(query);
             rs.next();
             pid=rs.getString(1);
             return pid;
         }catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }  
    	 
     }
         public static  String[] serachPackage(String nid)
         {
        	 try
        	 {
        		 con=connect.getConnection();
        		 stmt=con.createStatement();
        		 query="select * from packagedetail where nurseid='"+nid+"';";
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
         public static  String[] searchPackdate(String pac)
         {
        	 try{
                 String[] pdate = new String[2];
                 con=connect.getConnection();
                 stmt = con.createStatement();
                 query = "select * from package where packageid='"+pac+"';";
                 rs=stmt.executeQuery(query);
                 rs.next();
                 pdate[0]=rs.getString(2);
                 pdate[1]=rs.getString(3);
                 return pdate;
             }catch(SQLException sqle)
             {
                 System.out.println(sqle);
                 return null;
             }  
     }
         //***********************************search nurse id for package Detail Update *****************************
         
         public static  String[] getnurseid_for_price(String nid)
         {
        	 try{
                 String[] price = new String[2];
                 con=connect.getConnection();
                 stmt = con.createStatement();
                 query = "select * from packagedetail where nurseid='"+nid+"';";
                 rs=stmt.executeQuery(query);
                 rs.next();
                 price[0]=rs.getString(3);
                 price[1]=rs.getString(4);
                 return price;
             }catch(SQLException sqle)
             {
                 System.out.println(sqle);
                 return null;
             } 
     }
         
         public static  String[] serachPrice(String pid,String nid)
         {
        	 try{
                 String[] price = new String[2];
                 con=connect.getConnection();
                 stmt = con.createStatement();
                 query = "select * from packagedetail where packageid='"+pid+"' and nurseid='"+nid+"';";
                 //System.out.print(query);
                 rs=stmt.executeQuery(query);
                 rs.next();
                 price[0]=rs.getString(3);
                 price[1]=rs.getString(4);
                 return price;
             }catch(SQLException sqle)
             {
                 System.out.println(sqle);
                 return null;
             } 
     } 
         
  public static  String[] serachPrice1(String pid,String nuid)
     {
    	 try{
             String[] price = new String[2];
             con=connect.getConnection();
             stmt = con.createStatement();
             query = "select * from packagedetail where packageid='"+pid+"' and nurseid='"+nuid+"';";
             rs=stmt.executeQuery(query);
             rs.next();
             price[0]=rs.getString(3);
             return price;
         }catch(SQLException sqle)
         {
        	 //JOptionPane.showMessageDialog(null, "There is no Data!");
             return null;
         } 
 }
         
         
         
         
         
         
         
         
         
         public static boolean insertConfirmData(String tbName , String pid,String nid,int cid,String date,String price)
     	{
     	    if(tbName.equals("calling"))
     	    {
     	    	query="insert into calling(packageid,nurseid,patientid,date,price)values('"+pid+"','"+nid+"',"+cid+",'"+date+"','"+price+"')";
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

         public static  String[] getnurseData(String nid)
         {
        	 try{
                 String[] nur = new String[4];
                 con=connect.getConnection();
                 stmt = con.createStatement();
                 query = "select * from nurse where nurseid='"+nid+"';";
                 rs=stmt.executeQuery(query);
                 rs.next();
                 nur[0]=rs.getString(2);
                 nur[1]=rs.getString(6);
                 nur[2]=rs.getString(7);
                 nur[3]=rs.getString(8);
                 return nur;
             }catch(SQLException sqle)
             {
                 System.out.println(sqle);
                 return null;
             } 
     }
         public static  String[] getpackData(String pid)
         {
        	 try{
                 String[] date = new String[2];
                 con=connect.getConnection();
                 stmt = con.createStatement();
                 query = "select * from package where packageid='"+pid+"';";
                 rs=stmt.executeQuery(query);
                 rs.next();
                 date[0]=rs.getString(2);
                 date[1]=rs.getString(3);
                 return date;
             }catch(SQLException sqle)
             {
                 System.out.println(sqle);
                 return null;
             } 
     }
         public static  String[] getpatientData(String patientid)
         {
        	 try{
                 String[] pt = new String[2];
                 con=connect.getConnection();
                 stmt = con.createStatement();
                 query = "select * from patient where patientid='"+patientid+"';";
                 rs=stmt.executeQuery(query);
                 rs.next();
                 pt[0]=rs.getString(4);
                 pt[1]=rs.getString(5);
                 return  pt;
             }catch(SQLException sqle)
             {
                 System.out.println(sqle);
                 return null;
             } 
     }
         //********************Updage pkg,price,nurse,patient **************************
         public static boolean updateRecord(String tbName,String id , String []data)
         {
             if(tbName.equals("patient"))
                 query = "update patient set age='"+data[0]+"',contact='"+data[1]+"'where patientid='"+id+"'";
             else  if(tbName.equals("package"))
                 query = "update package set startdate='"+data[0]+"',enddate='"+data[1]+"'where packageid='"+id+"'";
             else if(tbName.equals("nurse"))
                 query = "update nurse set name='"+data[0]+"',experience='"+data[1]+"',phone='"+data[2]+"',address='"+data[3]+"'where nurseid='"+id+"'";
             else if(tbName.equals("packagedetail"))
                 query = "update packagedetail set price='"+data[0]+"'where packageid='"+id+"'";
  //           else if(tbName.equals("brand"))
//                  query = "update brand set brandname='"+data[0]+"' where brandid='"+id+"'";
//             else if(tbName.equals("type"))
//                  query = "update type set typename='"+data[0]+"' where typeid='"+id+"'";
//             else if(tbName.equals("orderdetail"))
//                  query = "update orderdetail set remark = "+Integer.parseInt(data[0])+" where orderid='"+id+"'";
//             else if(tbName.equals("orders"))
//             {
//                  int cat = data[0].indexOf("(");
//                  query = "update orders set orderdate='"+data[0].substring(0,cat)+"'where orderid='"+id+"'";
//             }

                 
                 try{
                	 con=connect.getConnection();
                     stmt = con.createStatement();
                     if(stmt.executeUpdate(query)==1)
                     {
                         return true;
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                         return false;}
                 }
                 catch(SQLException e)
                 {
                     JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                     return false;
                 }
           }
         public static boolean afterupdateRecord(String tbName,String id , String []data)
         {
             if(tbName.equals("packagedetail"))
                 query = "update packagedetail set oncall='"+data[0]+"'where packageid='"+id+"'";
  //           else if(tbName.equals("brand"))
//                  query = "update brand set brandname='"+data[0]+"' where brandid='"+id+"'";
//             else if(tbName.equals("type"))
//                  query = "update type set typename='"+data[0]+"' where typeid='"+id+"'";
//             else if(tbName.equals("orderdetail"))
//                  query = "update orderdetail set remark = "+Integer.parseInt(data[0])+" where orderid='"+id+"'";
//             else if(tbName.equals("orders"))
//             {
//                  int cat = data[0].indexOf("(");
//                  query = "update orders set orderdate='"+data[0].substring(0,cat)+"'where orderid='"+id+"'";
//             }

                 
                 try{
                	 con=connect.getConnection();
                     stmt = con.createStatement();
                     if(stmt.executeUpdate(query)==1)
                     {
                         return true;
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                         return false;}
                 }
                 catch(SQLException e)
                 {
                     JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                     return false;
                 }
           }
         public static boolean updatePackageDetailRecord(String tbName,String pid,String nid , String []data)
         {
             if(tbName.equals("packagedetail"))
                 query = "update packagedetail set price='"+data[0]+"'where packageid='"+pid+"' and nurseid='"+nid+"'";
  //           else if(tbName.equals("brand"))
//                  query = "update brand set brandname='"+data[0]+"' where brandid='"+id+"'";
//             else if(tbName.equals("type"))
//                  query = "update type set typename='"+data[0]+"' where typeid='"+id+"'";
//             else if(tbName.equals("orderdetail"))
//                  query = "update orderdetail set remark = "+Integer.parseInt(data[0])+" where orderid='"+id+"'";
//             else if(tbName.equals("orders"))
//             {
//                  int cat = data[0].indexOf("(");
//                  query = "update orders set orderdate='"+data[0].substring(0,cat)+"'where orderid='"+id+"'";
//             }

                 
                 try{
                	 con=connect.getConnection();
                     stmt = con.createStatement();
                     if(stmt.executeUpdate(query)==1)
                     {
                         return true;
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                         return false;}
                 }
                 catch(SQLException e)
                 {
                     JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                     return false;
                 }
           }
         
         public static void deleteRecord(String tbName,String id)
         {
             String query = "";
             if(tbName.equals("patient"))
             {
                 query = "delete from patient where patientid = '"+id+"' ";
             }
             if(tbName.equals("package"))
             {
                 query = "delete from package where packageid = '"+id+"' ";
             }
             if(tbName.equals("nurse"))
             {
                 query = "delete from nurse where nurseid = '"+id+"' ";
             }
             try{
                 stmt = con.createStatement();
                 if(!query.equals("")&&stmt.executeUpdate(query)==1)
                     JOptionPane.showMessageDialog(null, "The record is deleted successfully in"+tbName+"table.");
                 else
                     JOptionPane.showMessageDialog(null,"The specified ID does not found in the table .","Delete Fail",JOptionPane.ERROR_MESSAGE);
             }catch(SQLException e)
             {
                 JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
             }

         }
         public static void deletePackageDetailRecord(String tbName,String id,String nid)
         {
             String query = "";
             if(tbName.equals("packagedetail"))
             {
                 query = "delete from packagedetail where packageid = '"+id+"' and nurseid='"+nid+"'";
             }
             try{
                 stmt = con.createStatement();
                 if(!query.equals("")&&stmt.executeUpdate(query)==1)
                     JOptionPane.showMessageDialog(null, "The record is deleted successfully in"+tbName+"table.");
                 else
                     JOptionPane.showMessageDialog(null,"The specified ID does not found in the table .","Delete Fail",JOptionPane.ERROR_MESSAGE);
             }catch(SQLException e)
             {
                 JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
             }

         }


}

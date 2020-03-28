package com.nwnu.model.dao;

import java.sql.*; 

public class QueryNew {
	
	String Sqll;
	Statement sta;
	ResultSet res;
	MysqlConnection mysqlConn = new MysqlConnection();
	Connection conn = mysqlConn.myConnection();
	
	
	Object a[][]=null;  
	String b[]=null;  
	String tableName="";  
	int p;//字段个数  
	    
	public Object[][] getRecord(){//求表格的内容  
		a=null;  
	    b=null;  
	    try{   
	         int n=getAmount();
	         sta = conn.createStatement();
	         res = sta.executeQuery(Sqll);
	         ResultSetMetaData rem = res.getMetaData();
	         int p=rem.getColumnCount(); 
	         a=new Object[n][p];  
	        // sta=conn.createStatement();           
	         
	         int m=0;  
	         while(res.next()){  
	             for(int k=1;k<=p;k++){  
	                 a[m][k-1]=res.getString(k);  
	             }  
	         System.out.println();  
	         m++;  
	         }  
	    }  
	        catch(SQLException e){  
	            System.out.println("请输入正确的表名"+e);  
	        }  
	        return a;  
	    }  
	    
	    public int getAmount(){//求表内容有多少行  
	     
	        try{  
	             
	            sta=conn.createStatement();  
	            res=sta.executeQuery(Sqll);  
	            res.last();  
	            int rows=res.getRow();  
	            return rows;  
	        }  
	        catch(SQLException exp){  
	            System.out.println(""+exp);  
	            return 0;  
	        }  
	    }  
	    
	    public String[] getField(){//求字段名称   
	        try{  
	        	sta = conn.createStatement();
	        	res = sta.executeQuery(Sqll);
	        	ResultSetMetaData rem = res.getMetaData();
	           	int p=rem.getColumnCount();
	          // 	System.out.println(p);
	            b=new String[p];  
	            int k;  	             
	            for (k=0; k < p; k++) {// 获取从1到字段的数量
					
					b[k]= rem.getColumnName(k+1); 
					//System.out.println(b[k]);
	            }
				
	        }  
	        catch(SQLException e){  
	            System.out.println(e);  
	        }  
	        return b;  
	    }  
	    
	    public void setTableName(String s){//初试表名  
	        tableName=s.trim();  
	    }  
	    public void setSqll(String s){//初试表名  
	        Sqll = s;  
	    }
	    
	/*    public int getZiDuan(){//求字段个数  
	        try{  
	            
	            DatabaseMetaData metadata=conn.getMetaData();  
	            ResultSet rs1=metadata.getColumns(null, null, tableName, null);  
	            p=0;  
	            while(rs1.next())  
	                p++;  
	        }  
	        catch(SQLException e){  
	            System.out.println(e);  
	        }  
	        return p;  
	    }  */
}

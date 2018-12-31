package com.modelpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.beanpack.TestBean;

public class DBCon {
	private static DBCon dbcon;
	private Connection con;
	Statement st;PreparedStatement ps;ResultSet rs;
	private DBCon()
	{
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","user1","oracle");
		}catch(Exception e){e.printStackTrace();}
	}
	public static DBCon getDBCon()
	{
		try{
			if(dbcon==null)
			{
				dbcon=new DBCon();
				return dbcon;
			}
			else
			{
				return dbcon;
			}
		}catch(Exception e){e.printStackTrace();return null;}
	}
	public boolean checkUser(String uname, String upass)
	{
		try{
			ps=con.prepareStatement("SELECT * FROM REGISTRATION WHERE NAME=?");
			ps.setString(1,uname);
			rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getString(2).equals(upass)){
					return true;
				}else{
					return false;
				}
			}
			else
			{
			return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			try{ps.close();rs.close();}catch(Exception e){}
		}
	}
	public boolean checkStatus(String uname)
	{
		try{
			ps=con.prepareStatement("SELECT * FROM REGISTRATION WHERE NAME=?");
			ps.setString(1,uname);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int status = rs.getInt(4);
				if(status==0){return true;}
				else{return false;}
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			try{ps.close();rs.close();}catch(Exception e){}
		}
	}
	public void changeStatus(String uname,int status)
	{
		try{
		ps=con.prepareStatement("UPDATE REGISTRATION SET STATUS=? WHERE NAME=?");
		ps.setInt(1,status);
		ps.setString(2,uname);
		ps.executeUpdate();
		}catch(Exception e){}
		finally{try{ps.close();}catch(Exception e){}
		}
	}
	public boolean registerUser(String uname, String upass, String rollno) {
		try{
			ps=con.prepareStatement("INSERT INTO REGISTRATION VALUES (?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,upass);
			ps.setString(3,rollno);
			ps.setInt(4,0);
			rs=ps.executeQuery();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			try{ps.close();rs.close();}catch(Exception e){}
		}
	}
	
	public boolean checkUserPresent(String uname)
	{
		try{
			ps=con.prepareStatement("SELECT * FROM REGISTRATION WHERE NAME=?");
			ps.setString(1,uname);
			rs=ps.executeQuery();
			if(rs.next()){
			return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			try{ps.close();rs.close();}catch(Exception e){}
		}
	}
	
	public HashMap getQuestionAnswerSet()
	{
		HashMap hm=new HashMap();
		TestBean testbean;
		try{
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM QUESTIONAIRE");
			int i=0;
			while(rs.next())
			{
				testbean=new TestBean();
				testbean.setQid(rs.getInt(1));
				testbean.setQuestion(rs.getString(2));
				testbean.setO1(rs.getString(3));
				testbean.setO2(rs.getString(4));
				testbean.setO3(rs.getString(5));
				testbean.setAns(rs.getString(6));
				i++;
				System.out.println(i);
				hm.put(testbean.getQid(),testbean);
				hm.put("noofquestions", i);
			}
			return hm;
		}catch(Exception e){
			e.printStackTrace();return null;}
		finally{try{st.close();rs.close();}catch
			(Exception ee){}}
	}

}

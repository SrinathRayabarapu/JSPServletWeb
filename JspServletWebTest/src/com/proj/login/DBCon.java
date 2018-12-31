package com.proj.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import com.proj.testbean.TestBean;
import com.proj.testbean.Question;

public class DBCon {
	private static DBCon dbcon;
	private Connection	con;
	private ResultSet rs;
	private PreparedStatement ps;
	private Statement stmt;
	
	private DBCon() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","user1","oracle");
		}catch(Exception e){e.printStackTrace();}
	}
	public static DBCon getDBCon()
	{
		if(dbcon==null)
		{
			dbcon=new DBCon();
			return dbcon;
		}
		else
		{
			return dbcon;
		}
	}
	public HashMap getCredentials(String name)
	{
		HashMap hashMap = new HashMap();
		ArrayList arrayList = new ArrayList();
		TestBean testBean = new TestBean();
		
		try{
			stmt=con.createStatement();
			String query = "SELECT * FROM REGISTRATION WHERE NAME='"+name+"'";
			rs=stmt.executeQuery(query);

			while(rs.next())
			{	
				testBean.setPassword(rs.getString(2));
				hashMap.put("credentials",testBean);
			}
			return hashMap;
		}catch(Exception e){
			e.printStackTrace();return null;}
		finally{try{stmt.close();rs.close();}catch
			(Exception ee){}}
	}
	
	public boolean getRegister(HashMap hashMap)
	{
		TestBean testBean = (TestBean)hashMap.get("regestervalues");
		
		try{
			stmt=con.createStatement();
			String query = "INSERT INTO REGISTRATION VALUES (?, ?, ?, ?)";
			rs=stmt.executeQuery(query);
			ps = con.prepareStatement(query);
			
			System.out.println(testBean.getUsername());
			
			ps.setString(1, testBean.getUsername());
			ps.setString(2, testBean.getPassword());
			ps.setString(3, testBean.getRollno());
			ps.setInt(4,0);  
			
			ps.executeUpdate();
			return true;
			
		}catch(Exception e){
			System.out.println(e);return false;}
		finally{try{stmt.close();rs.close();}catch(Exception ee){}}
	}
	public HashMap getQuestionSet()
	{
		HashMap hm=new HashMap();
		Question question=null;
		try{
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from questionaire");
			while(rs.next())
			{
				question=new Question();
				question.setQid(rs.getInt(1));
				question.setQuestion(rs.getString(2));
				question.setO1(rs.getString(3));
				question.setO2(rs.getString(4));
				question.setO3(rs.getString(5));
				question.setAns(rs.getString(6));
				hm.put(question.getQid(),question);
			}
			return hm;
		}catch(Exception e){
			e.printStackTrace();return null;}
		finally{try{stmt.close();rs.close();}catch
			(Exception ee){}}
	}
}

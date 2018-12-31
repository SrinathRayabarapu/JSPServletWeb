package com.proj.scenario;

import java.util.HashMap;
import com.proj.login.DBCon;
import com.proj.testbean.TestBean;

public class Scenario {

	public static void main(String[] args) {
		DBCon dbcon;
		HashMap hm;
		TestBean bean;
		String name = "srinath";
		dbcon=DBCon.getDBCon();
		 hm=dbcon.getCredentials(name);
		 bean = (TestBean)hm.get("credentials");
//		 System.out.println(bean.getPassword());
	}
}

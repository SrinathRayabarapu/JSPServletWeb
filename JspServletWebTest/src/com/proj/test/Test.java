package com.proj.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.proj.login.DBCon;
import com.proj.testbean.Question;

public class Test{
	DBCon dbcon;
	HashMap hm;
	HashMap answerset;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Question question;
	int next;
	Thread thread;
	
	public Test() {
		 dbcon=DBCon.getDBCon();
		 hm=dbcon.getQuestionSet();
//		 thread = new Thread(this);
//		 thread.start();
//		 try {
//			Thread.sleep(40000);
//		} catch (InterruptedException e) {e.printStackTrace();}
	}
	public void takeTest()
	{
		Random r=new Random();
		answerset=new HashMap();
		String noofvalues=hm.get("noofquestions").toString();
		int qnumber = Integer.parseInt(noofvalues);
		
		try{
			for(int i=1;i<=qnumber;i++)
			{
				next=r.nextInt(qnumber);
				if(next!=0){
					question=(Question)hm.get(next);
					System.out.println(question);
					System.out.println("ANS-Press A or B or C and Enter:");
					String ans=br.readLine();
					answerset.put(question.getQid(),ans);
					
					System.out.println("Enter b for back; f for forward questions");
					String navigate = br.readLine();
					if(navigate.equalsIgnoreCase("b")){
						question=(Question)hm.get(next-1);
						System.out.println(question);
						System.out.println("ANS-Press A or B or C and Enter:");
						String ans1=br.readLine();
						answerset.put(question.getQid(),ans1);
					}else if(navigate.equalsIgnoreCase("f")){
						question=(Question)hm.get(next+1);
						System.out.println(question);
						System.out.println("ANS-Press A or B or C and Enter:");
						String ans2=br.readLine();
						answerset.put(question.getQid(),ans2);
					}
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}

	public void calculateResult()
	{
		System.out.println("Time is up !!");
		int score=0;
		Set set= answerset.entrySet();
		Iterator iter=set.iterator();
		while(iter.hasNext())
		{
			Map.Entry me=(Map.Entry)iter.next();
			int qid=(Integer)me.getKey();
			String ans=(String)me.getValue();
			String rightans=((Question)hm.get(qid)).getAns();
			if(ans.equalsIgnoreCase(rightans.trim()))
			{
				score++;
			}
		}
		System.out.println("You Scored: "+score);
	}
//	public static void main(String[] args) {
//		Test obj=new Test();
//		obj.calculateResult();
//		System.exit(0);
//	}
//
//	@Override
//	public void run() {
//		takeTest(3);
//	}
}

package com.proj.testbean;

import java.io.Serializable;

public class Question implements Serializable{
	private int qid;
	private String question;
	private String o1;
	private String o2;
	private String o3;
	private String ans;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getO1() {
		return o1;
	}
	public void setO1(String o1) {
		this.o1 = o1;
	}
	public String getO2() {
		return o2;
	}
	public void setO2(String o2) {
		this.o2 = o2;
	}
	public String getO3() {
		return o3;
	}
	public void setO3(String o3) {
		this.o3 = o3;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
//	@Override
//	public String toString() {
//		return getQuestion()+" "+"\n"+getO1()+"\n"
//		+getO2()+"\n"+getO3()+"\n";
//	}
}

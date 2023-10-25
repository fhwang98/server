package com.test.ajax.model;

// 계층 간 데이터를 전달하는 상자 역할 > Model
//- DTO > Data Transfer Object
//		> 멤버 변수 + Getter/Setter 구현

//MemoDTO == tblMemo의 레코드 1줄
public class MemoDTO {
	
	private String seq;
	private String name;
	private String pw;
	private String memo;
	private String regdate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}

package com.test.memo.model;

// 계층 간 데이터를 전달하는 상자 역할 > Model
//- DTO > Data Transfer Object
//		> 멤버 변수 + Getter/Setter 구현
public class MemoDTO {
	
	private String name;
	private String pw;
	private String memo;

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
	
}

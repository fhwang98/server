package com.test.toy.board.model;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String seq;
	private String subject;
	private String content;
	private String regdate;
	private int readcount;
	private String id;
	
	private String name;
	private String isnew;

}

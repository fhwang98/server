package com.test.toy.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//Lombok

@Data
public class UserDTO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String lv;
	private String pic;
	private String intro;
	

	
}

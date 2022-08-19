package com.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username Must Be min 4 characters !!!")
	private String name;
	
	@Email
	@Size(message = "Email s not valid !!!")
	private String email;
	
	@NotEmpty
	@Size(min = 4, max = 10 , message = "password must be min 4 and max 10 !!!")
	private String password;
	
	@NotEmpty
	private String about;

}

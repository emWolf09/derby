package com.derby.model;

import lombok.*;

/**
 * @author MAHESH NAGARWAL
 *
 */
@Data
public class User {
	private int id;
	private String username;
	private String email;
	private String name;
	private String password;
	
}

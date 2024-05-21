package com.example.User.UserListExample.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")  // Changed table name

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(sequenceName = "user_seq", name = "user_generator", allocationSize = 1)

	private int userId;
	private String userName;
	private String user_FatherName;
	private String user_MotherName;
	private String email_id;
	private long mob_num;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String user_FatherName, String user_MotherName, String email_id,
			long mob_num) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.user_FatherName = user_FatherName;
		this.user_MotherName = user_MotherName;
		this.email_id = email_id;
		this.mob_num = mob_num;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUser_FatherName() {
		return user_FatherName;
	}
	public void setUser_FatherName(String user_FatherName) {
		this.user_FatherName = user_FatherName;
	}
	public String getUser_MotherName() {
		return user_MotherName;
	}
	public void setUser_MotherName(String user_MotherName) {
		this.user_MotherName = user_MotherName;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getMob_num() {
		return mob_num;
	}
	public void setMob_num(long mob_num) {
		this.mob_num = mob_num;
	}

}
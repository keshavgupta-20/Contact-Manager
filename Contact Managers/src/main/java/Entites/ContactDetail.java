package Entites;

import java.sql.Date;

public class ContactDetail {
	public ContactDetail() {
		
	}
	private String group;
	
	public String getGroup() {
	    return group;
	}
	public void setGroup(String group) {
	    this.group = group;
	}
	public ContactDetail(int id, String name, String email, String phone, String address, Date birthday, String group) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	private int id; // This is important
	private String name;
	private String email;
	private String phone;
	private String address;
	private Date birthday;
	

}

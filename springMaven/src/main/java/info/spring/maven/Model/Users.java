package info.spring.maven.Model;

public class Users {

	
	@org.springframework.data.annotation.Id private String Id;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Users(String name, String surname, String phone) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}
	public Users()
	{
		
		
	}
	public Users(String id, String name, String surname, String phone) {
		this.Id = id;
	    this.name = name;
		this.surname = surname;
		this.phone= phone;
	}

	private String name;
	private String surname;

	private String phone;
	@Override
	public String toString() {
		return "Users [Id=" + Id + ", name=" + name + ", surname=" + surname
				+ ", phone=" + phone + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return this.surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

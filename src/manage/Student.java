package manage;

import java.io.Serializable;

public class Student implements Serializable {
	private 
		String number;
		String name;
		int age;
		String sex;
		String origo;
		String photo;
		String hobby;
	public Student(String number, String name,  String sex,int age,
			String origo,  String hobby,String photo) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.origo = origo;
		this.photo = photo;
		this.hobby = hobby;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOrigo() {
		return origo;
	}
	public void setOrigo(String origo) {
		this.origo = origo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

		
}

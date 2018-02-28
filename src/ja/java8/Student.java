package ja.java8;

public class Student {
	private String name;
	private String surname;
	
	public Student() {
	}
	
	public Student(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
	}
}

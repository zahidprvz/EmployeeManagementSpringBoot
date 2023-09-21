package com.example.demo;

// Creating an entity Employee
public class Employee {

	public Employee() {}

	// Parameterized Constructor
	// to assign the values
	// to the properties of
	// the entity
	public Employee(
		Integer employee_id, String first_name,
		String last_name, String email, String title)
	{

		super();

		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
        this.title = title;

		 
	}

	 private Integer employee_id;
	 private String first_name;
	 private String last_name;
	 private String email;
     private String title;

	// Overriding the toString method
	// to find all the values
	@Override
 public String toString()
	{

		return "Employee [employee_id="
			+ employee_id + ", first_name="
			+ first_name + ", last_name="
			+ last_name + ", email="
			+ email + ", title="
            + title + "]";

		 
	}

	// Getters and setters of
	// the properties
	public Integer getId()
	{
		return employee_id;
	}

	public void setId(Integer employee_id)
	{
		this.employee_id = employee_id;
	}

	public String getFirstName()
	{
		return first_name;
	}

	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}

	public String getLastName()
	{
		return last_name;
	}

	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

    	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
}

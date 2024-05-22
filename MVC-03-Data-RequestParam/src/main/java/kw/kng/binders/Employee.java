package kw.kng.binders;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee 
{
	private Long eno;
	private String ename;
	private Double salary;
	private Boolean vaccinated;
	
	public Employee()
	{}

}

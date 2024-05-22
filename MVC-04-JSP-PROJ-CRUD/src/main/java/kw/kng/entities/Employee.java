package kw.kng.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CRUD_EMPLOYEE")
@Data
public class Employee 
{
	@Id
	@SequenceGenerator(name="gen1", sequenceName="crud_employee_seq", allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private long empno;
	
	@Column(length=20)
	private String ename;
	
	@Column(length=20)
	private String job;
	
	private Float sal;
	
	private Integer deptno;
	
}
/*
 
  CREATE SEQUENCE crud_employee_seq
    START WITH 100
    INCREMENT BY 1
    NOMAXVALUE;
    
    
 */
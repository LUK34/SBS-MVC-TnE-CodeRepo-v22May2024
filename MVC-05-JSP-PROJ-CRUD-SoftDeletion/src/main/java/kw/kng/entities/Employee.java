package kw.kng.entities;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CRUD_EMPLOYEE_V2")
@Data
@SQLDelete(sql="UPDATE CRUD_EMPLOYEE_V2 SET STATUS='N' where EMPNO=?")
@SQLRestriction("STATUS <> 'N'")
public class Employee 
{
	@Id
	@SequenceGenerator(name="gen1", sequenceName="crud_employee_v2_seq", allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private long empno;
	
	@Column(length=20)
	private String ename;
	
	@Column(length=20)
	private String job;
	
	private Float sal;
	
	private Integer deptno=10;
	
	private String status="Y";
	
	
}
/*
 
 1. Deleting record permanently from database table is called Hard Deletion.
 
 2. Deleting record by changing the status of the record and making that not participating in CURD opertaions
 is called SoftDeletion.
 
 3. We have JPA Annotation called SQL annotation which allows to configure custom SQL Queries
 for standard SQL operations like INSERT, UPDATE,DELETE.(@SQLInsert,@SQLDelete,@SQLUpdate)
 
 4. @SQLDelete annotation is useful to cfg Custom Query for the standard delete operation.
 Thisis very useful to cfg UPDATE SQL Query of soft deletion to mark the record as the DELETED record
 for standard delete operation.
 
 5. @Where annotation can be used to specify implcit condition that should applied on every query that executes.
 
 
 
 */


/*
 
 //SQL COMMANDS USED:
 
  CREATE SEQUENCE crud_employee_v2_seq
    START WITH 100
    INCREMENT BY 1
    NOMAXVALUE;
    
   
ALTER TABLE CRUD_EMPLOYEE_V2 ADD (status VARCHAR2(15));

ALTER TABLE CRUD_EMPLOYEE_V2 MODIFY STATUS VARCHAR2(1);

UPDATE CRUD_EMPLOYEE_V2 SET status = 'Y';        
*/
    
   
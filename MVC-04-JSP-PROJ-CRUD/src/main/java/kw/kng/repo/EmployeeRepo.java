package kw.kng.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> 
{

}

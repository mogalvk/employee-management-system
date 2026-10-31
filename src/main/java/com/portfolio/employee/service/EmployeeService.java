package com.portfolio.employee.service;
import com.portfolio.employee.api.EmployeeRequest; import com.portfolio.employee.domain.Employee; import com.portfolio.employee.repo.EmployeeRepository; import com.portfolio.employee.error.*; import org.springframework.data.domain.*; import org.springframework.stereotype.Service;
@Service public class EmployeeService { private final EmployeeRepository repo; public EmployeeService(EmployeeRepository repo){this.repo=repo;}
 public Page<Employee> list(Pageable p){return repo.findAll(p);} public Employee get(long id){return repo.findById(id).orElseThrow(()->new NotFoundException("Employee not found"));}
 public Employee create(EmployeeRequest r){ if(repo.existsByEmailIgnoreCase(r.email())) throw new ConflictException("Email already exists"); Employee e=new Employee(); apply(e,r); return repo.save(e); }
 public Employee update(long id,EmployeeRequest r){Employee e=get(id); apply(e,r); return repo.save(e);} public void delete(long id){repo.delete(get(id));}
 private void apply(Employee e,EmployeeRequest r){e.setFirstName(r.firstName()); e.setLastName(r.lastName()); e.setEmail(r.email().toLowerCase()); e.setDepartment(r.department()); e.setSalary(r.salary());}
}
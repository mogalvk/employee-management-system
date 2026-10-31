package com.portfolio.employee.repo;
import com.portfolio.employee.domain.Employee; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface EmployeeRepository extends JpaRepository<Employee,Long> { boolean existsByEmailIgnoreCase(String email); }

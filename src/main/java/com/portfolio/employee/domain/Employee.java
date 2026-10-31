package com.portfolio.employee.domain;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
@Entity @Table(name="employees") public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String firstName;
        private String lastName;
        private String email;
        private String department;
        private BigDecimal salary;
    private Instant createdAt;
 @PrePersist void stamp() { createdAt=Instant.now(); }
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getFirstName(){return firstName;} public void setFirstName(String v){this.firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){this.lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){this.email=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){this.department=v;}
 public BigDecimal getSalary(){return salary;} public void setSalary(BigDecimal v){this.salary=v;}
 public Instant getCreatedAt(){return createdAt;}
}
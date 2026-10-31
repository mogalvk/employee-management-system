package com.portfolio.employee.api;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public record EmployeeRequest(
 @NotBlank @Size(max=80) String firstName,
 @NotBlank @Size(max=80) String lastName,
 @NotBlank @Email @Size(max=180) String email,
 @NotBlank @Size(max=100) String department,
 @NotNull @DecimalMin("0.00") @Digits(integer=10, fraction=2) BigDecimal salary
) {}

package com.anataarisa.pimtool.service;

import com.anataarisa.pimtool.model.dto.EmployeeDto;
import com.anataarisa.pimtool.model.entity.Employee;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    public Optional<Employee> findEmployeeById(Number employeeID) throws EntitySearchNotFoundException;
    public Set<Employee> getEmployeesByVisa(Set<String> visa) throws EntitySearchNotFoundException;

}

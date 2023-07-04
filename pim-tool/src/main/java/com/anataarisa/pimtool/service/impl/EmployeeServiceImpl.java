package com.anataarisa.pimtool.service.impl;

import com.anataarisa.pimtool.model.entity.Employee;
import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.repository.EmployeeRepository;
import com.anataarisa.pimtool.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Optional<Employee> findEmployeeById(Number employeeID) throws EntitySearchNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeID);
        if(employee.isEmpty()) throw new EntitySearchNotFoundException("This employee does not exist");
        return employee;
    }

    @Override
    public Set<Employee> getEmployeesByVisa(Set<String> visa) throws EntitySearchNotFoundException {
        Set<Employee> employeeSet  = new HashSet<>();
        for(String visaEmtity: visa){
            Set<Employee> temp = employeeRepository.findAll().stream().filter(a->a.getVisa().equalsIgnoreCase(visaEmtity)).collect(Collectors.toSet());
            if(temp.isEmpty()) throw new EntitySearchNotFoundException("Employees with this visa don't exist");
            else employeeSet.addAll(temp);
        }
        return employeeSet;
    }
}

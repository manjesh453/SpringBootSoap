package com.soapapi.service.impl;

import com.soapapi.model.Employee;
import com.soapapi.repo.EmployeeRepo;
import com.soapapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Override
    public void AddEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }
}

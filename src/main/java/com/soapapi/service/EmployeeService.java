package com.soapapi.service;

import com.soapapi.model.Employee;

public interface EmployeeService {
    void AddEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(long id);
}

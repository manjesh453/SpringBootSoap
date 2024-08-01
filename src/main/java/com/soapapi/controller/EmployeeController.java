package com.soapapi.controller;

import com.soapapi.dto.*;
import com.soapapi.model.Employee;
import com.soapapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class EmployeeController {
    private static final String NAMESPACE_URL = "http://com.soapapi.appapis";
    private EmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
        AddEmployeeResponse response = new AddEmployeeResponse();
        ServiceStatus status = new ServiceStatus();
        Employee employee = new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
        employeeService.AddEmployee(employee);
        status.setStatus("Success");
        status.setMessage("Content Added Successfully");
        response.setServiceStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
        response.setEmployeeInfo(employeeInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
        employeeService.updateEmployee(employee);
        ServiceStatus status = new ServiceStatus();
        status.setStatus("Success");
        status.setMessage("Content Update Successfully");
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setServiceStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "deleteEmployee")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
        employeeService.deleteEmployee(request.getEmployeeId());
        ServiceStatus status = new ServiceStatus();
        status.setStatus("Success");
        status.setMessage("Content Delete Successfully");
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setServiceStatus(status);
        return response;
    }
}

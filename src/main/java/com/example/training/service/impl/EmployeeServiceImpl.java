package com.example.training.service.impl;

import com.example.training.dto.EmployeeDto;
import com.example.training.entity.Employee;
import com.example.training.mapper.EmployeeMapper;
import com.example.training.repository.EmployeeRepository;
import com.example.training.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }
}

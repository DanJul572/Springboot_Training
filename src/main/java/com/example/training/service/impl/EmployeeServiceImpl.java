package com.example.training.service.impl;

import com.example.training.dto.EmployeeDto;
import com.example.training.entity.Employee;
import com.example.training.exception.ResourceNotFoundException;
import com.example.training.mapper.EmployeeMapper;
import com.example.training.repository.EmployeeRepository;
import com.example.training.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public  EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + id + " not found")
        );
        return EmployeeMapper.toEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        EmployeeDto employee = getEmployeeById(id);
        Employee updatedEmployee = EmployeeMapper.toEmployee(employee);

        updatedEmployee.setFirstName(employeeDto.getFirstName());
        updatedEmployee.setLastName(employeeDto.getLastName());
        updatedEmployee.setEmail(employeeDto.getEmail());

        Employee savedEmployee = employeeRepository.save(updatedEmployee);

        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        EmployeeDto employeeDto = getEmployeeById(id);
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        employeeRepository.delete(employee);
    }
}

package org.thepoet.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thepoet.dao.EmployeeDao;
import org.thepoet.enums.ErrorCode;
import org.thepoet.exception.ServiceException;
import org.thepoet.model.Employee;
import org.thepoet.model.Hobby;
import org.thepoet.service.spec.EmployeeService;

import java.util.List;
import java.util.Set;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee saveEmployee(Employee employee) throws ServiceException {
        if (isExists(employee.getMailAddress())) {
            throw new ServiceException(ErrorCode.EMPLOYEE_ALREADY_EXISTS);
        }
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public Employee getByMailAddress(String mailAddress) throws ServiceException {
        Employee employee = employeeDao.getEmployeeByMailAddress(mailAddress);
        if (employee == null) {
            throw new ServiceException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() throws ServiceException {
        List<Employee> employeeList = employeeDao.getAllBy();
        if (employeeList == null || employeeList.isEmpty()) {
            throw new ServiceException(ErrorCode.EMPLOYEE_LIST_IS_EMPTY);
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) throws ServiceException {
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee == null) {
            throw new ServiceException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        return employee;
    }

    @Override
    public boolean isExists(String mailAddress) {
        try {
            Employee employee = getByMailAddress(mailAddress);
            return true;
        } catch (ServiceException e) {
            return false;
        }
    }

    @Override
    public void deleteEmployeeById(String id) throws ServiceException {
        Employee employee = getEmployeeById(id);
        employeeDao.delete(employee);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) throws ServiceException {
        Employee existingEmployee = getEmployeeById(id);
        if (!StringUtils.equalsIgnoreCase(employee.getMailAddress(), existingEmployee.getMailAddress()) && isExists(employee.getMailAddress())) {
            throw new ServiceException(ErrorCode.EMPLOYEE_EXISTS_WITH_THIS_MAIL_ADDRESS);
        }
        existingEmployee.setMailAddress(employee.getMailAddress());
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setBirthDay(employee.getBirthDay());
        Set<Hobby> employeeHobbyList = employee.getHobbyList();
        if (employeeHobbyList != null && employeeHobbyList.size() > 0) {
            existingEmployee.setHobbyList(employeeHobbyList);
        }
        employeeDao.save(existingEmployee);
        return getEmployeeById(id);
    }
}
package org.thepoet.service.spec;

import org.thepoet.exception.ServiceException;
import org.thepoet.model.Employee;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee) throws ServiceException;

    boolean isExists(String mailAddress);

    Employee getByMailAddress(String mailAddress) throws ServiceException;

    List<Employee> getAllEmployees() throws ServiceException;

    Employee getEmployeeById(String id) throws ServiceException;

    void deleteEmployeeById(String id) throws ServiceException;

    Employee updateEmployee(String id, Employee employee) throws ServiceException;
}

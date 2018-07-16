package org.thepoet.dao;

import org.springframework.data.repository.CrudRepository;
import org.thepoet.model.Employee;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
public interface EmployeeDao extends CrudRepository<Employee, String> {
    Employee getEmployeeByMailAddress(String mailAddress);

    List<Employee> getAllBy();

    Employee getEmployeeById(String id);

    void deleteAllById(String id);

}

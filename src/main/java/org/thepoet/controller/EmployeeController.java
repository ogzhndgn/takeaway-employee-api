package org.thepoet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thepoet.model.Employee;
import org.thepoet.service.spec.EmployeeService;
import org.thepoet.util.TakeawayApiError;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
@RestController
@RequestMapping("api")
@Api(description = "takeaway.com Employee CRUD API")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/", method = RequestMethod.GET)
    @ApiOperation(value = "List of all employees", nickname = "GetAllEmployees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "EMPLOYEE_LIST_IS_EMPTY")
    })
    public ResponseEntity<?> listAllEmployees() {
        try {
            List<Employee> employeeList = employeeService.getAllEmployees();
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TakeawayApiError(e.getMessage()), HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get an employee's information by employee id", nickname = "GetEmployeeById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 204, message = "EMPLOYEE_NOT_FOUND")
    })
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TakeawayApiError(e.getMessage()), HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    @ApiOperation(value = "Create an employee", nickname = "CreateEmployee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 409, message = "EMPLOYEE_ALREADY_EXISTS")
    })
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TakeawayApiError(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update an employee by id", nickname = "UpdateAnEmployee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 409, message = "EMPLOYEE_NOT_FOUND"),
            @ApiResponse(code = 409, message = "EMPLOYEE_EXISTS_WITH_THIS_MAIL_ADDRESS")
    })
    public ResponseEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TakeawayApiError(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an employee by id", nickname = "DeleteAnEmployee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 204, message = "EMPLOYEE_NOT_FOUND")
    })
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TakeawayApiError(e.getMessage()), HttpStatus.NO_CONTENT);
        }

    }
}

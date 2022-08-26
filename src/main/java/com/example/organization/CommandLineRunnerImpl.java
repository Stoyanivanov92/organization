package com.example.organization;

import com.example.organization.service.DepartmentService;
import com.example.organization.service.DirectoryService;
import com.example.organization.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final Scanner scan;
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final DirectoryService directoryService;

    public CommandLineRunnerImpl(Scanner scan, EmployeeService employeeService, DepartmentService departmentService, DirectoryService directoryService) {
        this.scan = scan;
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.directoryService = directoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter username");
        String username = this.scan.nextLine();
        System.out.println("Enter password");
        String password = this.scan.nextLine();
        System.out.println("Successful access! Find data!");
        String input = this.scan.nextLine();

         while (!input.equals("Exit")) {
             String[] data = input.split(" ");
             if (data[0].equals("Add") && data[1].equals("employee")) {
                 String firstName = data[2];
                 String lastName = data[3];
                 String identicalNumber = data[4];
                 int age = Integer.parseInt(data[5]);
                 String position = data[6];
                 long departmentId = Long.parseLong(data[7]);
                 long directoryId = Long.parseLong(data[8]);

                 this.employeeService.addEmployee(firstName, lastName, identicalNumber, age, position, departmentId, directoryId);
             } else if (data[0].equals("Add") && data[1].equals("department")) {
                 String name = data[2];
                 String description = data[3];
                 long directoryId = Long.parseLong(data[4]);

                 this.departmentService.addDepartment(name, description, directoryId);
             } else if (data[0].equals("Add") && data[1].equals("directory")) {
                 String name = data[2];
                 String description = data[3];

                 this.directoryService.addDirectory(name, description);
             } else if (data[0].equals("update") && data[1].equals("employee")) {
                 long id = Long.parseLong(data[2]);
                 this.employeeService.editEmployee(id);
             } else if (data[0].equals("update") && data[1].equals("department")) {
                 long id = Long.parseLong(data[2]);
                 String description = data[3];
                 this.departmentService.editDepartment(id, description);
             }  else if (data[0].equals("update") && data[1].equals("directory")) {
                 long id = Long.parseLong(data[2]);
                 String description = data[3];
                 this.directoryService.editDirectory(id, description);
             } else if (data[0].equals("delete") && data[1].equals("employee")) {
                 long id = Long.parseLong(data[2]);
                 this.employeeService.deleteEmployee(id);
             } else if (data[0].equals("delete") && data[1].equals("department")) {
                 long id = Long.parseLong(data[2]);
                 this.departmentService.deleteDepartment(id);
             } else if (data[0].equals("delete") && data[1].equals("directory")) {
                 long id = Long.parseLong(data[2]);
                 this.directoryService.deleteDirectory(id);
             }





             input = this.scan.nextLine();

         }
    }
}

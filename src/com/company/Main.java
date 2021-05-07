package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        

        ArrayList<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(new EmployeeFullTime("quangha","a", "a", "a","1", 20, true, 100,100,100));
        listEmployee.add(new EmployeeFullTime("a","c", "c", "c", "999999999",2, true, 100,100,100));
        listEmployee.add(new EmployeeFullTime("b","b", "b", "b","98888823", 19, false, 100,100,100));
        listEmployee.add(new Employee("admin", "admin"));
        Authentication authentication = new Authentication(listEmployee);
        authentication.privateLogin();
//        authentication.updatePassword();

        final Control haanh = new Control(listEmployee);
        haanh.addEmployee();
//      haanh.searchEmployee(listEmployee);
//        haanh.statusOfEmployee(listEmployee);
//        listEmployee.add(haanh.addEmployee(listEmployee));
        haanh.displayListEmployee(3);
//        haanh.updateEmployee(listEmployee);
//        haanh.deleteEmployee(listEmployee);
//        haanh.displayListEmployee(3,listEmployee);

    }
}

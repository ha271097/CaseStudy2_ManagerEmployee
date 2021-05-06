package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(new EmployeeFullTime("quangha","a", "a", "a","99999", 20, true, 100,100,100));
        listEmployee.add(new EmployeeFullTime("a","c", "c", "c", "999999999",2, true, 100,100,100));
        listEmployee.add(new EmployeeFullTime("b","b", "b", "b","98888823", 19, false, 100,100,100));
        final Control haanh = new Control();
//      haanh.searchEmployee(listEmployee);
//        haanh.statusOfEmployee(listEmployee);
        listEmployee.add(haanh.addEmployee(listEmployee));
//        haanh.displayListEmployee(3,listEmployee);
//        haanh.updateEmployee(listEmployee);
    }
}

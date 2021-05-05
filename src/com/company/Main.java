package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(new EmployeeFullTime("a","a", "a", "a", 20, true, 100,100,100));
        listEmployee.add(new EmployeeFullTime("a","c", "c", "c", 20, true, 100,100,100));
        listEmployee.add(new EmployeeFullTime("b","b", "b", "b", 19, false, 100,100,100));
        Control haanh = new Control();
//        haanh.searchEmployee(listEmployee);
        haanh.statusOfEmployee(listEmployee);
    }
}

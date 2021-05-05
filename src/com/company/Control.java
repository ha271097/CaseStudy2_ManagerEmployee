package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    private final Scanner SCANNER = new Scanner(System.in);

    // Hiện thị nhâm viên  và nhân viên theo trang thái
    public void displayListEmployeeTrue(int num, ArrayList<Employee> listEmployee){
        for (Employee employee: listEmployee
             ) {
            if(employee.isStatus() && num == 1) System.out.println(employee);
            else if(!employee.isStatus() && num == 2) System.out.println(employee);
            else if (num == 3) System.out.println(employee);
        }
    }
    // Tìm kiếm nhân viên:
    public void searchEmployee(ArrayList<Employee> listEmployee){
        Employee[] employees;
        do {
            System.out.println("Enter name: ");
            String name = SCANNER.nextLine();
            employees = listEmployee.stream().filter(
                    o -> o.getName().equals(name)).toArray(Employee[]::new);
            if(employees.length == 0) System.out.println("Name not found - Please enter name again: ");
            }  while(employees.length == 0);

        for (Employee emp: employees
             ) {
            System.out.println(emp.toString());
        }
    }
    //Check trạng thái của nhân viên
    public void statusOfEmployee(ArrayList<Employee> listEmployee){
        boolean check = false;
       do {
           System.out.println("Enter name: ");
           String name = SCANNER.nextLine();
           for (int i = 0; i < listEmployee.size(); i++) {
               if(listEmployee.get(i).getName().equals(name)){
                   System.out.println("Employee " + name + " status is: " + listEmployee.get(i).isStatus());
                   check = true;
               }
           }
           if(!check) System.out.println("Name not found - Please enter name again: ");
       }while (!check);
    }
    //Thêm nhân viên
    public Employee addEmployee(){
        EmployeeFullTime newEmployee = new EmployeeFullTime();
        newEmployee.setName(writeName());
        newEmployee.setAddress(writeAddress());
        newEmployee.setPhone(writePhone());
        newEmployee.setEmail(writeEmail());
        newEmployee.setAge(writeAge());
        newEmployee.setStatus(writeStatus());
        newEmployee.setSalary(writeSalary());
        newEmployee.setBonus(writeBonus());
        newEmployee.setPenalty(writePenalty());
        return newEmployee;
    }

    //Phương thức đặt thuộc tính của nhân viên
    public String writeName(){
        System.out.println("Enter name: ");
        return SCANNER.nextLine();
    }
    public String writeAddress(){
        System.out.println("Enter address: ");
        return SCANNER.nextLine();
    }
    public String writePhone(){
        System.out.println("Enter phone: ");
        return SCANNER.nextLine();
    }
    public String writeEmail(){
        System.out.println("Enter email: ");
        return SCANNER.nextLine();
    }
    public int writeAge(){
        System.out.println("Enter age: ");
        return SCANNER.nextInt();
    }
    public boolean writeStatus(){
        System.out.println("Select one: " + "\n" + "Number 1 = True." + "\n" + "Number 2 = False");
        switch (SCANNER.nextInt()){
            case 1:
                return true;
            case 2:
                return false;
            case 0:
                System.exit(0);
        }
        return true;
    }
    public double writeSalary(){
        System.out.println("Enter salary: ");
        double salary = SCANNER.nextDouble();
        if(salary == 0){
            salary = 8000000;
        }
        return salary;
    }
    public double writeBonus(){
        System.out.println("Enter bonus: ");
        return SCANNER.nextDouble();
    }
    public double writePenalty(){
        System.out.println("Enter penalty: ");
        return SCANNER.nextDouble();
    }
    public float writeTime(){
        System.out.println("Enter time: ");
        return SCANNER.nextFloat();
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    private final Scanner SCANNER = new Scanner(System.in);
    ArrayList<Employee> listEmployee;

    public Control(ArrayList<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    // Hiện thị nhâm viên  và nhân viên theo trang thái
    public void displayListEmployee(int num){
        for (Employee employee: listEmployee
             ) {
            if(employee.isStatus() && num == 1) System.out.println(employee);
            else if(!employee.isStatus() && num == 2) System.out.println(employee);
            else if (num == 3) {
                if(employee instanceof EmployeePartTime && employee instanceof EmployeeFullTime) System.out.println(employee);
            }
        }
    }
    // Tìm kiếm nhân viên:
    public void searchEmployee(){
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
    public void statusOfEmployee(){
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
        System.out.println("Select type employee: " + "\n" + "Number 1: Employee Full Time." + "\n" + "Number 2: Employee Part Time." );
        switch ( SCANNER.nextInt()){
            case 1:
                EmployeeFullTime newEmployeeFullTime = new EmployeeFullTime();
                String inputFullTime;
                boolean checkFullTime = true;
                boolean checkRegexFullTime;
                do {
                    inputFullTime = writeName();
                    checkRegexFullTime = regexName(inputFullTime);
                }while (!checkRegexFullTime);
                newEmployeeFullTime.setName(inputFullTime);
                do {
                    inputFullTime = writeAddress();
                    if(inputFullTime.equals("")) {
                        System.out.println("Not Empty --- Please enter: ");
                    }
                }while(inputFullTime.equals(""));
                newEmployeeFullTime.setAddress(inputFullTime);
                do {
                    inputFullTime = writePhone();
                    checkFullTime = checkInfo(inputFullTime, listEmployee);
                    if(!checkFullTime) System.out.println("Phone exist --- Please enter again: ");
                    checkRegexFullTime = regexPhone(inputFullTime);
                }while (checkFullTime && !checkRegexFullTime);
                newEmployeeFullTime.setPhone("+" + inputFullTime);
                do {
                    inputFullTime = writeEmail();
                    checkFullTime = checkInfo(inputFullTime, listEmployee);
                    if(!checkFullTime) System.out.println("Email exist --- Please enter again: ");
                    checkRegexFullTime = regexEmail(inputFullTime);
                }while (checkFullTime && !checkRegexFullTime);
                newEmployeeFullTime.setEmail(inputFullTime);
                do {
                    inputFullTime = writeCmnd();
                    checkFullTime = checkInfo(inputFullTime,listEmployee);
                    if(!checkFullTime) System.out.println("Cmnd exist --- Please enter again: ");
                    checkRegexFullTime = regexCmnd(inputFullTime);
                }while (checkFullTime && !checkRegexFullTime);
                newEmployeeFullTime.setCmnd(inputFullTime);
                newEmployeeFullTime.setAge(writeAge());
                newEmployeeFullTime.setStatus(writeStatus());
                newEmployeeFullTime.setSalary(writeSalary());
                newEmployeeFullTime.setBonus(writeBonus());
                newEmployeeFullTime.setPenalty(writePenalty());
                return newEmployeeFullTime;
            case 2:
                EmployeePartTime newEmployeePartTime = new EmployeePartTime();
                String inputPartTime;
                boolean checkPartTime;
                boolean checkRegexPartTime;
                do {
                    inputPartTime = writeName();
                    checkRegexPartTime = regexName(inputPartTime);
                }while (!checkRegexPartTime);
                newEmployeePartTime.setName(inputPartTime);
                do {
                    inputPartTime = writeAddress();
                    if(inputPartTime.equals("")) {
                        System.out.println("Not Empty --- Please enter: ");
                    }
                }while(inputPartTime.equals(""));
                newEmployeePartTime.setAddress(inputPartTime);
                do {
                    inputPartTime = writePhone();
                    checkPartTime = checkInfo(inputPartTime, listEmployee);
                    if(!checkPartTime) System.out.println("Phone exist --- Please enter again: ");
                    checkRegexPartTime = regexPhone(inputPartTime);
                }while (checkPartTime && !checkRegexPartTime);
                newEmployeePartTime.setPhone("+" + inputPartTime);
                do {
                    inputPartTime = writeEmail();
                    checkPartTime = checkInfo(inputPartTime, listEmployee);
                    if(!checkPartTime) System.out.println("Email exist --- Please enter again: ");
                    checkRegexPartTime = regexEmail(inputPartTime);
                }while (checkPartTime && !checkRegexPartTime);
                newEmployeePartTime.setEmail(inputPartTime);
                do {
                    inputPartTime = writeCmnd();
                    checkPartTime = checkInfo(inputPartTime,listEmployee);
                    if(!checkPartTime) System.out.println("Cmnd exist --- Please enter again: ");
                    checkRegexPartTime = regexCmnd(inputPartTime);
                }while (checkPartTime && !checkRegexPartTime);
                newEmployeePartTime.setCmnd(inputPartTime);
                newEmployeePartTime.setAge(writeAge());
                newEmployeePartTime.setStatus(writeStatus());
                newEmployeePartTime.setTime(writeTime());
                return newEmployeePartTime;
            default:
                System.exit(0);
                return null;
        }
    }


    //Phương thức đặt thuộc tính của nhân viên
    public String writeName(){
        Scanner name = new Scanner(System.in);
        System.out.println("Enter name: ");
        return name.nextLine();
    }
    public String writeAddress(){
        Scanner address = new Scanner(System.in);
        System.out.println("Enter address: ");
        return address.nextLine();
    }
    public String writePhone(){
        Scanner phone = new Scanner(System.in);
        System.out.println("Enter phone: ");
        System.out.println("Demo: //85-990-8989");
        return phone.nextLine();
    }
    public String writeEmail(){
        Scanner email = new Scanner( System.in);
        System.out.println("Enter email: ");
        System.out.println("Demo://employee@gmail.com ");
        return email.nextLine();
    }
    public String writeCmnd(){
        Scanner cmnd = new Scanner(System.in);
        System.out.println("Enter cmnd: ");
        return cmnd.nextLine();
    }
    public int writeAge(){
        Scanner age = new Scanner(System.in);
        System.out.println("Enter age: ");
        while(!age.hasNextInt())
        {
            age = new Scanner(System.in);
            System.out.println("Format age wrong --- Please enter agian: ");
            System.out.println("Enter age: ");
        }

        return age.nextInt();
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
    // Check dữ liệu đã tồn tại hay chưa
    public boolean checkInfo(String info, ArrayList<Employee> listEmployee) {
        Employee employee;
        employee = this.listEmployee.stream().filter(
                o -> info.equals(o.getPhone())).findFirst().orElse(null);
        if(employee == null) return true;
        else return false;
    }
    //Regex định dạng các trường dữ liệu đầu vào
    public boolean regexName (String name){
        String regexName = "^[a-zA-Z]+[\\-'\\s]*[a-zA-Z ]+$";
        if(name.matches(regexName)) return true;
        else {
            System.out.println("Format name wrong --- Please enter phone again: ");
            return false;
        }
    }
    public boolean regexPhone(String phone){
        String regexPhone  = "^\\d{2}-\\d{3}-\\d{4}$";
        if(phone.matches(regexPhone)) return true;
        else {
            System.out.println("Format phone wrong ---  Please enter phone a gain: ");
            return false;
        }
    }
    public boolean regexEmail(String email){
        String regexEmail =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if(email.matches(regexEmail)) return true;
        else {
            System.out.println("Format email wrong --- PLeasse enter email again: ");
            return false;
        }
    }
    public boolean regexCmnd(String cmnd){
        String regexCmnd  = "^\\d{9}$";
        if(cmnd.matches(regexCmnd)) return true;
        else {
            System.out.println("Format phone wrong ---  Please enter phone a gain: ");
            return false;
        }
    }
    // Cập nhật nhân viên
    public void updateEmployee(){
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check = false;
        do {
            System.out.println("Enter cmnd of employee update: ");
            cmnd = sc.nextLine();
            for (int i = 0; i < listEmployee.size(); i++) {
                if(listEmployee.get(i) instanceof EmployeeFullTime && listEmployee.get(i).getCmnd().equals(cmnd)){
                    System.out.println("Employee  Full Time " + listEmployee.get(i).getName() +" Update: ");
                    EmployeeFullTime employeeFullTime = new EmployeeFullTime();
                    String inputFullTime;
                    boolean checkFullTime = true;
                    boolean checkRegexFullTime;
                    do {
                        inputFullTime = writeName();
                        checkRegexFullTime = regexName(inputFullTime);
                    }while (!checkRegexFullTime);
                    employeeFullTime.setName(inputFullTime);
                    do {
                        inputFullTime = writeAddress();
                        if(inputFullTime.equals("")) {
                            System.out.println("Not Empty --- Please enter: ");
                        }
                    }while(inputFullTime.equals(""));
                    employeeFullTime.setAddress(inputFullTime);
                    do {
                        inputFullTime = writePhone();
                        checkFullTime = checkInfo(inputFullTime, listEmployee);
                        if(!checkFullTime) System.out.println("Phone exist --- Please enter again: ");
                        checkRegexFullTime = regexPhone(inputFullTime);
                    }while (checkFullTime && !checkRegexFullTime);
                    employeeFullTime.setPhone("+" + inputFullTime);
                    do {
                        inputFullTime = writeEmail();
                        checkFullTime = checkInfo(inputFullTime, listEmployee);
                        if(!checkFullTime) System.out.println("Email exist --- Please enter again: ");
                        checkRegexFullTime = regexEmail(inputFullTime);
                    }while (checkFullTime && !checkRegexFullTime);
                    employeeFullTime.setEmail(inputFullTime);
                    do {
                        inputFullTime = writeCmnd();
                        checkFullTime = checkInfo(inputFullTime,listEmployee);
                        if(!checkFullTime) System.out.println("Cmnd exist --- Please enter again: ");
                        checkRegexFullTime = regexCmnd(inputFullTime);
                    }while (checkFullTime && !checkRegexFullTime);
                    employeeFullTime.setCmnd(inputFullTime);
                    employeeFullTime.setAge(writeAge());
                    employeeFullTime.setStatus(writeStatus());
                    employeeFullTime.setSalary(writeSalary());
                    employeeFullTime.setBonus(writeBonus());
                    employeeFullTime.setPenalty(writePenalty());

                    listEmployee.set(i, employeeFullTime);
                }
                else if(listEmployee.get(i).getCmnd().equals(cmnd) && listEmployee.get(i) instanceof EmployeePartTime){
                    System.out.println("Employee  Part Time " + listEmployee.get(i).getName() +" Update: ");
                    EmployeePartTime updateEmployeePartTime = new EmployeePartTime();
                    String inputPartTime;
                    boolean checkPartTime;
                    boolean checkRegexPartTime;
                    do {
                        inputPartTime = writeName();
                        checkRegexPartTime = regexName(inputPartTime);
                    }while (!checkRegexPartTime);
                    updateEmployeePartTime.setName(inputPartTime);
                    do {
                        inputPartTime = writeAddress();
                        if(inputPartTime.equals("")) {
                            System.out.println("Not Empty --- Please enter: ");
                        }
                    }while(inputPartTime.equals(""));
                    updateEmployeePartTime.setAddress(inputPartTime);
                    do {
                        inputPartTime = writePhone();
                        checkPartTime = checkInfo(inputPartTime, listEmployee);
                        if(!checkPartTime) System.out.println("Phone exist --- Please enter again: ");
                        checkRegexPartTime = regexPhone(inputPartTime);
                    }while (checkPartTime && !checkRegexPartTime);
                    updateEmployeePartTime.setPhone("+" + inputPartTime);
                    do {
                        inputPartTime = writeEmail();
                        checkPartTime = checkInfo(inputPartTime, listEmployee);
                        if(!checkPartTime) System.out.println("Email exist --- Please enter again: ");
                        checkRegexPartTime = regexEmail(inputPartTime);
                    }while (checkPartTime && !checkRegexPartTime);
                    updateEmployeePartTime.setEmail(inputPartTime);
                    do {
                        inputPartTime = writeCmnd();
                        checkPartTime = checkInfo(inputPartTime,listEmployee);
                        if(!checkPartTime) System.out.println("Cmnd exist --- Please enter again: ");
                        checkRegexPartTime = regexCmnd(inputPartTime);
                    }while (checkPartTime && !checkRegexPartTime);
                    updateEmployeePartTime.setCmnd(inputPartTime);
                    updateEmployeePartTime.setAge(writeAge());
                    updateEmployeePartTime.setStatus(writeStatus());
                    updateEmployeePartTime.setTime(writeTime());

                    listEmployee.set(i,updateEmployeePartTime);
                }else check = true;
            }
        }while (check);
        System.out.println("Update complete..!");
    }
    // Xóa nhân viên
    public void deleteEmployee(ArrayList<Employee> listEmployee){
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check = false;
        do {
            System.out.println("Enter cmnd of Employee: ");
            cmnd = sc.nextLine();
            for (int i = 0; i < listEmployee.size(); i++) {
                if (listEmployee.get(i).getCmnd().equals(cmnd)) {
                    listEmployee.remove(i);
                    break;
                } else check = true;
            }
        } while (check);
    }
}

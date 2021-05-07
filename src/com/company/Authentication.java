package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    private ArrayList<Employee> listEmployee;

    public Authentication(ArrayList<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
    public  void privateLogin(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Employee employee;
        Employee employee1;
        int count = 0;
        boolean check = false;
        do {System.out.println("Please login..!");
            System.out.println("Username: ");
            String username = sc .nextLine();
            System.out.println("Password: ");
            String password = sc1.nextLine();
            String finalUsername = username;
            String finalPassword = password;
            employee = listEmployee.stream().filter(o -> finalUsername.equals(o.getUsername()) && finalPassword.equals(o.getPassword())).findFirst().orElse(null);
            if(employee != null) check = true;
            else count ++;
            if(count == 1) System.out.println("You wrong - You have 2 enters left");
            if(count == 2) System.out.println("You wrong - You have 1 enters left");
            if(count >2) break;
        }while (!check);
        if(count == 3){
            System.out.println("You entered incorrectly three times --- bye..! ");
            System.exit(0);
        }else {
            System.out.println("Welcome admin <3..!");
        }
        System.out.println("Complete");
    }
    public void updatePassword(){
//        Employee employee = new Employee();
//        Scanner sc = new Scanner(System.in);
//        do {
//            System.out.println("Enter Username: ");;
//            String finalName = sc.nextLine();
//            employee = listEmployee.stream().filter(o -> finalName.equals(o.getUsername())).findFirst().orElse(null);
//            if(employee == null) System.out.println("Username Not Found ");
//            if(employee !=null){
//                Scanner sc1 = new Scanner(System.in);
//                do {
//                    System.out.println("Enter Old Password: ");
//                    String finalPassword = sc1.nextLine();
//                    employee =  listEmployee.stream().filter(o -> finalPassword.equals(o.getPassword())).findFirst().orElse(null);
//                    if(employee != null){
//                        Scanner sc2 = new Scanner(System.in);
//                        System.out.println("Enter New Password: ");
//                        String newPassword = sc2.nextLine();
//                        employee.setPassword(newPassword);
//                    }else System.out.println("Old Password wrong..!");
//                }while (employee == null);
//            }
//        }while (employee == null);
        String name;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.println("Enter Username: ");
            name = sc.nextLine();
            for (int i = 0; i < listEmployee.size(); i++) {
                if(name.equals(listEmployee.get(i).getUsername())){
                    check = true;
                    Scanner sc1 = new Scanner(System.in);
                    String oldPassword;
                    do {
                        System.out.println("Enter old password: ");
                        oldPassword = sc1.nextLine();
                        if(!oldPassword.equals(listEmployee.get(i).getPassword())) System.out.println("Old password wrong --- Please enter again: ");;
                    }while (!oldPassword.equals(listEmployee.get(i).getPassword()));
                    if(oldPassword.equals(listEmployee.get(i).getPassword())){
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Enter new password: ");
                        String newPassword = sc2.nextLine();
                        listEmployee.get(i).setPassword(newPassword);
                        System.out.println("Change password complete..! ");
                    }
                }
            }
            if(check == true) break;
            System.out.println("Name not Found --- Please enter again: ");
            check = false;
        }while (!check);
    }
}
package com.company;

public class EmployeePartTime extends Employee implements CalculateSalary {
    private float time;
    private final double PRICE_TIME = 120000;

    public EmployeePartTime(float time) {
        this.time = time;
    }

    public EmployeePartTime(String name, String address, String phone, String email, int age, boolean status, float time) {
        super(name, address, phone, email, age, status);
        this.time = time;
    }

    @Override
    public double calculateSalary() {
        return time*PRICE_TIME;
    }

    @Override
    public String toString() {
        return "EmployeePartTime : " +
                "Name: " +
                "time=" + time +
                ", PRICE_TIME=" + PRICE_TIME +
                '}';
    }
}

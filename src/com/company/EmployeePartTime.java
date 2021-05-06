package com.company;

public class EmployeePartTime extends Employee implements CalculateSalary {
    private float time;
    private final double PRICE_TIME = 120000;

    public EmployeePartTime(float time) {
        this.time = time;
    }

    public EmployeePartTime(String name, String address, String phone, String email, String cmnd, int age, boolean status, float time) {
        super(name, address, phone, email, cmnd, age, status);
        this.time = time;
    }

    public EmployeePartTime() {
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public double getPRICE_TIME() {
        return PRICE_TIME;
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

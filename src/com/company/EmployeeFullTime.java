package com.company;

public class EmployeeFullTime extends Employee implements CalculateSalary {
    private double salary;
    private double bonus;
    private double penalty;

    public EmployeeFullTime(String name, String address, String phone, String email, int age, boolean status, double salary, double bonus, double penalty) {
        super(name, address, phone, email, age, status);
        this.salary = salary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public EmployeeFullTime() {
    }

    @Override
    public double calculateSalary() {
        return salary+bonus-penalty;
    }

    @Override
    public String toString() {
        return super.toString() + "EmployeeFullTime :" +
                "salary=" + salary +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                "}";
    }
}

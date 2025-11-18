package com.scu.prvms;

public class Employee extends Person {
    private String employeeId;
    private String role;

    public Employee() {
        super(); // 调用父类的默认构造函数
    }

    public Employee(String name, int age, String id, String employeeId, String role) {
        super(name, age, id); // 调用父类的参数化构造函数
        this.employeeId = employeeId;
        this.role = role;
    }

    // Getters 和 Setters for employeeId and role...

    @Override
    public String toString() {
        return "Employee{" + "person=" + super.toString() + ", employeeId='" + employeeId + '\'' + ", role='" + role + '\'' + '}';
    }
}
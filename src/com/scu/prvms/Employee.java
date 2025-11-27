package com.scu.prvms;

/**
 * PROG2004 Assessment 2 - Employee (Concrete Subclass)
 * 这个类代表主题公园的员工。
 * 它继承自 Person 类，并添加了员工特有的属性，例如员工ID和角色。
 */
public class Employee extends Person {

    // --- 实例变量 (Instance Variables) ---
    // 这是 Employee 类独有的属性。

    //员工的唯一工号。
    private String employeeId;

    //员工在公园中的角色
    private String role;


    // --- 构造函数 (Constructors) ---

    /**
     * 默认构造函数 (无参构造函数)。
     * 创建一个具有默认值的 Employee 对象。
     */
    public Employee() {
        // Java 会自动隐式调用 super(); 来执行父类 Person 的默认构造函数。
        super();
    }

    /**
     * 参数化构造函数。
     * 用于在创建 Employee 对象时初始化所有属性，包括从 Person 继承的属性。
     */
    public Employee(String name, int age, String id, String employeeId, String role) {
        // 使用 super() 调用父类 Person 的构造函数，来初始化 name, age, 和 id。
        // 这必须是构造函数中的第一行代码。
        super(name, age, id);

        // 初始化 Employee 类自己的属性。
        this.employeeId = employeeId;
        this.role = role;
    }


    // --- Getters 和 Setters ---
    // 为 Employee 类的特有属性提供公共的访问和修改方法。

    //获取员工的工号。
    public String getEmployeeId() {
        return employeeId;
    }

    //设置员工的工号。
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    //获取员工的角色。
    public String getRole() {
        return role;
    }

    //设置员工的角色。
    public void setRole(String role) {
        this.role = role;
    }


    // --- 辅助方法 (Utility Methods) ---

    //覆盖 Person 类的 toString 方法，以包含 Employee 的特定信息。
    @Override
    public String toString() {
        return "Employee{" +
                "personDetails=" + super.toString() + ", " + // 调用父类的 toString() 获取通用信息
                "employeeId='" + employeeId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
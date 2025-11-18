package com.scu.prvms;

// 在第二部分，我们会把它变成 abstract
public abstract class Person {
    private String name;
    private int age;
    private String id;

    // 默认构造函数
    public Person() {}

    // 参数化构造函数
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Getters 和 Setters
    // IDEA 快捷方式：Alt + Insert (或右键 -> Generate...) -> Getter and Setter -> 全选
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // 覆盖 toString() 方法，方便打印信息
    // IDEA 快捷方式：Alt + Insert -> toString() -> 全选
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", id='" + id + '\'' + '}';
    }
}
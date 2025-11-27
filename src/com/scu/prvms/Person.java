package com.scu.prvms;

/**
 * 这是一个抽象基类，用于定义主题公园中所有“人”的通用属性和行为。
 * 它作为 Employee 和 Visitor 类的父类，实现了代码的复用和分层设计。
 */
public abstract class Person {

    // 使用 private 访问修饰符来封装数据，只能通过 public 的 getters/setters 访问。
     //人的姓名。
    private String name;


     // 人的年龄。
    private int age;

    //人的身份证号。
    private String id;


    // --- 构造函数 (Constructors) ---

    /**
     * 默认构造函数 (无参构造函数)。
     * 当子类创建一个没有参数的对象时，这个构造函数会被隐式调用。
     */
    public Person() {
        // 初始化为默认值 (Java 会自动将 String 设为 null, int 设为 0)
        this.name = "Unknown";
        this.age = 0;
        this.id = "N/A";
    }

    /**
     * 参数化构造函数。
     * 用于在创建对象时直接初始化所有属性。
     * 子类 (Employee, Visitor) 将通过 super() 关键字来调用这个构造函数。
     *
     * @param name 要设置的姓名。
     * @param age  要设置的年龄。
     * @param id   要设置的身份标识。
     */
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    // --- Getters 和 Setters ---
    // 提供公共的访问方法，允许外部代码安全地读取和修改对象的私有属性。

    //获取此人的姓名。
    public String getName() {
        return name;
    }

    //设置此人的姓名。
    public void setName(String name) {
        this.name = name;
    }

    //获取此人的年龄。
    public int getAge() {
        return age;
    }


     //设置此人的年龄。
    public void setAge(int age) {
        this.age = age;
    }


     //获取此人的身份标识。
    public String getId() {
        return id;
    }

     //设置此人的身份标识。
    public void setId(String id) {
        this.id = id;
    }


    //辅助方法 (Utility Methods)

    /**
     * 覆盖 Object 类的 toString 方法，提供一个有意义的字符串表示形式。
     * 这在打印对象或进行调试时非常有用。
     * 子类可以进一步覆盖此方法，以包含它们自己的特定信息。
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}
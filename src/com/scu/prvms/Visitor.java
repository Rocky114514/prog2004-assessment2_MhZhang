package com.scu.prvms;

/**
 * 这个类代表主题公园的游客。
 * 它继承自 Person 类，并添加了游客特有的属性，例如票务ID和通行证类型。
 * Visitor 对象是系统中被管理的核心实体，它们会进入等待队列、被添加到游玩历史记录中。
 */
public class Visitor extends Person {

    // --- 实例变量 (Instance Variables) ---
    // 这是 Visitor 类独有的属性。

    //游客所持门票的唯一标识符。
    private String ticketId;

    //游客购买的通行证类型
    private String passType;


    // 构造函数 (Constructors)

    //创建一个具有默认值的 Visitor 对象。
    public Visitor() {
        // 隐式调用 super() 来执行父类 Person 的默认构造函数。
        super();
    }

    //参数化构造函数。
    public Visitor(String name, int age, String id, String ticketId, String passType) {
        // 使用 super() 调用父类 Person 的构造函数，来初始化 name, age, 和 id。
        // 这必须是构造函数中的第一行代码。
        super(name, age, id);

        // 初始化 Visitor 类自己的属性。
        this.ticketId = ticketId;
        this.passType = passType;
    }


    // Getters 和 Setters
    // 为 Visitor 类的特有属性提供公共的访问和修改方法。

    //获取游客的票务ID。
    public String getTicketId() {
        return ticketId;
    }

    //设置游客的票务ID。
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    // 获取游客的通行证类型。
    public String getPassType() {
        return passType;
    }

    //设置游客的通行证类型。
    public void setPassType(String passType) {
        this.passType = passType;
    }


    // --- 辅助方法 (Utility Methods) ---

    //覆盖 Person 类的 toString 方法，以包含 Visitor 的特定信息
    public String toString() {
        return "Visitor{" +
                "personDetails=" + super.toString() + ", " + // 调用父类的 toString() 获取通用信息
                "ticketId='" + ticketId + '\'' +
                ", passType='" + passType + '\'' +
                '}';
    }
}
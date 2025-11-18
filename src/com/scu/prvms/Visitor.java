package com.scu.prvms;

public class Visitor extends Person {
    private String ticketId;
    private String passType;

    // 默认构造函数
    public Visitor() {
        super();
    }

    // 参数化构造函数
    public Visitor(String name, int age, String id, String ticketId, String passType) {
        super(name, age, id); // 协调点：调用Person的构造函数
        this.ticketId = ticketId;
        this.passType = passType;
    }

    // Getters 和 Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public String getPassType() { return passType; }
    public void setPassType(String passType) { this.passType = passType; }
}
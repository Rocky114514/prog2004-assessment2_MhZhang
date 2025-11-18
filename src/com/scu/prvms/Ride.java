package com.scu.prvms;

public class Ride implements RideInterface {
    private String rideName;
    private Employee rideOperator; // 关键变量
    private boolean isOpen;

    // 构造函数、Getters/Setters...

    // 特别为 rideOperator 提供 getter 和 setter
    public Employee getRideOperator() { return rideOperator; }
    public void assignOperator(Employee operator) {
        this.rideOperator = operator;
        this.isOpen = (operator != null); // 如果有操作员，就认为是开放的
        System.out.println(operator.getName() + " is now operating " + this.rideName);
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {

    }

    @Override
    public void removeVisitorFromQueue() {

    }

    @Override
    public void printQueue() {

    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {

    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return 0;
    }

    @Override
    public void printRideHistory() {

    }

    @Override
    public void runOneCycle() {

    }
}
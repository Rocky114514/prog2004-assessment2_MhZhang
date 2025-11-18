package com.scu.prvms;

import java.util.*;

public class Ride implements RideInterface {

    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private Queue<Visitor> waitingLine;
    private List<Visitor> rideHistory;

    // --- Part 5: 新增的实例变量 ---
    private int maxRider;       // 每轮最大载客量
    private int numOfCycles;    // 已运行的总轮数
    // ---

    // --- Part 5: 修改了构造函数以接收 maxRider ---
    public Ride(String rideName, String rideType, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = null;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();

        // 初始化 Part 5 的新变量
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }
    // ---

    // Part 4B 的排序方法 (保持不变)
    public void sortRideHistory() {
        if (rideHistory == null || rideHistory.isEmpty()) {
            System.out.println("Ride history is empty, nothing to sort.");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("SUCCESS: Ride history has been sorted by age, then by name.");
    }

    // Getters 和 Setters (保持不变)
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public Employee getRideOperator() { return rideOperator; }
    public void assignOperator(Employee operator) { this.rideOperator = operator; }


    // --- Part 5: 实现 runOneCycle 方法 ---

    @Override
    public void runOneCycle() {
        System.out.println("\nAttempting to run a cycle for '" + this.getRideName() + "'...");

        // 1. 前置检查 (健壮性)
        if (this.rideOperator == null) {
            System.out.println("FAILURE: Cannot run cycle. No operator is assigned to the ride!");
            return;
        }
        if (this.waitingLine.isEmpty()) {
            System.out.println("FAILURE: Cannot run cycle. The waiting line is empty.");
            return;
        }

        // 2. 核心逻辑：计算本轮可乘坐的游客数量
        int ridersThisCycle = Math.min(this.maxRider, this.waitingLine.size());
        System.out.println("INFO: Cycle is starting! Moving " + ridersThisCycle + " visitors from the queue to the ride.");

        // 3. 移动游客：从队列移除，添加到历史记录
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = waitingLine.poll(); // 从队首移除
            if (visitor != null) {
                this.addVisitorToHistory(visitor); // 添加到历史 (这个方法会打印自己的消息)
            }
        }

        // 4. 更新运行轮数
        this.numOfCycles++;
        System.out.println("SUCCESS: Cycle finished. Total cycles run for this ride: " + this.numOfCycles);
    }
    // ---


    // --- Part 3 & 4A 的已实现方法 (保持不变) ---
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.add(visitor);
        System.out.println("SUCCESS: " + visitor.getName() + " has joined the queue for " + this.getRideName() + ".");
    }
    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) { System.out.println("FAILURE: The queue is empty."); return; }
        Visitor removedVisitor = waitingLine.poll();
        System.out.println("SUCCESS: " + removedVisitor.getName() + " has been removed from the queue.");
    }
    @Override
    public void printQueue() {
        System.out.println("\n--- Queue for '" + this.getRideName() + "' ---");
        if (waitingLine.isEmpty()) { System.out.println("The queue is empty."); }
        else { int pos = 1; for (Visitor v : waitingLine) { System.out.println(pos++ + ". " + v.getName()); } }
        System.out.println("---------------------------\n");
    }
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("INFO: " + visitor.getName() + " was added to the ride history.");
    }
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    @Override
    public void printRideHistory() {
        System.out.println("\n--- Ride History for '" + this.getRideName() + "' ---");
        if (rideHistory.isEmpty()) { System.out.println("The history is empty."); }
        else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println("- Name: " + v.getName() + ", Age: " + v.getAge());
            }
        }
        System.out.println("----------------------------------\n");
    }
}
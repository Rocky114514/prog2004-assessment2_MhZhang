package com.scu.prvms;

import java.util.*; // 使用通配符导入，包含了Queue, List, LinkedList, Iterator, Collections

public class Ride implements RideInterface {

    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private Queue<Visitor> waitingLine;
    private List<Visitor> rideHistory; // Part 4A 的内容

    public Ride(String rideName, String rideType) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = null;
        this.waitingLine = new LinkedList<>(); // Part 3 的内容
        this.rideHistory = new LinkedList<>(); // Part 4A 的内容
    }

    // --- Part 4B: 新增的排序方法 ---
    /**
     * 对 rideHistory 列表使用 VisitorComparator进行排序。
     */
    public void sortRideHistory() {
        if (rideHistory == null || rideHistory.isEmpty()) {
            System.out.println("Ride history is empty, nothing to sort.");
            return;
        }
        // 使用 Collections.sort() 和我们自定义的 Comparator
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("SUCCESS: Ride history has been sorted by age, then by name.");
    }
    // ---

    // Getters 和 Setters ...
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public Employee getRideOperator() { return rideOperator; }
    public void assignOperator(Employee operator) { this.rideOperator = operator; }


    // --- Part 3 的已实现方法 ---
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
        if (waitingLine.isEmpty()) { System.out.println("Empty."); }
        else { int pos = 1; for (Visitor v : waitingLine) { System.out.println(pos++ + ". " + v.getName()); } }
        System.out.println("---------------------------\n");
    }

    // --- Part 4A 的已实现方法 ---
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
        if (rideHistory.isEmpty()) { System.out.println("Empty."); }
        else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println("- " + v.getName() + " (Age: " + v.getAge() + ")");
            }
        }
        System.out.println("----------------------------------\n");
    }

    // --- 待实现的方法 ---
    @Override
    public void runOneCycle() {
        // Part 5 中实现
    }
}
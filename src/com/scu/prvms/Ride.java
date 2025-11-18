package com.scu.prvms;

// --- 新增的导入 ---
import java.util.Queue;
import java.util.LinkedList;
// ---

public class Ride implements RideInterface {

    private String rideName;
    private String rideType;
    private Employee rideOperator;

    // --- 新增的实例变量 ---
    private Queue<Visitor> waitingLine;
    // ---

    // 默认构造函数
    public Ride() {
        // --- 在构造函数中进行初始化 ---
        this.waitingLine = new LinkedList<>();
    }

    // 参数化构造函数
    public Ride(String rideName, String rideType) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = null;
        // --- 在构造函数中进行初始化 ---
        this.waitingLine = new LinkedList<>();
    }

    // --- Getters 和 Setters (保持不变) ---
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getRideOperator() { return rideOperator; }
    public void assignOperator(Employee operator) { this.rideOperator = operator; }


    // --- 第三部分：实现的三个核心方法 ---

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.add(visitor); // 使用add方法将游客添加到队尾
        System.out.println("SUCCESS: " + visitor.getName() + " has joined the queue for " + this.getRideName() + ".");
    }

    @Override
    public void removeVisitorFromQueue() {
        // 先检查队列是否为空，这是健壮的代码
        if (waitingLine.isEmpty()) {
            System.out.println("FAILURE: The queue is empty. No visitor to remove.");
            return;
        }
        // poll方法会移除并返回队首的元素，如果队列为空则返回null
        Visitor removedVisitor = waitingLine.poll();
        System.out.println("SUCCESS: " + removedVisitor.getName() + " has been removed from the queue.");
    }

    @Override
    public void printQueue() {
        System.out.println("\n--- Current Waiting Line for '" + this.getRideName() + "' ---");
        if (waitingLine.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            int position = 1;
            // 使用增强for循环遍历队列并打印
            for (Visitor visitor : waitingLine) {
                System.out.println(position + ". " + visitor.getName() + " (Ticket: " + visitor.getTicketId() + ")");
                position++;
            }
        }
        System.out.println("-------------------------------------------------\n");
    }

    // --- 其他来自接口的方法暂时还是空的 ---

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Part 4 中实现
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Part 4 中实现
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // Part 4 中实现
        return 0;
    }

    @Override
    public void printRideHistory() {
        // Part 4 中实现
    }

    @Override
    public void runOneCycle() {
        // Part 5 中实现
    }
}
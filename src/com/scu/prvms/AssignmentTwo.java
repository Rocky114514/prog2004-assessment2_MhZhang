package com.scu.prvms;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // assignment.partThree();
        // assignment.partFourA();
        // assignment.partFourB();

        // --- 调用partFive()来运行本次的演示 ---
        assignment.partFive();
    }

    public void partThree() {
        // Part 3 的演示代码... (为简洁省略)
    }

    public void partFourA() {
        // Part 4A 的演示代码... (为简洁省略)
    }

    public void partFourB() {
        // Part 4B 的演示代码... (为简洁省略)
    }

    // --- Part 5：在partFive()中编写演示代码 ---
    public void partFive() {
        System.out.println("--- Executing Part 5: Run a Ride Cycle Demonstration ---");

        // 1. 创建一个 Ride 对象，设置每轮最大载客量为 4
        Ride hauntedMansion = new Ride("Haunted Mansion", "Dark Ride", 4);
        System.out.println("Created a new ride: '" + hauntedMansion.getRideName() + "' with a capacity of 4 riders per cycle.");

        // 2. 必须为游乐设施分配一个操作员
        Employee operator = new Employee("Henry", 40, "E101", "EMP101", "Ride Operator");
        hauntedMansion.assignOperator(operator);
        System.out.println("Assigned operator '" + operator.getName() + "' to the ride.");

        // 3. 添加超过一轮容量的游客到队列中 (例如，添加10名)
        System.out.println("\nAdding 10 visitors to the queue...");
        for (int i = 1; i <= 10; i++) {
            hauntedMansion.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "ID_V" + i, "T_V" + i, "Day Pass"));
        }

        // 4. 打印运行前的状态
        System.out.println("\n--- STATUS BEFORE RUNNING CYCLE ---");
        hauntedMansion.printQueue();
        hauntedMansion.printRideHistory();

        // 5. 运行一轮
        hauntedMansion.runOneCycle();

        // 6. 打印运行后的状态，以验证变化
        System.out.println("\n--- STATUS AFTER RUNNING CYCLE ---");
        System.out.println("Queue should now have 6 visitors (10 - 4).");
        hauntedMansion.printQueue();
        System.out.println("Ride history should now have 4 visitors.");
        hauntedMansion.printRideHistory();

        System.out.println("\n--- Part 5 Demonstration Finished ---");
    }
    // ---

    public void partSix() {}
    public void partSeven() {}
}
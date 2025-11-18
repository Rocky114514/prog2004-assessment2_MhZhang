package com.scu.prvms;

public class AssignmentTwo {

    public static void main(String[] args) {
        // 创建AssignmentTwo的实例以调用非静态方法
        AssignmentTwo assignment = new AssignmentTwo();

        // --- 调用partThree()来运行第三部分的演示 ---
        assignment.partThree();
    }

    // --- 第三部分：在partThree()中编写演示代码 ---
    public void partThree() {
        System.out.println("--- Executing Part 3: Waiting Line Demonstration ---");

        // 1. 创建一个新的 Ride 对象
        Ride rollerCoaster = new Ride("Dragon's Fury", "Roller Coaster");
        System.out.println("Created a new ride: " + rollerCoaster.getRideName());

        // 2. 创建至少5个 Visitor 对象
        Visitor visitor1 = new Visitor("Alice", 30, "ID001", "T01", "Day Pass");
        Visitor visitor2 = new Visitor("Bob", 25, "ID002", "T02", "Day Pass");
        Visitor visitor3 = new Visitor("Charlie", 45, "ID003", "T03", "Annual Pass");
        Visitor visitor4 = new Visitor("Diana", 19, "ID004", "T04", "Day Pass");
        Visitor visitor5 = new Visitor("Edward", 50, "ID005", "T05", "VIP Pass");

        // 3. 使用创建的方法，将他们添加到队列
        System.out.println("\n--- Adding visitors to the queue... ---");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 打印一下当前的队列，看看是否都加进去了
        rollerCoaster.printQueue();

        // 4. 从队列中移除一个游客 (移除的是队首的 Alice)
        System.out.println("\n--- Removing one visitor from the front of the queue... ---");
        rollerCoaster.removeVisitorFromQueue();

        // 5. 再次打印队列，验证移除操作
        System.out.println("\n--- Final queue status: ---");
        rollerCoaster.printQueue();

        System.out.println("\n--- Part 3 Demonstration Finished ---");
    }
    // ---

    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}
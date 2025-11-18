package com.scu.prvms;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // assignment.partThree();
        // assignment.partFourA();
        // --- 调用partFourB()来运行本次的演示 ---
        assignment.partFourB();
    }

    // Part 3 的演示代码 (已完成)
    public void partThree() { /* ... */ }

    // Part 4A 的演示代码 (已完成)
    public void partFourA() { /* ... */ }

    // --- Part 4B：在partFourB()中编写演示代码 ---
    public void partFourB() {
        System.out.println("--- Executing Part 4B: Sorting Ride History Demonstration ---");

        // 1. 创建一个 Ride 对象
        Ride pirateShip = new Ride("The Galleon", "Swing Ride");

        // 2. 添加一些乱序的游客到历史记录中
        // 注意：Zane 和 Alex 年龄相同，用于测试次要排序规则（按姓名）
        pirateShip.addVisitorToHistory(new Visitor("Zane", 22, "ID010", "T10", "Day Pass"));
        pirateShip.addVisitorToHistory(new Visitor("Yara", 35, "ID009", "T09", "Day Pass"));
        pirateShip.addVisitorToHistory(new Visitor("Alex", 22, "ID008", "T08", "Day Pass"));
        pirateShip.addVisitorToHistory(new Visitor("Bob", 19, "ID011", "T11", "Day Pass"));

        // 3. 打印排序前的列表
        System.out.println("\n--- Unsorted Ride History: ---");
        pirateShip.printRideHistory();

        // 4. 调用新的排序方法
        pirateShip.sortRideHistory();

        // 5. 再次打印列表，以验证排序结果
        // 预期顺序: Bob(19), Alex(22), Zane(22), Yara(35)
        System.out.println("\n--- Sorted Ride History: ---");
        pirateShip.printRideHistory();

        System.out.println("\n--- Part 4B Demonstration Finished ---");
    }
    // ---

    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}
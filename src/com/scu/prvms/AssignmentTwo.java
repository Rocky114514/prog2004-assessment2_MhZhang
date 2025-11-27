package com.scu.prvms;

/**
 * 这个类是整个项目的主入口和演示驱动程序。
 * 它包含了对作业各个部分功能的测试和演示方法。
 */
public class AssignmentTwo {

    /**
     * main 方法是程序的起点。
     * 它创建 AssignmentTwo 的一个实例，并按顺序调用所有部分的演示方法，
     * 以便在一次运行中完整地展示项目的所有功能。
     */
    public static void main(String[] args) {
        // 创建AssignmentTwo的实例以调用非静态的演示方法
        AssignmentTwo assignment = new AssignmentTwo();

        // 为了在控制台输出中清晰地区分各个部分的演示，我们添加了标题。
        System.out.println("==================== PART 3 DEMO: WAITING LINE (QUEUE) ====================");
        assignment.partThree();

        System.out.println("\n\n==================== PART 4A DEMO: RIDE HISTORY (LINKEDLIST) ====================");
        assignment.partFourA();

        System.out.println("\n\n==================== PART 4B DEMO: SORTING HISTORY (COMPARATOR) ====================");
        assignment.partFourB();

        System.out.println("\n\n==================== PART 5 DEMO: RUN A RIDE CYCLE ====================");
        assignment.partFive();

        System.out.println("\n\n==================== PART 6 & 7 DEMO: FILE I/O ====================");
        assignment.partSix();    // 先执行写入文件
        assignment.partSeven();  // 再执行读取文件

        System.out.println("\n\n==================== ALL DEMONSTRATIONS FINISHED ====================");
    }

    /**
     * Part 3: 演示等待队列 (Queue) 的功能。
     * - 创建 Ride 和多个 Visitor 对象。
     * - 将游客添加到等待队列。
     * - 从队列中移除一个游客。
     * - 打印队列状态以验证操作。
     */
    public void partThree() {
        Ride rollerCoaster = new Ride("Dragon's Fury", "Roller Coaster", 5); // maxRider 设为5
        System.out.println("Created a new ride: " + rollerCoaster.getRideName());

        System.out.println("\n--- Adding 5 visitors to the queue... ---");
        rollerCoaster.addVisitorToQueue(new Visitor("Alice", 30, "ID001", "T01", "Day Pass"));
        rollerCoaster.addVisitorToQueue(new Visitor("Bob", 25, "ID002", "T02", "Day Pass"));
        rollerCoaster.addVisitorToQueue(new Visitor("Charlie", 45, "ID003", "T03", "Annual Pass"));
        rollerCoaster.addVisitorToQueue(new Visitor("Diana", 19, "ID004", "T04", "Day Pass"));
        rollerCoaster.addVisitorToQueue(new Visitor("Edward", 50, "ID005", "T05", "VIP Pass"));
        rollerCoaster.printQueue();

        System.out.println("\n--- Removing one visitor from the front of the queue... ---");
        rollerCoaster.removeVisitorFromQueue();
        System.out.println("\n--- Final queue status: ---");
        rollerCoaster.printQueue();
    }

    /**
     * Part 4A: 演示游玩历史记录 (LinkedList) 的功能。
     * - 创建 Ride 和多个 Visitor 对象。
     * - 将游客添加到历史记录。
     * - 检查历史记录中的游客数量和特定游客是否存在。
     * - 使用 Iterator 打印整个历史记录。
     */
    public void partFourA() {
        Ride waterSlide = new Ride("Aqua Loop", "Water Slide", 8);
        Visitor v1 = new Visitor("Frank", 33, "ID006", "T06", "Day Pass");
        Visitor v2 = new Visitor("Grace", 28, "ID007", "T07", "Day Pass");

        System.out.println("\nAdding visitors to history...");
        waterSlide.addVisitorToHistory(v1);
        waterSlide.addVisitorToHistory(v2);

        System.out.println("\nChecking history status...");
        System.out.println("Total visitors in history: " + waterSlide.numberOfVisitors());
        System.out.println("Is Frank in history? " + waterSlide.checkVisitorFromHistory(v1));

        System.out.println("\nPrinting history using an iterator...");
        waterSlide.printRideHistory();
    }

    /**
     * Part 4B: 演示使用 Comparator 对历史记录进行排序。
     * - 创建一个包含乱序游客的历史记录。
     * - 打印排序前的列表。
     * - 调用排序方法。
     * - 打印排序后的列表以验证结果。
     */
    public void partFourB() {
        Ride pirateShip = new Ride("The Galleon", "Swing Ride", 20);
        pirateShip.addVisitorToHistory(new Visitor("Zane", 22, "ID010", "T10", "Day Pass"));
        pirateShip.addVisitorToHistory(new Visitor("Yara", 35, "ID009", "T09", "Day Pass"));
        pirateShip.addVisitorToHistory(new Visitor("Alex", 22, "ID008", "T08", "Day Pass"));
        pirateShip.addVisitorToHistory(new Visitor("Bob", 19, "ID011", "T11", "Day Pass"));

        System.out.println("\n--- Unsorted Ride History: ---");
        pirateShip.printRideHistory();

        pirateShip.sortRideHistory();

        System.out.println("\n--- Sorted Ride History (by age, then name): ---");
        pirateShip.printRideHistory();
    }

    /**
     * Part 5: 演示运行一轮游乐设施 (runOneCycle)。
     * - 创建 Ride 并为其分配一个 Employee 操作员。
     * - 向队列中添加超过一轮容量的游客。
     * - 打印运行前队列和历史记录的状态。
     * - 调用 runOneCycle 方法。
     * - 打印运行后队列和历史记录的状态，以展示游客的流动。
     */
    public void partFive() {
        Ride hauntedMansion = new Ride("Haunted Mansion", "Dark Ride", 4);
        System.out.println("Created a new ride: '" + hauntedMansion.getRideName() + "' with a capacity of 4 riders per cycle.");

        Employee operator = new Employee("Henry", 40, "E101", "EMP101", "Ride Operator");
        hauntedMansion.assignOperator(operator);
        System.out.println("Assigned operator '" + operator.getName() + "' to the ride.");

        System.out.println("\nAdding 10 visitors to the queue...");
        for (int i = 1; i <= 10; i++) {
            hauntedMansion.addVisitorToQueue(new Visitor("CycleVisitor" + i, 20 + i, "ID_C" + i, "T_C" + i, "Day Pass"));
        }

        System.out.println("\n--- STATUS BEFORE RUNNING CYCLE ---");
        hauntedMansion.printQueue();
        hauntedMansion.printRideHistory();

        hauntedMansion.runOneCycle();

        System.out.println("\n--- STATUS AFTER RUNNING CYCLE ---");
        hauntedMansion.printQueue();
        hauntedMansion.printRideHistory();
    }

    /**
     * Part 6: 演示将游玩历史写入文件 (exportRideHistory)。
     * - 创建一个包含数据的 Ride 对象。
     * - 将其历史记录导出到 "ride_history.csv" 文件。
     */
    public void partSix() {
        Ride exportRide = new Ride("Data Exporter", "Utility Ride", 10);
        System.out.println("\nAdding 5 visitors to a new ride's history for export...");
        exportRide.addVisitorToHistory(new Visitor("Kevin", 41, "ID11", "T11", "Annual Pass"));
        exportRide.addVisitorToHistory(new Visitor("Laura", 36, "ID12", "T12", "Day Pass"));
        exportRide.addVisitorToHistory(new Visitor("Mike", 25, "ID13", "T13", "Day Pass"));
        exportRide.addVisitorToHistory(new Visitor("Nancy", 52, "ID14", "T14", "VIP Pass"));
        exportRide.addVisitorToHistory(new Visitor("Oscar", 22, "ID15", "T15", "Day Pass"));

        System.out.println("\n--- Current Ride History (to be exported): ---");
        exportRide.printRideHistory();

        exportRide.exportRideHistory("ride_history.csv");
    }

    /**
     * Part 7: 演示从文件中读取游玩历史 (importRideHistory)。
     * - 创建一个全新的、历史记录为空的 Ride 对象。
     * - 从 "ride_history.csv" 文件中导入数据。
     * - 打印导入后的历史记录以验证数据已成功加载。
     */
    public void partSeven() {
        Ride importRide = new Ride("Data Importer", "Utility Ride", 10);

        System.out.println("\n--- Ride History BEFORE import: ---");
        importRide.printRideHistory();
        System.out.println("Number of visitors in history before import: " + importRide.numberOfVisitors());

        importRide.importRideHistory("ride_history.csv");

        System.out.println("\n--- Ride History AFTER import: ---");
        importRide.printRideHistory();
        System.out.println("Number of visitors in history after import: " + importRide.numberOfVisitors());
    }
}
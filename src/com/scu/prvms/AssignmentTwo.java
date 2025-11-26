package com.scu.prvms;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // assignment.partThree();
        // assignment.partFourA();
        // assignment.partFourB();
        // assignment.partFive();

        assignment.partSix();
        assignment.partSeven();
    }


    public void partThree() { /* ... */ }
    public void partFourA() { /* ... */ }
    public void partFourB() { /* ... */ }
    public void partFive() { /* ... */ }

    // --- 在partSix()中编写演示代码 ---
    public void partSix() {
        System.out.println("--- Executing Part 6: Writing Ride History to a File ---");

        Ride exportRide = new Ride("Data Exporter", "Utility Ride", 10);
        System.out.println("\nAdding 5 visitors to the ride history...");
        exportRide.addVisitorToHistory(new Visitor("Kevin", 41, "ID11", "T11", "Annual Pass"));
        exportRide.addVisitorToHistory(new Visitor("Laura", 36, "ID12", "T12", "Day Pass"));
        exportRide.addVisitorToHistory(new Visitor("Mike", 25, "ID13", "T13", "Day Pass"));
        exportRide.addVisitorToHistory(new Visitor("Nancy", 52, "ID14", "T14", "VIP Pass"));
        exportRide.addVisitorToHistory(new Visitor("Oscar", 22, "ID15", "T15", "Day Pass"));

        System.out.println("\n--- Current Ride History (to be exported): ---");
        exportRide.printRideHistory();

        // 调用导出方法，将数据写入名为 "ride_history.csv" 的文件
        exportRide.exportRideHistory("ride_history.csv");

        System.out.println("\nPlease check your project's root directory for the 'ride_history.csv' file.");
        System.out.println("\n--- Part 6 Demonstration Finished ---\n\n");
    }

    // --- 在partSeven()中编写演示代码 ---
    public void partSeven() {
        System.out.println("--- Executing Part 7: Reading Ride History from a File ---");

        // 创建一个全新的 Ride 对象，以确保其历史记录是空的
        Ride importRide = new Ride("Data Importer", "Utility Ride", 10);

        // 打印导入前的状态
        System.out.println("\n--- Ride History BEFORE import: ---");
        importRide.printRideHistory(); // 此时应为空
        System.out.println("Number of visitors in history before import: " + importRide.numberOfVisitors());


        // 调用导入方法
        importRide.importRideHistory("ride_history.csv");

        // 打印导入后的状态，以验证数据是否已成功加载
        System.out.println("\n--- Ride History AFTER import: ---");
        importRide.printRideHistory(); // 此时应包含5名游客的信息
        System.out.println("Number of visitors in history after import: " + importRide.numberOfVisitors());

        System.out.println("\n--- Part 7 Demonstration Finished ---");
    }
}
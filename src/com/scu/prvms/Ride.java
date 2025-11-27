package com.scu.prvms;

// 导入所有需要的 Java 工具类
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


//这个类代表一个游乐设施，是整个系统的核心。
//它实现了 RideInterface 接口，并管理着等待队列、游玩历史、运行周期以及数据的导入导出。
public class Ride implements RideInterface {

    // --- 实例变量 (Instance Variables) ---
    private String rideName;
    private String rideType;
    private Employee rideOperator;

    // Part 3: 使用 Queue<Visitor> 结构来存储等待的游客，遵循先进先出 (FIFO) 原则。
    private Queue<Visitor> waitingLine;

    // Part 4A: 使用 List<Visitor> (具体实现为 LinkedList) 来存储已完成游玩的游客历史。
    private List<Visitor> rideHistory;

    // Part 5: 用于管理游乐设施运行周期的变量。
    private int maxRider;       // 每轮最大载客量。
    private int numOfCycles;    // 已运行的总轮数。


    // --- 构造函数 (Constructor) ---


    //Ride 类的参数化构造函数。
    //在创建 Ride 对象时初始化其基本属性和数据结构。
    public Ride(String rideName, String rideType, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.maxRider = maxRider;

        // 初始化所有数据结构和计数器
        this.rideOperator = null;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }


    // --- 接口方法的实现 (@Override) ---

    // --- Part 3: 队列管理 ---
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.add(visitor);
        System.out.println("SUCCESS: " + visitor.getName() + " has joined the queue for " + this.rideName + ".");
    }
    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("FAILURE: The queue is empty. No visitor to remove.");
            return;
        }
        Visitor removedVisitor = waitingLine.poll();
        System.out.println("SUCCESS: " + removedVisitor.getName() + " has been removed from the queue.");
    }
    @Override
    public void printQueue() {
        System.out.println("\n--- Current Waiting Line for '" + this.rideName + "' (" + waitingLine.size() + " people) ---");
        if (waitingLine.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            int position = 1;
            for (Visitor visitor : waitingLine) {
                System.out.println(position++ + ". " + visitor.getName());
            }
        }
        System.out.println("-------------------------------------------------");
    }

    // --- Part 4A: 历史记录管理 ---
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
        System.out.println("\n--- Ride History for '" + this.rideName + "' (" + rideHistory.size() + " records) ---");
        if (rideHistory.isEmpty()) {
            System.out.println("The history is empty.");
        } else {
            // 作业要求：必须使用 Iterator
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println("- Name: " + v.getName() + ", Age: " + v.getAge());
            }
        }
        System.out.println("-------------------------------------------------");
    }

    // --- Part 5: 运行周期管理 ---
    @Override
    public void runOneCycle() {
        System.out.println("\nAttempting to run a cycle for '" + this.rideName + "'...");
        if (this.rideOperator == null) {
            System.out.println("FAILURE: Cannot run cycle. No operator is assigned!");
            return;
        }
        if (this.waitingLine.isEmpty()) {
            System.out.println("FAILURE: Cannot run cycle. The waiting line is empty.");
            return;
        }
        int ridersThisCycle = Math.min(this.maxRider, this.waitingLine.size());
        System.out.println("INFO: Cycle is starting! Moving " + ridersThisCycle + " visitors from the queue.");
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = waitingLine.poll();
            if (visitor != null) {
                this.addVisitorToHistory(visitor);
            }
        }
        this.numOfCycles++;
        System.out.println("SUCCESS: Cycle finished. Total cycles run: " + this.numOfCycles);
    }


    // --- Ride 类特有的公共方法 (非接口要求) ---

    // Part 4B: 排序功能
    //使用自定义的 VisitorComparator 对 rideHistory 列表进行排序。
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty, nothing to sort.");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("SUCCESS: Ride history has been sorted by age, then by name.");
    }

    // Part 6: 文件导出功能
    //将 rideHistory 中的所有游客数据导出到一个 CSV 文件中。
    public void exportRideHistory(String filename) {
        System.out.println("\nAttempting to export ride history to '" + filename + "'...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                String line = String.join(",", visitor.getId(), visitor.getName(), String.valueOf(visitor.getAge()), visitor.getTicketId(), visitor.getPassType());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("SUCCESS: Ride history has been successfully exported to " + filename);
        } catch (IOException e) {
            System.err.println("FAILURE: An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Part 7: 文件导入功能
    //从一个 CSV 文件中导入游客数据并填充到 rideHistory 中。
    public void importRideHistory(String filename) {
        System.out.println("\nAttempting to import ride history from '" + filename + "'...");
        rideHistory.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        Visitor visitor = new Visitor(parts[1], Integer.parseInt(parts[2].trim()), parts[0], parts[3], parts[4]);
                        this.addVisitorToHistory(visitor);
                    } catch (NumberFormatException e) {
                        System.err.println("SKIPPING LINE: Could not parse age in line: " + line);
                    }
                } else {
                    System.err.println("SKIPPING LINE: Malformed data in line: " + line);
                }
            }
            System.out.println("SUCCESS: Ride history has been successfully imported from " + filename);
        } catch (IOException e) {
            System.err.println("FAILURE: An error occurred while reading the file: " + e.getMessage());
        }
    }

    // --- Getters 和 Setters ---
    public String getRideName() { return rideName; }
    public void assignOperator(Employee operator) {
        this.rideOperator = operator;
        System.out.println("INFO: Operator '" + operator.getName() + "' has been assigned to " + this.rideName + ".");
    }
}
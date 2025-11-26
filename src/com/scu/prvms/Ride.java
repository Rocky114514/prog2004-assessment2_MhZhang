package com.scu.prvms;

// ---  新增的导入 ---
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// ---

import java.util.*;

public class Ride implements RideInterface {

    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private Queue<Visitor> waitingLine;
    private List<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    public Ride(String rideName, String rideType, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = null;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // ---  新增的文件导出方法 ---
    /**
     * 将 rideHistory 中的所有游客数据导出到一个 CSV 文件中。
     * @param filename 要创建的文件的名称 (例如 "ride_history.csv")。
     */
    public void exportRideHistory(String filename) {
        System.out.println("\nAttempting to export ride history to '" + filename + "'...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            if (rideHistory.isEmpty()) {
                System.out.println("INFO: Ride history is empty. An empty file will be created.");
            }
            for (Visitor visitor : rideHistory) {
                // 定义CSV格式: id,name,age,ticketId,passType
                String line = String.join(",",
                        visitor.getId(),
                        visitor.getName(),
                        String.valueOf(visitor.getAge()),
                        visitor.getTicketId(),
                        visitor.getPassType());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("SUCCESS: Ride history has been successfully exported to " + filename);
        } catch (IOException e) {
            System.err.println("FAILURE: An error occurred while writing to the file: " + e.getMessage());
        }
    }

    //  新增的文件导入方法 ---
    public void importRideHistory(String filename) {
        System.out.println("\nAttempting to import ride history from '" + filename + "'...");
        rideHistory.clear(); // 在导入前先清空当前的历史记录，防止重复
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // 数据验证：确保每一行都有5个部分
                if (parts.length == 5) {
                    try {
                        String id = parts[0];
                        String name = parts[1];
                        int age = Integer.parseInt(parts[2].trim()); // trim() 移除可能的空格
                        String ticketId = parts[3];
                        String passType = parts[4];

                        Visitor visitor = new Visitor(name, age, id, ticketId, passType);
                        this.addVisitorToHistory(visitor); // 使用已有的方法添加，可以复用打印信息
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
    // ---


    public void sortRideHistory() { /* ... */ }

    // Getters 和 Setters
    public String getRideName() { return rideName; }
    public void assignOperator(Employee operator) { this.rideOperator = operator; }


    @Override public void addVisitorToQueue(Visitor visitor) { /* ... */ }
    @Override public void removeVisitorFromQueue() { /* ... */ }
    @Override public void printQueue() { /* ... */ }
    @Override public void addVisitorToHistory(Visitor visitor) { rideHistory.add(visitor); System.out.println("INFO: " + visitor.getName() + " was added to the ride history."); }
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    @Override public void printRideHistory() { /* ... */ }
    @Override public void runOneCycle() { /* ... */ }
}
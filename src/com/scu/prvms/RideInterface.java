package com.scu.prvms;

public interface RideInterface {
    // Part 3 methods
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Part 4 methods
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Part 5 method
    void runOneCycle();
}
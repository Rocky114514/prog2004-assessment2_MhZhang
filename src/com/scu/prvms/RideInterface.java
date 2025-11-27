package com.scu.prvms;

/**
 * 这个接口定义了一个游乐设施 (Ride) 应该具备的所有基本行为。
 * 任何实现了此接口的类都必须提供这些方法的具体实现。
 */
public interface RideInterface {

    // --- Part 3: 与等待队列 (Queue) 相关的方法 ---

    //将一个游客添加到等待队列的末尾。
    void addVisitorToQueue(Visitor visitor);

    //从等待队列的头部移除一个游客。
    void removeVisitorFromQueue();

    //打印当前等待队列中所有游客的信息。
    void printQueue();


    // --- Part 4: 与游玩历史 (Ride History) 相关的方法 ---

    //将一个游客添加到游玩历史记录中。
    //通常在游客完成一次游玩后调用此方法。
    void addVisitorToHistory(Visitor visitor);

    //检查指定的游客是否存在于游玩历史记录中。
    boolean checkVisitorFromHistory(Visitor visitor);

    //返回游玩历史记录中的游客总数。
    int numberOfVisitors();

    //打印游玩历史记录中所有游客的信息。
    void printRideHistory();


    // --- Part 5: 与游乐设施运行周期 (Ride Cycle) 相关的方法 ---

    void runOneCycle();

}
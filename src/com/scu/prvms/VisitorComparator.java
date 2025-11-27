package com.scu.prvms; // 确保包名一致

import java.util.Comparator;

/**
 * 这是一个用于比较两个 Visitor 对象的比较器类。
 * 它实现了 Comparator 接口，用于对 Visitor 集合进行自定义排序。
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * 比较两个 Visitor 对象以确定它们的顺序。
     * 排序规则:
     * 1. 主要排序依据：按年龄 (age) 升序排列。
     * 2. 次要排序依据：如果年龄相同，则按姓名 (name) 的字母顺序升序排列。
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 比较年龄
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());

        // 如果年龄不相同，直接返回年龄的比较结果
        if (ageComparison != 0) {
            return ageComparison;
        } else {
            // 如果年龄相同，则比较姓名
            return v1.getName().compareTo(v2.getName());
        }
    }
}
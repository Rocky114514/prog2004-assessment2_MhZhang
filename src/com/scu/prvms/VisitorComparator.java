package com.scu.prvms; // 确保包名一致

import java.util.Comparator;

/**
 * 这是一个用于比较两个 Visitor 对象的比较器类。
 * 它实现了 Comparator 接口，用于对 Visitor 集合进行自定义排序。
 * 这是为作业 Part 4B 创建的。
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * 比较两个 Visitor 对象以确定它们的顺序。
     * 排序规则:
     * 1. 主要排序依据：按年龄 (age) 升序排列。
     * 2. 次要排序依据：如果年龄相同，则按姓名 (name) 的字母顺序升序排列。
     *
     * @param v1 第一个要比较的 Visitor 对象。
     * @param v2 第二个要比较的 Visitor 对象。
     * @return  一个负整数、零或正整数，表示第一个参数是小于、等于还是大于第二个参数。
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
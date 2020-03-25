package com.company;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wenxuan.hao
 * @create 2020-03-26 02:32
 */
public class Node {

    private String name;
    private int pri;
    // 调度次数
    private AtomicInteger hit;

    public Node(String name, int pri) {
        this.name = name;
        this.pri = pri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }

    public int incr(){
        return hit.addAndGet(1);
    }

    public int getHit(){
        return hit.get();
    }
}

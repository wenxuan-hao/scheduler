package com.company;

public class Main {

    public static void main(String[] args) {

        Scheduler scheduler = Scheduler.getScheduler();
        Node node = scheduler.weightRobin();
        int hit = node.getHit();
    }
}

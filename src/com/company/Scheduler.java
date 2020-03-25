package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wenxuan.hao
 * @create 2020-03-26 02:33
 */
public class Scheduler {

    private static volatile Scheduler INSTANCE;

    private Map<Node, Integer> nodes;

    private AtomicInteger index;

    private Scheduler(){
        nodes = new ConcurrentHashMap<>();
        index = new AtomicInteger(0);
    }


    // 单例模式初始化
    public static Scheduler getScheduler(){
        if(INSTANCE == null){
            synchronized (Scheduler.class){
                INSTANCE = new Scheduler();
            }
        }
        return INSTANCE;

    }

    // 负载策略
    public Node weightRobin(){

        int weight = nodes.values().stream().mapToInt( p -> p).sum();

        if(index.get() > weight){
            index.set(0);
        }
        int number = index.get();

        for(Map.Entry<Node,Integer> entry : nodes.entrySet()) {

            if(entry.getValue() >= number) {

                Node node =  entry.getKey();
                node.incr();
                return node;

            }

            number = number - entry.getValue();

        }

        return null;

    }

    public  void addNode(Node node){
        nodes.put(node, node.getPri());
    }

    public void delNode(Node node){
        nodes.remove(node);
    }

















}

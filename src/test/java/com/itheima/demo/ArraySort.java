package com.itheima.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArraySort implements  Runnable{
    private String num;
    public  ArraySort(int num){
        this.num = num + "";
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        for (int i =0;i<50;i++){
           list.add(r.nextInt(10));
        }
        for (int i=0;i<list.size();i++){
            new Thread(new ArraySort(list.get(i))).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.print(num + ",");
        }catch (Exception e){

        }
    }
}

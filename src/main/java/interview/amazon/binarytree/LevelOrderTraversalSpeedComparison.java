package interview.amazon.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalSpeedComparison {

    public static void method1(int runNTimes){
        int count = 0;
        while(count != runNTimes){
            List<String> list = new ArrayList();
            list.add("A");
            list.remove(0);
            count++;
        }

    }

    public static void method2(int runNTimes){
        int count = 0;
        while(count != runNTimes){
            LinkedList<String> list2 = new LinkedList();
            list2.add("A");
            list2.poll();
            count++;
        }

    }

//    public static void main(String[] args) {
//
//        long startTime = System.nanoTime();
//        //method1(100);
//        method2(100);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
//
//        System.out.println(duration);
//        // Method 1: 132600
//        // Method 2: 422600
//
//    }

}

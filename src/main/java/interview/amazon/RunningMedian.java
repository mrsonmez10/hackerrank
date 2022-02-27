package interview.amazon;

import java.util.*;

public class RunningMedian {

    // mis-understanding..
//    public static List<Double> runningMedian(List<Integer> a) {
//        List<Double> result = new ArrayList<>();
//        Collections.sort(a);
//        if(a.isEmpty()) {
//            return Collections.EMPTY_LIST;
//        } else if(null == a) {
//            return Collections.EMPTY_LIST;
//        } else if (a.size() == 1) {
//            result.add(Double.valueOf(a.get(0)));
//            System.out.println(result.get(0));
//            return result;
//        } else {
//            if(a.size() % 2 == 0) {
//                int midUpperPoint =  a.size()/2;
//                int midLowerPoint = midUpperPoint-1;
//                double median = (Double.valueOf(a.get(midUpperPoint))+Double.valueOf(a.get(midLowerPoint))) / 2;
//                result.add(median);
//                System.out.println(median);
//                return result;
//            } else {
//                double median = a.get(a.size()/2);
//                result.add(median);
//                System.out.println(median);
//                return result;
//            }
//        }
//    }
    /*


    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> lowerHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> higherHeap = new PriorityQueue<>();
        List<Double> medians = new ArrayList<>();
        if (a == null) {
            return Collections.EMPTY_LIST;
        } else if (a.isEmpty()) {
            return Collections.EMPTY_LIST;
        } else {
            for (int i = 0; i < a.size(); i++) {
                int number = a.get(i);
                addNumber(number, lowerHeap, higherHeap);
                rebalance(lowerHeap, higherHeap);
                double median = getMedian(lowerHeap, higherHeap);
                System.out.println(median);
                medians.set(i, getMedian(lowerHeap, higherHeap));
            }
            return medians;
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> higherHeap) {
        if (lowerHeap.size() == 0 || number < lowerHeap.peek()) {
            lowerHeap.add(number);
        } else {
            higherHeap.add(number);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> higherHeap) {
        PriorityQueue<Integer> biggerHeap = lowerHeap.size() > higherHeap.size() ? lowerHeap : higherHeap;
        PriorityQueue<Integer> smallerHeap = lowerHeap.size() > higherHeap.size() ? higherHeap : lowerHeap;

        if (biggerHeap.size() - smallerHeap.size() >=2 ) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static Double getMedian(PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> higherHeap) {
        PriorityQueue<Integer> biggerHeap = lowerHeap.size() > higherHeap.size() ? lowerHeap : higherHeap;
        PriorityQueue<Integer> smallerHeap = lowerHeap.size() > higherHeap.size() ? higherHeap : lowerHeap;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return (double) biggerHeap.peek();
        }
    }
     */

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static List<Double> runningMedian(List<Integer> a) {
        if (null == a) {
            return Collections.EMPTY_LIST;
        } else if (a.isEmpty()) {
            return Collections.EMPTY_LIST;
        } else {
            List<Double> medians = new ArrayList<>();
            for (int i = 0; i < a.size(); i++) {
                addNumber(a.get(i));
                System.out.println(getMedian());
                medians.add(getMedian());
            }
            return medians;
        }
    }

    private static void addNumber(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
    }

    private static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

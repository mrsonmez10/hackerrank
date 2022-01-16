package array.p01;

import java.util.List;

public class TwoDArray{

    // @Link: https://www.hackerrank.com/interview/interview-preparation-kit/arrays/challenges
    public static int hourglassSum(List<List<Integer>> arr) {
        int first = 0, mid = 0, last = 0;
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.size() - 2; j++) {
                first += first + arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2);
                mid += mid + arr.get(i + 1).get(j + 1);
                last += last + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                int sum = first + mid + last;
                System.out.print(sum + " ");
                if (sum>=max) {
                    max=sum;
                }
                first = 0;mid=0;last=0;
            }
            System.out.println();
        }
        return max;
    }

}

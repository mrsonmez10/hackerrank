package interview.amazon.q03;

import java.util.ArrayList;
import java.util.List;

public class QuestionThree {

    public static int maxSubarrayLength(List<Integer> badges) {
        if(null == badges){
            return 0;
        } else if(badges.isEmpty()){
            return 0;
        } else if(badges.size() == 1) {
            return  1;
        } else {
            int max = 0;
            int firstNegativeIndex = -1;
            int negativeCount = 0;
            int zeroIndex = -1;
            for (int i=0; i<badges.size(); i++) {
                if (badges.get(i) < 0) {
                    negativeCount ++;
                    if (firstNegativeIndex == -1) {
                        firstNegativeIndex = i;
                    }
                    else {
                        if (negativeCount % 2 == 0) {
                            max = Math.max(max, i-zeroIndex);
                        }
                    }
                } else {
                    if (negativeCount % 2 == 0) {
                        max = Math.max(max, i-zeroIndex);
                    }
                    else {
                        max = Math.max(max, i-firstNegativeIndex);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        List<Integer> badges = new ArrayList<>();
        badges.add(1);
        badges.add(-1);
        badges.add(-1);
        badges.add(-1);
        badges.add(1);
        badges.add(1);
        System.out.println(maxSubarrayLength(badges)); // (2,5) -> 4

        List<Integer> badges2 = new ArrayList<>();
        badges2.add(1);
        badges2.add(-1);
        badges2.add(-1);
        badges2.add(1);
        badges2.add(1);
        badges2.add(-1);
        System.out.println(maxSubarrayLength(badges2)); // (0,4) -> 5
    }
}

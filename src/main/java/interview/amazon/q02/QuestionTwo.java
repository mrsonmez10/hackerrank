package interview.amazon.q02;

import java.util.*;

/**
 * This is an amazon interview question.
 *
 * I will skip the writing question part.
 * Just focusing input and outputs..
 *
 * Input: bbacccc
 * Output: 3 (4(c) - 1(a))
 *
 * Input: bbacccabab
 * output: 2 // accc and ccca -- freq(c) - freq(a): 3-1=2
 *
 * Input: aaaa
 * output: 0 // max(freq) == min(freq)
 */
public class QuestionTwo {
    static Set<String> mySet = new HashSet<>();
    static final int MAX_CHAR = 256;

    public static int solution(String input){
        int result = 0;
        if(null == input){
            throw new NullPointerException("Input can not be null");
        }
        if("".equalsIgnoreCase(input)){
            return result;
        } // Also you can add more control flow like remove special chars, white space etc..
        // You can make another method for that. (errorHandlingSolution(input))

        myPermutation(input, input); // Set
//        for(String str: mySet){
//            System.out.println(str);
//        }

        Map<Character, Integer> map = new HashMap<>();
        for(String str: mySet){
            if(!"".equalsIgnoreCase(str))
            {
                map = getOccuringChar(str);
                int maxValueInMap=(Collections.max(map.values()));
                int minValueInMap=(Collections.min(map.values()));
                int difference = maxValueInMap-minValueInMap;
                if(difference > result){
                    result = difference;
                }
            }
        }

        mySet.clear();
        return result;
    }

    public static void myPermutation(String str, String actual){
        myPermutation("", str, actual);
    }

    private static void myPermutation(String prefix, String str, String actual){
        int n = str.length();
        if(!prefix.isEmpty())
            mySet.add(prefix);
        if(n > 0){
            for(int i = 0; i < n; i++){
                if(actual.contains(prefix + str.charAt(i))){
                    myPermutation(prefix + str.charAt(i), str.substring(i + 1, n), actual);
                }

            }
        }
    }

    public static Map<Character, Integer> getOccuringChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        // i.e. ASCII_SIZE
        int count[] = new int[MAX_CHAR];
        int len = str.length();

        // Initialize count array index
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        // Create an array of given String size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                // If any matches found
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1){
                //System.out.println("Number of Occurrence of " + str.charAt(i) + " is:" + count[str.charAt(i)]);
                map.put(str.charAt(i),count[str.charAt(i)]);
            }
        }
        return map;
    }

//    public static void main (String[]args){
//        System.out.println(solution("abc")); // 0
//        System.out.println(solution("aabb")); // 1
//        System.out.println(solution("bbacccabab")); // 2
//        System.out.println(solution("aaaa")); // 0
//    }
}

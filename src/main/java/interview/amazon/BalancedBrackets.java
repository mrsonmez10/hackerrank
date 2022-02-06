package interview.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    static Map<Character, Character> bracketMap;

    static {
        bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
    }

    static String isBalanced(String str) {
        String yes = "YES";
        String no = "NO";

        if ((str.length() % 2) != 0)
            return no;

        Stack<Character> stack = new Stack();
        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(bracketMap.containsKey(ch)) {
                stack.push(ch);
            } else if(stack.isEmpty() || ch != bracketMap.get(stack.pop())) {
                return no;
            }
        }
        return stack.isEmpty() ? yes : no;
    }
}

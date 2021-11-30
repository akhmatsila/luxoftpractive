import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Task3 {

    public static boolean isProperParentheses(String str) {
        if (str.length() % 2 != 0) return false;
        int balance = 0;
        for (int i = 0 ; i < str.length() ; ++i) {
            if (str.charAt(i) == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    /*
   Determine whether a given non-blank string of parentheses is properly nested.
   String consists only of the characters "(" and/or ")".
   For example, string "(()(())())" is properly nested but string "())" isn't.

   Try to estimate time-space complexitty.

   Time complexity is O(n) , space complexity is O(n)
   Need to use Java Collections
    */
    public static boolean isProperNestedParentheses(String str) {
        if (!isProperParentheses(str)) return false;
        Deque<Character> leftHalf = new LinkedList<>();
        Deque<Character> rightHalf = new LinkedList<>();
        for (int i = 0 ; i < str.length() / 2 ; ++i) {
            leftHalf.add(str.charAt(i));
            rightHalf.add(str.charAt(str.length() - 1 - i));
        }
        Iterator<Character> leftHalfIter = leftHalf.iterator();
        Iterator<Character> rightHalfIter = rightHalf.iterator();
        while (leftHalfIter.hasNext()) {
            char leftCurChar = leftHalfIter.next();
            char rightCurChar = rightHalfIter.next();
            if (leftCurChar == rightCurChar) return false;
        }
        return true;
    }
}

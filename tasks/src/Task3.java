public class Task3 {
    /*
    Determine whether a given non-blank string of parentheses is properly nested.
    String consists only of the characters "(" and/or ")".
    For example, string "(()(())())" is properly nested but string "())" isn't.

    Try to estimate time-space complexitty.

    Time complexity is O(n) , space complexity is O(1)
     */
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
}

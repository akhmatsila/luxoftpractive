import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {
    @Test
    public void test1() {
        assertTrue(Task3.isProperNestedParentheses("()()()"));
    }

    @Test
    public void test2() {
        assertFalse(Task3.isProperNestedParentheses("()(())"));
    }

    @Test
    public void test3() {
        assertFalse(Task3.isProperNestedParentheses("(())()"));
    }

    @Test
    public void test4() {
        assertTrue(Task3.isProperNestedParentheses("((()))"));
    }

    @Test
    public void test5() {
        assertFalse(Task3.isProperNestedParentheses(")()()"));
    }

    @Test
    public void test6() {
        assertFalse(Task3.isProperNestedParentheses("((())))"));
    }

    @Test
    public void test7() {
        assertFalse(Task3.isProperNestedParentheses("((()))()("));
    }

    @Test
    public void test8() {
        assertFalse(Task3.isProperNestedParentheses(")()("));
    }

    @Test
    public void test9() {
        assertFalse(Task3.isProperNestedParentheses(")((()))("));
    }

    @Test
    public void test10() {
        assertTrue(Task3.isProperNestedParentheses("(((()()()))((()()()))((()()())))"));
    }

    @Test
    public void test11(){
        assertTrue(Task3.isProperNestedParentheses("()()()()()()()()()()()()"));
    }

    @Test
    public void test12() {
        assertTrue(Task3.isProperNestedParentheses("(())(((()()())))(())"));
    }
}

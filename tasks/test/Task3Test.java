import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {
    @Test
    public void test1() {
        assertTrue(Task3.isProperParentheses("()()()"));
    }

    @Test
    public void test2() {
        assertTrue(Task3.isProperParentheses("()(())"));
    }

    @Test
    public void test3() {
        assertTrue(Task3.isProperParentheses("(())()"));
    }

    @Test
    public void test4() {
        assertTrue(Task3.isProperParentheses("((()))"));
    }

    @Test
    public void test5() {
        assertFalse(Task3.isProperParentheses(")()()"));
    }

    @Test
    public void test6() {
        assertFalse(Task3.isProperParentheses("((())))"));
    }

    @Test
    public void test7() {
        assertFalse(Task3.isProperParentheses("((()))()("));
    }

    @Test
    public void test8() {
        assertFalse(Task3.isProperParentheses(")()("));
    }

    @Test
    public void test9() {
        assertFalse(Task3.isProperParentheses(")((()))("));
    }
}

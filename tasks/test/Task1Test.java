import static org.junit.Assert.*;
import org.junit.Test;

public class Task1Test {
    @Test
    public void checkNull() {
        boolean res = Task1.isSubsequence(null, new int[]{});
        assertFalse(res);
        boolean res2 = Task1.isSubsequence(new int[]{}, null);
        assertFalse(res2);
    }

    @Test
    public void checkEmptyArrays() {
        assertTrue(Task1.isSubsequence(new int[]{}, new int[]{}));
    }

    @Test
    public void check1() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 3};
        assertTrue(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void check2() {
        int[] arr1 = {1, 2, 1, 1, 1, 1 };
        int[] arr2 = {1, 1, 1, 1};
        assertTrue(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void check3() {
        int[] arr1 = {10, 9};
        int[] arr2 = {9, 10, 9};
        assertTrue(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void check4() {
        int[] arr1 = {0, 0, 0, 0};
        int[] arr2 = {0, 0, 0, 0};
        assertTrue(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void check5() {
        int[] arr1 = {};
        int[] arr2 = {1, 2, 3, 4, 5};
        assertTrue(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void check6() {
        int[] arr1 = {1, 2, 3, 4, 5, 98, 1, 1, 1 ,1};
        int[] arr2 = {2, 98, 1};
        assertTrue(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void falseCheck1() {
        int[] arr1 = {0, 1, 2, 3};
        int[] arr2 = {0, 2, 4};
        assertFalse(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void falseCheck2() {
        int[] arr1 = {98, 98, 98, 98, 98, 0, 98};
        int[] arr2 = {98, 98, 0, 98 , 98};
        assertFalse(Task1.isSubsequence(arr1, arr2));
    }

    @Test
    public void falseCheck3() {
        int[] arr1 = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        assertFalse(Task1.isSubsequence(arr1, arr2));
    }
}

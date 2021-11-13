public class Task1 {
    /*
    Given two non-empty arrays of positive integers,
    write a function that determines whether
    the second array is a subsequence of the first one.
    A subsequence of an array is a set of numbers
    that aren't necessarily adjacent in the array
    but that are in the same order as they appear in the array.
    For example, array [1, 2, 3, 4]
    could have subsequences: [1, 3, 4] or [2, 4] or [1]
     */
    public static boolean isSubsequence(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return false;
        if (arr1.length < arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int arr1Index = 0;
        for (int cur : arr2) {
            while (arr1Index < arr1.length && arr1[arr1Index] != cur) arr1Index++;
            if (arr1Index >= arr1.length) return false;
            arr1Index++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}

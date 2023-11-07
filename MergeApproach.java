import java.util.Arrays;

public class MergeApproach {
    public static int[] union(int[] a1, int[] a2) {
        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException();
        }

        int[] total = new int[a1.length + a2.length];

        if (a1.length > 1) {
            Sort.quickSort(a1);
        }
        if (a2.length > 1) {
            Sort.quickSort(a2);
        }

        int i = 0;
        int j = 0;
        int insert = 0;

        while (i < a1.length && j < a2.length) {
            if (insert == 0) {
                if (a1[i] == a2[j]) {
                    total[insert++] = a1[i++];
                    j++;
                }
                else if (a1[i] < a2[j]) {
                    total[insert++] = a1[i++];
                }
                else {
                    total[insert++] = a2[j++];
                }
            }
            else {
                i++;j++;
            }
        }

        // case for j hasn't made it thru a2
        if (i == a1.length) {
            while(j < a2.length) {
                total[insert] = a2[j];
                insert++;
                j++;
            }
        }
        // case for i hasn't made it thru a1
        else {
            while(i < a1.length) {
                total[insert] = a1[i];
                insert++;
                i++;
            }
        }

        return total;
    }
    public static void main(String[] args) {
        int[] a1 = {10, 5, 7, 5, 9, 4};
        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result1 = union(a1, a2);
        System.out.println("result1: " + Arrays.toString(result1));

        int[] a3 = {0, 2, -4, 6, 10, 8};
        int[] a4 = {12, 0, -4, 8};
        int[] result2 = union(a3, a4);
        System.out.println("result2: " + Arrays.toString(result2));

        int[] a5 = {9, 9, 9, 9, 9, 9, 9};
        int[] a6 = {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 21};
        int[] result3 = union(a5, a6);
        System.out.println("result3: " + Arrays.toString(result3));

        int[] a7 = {};
        int[] a8 = {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 21};
        int[] result4 = union(a7, a8);
        System.out.println("result4: " + Arrays.toString(result4));

    }
}

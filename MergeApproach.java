import java.awt.desktop.SystemSleepEvent;
import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;

public class MergeApproach {
    public static int[] union(int[] a1, int[] a2) {
        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException();
        }

        int[] total = new int[a1.length + a2.length];
        if (total.length == 0) {
            return total;
        }

        if (a1.length > 1) {
            Sort.quickSort(a1);
        }
        if (a2.length > 1) {
            Sort.quickSort(a2);
        }

        int i = 0;
        int j = 0;
        int insert = -1;

        // ensure indices are valid heading into the while loop
        if (a1.length == 0) {
            total[++insert] = a2[j++];
            while (j < a2.length) {
                if (total[insert] != a2[j]) {
                    total[++insert] = a2[j++];
                }
                else {
                    j++;
                }
            }
            return total;
        }
        if (a2.length == 0) {
            total[++insert] = a1[i++];
            while (i < a1.length) {
                if (total[insert] != a1[i]) {
                    total[++insert] = a1[i++];
                }
                else {
                    i++;
                }
            }
            return total;
        }

        if (a1[i] <= a2[j]) {
            total[++insert] = a1[i++];
        }
        else {
            total[++insert] = a2[j++];
        }

        while (i < a1.length && j < a2.length) {
//            System.out.println("i: " + i + " j: " + j + "");
            if (total[insert] != a1[i] && a1[i] <= a2[j]) {
                total[++insert] = a1[i++];
            }
            else if (total[insert] != a2[j] && a1[i] >= a2[j]) {
                total[++insert] = a2[j++];
            }
            // both were equal to total[insert]
            else {
                i++;
                j++;
            }
        }

//        while (insert < total.length) {
//            // i is at the end of a1
//            if (i == a1.length && j < a2.length) {
//                total[insert++] = a2[j++];
//            }
//            // a1 must still have items
//            else if (j == a2.length && i < a1.length) {
//                total[insert++] = a1[i++];
//            }
//            else if (j == a2.length && i == a1.length) {
//                System.out.print("this should never be triggered");
//                break;
//            }
//            else {
//                if (a1[i] != total[insert]) {
//                    // now we know [i] is valid to place in
//                    if (a1[i] < a2[j]) {
//                        // now we know [i] is the correct placement
//                        total[++insert] = a1[i++];
//                    }
//                    // now we know [j] is >= [i] and [i] != insert
//                    // so [j] is > insert
//                    // (exception is if insert is 0 because
//                    // it hasn't been initialized yet)
//                    else if (a1[i] == a2[j]) {
//                        total[++insert] = a1[i++];
//                        j++;
//                    }
//                    // now we know [i] is greater than [j]
//                    else {
//                        total[++insert] = a2[j++];
//                    }
//                }
//                // now we know that [i] is a duplicate
//                else if (a2[j] != total[insert]) {
//                    // no we know both [i] and [j] aren't duplicates
//                    if (a1[i] < a2[j]) {
//                        // now we know [i] is the correct placement
//                        total[++insert] = a1[i++];
//                    }
//                    // now we know [j] is >= [i] and [i] != insert
//                    // so [j] is > insert
//                    // (exception is if insert is 0 because
//                    // it hasn't been initialized yet)
//                    else if (a1[i] == a2[j]) {
//                        total[++insert] = a1[i++];
//                        j++;
//                    }
//                    // now we know [i] is greater than [j]
//                    else {
//                        total[++insert] = a2[j++];
//                    }
//                }
//                // both [i] and [j] are insert
//                else {
//                    i++;
//                    j++;
//                }
//            }
//        }

        return total;
    }
    public static void main(String[] args) {
//        int[] a1 = {10, 5, 7, 5, 9, 4};
//        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
//        int[] result1 = union(a1, a2);
//        System.out.println("result1: " + Arrays.toString(result1));
//
//        int[] a3 = {0, 2, -4, 6, 10, 8};
//        int[] a4 = {12, 0, -4, 8};
//        int[] result2 = union(a3, a4);
//        System.out.println("result2: " + Arrays.toString(result2));
//
//        int[] a5 = {9, 9, 9, 9, 9, 9, 9};
//        int[] a6 = {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 21};
//        int[] result3 = union(a5, a6);
//        System.out.println("result3: " + Arrays.toString(result3));
//
//        int[] a7 = {};
//        int[] a8 = {14, 14, 14, 14, 21};
//        int[] result4 = union(a7, a8);
//        System.out.println("result4: " + Arrays.toString(result4));

        int[] a9 = {0, 2};
        int[] a10 = {0, 0, 3, 1};
        int[] result5 = union(a9, a10);
        System.out.println("result5: " + Arrays.toString(result5));

//        int[] a11 = {0, 79, 13, 34, 50, 28, 52, 18, 17};
//        int[] a12 = {90, 34, 12, 73, 92, 31};
//        int[] result6 = union(a11, a12);
//        System.out.println("result5: " + Arrays.toString(result6));
    }
}

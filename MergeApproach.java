/*
 * CS 112 Problem Set 6
 * Jacob Brinton
 * jbrin@bu.edu
 *
 * This is a class of merging methods such as union and intersect.
 */

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

        // merge portion
        while (i < a1.length && j < a2.length) {
            // [i] is unique and less than [j]
            if (total[insert] != a1[i] && a1[i] <= a2[j]) {
                total[++insert] = a1[i++];
            }
            // [j] is unique and less than [i]
            else if (total[insert] != a2[j] && a1[i] >= a2[j]) {
                total[++insert] = a2[j++];
            }
            // both were equal to total[insert]
            else {
                while (i < a1.length && total[insert] == a1[i]) {
                    i++;
                }
                while (j < a2.length && total[insert] == a2[j]) {
                    j++;
                }
            }
        }

        // left with only one array that still needs to be added
        while (i < a1.length) {
            if (total[insert] != a1[i]) {
                total[++insert] = a1[i++];
            }
            else {
                i++;
            }
        }
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

    public static int[] intersect(int[] a1, int[] a2) {
        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException();
        }

        int[] total = new int[Math.min(a1.length, a2.length)];
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
        int insert = 0;

        while (i < a1.length && j < a2.length) {
            // case for insertion is needed
            if (a1[i] == a2[j] && a1[i] != total[insert]) {
                total[insert++] = a1[i++];
                j++;
            }
            // case for [j] > [i], so increment i++
            else if (a1[i] < a2[j]) {
                i++;
            }
            // case for [i] > [j], so increment j++
            else if (a1[i] > a2[j]) {
                j++;
            }
            // case for [insert], [i], and [j] all have the same value
            else {
                i++;
                j++;
            }
        }
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
//
//        int[] a9 = {0, 2};
//        int[] a10 = {0, 0, 3, 1};
//        int[] result5 = union(a9, a10);
//        System.out.println("result5: " + Arrays.toString(result5));
//
//        int[] a11 = {0, 79, 13, 34, 50, 28, 52, 18, 17};
//        int[] a12 = {90, 34, 12, 73, 92, 31};
//        int[] result6 = union(a11, a12);
//        System.out.println("result5: " + Arrays.toString(result6));
//
//        int[] a13 = {-99, 77, 17};
//        int[] a14 = {0};
//        int[] result7 = union(a13, a14);
//        System.out.println("result5: " + Arrays.toString(result7));

        int[] b1 = {10, 5, 7, 5, 9, 4};
        int[] b2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result90 = intersect(b1, b2);
        System.out.println("Result b1: " + Arrays.toString(result90));

        int[] b3 = {0, 2, -4, 6, 10, 8};
        int[] b4 = {12, 0, -4, 8};
        int[] result91 = intersect(b3, b4);
        System.out.println("Result b2: " + Arrays.toString(result91));

        int[] b5 = {0, 0, 0, 2};
        int[] b6 = {2, 0, 0, 0};
        int[] result93 = intersect(b5, b6);
        System.out.println("Result b3: " + Arrays.toString(result93));
    }
}

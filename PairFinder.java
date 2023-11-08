public class PairFinder {
    public static void findPairSums(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                }
            }
        }
    }

    public static void findPairSumsFaster(int k, int[] arr) {
        if (arr.length > 1) {
            Sort.quickSort(arr);
        }

        int i = 0;
        int j = 0;
        while (j < arr.length && i < arr.length) {
            // case of too large
            if (arr[i] + arr[j] > k) {
                break;
            }
            else if (arr[i] + arr[j] == k) {
                System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                // check for out of bounds
                if (j+1 == arr.length) {
                    i++;
                }
                // only increment i if the difference between its next element
                // is less than that of j's (this ensures j >= i always)
                else if (arr[i+1] - arr[i] < arr[j+1] - arr[j]) {
                    i++;
                }
                else {
                    j++;
                }
            }
            else {
                // check for out of bounds
                if (j+1 == arr.length) {
                    i++;
                }
                // only increment i if the difference between its next element
                // is less than that of j's (this ensures j >= i always)
                else if (arr[i+1] - arr[i] < arr[j+1] - arr[j]) {
                    i++;
                }
                else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        findPairSums(12, new int[]{10, 4, 7, 7, 8, 5, 15});
        findPairSums(12, new int[]{0, 0, 0, 0, 1, 2, 3, 4, 90});
        findPairSums(-3, new int[]{90, -3, 0, -1, 2, -2, 56});

        findPairSumsFaster(-5, new int[]{90, -3, 0, -1, 2, -2, 56});
        findPairSumsFaster(12, new int[]{10, 4, 7, 7, 8, 5, 15});
        findPairSumsFaster(12, new int[]{0, 0, 0, 0, 1, 2, 3, 4, 90});
        findPairSumsFaster(-3, new int[]{90, 0, -2, 13, 0, -1, -2});
        findPairSumsFaster(0, new int[]{90, -2, 13, 0, -1, -2});
        findPairSumsFaster(1990, new int[]{995, 995, -2, 13, 0, -1, -2});

        for (int i = -130; i < 140; i++) {
            int[] randArr = new int[(int) (Math.random() * 15)];

            for (int k = 0; k < randArr.length; k++) {
                randArr[k] = (int)(Math.random() * (90 + 1)) - 45;
            }
            findPairSumsFaster(i, randArr);
        }
    }
}
public class Scratchpad {

    public static int loop(int n) {
        int count = 0;
        for (int i = 0; i < 2*n; i++) {
            for (int j = 0; j < n - 1; j++) {
                count++;
            }
        }
        return count;
    }

    public static int loop2(int n) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = n; k > 0; k = k/2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.println("i/c is    " + i + " : " + loop2(i));
        }
    }
}

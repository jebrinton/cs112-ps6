import java.util.Arrays;

public class SortClient {
    public static void main(String[] args) {
        int[] a = new int[]{14, 7, 27, 13, 24, 20, 10, 33};
        System.out.println(Arrays.toString(a));

        System.out.println("\nSelection sort: use pass 2");
        SortPlus.selectionSort(a.clone());

        System.out.println("\nInsertion sort: use pass 4");
        SortPlus.insertionSort(a.clone());

        System.out.println("\nBubble sort: use pass 3");
        SortPlus.bubbleSort(a.clone());

        System.out.println("\nQuicksort: use calls 1 and 2 and 3 and 4");
        SortPlus.quickSort(a.clone());

        System.out.println("\nMergesort: use call 4");
        SortPlus.mergeSort(a.clone());

        int[] b = new int[]{24, 3, 27, 13, 34, 2, 50, 12};
        System.out.print("\n" + Arrays.toString(b));

        System.out.println("\nMergesort: use calls 2 and 4");
        SortPlus.mergeSort(b.clone());
    }
}

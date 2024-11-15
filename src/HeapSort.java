import java.util.Arrays;

public class HeapSort {
    public static void heapSort(Integer[] values) {
        int size = values.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(values, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = values[0];
            values[0] = values[i];
            values[i] = temp;

            heapify(values, i, 0);
        }
    }

    public static void heapify(Integer[] values, int size, int rootIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int indexOfSmallest = rootIndex;

        if (leftChildIndex < size && values[leftChildIndex] < values[indexOfSmallest]) {
            indexOfSmallest = leftChildIndex;
        }
        if (rightChildIndex < size && values[rightChildIndex] < values[indexOfSmallest]) {
            indexOfSmallest = rightChildIndex;
        }
        if (indexOfSmallest != rootIndex) {
            int temp = values[rootIndex];
            values[rootIndex] = values[indexOfSmallest];
            values[indexOfSmallest] = temp;

            heapify(values, size, indexOfSmallest);
        }
    }

    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
    }
}

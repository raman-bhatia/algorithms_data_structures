import java.util.Arrays;

public class HeapSort {
    public static void maxHeapify(Integer[] A, int r) {
        int largest = r; // Initialize largest as root
        int x = 2*r + 1; // left = 2*i + 1
        int y = 2*r + 2; // right = 2*i + 2

        // If left child is larger than root
        if (x < A.length && A[x] > A[largest])
            largest = x;

        // If right child is larger than largest so far
        if (y < A.length && A[y] > A[largest])
            largest = y;

        // If largest is not root
        if (largest != r)
        {
            int swap = A[r];
            A[r] = A[largest];
            A[largest] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(A, largest);
        }
    }

    public static void buildMaxHeap(Integer[] A) {

        // Build heap (rearrange array)
        for (int r = A.length / 2 - 1; r >= 0; r--) {
            maxHeapify(A, r);
        }

    }

    public static void heapSort(Integer[] A) {
        buildMaxHeap(A);
        for (int i=A.length-1; i>0; i--)
        {
            // Move current root to end
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            // call max heapify on the reduced heap
            maxHeapify(A, 0);
        }
        System.out.print(Arrays.toString(A));

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer arr[] = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
    }
}

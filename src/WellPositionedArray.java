import java.util.ArrayList;
import java.util.Arrays;

public class WellPositioned {

        public static ArrayList<Integer> minHeapify(ArrayList<Integer> B, int n, int i) {

            ArrayList<Integer> A = new ArrayList<>(B);

            int smallest = i; // Initialize largest as root
            int l = 2*i + 1; // left = 2*i + 1
            int r = 2*i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < n && A.get(l) < A.get(smallest))
                smallest = l;

            // If right child is larger than largest so far
            if (r < n && A.get(r) < A.get(smallest))
                smallest = r;

            // If largest is not root
            if (smallest != i)
            {
                int swap = A.get(i);
                A.set(i, A.get(smallest));
                A.set(smallest, swap);

                // Recursively heapify the affected sub-tree
                A = minHeapify(A, n, smallest);
            }
            return A;
        }

        public static ArrayList<Integer> buildMinHeap(ArrayList<Integer> B) {
            ArrayList<Integer> A = new ArrayList<>(B);
            // Build heap (rearrange array)
            for (int r = A.size() / 2 - 1; r >= 0; r--) {
                A = minHeapify(A, A.size(), r);
            }
            return A;
        }

        public static ArrayList<Integer> maxHeapify(ArrayList<Integer> B, int n, int i) {

            ArrayList<Integer> A = new ArrayList<>(B);
            int largest = i; // Initialize largest as root
            int l = 2*i + 1; // left = 2*i + 1
            int r = 2*i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < n && A.get(l) > A.get(largest))
                largest = l;

            // If right child is larger than largest so far
            if (r < n && A.get(r) > A.get(largest))
                largest = r;

            // If largest is not root
            if (largest != i)
            {
                int swap = A.get(i);
                A.set(i, A.get(largest));
                A.set(largest, swap);

                // Recursively heapify the affected sub-tree
                A = maxHeapify(A, n, largest);
            }

            return A;
        }

        public static ArrayList<Integer> buildMaxHeap(ArrayList<Integer> B) {
            ArrayList<Integer> A = new ArrayList<>(B);
            // Build heap (rearrange array)
            for (int i = A.size() / 2 - 1; i >= 0; i--) {
                A = maxHeapify(A, A.size(), i);
            }
            return A;
        }

    public static void main(String[] args) {

        Integer arr[] = {21, 20, 23, 24, 26, 18, 25, 30,27, 29, 60, 65};

        int k = 6;

        Integer[] subA = Arrays.copyOfRange(arr, 0, k );

        ArrayList<Integer> subAL = new ArrayList<Integer>(Arrays.asList(subA));

        ArrayList<Integer> subALKeep = new ArrayList<Integer>(subAL);
        System.out.println("Original : " + subAL);

        ArrayList<Integer> minHeap = new ArrayList<Integer>();
        ArrayList<Integer> maxHeap = new ArrayList<Integer>();



        int wellPositioned = 1;
        for (int i = k; i <= arr.length ; i++ ){


            minHeap = buildMinHeap(subAL); // klo
            maxHeap = buildMaxHeap(subAL);


            System.out.println(" " + minHeap  + maxHeap + subAL);

            if (2 * minHeap.get(0) <=  maxHeap.get(0)){

                wellPositioned = 0;
                break;

            }

            subAL.remove(0);
            subAL.add(arr[i]);
        }

        if (wellPositioned == 1){
            System.out.println("Array is well positioned");
        } else {
            System.out.println("Array is not well positioned");
        }


    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class AlmostHeapSort {
    public static void minHeapify(ArrayList<Integer> A, int n, int i) {
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
            minHeapify(A, n, smallest);
        }
    }

    public static void buildMinHeap(ArrayList<Integer> A) {

        // Build heap (rearrange array)
        for (int r = A.size() / 2 - 1; r >= 0; r--) {
            minHeapify(A, A.size() , r);
        }

    }

    public static ArrayList<Integer> heapSort(ArrayList<Integer> A) {
        buildMinHeap(A);
        for (int i=A.size()-1; i>0; i--)
        {
            // Move current root to end
            int temp = A.get(0);
            A.set(0, A.get(i));
            A.set(i, temp);

            // call max heapify on the reduced heap
            minHeapify(A, i,0);
        }
        //System.out.print(Arrays.toString(A));
        return A;
    }


//    public static ArrayList<Integer> partialSort(Integer[] A, int k){
//        Integer[] subA = Arrays.copyOfRange(A, 0, k+1);
//        Integer[] sortedSubA = heapSort(subA);
//        ArrayList<Integer> sortedSubAList = new ArrayList<Integer>(Arrays.asList(sortedSubA));
//        return sortedSubAList;
//    }

    public static void main(String[] args) {

        Integer arr[] = {2,1,4,3,6,5, 10,7, 9, 8};

        int k = 3;
        //Integer[] subA = Arrays.copyOfRange(arr, 0, k+1);

        Integer[] subA = Arrays.copyOfRange(arr, 0, k + 1);

        ArrayList<Integer> subAL = new ArrayList<Integer>(Arrays.asList(subA));

        System.out.println("Original : " + subAL);

        ArrayList<Integer> sortedA = new ArrayList<Integer>();

        for (int i = k+1; i < arr.length ; i++ ){

            buildMinHeap(subAL);
            System.out.println( "After Heapify : " + subAL);
            sortedA.add(subAL.get(0));
            subAL.remove(0);
            System.out.println( "After Heapify : " + subAL);
            subAL.add(arr[i]);
            System.out.println( "After Heapify : " + subAL);


        }

        for (int i = 0; i < subA.length; i++){
            buildMinHeap(subAL);
            System.out.println("Remaining : " + subAL);
            sortedA.add(subAL.get(0));
            subAL.remove(0);

        }

        System.out.println("Answer" + sortedA);

    }
}

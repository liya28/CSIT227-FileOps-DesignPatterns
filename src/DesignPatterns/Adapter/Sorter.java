package DesignPatterns.Adapter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public interface Sorter {
    void sort(int[] array);
}

// Third-party NumberSorter class that only accepts Lists
class NumberSorter {
    public void sortList(List<Integer> list) {
        list.sort(Integer::compareTo);
        System.out.println("Sorted List: " + list);
    }
}

// Adapter class for sorting arrays

class ArraySorterAdapter implements Sorter {
    private NumberSorter numberSorter;

    public ArraySorterAdapter() {
        this.numberSorter = new NumberSorter();
    }

    @Override
    public void sort(int[] array) {
        List<Integer> list = new ArrayList<>();
        // Convert array to List
        for (int num : array) {
            list.add(num);
        }
        // Use the NumberSorter to sort the List
        numberSorter.sortList(list);
        // Convert back to array if necessary
        // Optional: Print sorted array
        System.out.println("Sorted Array: " + Arrays.toString(list.toArray()));
    }
}

class SorterApp {
    public static void main(String[] args) {
        Sorter sorter = new ArraySorterAdapter();
        int[] numbers = {5, 3, 8, 1, 4};

        System.out.println("Original Array: " + Arrays.toString(numbers));
        sorter.sort(numbers);  // Use the adapter to sort the array
    }
}

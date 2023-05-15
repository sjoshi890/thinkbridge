package com.sorting.Sorting;

import com.sorting.Employee;

public class Sorting {

    // 1 > Bubble Sort
    // Sorts an array of employees based on their salary using Bubble sort algorithm
    static void bubbleSort(Employee[] arr) {
        // Store length of array
        int len = arr.length;

        // set position where to traverse
        int elementPos = len - 1;

        while (elementPos >= 1) {
            int currentPos = 0;
            int swapCount = 0;
            while (currentPos < elementPos) {
                // Swap elements if next element is smaller than current one.
                if (arr[currentPos].getSalary() > arr[currentPos + 1].getSalary()) {
                    swapCount++;
                    Employee temp = arr[currentPos];
                    arr[currentPos] = arr[currentPos + 1];
                    arr[currentPos + 1] = temp;
                }
                currentPos = currentPos + 1;
            }

                /* In case whole list/array is already sorted there is no need to run the process further.
                It reduces the time complexity of the Sorting.
                 */
            if (swapCount == 0) {
                return;
            }

            // Each time reduce elementPos by 1 as we are moving the largest element to the rightmost corner.
            elementPos = elementPos - 1;
        }
    }



    // 2 > Selection Sort
    // Sorts an array of employees based on their salary using selection sort algorithm
    static void selectionSort(Employee[] employees) {
        int len = employees.length;
        int elementPos = 0;
        while (elementPos < len - 1) {
            // Assume smallest element position to be current position
            int smallestElementPos = elementPos;
            int currentPos = elementPos + 1;
            while (currentPos < len) {
                // Compare salary of current employee with small employee so far
                if (employees[currentPos].getSalary() < employees[smallestElementPos].getSalary()) {
                    smallestElementPos = currentPos;
                }
                currentPos++;
            }
            // Swap elements if smallest employee is not at its expected position
            if (elementPos != smallestElementPos) {
                Employee temp = employees[elementPos];
                employees[elementPos] = employees[smallestElementPos];
                employees[smallestElementPos] = temp;
            }
            elementPos++;
        }
    }


    // 3 > Insertion Sort
    //  Sorts an array of employees based on their salary using Insertion sort algorithm
    static void insertionSort(Employee[] arr) {
        // Let's take initially the sortedSize of Employee is 1
        int sortedSize = 1;
        while (sortedSize < arr.length) {
            Employee insertEmployee = arr[sortedSize];
            int currentPos = sortedSize - 1;
            while (currentPos >= 0) {
                // If the current element's salary is smaller than the one being inserted, break out of the loop
                if (arr[currentPos].getSalary() < insertEmployee.getSalary()) {
                    break;
                }
                // Shift the current element to the right to make space for the new element
                if (arr[currentPos].getSalary() > insertEmployee.getSalary()) {
                    arr[currentPos + 1] = arr[currentPos];
                    currentPos = currentPos - 1;
                }
            }
            // Insert the element at the appropriate position
            arr[currentPos + 1] = insertEmployee;
            sortedSize++;
        }
    }


    // 4 > Quick Sort
    //  Sorts an array of employees based on their salary using Quick sort algorithm
    static int partition(Employee arr[], int low, int high) {
        // Choose the last element as the pivot
        int pivot = arr[high].getSalary();
        int i = low - 1;

        // Traverse the sub array and swap elements
        for (int j = low; j < high; j++) {
            if (arr[j].getSalary() < pivot) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        Employee temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void quickSort(Employee arr[], int low, int high) {
        if (low < high) {
            int partition_index = partition(arr, low, high);
            quickSort(arr, low, partition_index - 1);
            quickSort(arr, partition_index + 1, high);
        }
    }

}

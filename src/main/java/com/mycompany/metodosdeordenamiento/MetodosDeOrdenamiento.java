/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metodosdeordenamiento;
import java.util.Scanner;


/**
 *
 * @author Usuario
 */
public class MetodosDeOrdenamiento {

    public static void mostrar(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ========================
    // SELECTION SORT
    // ========================
    public static void selectionSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // ========================
    // BUBBLE SORT
    // ========================
    public static void bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    // ========================
    // INSERTION SORT
    // ========================
    public static void insertionSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // ========================
    // MERGE SORT
    // ========================
    public static void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                arr[k] = L[i];
                i++;

            } else {

                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {

            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {

            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int l, int r) {

        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // ========================
    // QUICK SORT
    // ========================
    public static int partition(int arr[], int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // ========================
    // HEAP SORT
    // ========================
    public static void heapify(int arr[], int n, int i) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {

            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int arr[]) {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // ========================
    // COUNTING SORT
    // ========================
    public static void countingSort(int arr[]) {

        int max = arr[0];

        for (int i : arr)
            if (i > max)
                max = i;

        int count[] = new int[max + 1];

        for (int i : arr)
            count[i]++;

        int index = 0;

        for (int i = 0; i <= max; i++) {

            while (count[i] > 0) {

                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // ========================
    // RADIX SORT
    // ========================
    public static int getMax(int arr[]) {

        int max = arr[0];

        for (int i : arr)
            if (i > max)
                max = i;

        return max;
    }

    public static void countSort(int arr[], int exp) {

        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {

            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixSort(int arr[]) {

        int m = getMax(arr);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    // ========================
    // BUCKET SORT
    // ========================
    public static void bucketSort(int arr[]) {

        int max = arr[0];

        for (int i : arr)
            if (i > max)
                max = i;

        int bucket[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++)
            bucket[arr[i]]++;

        int index = 0;

        for (int i = 0; i <= max; i++) {

            while (bucket[i] > 0) {

                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    // ========================
    // MAIN
    // ========================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Ingrese los numeros:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int opcion;

        do {

            System.out.println("\nMENU DE ORDENAMIENTO");
            System.out.println("1. Selection Sort");
            System.out.println("2. Bubble Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Heap Sort");
            System.out.println("7. Counting Sort");
            System.out.println("8. Radix Sort");
            System.out.println("9. Bucket Sort");
            System.out.println("10. Ingresar nuevos numeros");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            int copia[] = arr.clone();

            switch (opcion) {

                case 1:
                    selectionSort(copia);
                    mostrar(copia);
                    break;

                case 2:
                    bubbleSort(copia);
                    mostrar(copia);
                    break;

                case 3:
                    insertionSort(copia);
                    mostrar(copia);
                    break;

                case 4:
                    mergeSort(copia, 0, copia.length - 1);
                    mostrar(copia);
                    break;

                case 5:
                    quickSort(copia, 0, copia.length - 1);
                    mostrar(copia);
                    break;

                case 6:
                    heapSort(copia);
                    mostrar(copia);
                    break;

                case 7:
                    countingSort(copia);
                    mostrar(copia);
                    break;

                case 8:
                    radixSort(copia);
                    mostrar(copia);
                    break;

                case 9:
                    bucketSort(copia);
                    mostrar(copia);
                    break;

                    case 10:

    System.out.print("Ingrese la nueva cantidad de numeros: ");
    n = sc.nextInt();

    arr = new int[n];

    System.out.println("Ingrese los nuevos numeros:");

    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    break;
                    
                    
            }

        } while (opcion != 0);

    }
}

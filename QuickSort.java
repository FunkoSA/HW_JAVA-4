package JAVA.HW4_JAVA;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args)
	{
		
		Scanner iScanner = new Scanner(System.in);
        System.out.printf("int Введите количество элементов для генерации массива n: ");
        boolean flag = iScanner.hasNextInt();
        if (flag) {
            int n = iScanner.nextInt();
            iScanner.close();
			int[] arr = new int [n];
			for (int index = 0; index < n; index++) {
				arr [index] = new Random().nextInt(50 + 1);
				
			}
			
			int ArraySize = arr.length;
			System.out.println("вывод исходного массива: ");
			printArray(arr, ArraySize);
			quickSort(arr, 0, ArraySize - 1);
			System.out.println("Результат сортировки массива: ");
			printArray(arr, ArraySize);
        } else {
            System.out.println("Введено значение, отличное от натурального числа");
        }

	}
	// перестановка элементов
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		System.out.println("Промежуточная сортировка массива: ");
		printArray(arr, arr.length);
	}


	static int partition(int[] arr, int low, int high)
	{

		// pivot
		int pivot = arr[high];

		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);
		
		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {

				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
                
			}
		}
		swap(arr, i + 1, high);
        
		return (i + 1);
	}


	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			// pi is partitioning index, arr[p]
			// is now at right place
            
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
            

		}
	}

	// Вывод массива на экран
	static void printArray(int[] arr, int size)
	{
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + "\t");

		System.out.println();
	}



}

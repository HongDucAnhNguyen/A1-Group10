package sait.sos.utility;

import sait.sos.problemdomain.Shape;
import java.util.*;

/**
 * Implements six sorting algorithms.
 */
public class Utility {
	
	private static Random r;
	
	/**
	 * Performs a quicksort.
	 * @param shapes - Array of shapes to be sorted.
	 * @param start - The first index of the array.
	 * @param end - The last index of the array.
	 * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
	 */
	public static void quicksort(Shape[] shapes, int start, int end, String compareType) {
        // If dividing no longer possible, length <= 1
        if (end <= start) {
        	return; //base case
        }

        // Partition will sort our array and find pivot
        int pivotPosition = partition(shapes, start, end, compareType);
        quicksort(shapes, start, pivotPosition - 1, compareType); //pivot - 1 means the ending index of the sub array on the left
        quicksort(shapes, pivotPosition + 1, end, compareType); //pivot + 1 means the beginning index of the sub array on the right
    }
	
	/**
	 * Sorts the array of shapes and finds pivot for quicksort.
	 * @param shapes - Array of shapes to be sorted.
	 * @param start - The first index of the array.
	 * @param end - The last index of the array.
	 * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
	 * @return the pivot location.
	 */
    private static int partition(Shape[] shapes, int start, int end, String compareType) {

        Shape pivot = shapes[end]; //initially the pivot will be the ending
        int i = start - 1; //i stands at [the first index of the array - 1]

        for(int j = start; j <= end; j++) {
            //if value at index j < pivot, increment i and swap array[i] and array[j]
            if(compareType.equalsIgnoreCase("h")){
                if(shapes[j].compareTo(pivot) > 0) {
                    i++;

                    //swapping using temp variable
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
            if(compareType.equalsIgnoreCase("v")){
                CompareVolume volume = new CompareVolume();
                if(volume.compare(shapes[j],pivot) > 0) {
                    i++;

                    //swapping using temp variable
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
            if(compareType.equalsIgnoreCase("a")){
                CompareBaseArea baseArea = new CompareBaseArea();
                if(baseArea.compare(shapes[j],pivot) > 0) {
                    i++;

                    //swapping using temp variable
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
        }
        //this means when [j] reaches pivot, swap the value at pivot with [i+1]
        i++;//increment the i value first, now it is i + 1
        //perform swap
        Shape temp = shapes[i];
        shapes[i] = shapes[end];
        shapes[end] = temp;

        return i; //return i value which is now where the pivot stands within the array
    }
    
    /**
     * Performs a bubble sort.
     * @param shapes - Array of shapes to be sorted.
     * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area. 
     */
    public static void bubbleSort(Shape[] shapes, String compareType) {
        for(int i = 0; i < shapes.length - 1; i++) {
            for(int j = 0; j < shapes.length - i - 1; j++) {
                if(compareType.equalsIgnoreCase("h")){
                    if(shapes[j].compareTo(shapes[j+1]) < 0) {
                        Shape temp = shapes[j];
                        shapes[j] = shapes[j+1];
                        shapes[j+1] = temp;
                    }
                }
                if(compareType.equalsIgnoreCase("a")){
                    CompareBaseArea baseArea = new CompareBaseArea();
                    if(baseArea.compare(shapes[j], shapes[j+1])< 0) {
                        Shape temp = shapes[j];
                        shapes[j] = shapes[j+1];
                        shapes[j+1] = temp;
                    }
                }
                if(compareType.equalsIgnoreCase("v")){
                    CompareVolume volume = new CompareVolume();
                    if(volume.compare(shapes[j], shapes[j+1])< 0) {
                        Shape temp = shapes[j];
                        shapes[j] = shapes[j+1];
                        shapes[j+1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Performs a selection sort.
     * @param shapes - Array of shapes to be sorted.
     * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
     */
    public static void selectionSort(Shape[] shapes, String compareType) {
        CompareBaseArea baseArea = new CompareBaseArea();
        CompareVolume volume = new CompareVolume();

        //we set the limit of iteration to length - 1 (i.e index 8)
        //because once we get to index 7, the starting index is i++ so it will be index 8
        //if the limit is equal to index 8 , the starting index is i++ which wil be index 9
        //and because index 9 doesnt exist in our array it will throw an error
        for(int i = 0; i < shapes.length - 1; i++) {
            //set initial value of min to be 0
            int min = i;

            for(int j = i + 1; j < shapes.length; j++) {
                if(compareType.equalsIgnoreCase("h")){
                    //if value at index j is < the previous, set [j] as new min and move on
                    //keep repeating until this for loop break so we can start new iteration
                    if(shapes[min].compareTo(shapes[j]) < 0) {
                        min = j;
                    }
                }
                if (compareType.equalsIgnoreCase("a")){

                    if(baseArea.compare(shapes[min], (shapes[j])) < 0) {
                        min = j;
                    }
                }
                if (compareType.equalsIgnoreCase("v")){

                    if(volume.compare(shapes[min], (shapes[j])) < 0) {
                        min = j;
                    }
                }
            }
            //after for loop breaks, end of by executing these lines and then move on to new iteration
            //place temp where the index with which we used to start the iteration
            Shape temp = shapes[i];
            //place min where that starting index i was
            shapes[i] = shapes[min];

            //place temp where min was in the array
            shapes[min] = temp;
        }
        //move on to next iteration

    }

    /**
     * Performs an insertion sort.
     * @param shapes - Array of shapes to be sorted.
     * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
     */
    public static void insertionSort(Shape[] shapes, String compareType) {
        CompareBaseArea baseArea = new CompareBaseArea();
        CompareVolume volume = new CompareVolume();
        for(int i = 1; i < shapes.length; i++) {
            //set initial temp
            Shape temp = shapes[i];
            //value to compare is always the thing behind our current temp
            int j = i - 1;

            if(compareType.equalsIgnoreCase("h")){
                //while compare value is valid (not outside the array scope) and if [j] value > temp
                //then shift it right
                while(j >= 0 && shapes[j].compareTo(temp) < 0) {
                    //the position right next wil now be taken by our current [j] value
                    shapes[j + 1] = shapes[j];
                    //after that, decrement j so that
                    // any values remaining that come before temp that hasnt been compared yet
                    //can get compared
                    //once there are no values left, while loop will break and we move on
                    j--;
                }
            }
            if(compareType.equalsIgnoreCase("a")){

                while(j >= 0 && baseArea.compare(shapes[j],temp) < 0) {
                    //the position right next wil now be taken by our current [j] value
                    shapes[j + 1] = shapes[j];
                    //after that, decrement j so that
                    // any values remaining that come before temp that hasnt been compared yet
                    //can get compared
                    //once there are no values left, while loop will break and we move on
                    j--;
                }
            }
            if(compareType.equalsIgnoreCase("v")){

                while(j >= 0 && volume.compare(shapes[j],temp) < 0) {
                    //the position right next wil now be taken by our current [j] value
                    shapes[j + 1] = shapes[j];
                    //after that, decrement j so that
                    // any values remaining that come before temp that hasnt been compared yet
                    //can get compared
                    //once there are no values left, while loop will break and we move on
                    j--;
                }
            }
            //put the value temporarily stored in temp back to the empty slot
            //once finished with comparing
            shapes[j + 1] = temp;
        }
    }

    /**
     * Performs a merge sort.
     * @param shapes - Array of shapes to be sorted.
     * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
     */
    public static void mergeSort(Shape[] shapes, String compareType) {

        int length = shapes.length;
        //which means if the current state of the array only has 1 element and cannot be divided further
        if (length <= 1) return; //base case

        int middle = length / 2; //split the array each time mergeSort is called
        Shape[] leftArray = new Shape[middle]; //leftArray carries the splitted length
        Shape[] rightArray = new Shape[length - middle]; //rightArray carries whatever is left

        int i; //left array index
        int j = 0; //right array index

        for( i = 0; i < length; i++) {

            if(i < middle) {
                leftArray[i] = shapes[i];
                //now leftArray = [8,2,5,3]
                //this will keep going until there is no more arrays elements to divide
            }
            else {
                rightArray[j] = shapes[i];
                //now rightArray = [4, 7, 6, 1]
                //this will keep going until there is no more arrays elements to divide
                j++; //to go to next index in array
            }
        }
        mergeSort(leftArray, compareType); //recursion
        mergeSort(rightArray, compareType);
        merge(leftArray, rightArray, shapes, compareType); //after breaking array down to subarrays, merge it back and sort
    }
    
    /**
     * Merges the array of shapes for merge sort.
     * @param leftArray - Left half of the shapes array.
     * @param rightArray - Right half of the shapes array.
     * @param array - Array of shapes to be sorted.
     * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
     */
    private static void merge(Shape[] leftArray, Shape[] rightArray, Shape[] array, String compareType) {
        CompareVolume volume = new CompareVolume();
        CompareBaseArea baseArea = new CompareBaseArea();
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            //if number on the left is > , this number takes [i] of original array
            if(compareType.equalsIgnoreCase("h") && leftArray[l].compareTo(rightArray[r]) > 0) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else if (compareType.equalsIgnoreCase("v") && volume.compare(leftArray[l],rightArray[r])>0) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else if (compareType.equalsIgnoreCase("a") && baseArea.compare(leftArray[l],rightArray[r])>0) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                //if number on the left is <, number on the right array takes [i] of original array
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        //============================================================//
        //these two extra conditions are for the elements that have nothing to compare to
        //thats why we will compare them to the array size, if they are still within the range
        //then simply fill them in on the original array

        //excusively for the leftside
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        //excusively for the rightside
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    
    /**
     * Calls the appropriate bogosort method based on compare type.
     * @param shapes - Array of shapes to be sorted.
     * @param compareType - A char representing the attribute to be compared:
	 * 'h' for height, 'v' for volume, 'a' for base area.
     */
    public static void bogoSort(Shape[] shapes, String compareType) {
    	switch(compareType) {
    		case "h":
            case "H":
    			bogoSortHeight(shapes);
    			break;
    		case "a":
            case "A":
    			bogoSortArea(shapes);
    			break;
    		case "v":
            case "V":
    			bogoSortVolume(shapes);
    			break;
    		default:
    			System.out.println("\nInvalid compare type.\n");
    			System.exit(0);
    	}
    }
    
    /**
     * Performs a bogosort from largest to smallest based on height.
     * @param shapes - Array of shapes to be sorted.
     */
    public static void bogoSortHeight(Shape[] shapes) {    	
    	int length = shapes.length;
    	boolean sorted;
    	
    	do {
    		sorted = true;
    		for (int i = length - 1; i > 0; i--) {
    			if (shapes[i].compareTo(shapes[i - 1]) > 0) {
    				shuffle(shapes);
    				sorted = false;
    				break;
    			}
        	}
    	} while (!sorted);
    }
    
    /**
     * Performs a bogosort from largest to smallest based on volume.
     * @param shapes - Array of shapes to be sorted.
     */
    public static void bogoSortVolume(Shape[] shapes) {
    	CompareVolume volume = new CompareVolume();
    	int length = shapes.length;
    	boolean sorted;
    	
    	do {
    		sorted = true;
    		for (int i = length - 1; i > 0; i--) {
    			if (volume.compare(shapes[i], shapes[i - 1]) > 0) {
    				shuffle(shapes);
    				sorted = false;
    				break;
    			}
        	}
    	} while (!sorted);
    }
    
    /**
     * Performs a bogosort from largest to smallest based on base area.
     * @param shapes - Array of shapes to be sorted.
     */
    public static void bogoSortArea(Shape[] shapes) {
    	CompareBaseArea area = new CompareBaseArea();
    	int length = shapes.length;
    	boolean sorted;
    	
    	do {
    		sorted = true;
    		for (int i = length - 1; i > 0; i--) {
    			if (area.compare(shapes[i], shapes[i - 1]) > 0) {
    				shuffle(shapes);
    				sorted = false;
    				break;
    			}
        	}
    	} while (!sorted);
    }    
    
    /**
	 * Randomly shuffles the specified array.
	 * Source: Java.util.Collections.shuffle
	 * @param shapes - Array of shapes to be sorted.
	 */
	public static void shuffle(Shape[] shapes) {
		Random rnd = r;
		if (rnd == null) {
			r = rnd = new Random();
		}
		shuffle(shapes, rnd);
	}
    	
	/**
	 * Randomly shuffles the specified array.
	 * Source: Java.util.Collections.shuffle
	 * @param shapes - Array of shapes to be sorted.
	 * @param rnd - The source of randomness to use to shuffle the array.
	 */
	public static void shuffle(Shape[] shapes, Random rnd) {
		int size  = shapes.length;
		for (int i = size; i > 1; i--) {
			swap(shapes, i - 1, rnd.nextInt(i));
		}
	}
	
	/**
	 * Swaps the two specified elements in the specified array. 
     * Source: Java.util.Collections.swap
	 * @param arr - The array in which to swap elements.
	 * @param i - The index of one element to be swapped.
	 * @param j - The index of the other element to be swapped.
	 */
    public static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }    
}
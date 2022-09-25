package utils;

import shapes.CompareBaseArea;
import shapes.CompareVolume;
import shapes.GeneralShape;



public class Sorter {
    public static void quickSort(GeneralShape[] shapes, int start, int end, String sortBy) {
        //if dividing no longer possible, length <= 1
        if(end <= start) return; //base case

        //partition will sort our array and find pivot
        int pivotPosition = partition(shapes, start, end, sortBy);
        quickSort(shapes, start, pivotPosition - 1, sortBy); //pivot - 1 means the ending index of the sub array on the left
        quickSort(shapes, pivotPosition + 1, end,sortBy); //pivot + 1 means the beginning index of the sub array on the right



    }
    private static int partition(GeneralShape[] shapes, int start, int end, String sortBy) {

        GeneralShape pivot = shapes[end]; //initially the pivot will be the ending
        int i = start - 1; //i stands at [the first index of the array - 1]

        for(int j = start; j <= end; j++) {
            //if value at index j < pivot, increment i and swap array[i] and array[j]
            if(sortBy.equals("h")){
                if(shapes[j].compareTo(pivot) > 0) {
                    i++;

                    //swapping using temp variable
                    GeneralShape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
            if(sortBy.equals("v")){
                CompareVolume volume = new CompareVolume();
                if(volume.compare(shapes[j],pivot) > 0) {
                    i++;

                    //swapping using temp variable
                    GeneralShape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
            if(sortBy.equals("a")){
                CompareBaseArea baseArea = new CompareBaseArea();
                if(baseArea.compare(shapes[j],pivot) > 0) {
                    i++;

                    //swapping using temp variable
                    GeneralShape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
        }
        //this means when [j] reaches pivot, swap the value at pivot with [i+1]
        i++;//increment the i value first, now it is i + 1
        //perform swap
        GeneralShape temp = shapes[i];
        shapes[i] = shapes[end];
        shapes[end] = temp;

        return i; //return i value which is now where the pivot stands within the array
    }
    public static void BubbleSort(GeneralShape[] shapes, String sortBy) {
        for(int i = 0; i < shapes.length - 1; i++) {
            for(int j = 0; j < shapes.length - i - 1; j++) {
                if(sortBy.equals("h")){
                    if(shapes[j].compareTo(shapes[j+1]) < 0) {
                        GeneralShape temp = shapes[j];
                        shapes[j] = shapes[j+1];
                        shapes[j+1] = temp;
                    }
                }
                if(sortBy.equals("a")){
                    CompareBaseArea baseArea = new CompareBaseArea();
                    if(baseArea.compare(shapes[j], shapes[j+1])< 0) {
                        GeneralShape temp = shapes[j];
                        shapes[j] = shapes[j+1];
                        shapes[j+1] = temp;
                    }
                }
                if(sortBy.equals("v")){
                    CompareVolume volume = new CompareVolume();
                    if(volume.compare(shapes[j], shapes[j+1])< 0) {
                        GeneralShape temp = shapes[j];
                        shapes[j] = shapes[j+1];
                        shapes[j+1] = temp;
                    }
                }
            }
          }
    }

    public static void SelectionSort(GeneralShape[] shapes, String sortBy) {
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
                if(sortBy.equals("h")){
                    //if value at index j is < the previous, set [j] as new min and move on
                    //keep repeating until this for loop break so we can start new iteration
                    if(shapes[min].compareTo(shapes[j]) < 0) {
                        min = j;
                    }
                }
                if (sortBy.equals("a")){

                    if(baseArea.compare(shapes[min], (shapes[j])) < 0) {
                        min = j;
                    }
                }
                if (sortBy.equals("v")){

                    if(volume.compare(shapes[min], (shapes[j])) < 0) {
                        min = j;
                    }
                }
            }
            //after for loop breaks, end of by executing these lines and then move on to new iteration
            //place temp where the index with which we used to start the iteration
            GeneralShape temp = shapes[i];
            //place min where that starting index i was
            shapes[i] = shapes[min];

            //place temp where min was in the array
            shapes[min] = temp;
        }
        //move on to next iteration

    }

    public static void InsertionSort(GeneralShape[] shapes, String sortBy) {
        CompareBaseArea baseArea = new CompareBaseArea();
        CompareVolume volume = new CompareVolume();
        for(int i = 1; i < shapes.length; i++) {
            //set initial temp
            GeneralShape temp = shapes[i];
            //value to compare is always the thing behind our current temp
            int j = i - 1;

            if(sortBy.equals("h")){
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
            if(sortBy.equals("a")){

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
            if(sortBy.equals("v")){

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

    public static void mergeSort(GeneralShape[] shapes, String sortBy) {

        int length = shapes.length;
        //which means if the current state of the array only has 1 element and cannot be divided further
        if (length <= 1) return; //base case

        int middle = length / 2; //split the array each time mergeSort is called
        GeneralShape[] leftArray = new GeneralShape[middle]; //leftArray carries the splitted length
        GeneralShape[] rightArray = new GeneralShape[length - middle]; //rightArray carries whatevers left

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
        mergeSort(leftArray,sortBy); //recursion
        mergeSort(rightArray, sortBy);
        merge(leftArray, rightArray, shapes, sortBy); //after breaking array down to subarrays, merge it back and sort
    }
    private static void merge(GeneralShape[] leftArray, GeneralShape[] rightArray, GeneralShape[] array, String sortBy) {
        CompareVolume volume = new CompareVolume();
        CompareBaseArea baseArea = new CompareBaseArea();
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            //if number on the left is > , this number takes [i] of original array
            if(sortBy.equals("h") && leftArray[l].compareTo(rightArray[r]) > 0) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else if (sortBy.equals("v") && volume.compare(leftArray[l],rightArray[r])>0) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else if (sortBy.equals("a") && baseArea.compare(leftArray[l],rightArray[r])>0) {
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

    public static void SixthSort() {

    }
}

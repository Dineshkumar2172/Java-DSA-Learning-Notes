public class ArrayOperations {

    /* ARRAYS
     * 1. it's a collection of data elements of specified type.
     * 2. all data holding partitions have contiguous memory locations.
     * 3. each partitions has two neighbors except first and last one.
     * 4. size of an array is fixed and cannot be modified once it is created.
     * 5. being adjacent each partition is indexed and can be determined by its position.
     * 6. index starts at 0 and ends at arraylength-1 for one dimensional array.
     */

    /* 
     * DECLARATION OF AN ARRAY:
     * 
     * one dimensional array can be declared via syntax
     *      1. dataType arrayName[];
     *      2. dataType[] arrayName; (It's the preferred type to use)
     *      3. for example: if i want to declare an integer array, then
     *              a. int myArray[];
     *              b. int[] myArray; // preferred method to use
     * 
     * 
     * 
     * INITIALIZATION OF AN ARRAY AFTER DECLARING IT:
     * 
     * 1. it gives memory to array elements.
     * 2. one dimensional array can be initialized via syntax:
     *          arrayName = new dataType[size];
     * 3. for example: from the previous example, initialization can be done by following way:
     *          myArray = new int[5];
     * 
     * 
     * 
     * DECLARATION AND INITIALIZATION IN ONE STEP: 
     * 
     * 1. syntax:
     *             dataType[] arrayName = new dataType[size]; (or) dataType arrayName[] = new dataType[size];
     * 2. example:
     *             int[] myArray = new int[5]; (or) int myArray[] = new int[5]; (or) int[] myArray = {5, 4, 3, 2, 6};
     * 
     */

    public static void main(String[] args) {
        // once the below line gets executed
        // variable name myArray will be referencing to an array of size 5 with index starting from 0 to 4
        // here, array object is created inside the heap memory - and variable myArray will be referencing to this object.
        // now, with the help of this variable, we can control the array object which is inside the heap memory.
        int[] myArray = new int[5]; // declaring and initializing array with default values and fixed size

        // default values based on datatype after initializing
        // int, long - 0
        // float, double - 0.0
        // boolean - false
        // object - null

        // adding elements directly to array based on its index
        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;
        myArray[3] = 4;
        myArray[4] = 5;

        printArray(myArray);
        System.out.println(myArray.length); // to get the length of an array
        System.out.println(myArray[myArray.length - 1]); // to access last element in an array

        int[] arr = {1,2,3,4,5}; // declaring and initializing an array with values instead of size
        printArray(arr);
        System.out.println();
        int[] oddArray = removeEven(arr);
        printArray(oddArray);

    }

    // function to print elements in an array
    public static void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    // function to remove even integers from an array
    public static int[] removeEven(int[] arr){
        int oddCount = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]%2 != 0){
                oddCount++;
            }
        }

        int[] result = new int[oddCount];
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]%2 != 0) {
                result[index] = arr[i];
                index++;
            }
        }

        return result;
    }
}

import javax.lang.model.type.NullType;

public class ArrayDType {
    public static void main(String[] args) {
        /*
         * 1. It's a collection of data elements of specific type
         * 2. All data holding partitions have contiguous memeory locations.
         * 3. Each partitions have two neighbours except first and last one.
         * 4. Size of array is fixed and cannot be modified once its created.
         * 5. Being adjacent each partition is indexed and can be determined by its positions.
         * 6. Index starts at 0 and ends at n-1
         */

        // one dimensional array can be declared via syntax -
        // dataType arrName[];
        // dataType[] arrName; 
        // we can use both the syntaxes, but the most preferred one is second option because of its readability

        // array declaration 
        int myArray[];
        int[] myArray2;  

        // array initialization
        myArray = new int[10]; 
        myArray2 = new int[10];

        // declaration and initialization in single line
        int myArray3[] = new int[10];
        int[] myArray4 = new int[10];
        int[] myArray5 = {1,2,3,4,5}; // we can also provide actual data directly during initialization

        System.out.println(myArray5[4]); // accessing
        myArray5[4] = 10; // updating
        System.out.println(myArray5[4]);

        ArrayDType demo = new ArrayDType();
        demo.printArray(myArray5);

        int[] oddArray = demo.removeEvenIntegers(myArray5);
        demo.printArray(oddArray);

        // it'll do pass by reference by default, whatever change you do on top of input array directly
        // will affect the actual array outside the function from where array is being initialised i.e. source of the array
        demo.reverseArray(myArray5, 0, myArray5.length-1);
        demo.printArray(myArray5);


        int min = demo.findMinimum(myArray5);
        System.out.println(min);


        int secondMinimum = demo.findSecondMinimum(myArray5);
        System.out.println(secondMinimum);


        int secondMaximum = demo.findSecondMaximum(myArray5);
        System.out.println(secondMaximum);
    }

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] removeEvenIntegers(int[] arr){
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                oddCount++;
            }
        }

        int[] oddArray = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                oddArray[idx] = arr[i];
                idx++;
            }
        }

        return oddArray;
    }

    public void reverseArray(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] =  temp;
            start++;
            end--;
        }
    }


    public int findMinimum(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid Input");
        }

        int minimium = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minimium) {
                minimium = arr[i];
            }
        }

        return minimium;
    }


    public int findSecondMinimum(int[] arr){
        if(arr == null || arr.length <= 0){
            throw new IllegalArgumentException("Invalid Input");
        }

        int minimum = arr[0];
        int secondMinimum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minimum) {
                secondMinimum = minimum;
                minimum = arr[i];
            }
        }

        return secondMinimum;
    }


    public int findSecondMaximum(int[] arr){
        if(arr == null || arr.length <= 0){
            throw new IllegalArgumentException("Invalid Input");
        }

        int maximum = arr[0];
        int secondMaximum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            System.out.println(maximum);
            System.out.println(secondMaximum);
            System.out.println();
            if (arr[i] > maximum) {
                secondMaximum = maximum;
                maximum = arr[i];
            }
        }

        return secondMaximum;
    }

}

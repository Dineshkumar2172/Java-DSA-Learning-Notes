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



        int secondMaximum = demo.findSecondMaximum(myArray5);
        System.out.println(secondMaximum);


        int[] myArray6 = {1,0,5,0,19,3,45,6,0};
        int[] zeroLastResult = demo.moveZeroLast(myArray6);
        demo.printArray(zeroLastResult);

        
        // resizing array to handle more elements as part of it.
        int[] myArray7 = {1,2,3,4,5,6,7};
        demo.printArray(myArray7);
        System.out.println(myArray7.length);
        // myArray7[8] = 8;
        myArray7 = demo.resizeArray(myArray7, 8);
        System.out.println(myArray7.length);
        myArray7[7] = 8;
        demo.printArray(myArray7);


        // find missing element from an array
        int[] myArray8 = {1,2,3,5,6,7,8};
        System.out.println(demo.findMissingElement(myArray8));


        // finding whether if the given string is palindrome or not
        Boolean isStringPalindrome = demo.isPalindrome("madam");
        System.out.println(isStringPalindrome);

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


    public int findSecondMaximum(int[] arr){
        if(arr == null || arr.length <= 0){
            throw new IllegalArgumentException("Invalid Input");
        }

       int max = Integer.MIN_VALUE;
       int secondMax = Integer.MIN_VALUE;
       for (int index = 0; index < arr.length; index++) {
            if(arr[index] > max) {
                secondMax = max;
                max = arr[index];
            } else if(arr[index] > secondMax && arr[index] != max) {
                secondMax = arr[index];
            }
       }

       return secondMax;
    }


    public int[] moveZeroLast(int[] arr){
        int[] tempArray = new int[arr.length];
        int tempReference = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                tempArray[tempReference] = arr[i];
                tempReference++;
            }
        }

        return tempArray;
    }


    public int[] resizeArray(int[] arr, int capacity){
        int[] resizedArr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            resizedArr[i] = arr[i];
        }
        arr = resizedArr;
        return arr;
    }


    public int findMissingElement(int[] arr){
        int n = arr.length + 1; // since one missing element will be there, adding 1 to length
        int sum = (n * (n+1))/2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;

    }


    public Boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        for (int i = 0; i < charArray.length; i++) {
            if(start < end){
                if(charArray[start] != charArray[end]) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

}

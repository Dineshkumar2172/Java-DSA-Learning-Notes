public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 4, 8, 1};
        printArrayElements(arr);
        int[] nextGreater = findNextGreaterElement(arr);
        printArrayElements(nextGreater);
        
    }


    public static int[] findNextGreaterElement(int[] arr){
        int[] greaterArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    greaterArray[i] = arr[j];
                    break;
                }
            }


            if (greaterArray[i] == 0) {
                greaterArray[i] = -1;
            }
        }

        return greaterArray;
    }


    public static void printArrayElements(int[] arr){
        for (int element: arr) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}

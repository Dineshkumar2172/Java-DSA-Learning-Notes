public class InterviewQuestions {
    public static void main(String[] args) {
        
        // Question 1: Given a row and column wise n*n sorted matrix. Write a program to search a key in a given matrix.
        // Solution
        //      1. We could use two for loop one to keep track of row and another to keep track of column and search every cells in a table.
        //      2. But its inefficient considering its time complexity of searching the matrix will be 0(n^2)
        // refer to this - https://youtu.be/2ZLl8GAk1X4?t=74491

        Integer n = 4;
        Integer sortedMatrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 51}};
        InterviewQuestions iq = new InterviewQuestions();
        iq.searchKey(sortedMatrix, n, 37);



        // Question 2: Given a matrix, print it in a spiral form. - https://youtu.be/2ZLl8GAk1X4?t=75015
    }


    public void searchKey(Integer[][] matrix, Integer n, Integer key){
        int i = 0;
        int j = n-1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == key) {
                System.out.println("x found at - " + i + ", " + j);
                return;
            }

            if (matrix[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Not found");
    }
}

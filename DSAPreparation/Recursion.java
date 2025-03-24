package DSAPreparation; 

public class Recursion {

    int counter = 0;

    public void print() {
        System.out.println("printing for : " + counter);

        counter++;
        if (counter < 5) { // implicit base case
            print();
        }
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.print();
    }
}
